package process;

import java.util.List;

import data.Aeronef;
import data.Airport;
import data.Line;
import data.Terminal;
import gui.SimulPara;

/**
 * Class for the managmenent of an Airport
 * 
 * @author Ashanth
 *
 */
public class AirportManager extends Thread{
	private Airport airport;

	public AirportManager(Airport airport) {
		super();
		this.airport = airport;
	}

	@Override
	public void run() {
		int time = 0;
		while (time <= SimulPara.SIMUlATION_TIME) {
			if(isNextAeronef()) {
				Aeronef aeronef = nextTakeOffAeronef();
				AeronefManager aeronefManager = new AeronefManager(aeronef);
				if(airportTakeOffAuthorization(aeronef)) {
					aeronefManager.start();
				}			
			}
			time++;
		}
	}
	
	/**
	 * 
	 * Method who tell if the Terminal is full or not
	 * 
	 * @return isFull
	 */
	private String isTerminalFull() {
		String isfull = "Full"; // Resultat de la verification Initialisé a Full
		Terminal airportTerminal = airport.getTerminal(); // Aerogare d'un Aeroport
		List<Aeronef> airportAeronefsList = airportTerminal.getAeronefs(); // Liste des Avions qui ce trouve dans
																			// l'aerogare

		if (airportAeronefsList.size() < airportTerminal.getTotalParkingPlace()) { // Si La taille de la Liste est plus
																					// petit que le nombre de place max
			isfull = "Not Full"; // Le resultat est Not Full
		}
		return isfull;
	}

	/**
	 * Method who add an Aeronef in the Terminal
	 * 
	 * @param newAeronef
	 */
	public void addAeronefTerminal(Aeronef newAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() + 1;

		AirportAeronefsList.add(newAeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	/**
	 * Verification if the destination of the Aeronef is the same as the Airport
	 * 
	 * @param aeronef
	 * @return true if the destination is the Airport, or false if it's not
	 */
	private boolean destinationVerification(Aeronef aeronef) {
		boolean verification = false; // Resultat de la verification
		String airportName = airport.getName(); // Nom de l'aeroport
		List<Line> aiportLines = airport.getLinesList(); // Liste des Lignes de vols de l'aeroport
		String aeronefDestination = aeronef.getDestination(); // Nom de la destination de l'aeronef
		String airportDestination;

		if (aeronef.getDeparture().equals(airportName)) { // Si le lieu de depart est le meme que le nom de l'aeroport
			for (Line line : aiportLines) { // Pour toute les lignes de l'aeroport
				airportDestination = line.getdestination().getName(); // Le nom de la destination de la ligne
				if (aeronefDestination.equals(airportDestination)) { // Si le nom de destination correspond a celle de
																		// l'avion
					verification = true; // La verification donne vrai
				}
			}

		}
		return verification;

	}

	/**
	 *  Verification if the departure of the Aeronef is the same as the Airport
	 * 
	 * @param aeronef
	 * @return true if the departure is the Airport, or false if it's not
	 */
	private boolean departureVerification(Aeronef aeronef) {
		boolean verification = false;
		String airportName = airport.getName();
		List<Line> aiportLines = airport.getLinesList();
		String aeronefDeparture = aeronef.getDeparture();
		String airportDeparture;

		if (aeronef.getDestination().equals(airportName)) {
			for (Line line : aiportLines) {
				airportDeparture = line.getdeparture().getName();
				if (aeronefDeparture.equals(airportDeparture)) {
					verification = true;
				}
			}

		}
		return verification;

	}

	/**
	 * Remove an Aeronef from the Terminal
	 * @param outAeronef
	 */
	private void removeAeronefTerminal(Aeronef outAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() - 1;

		AirportAeronefsList.remove(outAeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	/**
	 * Give to an Aeronef the autorization to Takeoff
	 * @param goingAeronef
	 * @return true if he has the authorisation, else false
	 */
	public boolean airportTakeOffAuthorization(Aeronef goingAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		boolean authorization = false;

		if (destinationVerification(goingAeronef) && AirportAeronefsList.contains(goingAeronef)) {
			removeAeronefTerminal(goingAeronef); 
			authorization = true;
			System.out.println("Autorisation de décollage oui");
		}
		return authorization;
	}

	/**
	 * Tell if the Aeronef is plan to land in the aeroport
	 * @param comingAeronef
	 * @return 
	 */
	private boolean isLandingAeronef(Aeronef comingAeronef) {
		boolean authorization = false;

		if (departureVerification(comingAeronef)) { 
			// Si le lieu d'arriver est bon
			addAeronefTerminal(comingAeronef);
			authorization = true;
		}
		return authorization;
	}

	/**
	 * Give to an Aeronef the autorization to Land
	 * @param goingAeronef
	 * @return true if he has the authorisation, else false
	 */
	public boolean airportLandingAuthorization(Aeronef commingAeronef) {
		boolean authorization = false; // autorisation initialisé a faux
		String airportType = airport.getType(); // Type d'acceuil de l'aeroport
		String aeronefType = commingAeronef.getType(); // type de l'avion qui arrive

		if (airportType.equals("All") || airportType.equals(aeronefType)) { 
			// si l'aeroport est de type all ou qu'il est le meme que celle de l'avion
			if (isTerminalFull().equals("Not Full")) {
				if (departureVerification(commingAeronef)) { 
					// Si le lieu d'arriver est bon
					addAeronefTerminal(commingAeronef);
					authorization = true;
					System.out.println("Authorisation d'atterir");
				}			
			}
		}
		return authorization;
	}

	private boolean isNextAeronef() {
		Terminal airportTerminal = airport.getTerminal(); // aerogare de l'aerogare
		List<Aeronef> airportAeronefsList = airportTerminal.getAeronefs(); // Liste des avions de la gare
		return (!airportAeronefsList.isEmpty());
		
	}
	
	
	/**
	 * Get the next Aeronef to takeOff
	 * @return Aeronef to takeoff
	 */
	public Aeronef nextTakeOffAeronef() {
		Terminal airportTerminal = airport.getTerminal(); // aerogare de l'aerogare
		List<Aeronef> airportAeronefsList = airportTerminal.getAeronefs(); // Liste des avions de la gare

		Aeronef takeOffAeronef = airportAeronefsList.get(airportAeronefsList.size() - 1); 
		// Avion qui va decoller est le dernier de la liste des avions de la gare
		return takeOffAeronef;

	}

}
