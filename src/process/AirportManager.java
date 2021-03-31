package process;

import java.util.List;

import data.Aeronef;
import data.Airport;
import data.Line;
import data.Terminal;
import gui.SimulPara;

/**
 * 
 * @author Ashanth
 * 
 * Classe gérant les aéroports.
 * Classe constitutée des attributs ci contre :
 * aeroport (Airport), running (boolean), nextTakeOff (boolean), et flyAeronef (int)
 *
 * Cette classe est une classe fille de la classe Thread.
 */
public class AirportManager extends Thread {
	private Airport airport;
	private boolean running = true;
	private boolean nextTakeOff = true;
	private int flyAeronef = 0;

	public AirportManager(Airport airport) {
		super();
		this.airport = airport;
	}

	@Override
	public void run() {
		while (running) {
			enter();
			System.out.println(isNextAeronef());
			if (isNextAeronef()) {

				Aeronef aeronef = nextTakeOffAeronef();
				AeronefManager aeronefManager = new AeronefManager(aeronef);
				aeronefManager.setDepartureManager(this);
				if (airportTakeOffAuthorization(aeronef)) {
					removeAeronefTerminal(aeronef);
					aeronefManager.start();
					flyAeronef++;
				}
			}
			System.out.println("airport " + airport.getName() +" "+ isNextAeronef() + " " +  flyAeronef);
			running = isNextAeronef() ;
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
		List<Aeronef> airportAeronefsList = airportTerminal.getTakeOffAeronefsList(); // Liste des Avions qui ce trouve dans
																			// l'aerogare
		if (airportAeronefsList.size() <= airportTerminal.getTotalParkingPlace()) { // Si La taille de la Liste est plus
																					// petit que le nombre de place max
			isfull = "Not Full"; // Le resultat est Not Full
		}
		return isfull;
	}

	/**
	 * Method which adds an Aeronef in the Terminal
	 * 
	 * @param newAeronef
	 */
	public void addAeronefTerminal(Aeronef newAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getLandingAeronefsList();
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
	 * Verification if the departure of the Aeronef is the same as the Airport
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
	 * Removes an Aeronef from the Terminal
	 * 
	 * @param outAeronef
	 */
	private void removeAeronefTerminal(Aeronef outAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getTakeOffAeronefsList();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() - 1;

		AirportAeronefsList.remove(outAeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	/**
	 * Give to an Aeronef the autorization to Takeoff
	 * 
	 * @param goingAeronef
	 * @return true if he has the authorisation, else false
	 */
	public boolean airportTakeOffAuthorization(Aeronef goingAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getTakeOffAeronefsList();
		boolean authorization = false;
		if (goingAeronef.getDeparture().equals(airport.getName())) {
			if (destinationVerification(goingAeronef) && AirportAeronefsList.contains(goingAeronef)) {
				authorization = true;
			}
		}
		return authorization;
	}

	/**
	 * Give to an Aeronef the autorization to Land
	 * 
	 * @param goingAeronef
	 * @return true if he has the authorisation, else false
	 */
	public boolean airportLandingAuthorization(Aeronef commingAeronef) {
		boolean authorization = false; // autorisation initialisé a faux
		String airportType = airport.getType(); // Type d'acceuil de l'aeroport
		String aeronefType = commingAeronef.getType(); // type de l'avion qui arrive

//		if (airportType.equals("Civil/Cargo") || airportType.equals(aeronefType) || airportType.equals("Emergency")) {
		// si l'aeroport est de type all ou qu'il est le meme que celle de l'avion
		if (isTerminalFull().equals("Not Full")) {
		if (departureVerification(commingAeronef)) {
			// Si le lieu d'arriver est bon
			addAeronefTerminal(commingAeronef);
			authorization = true;
				}
		}
		// }
		return authorization;
	}

	/**
	 * Sets the isNext value true for an Aeronef
	 * if an Aeronef is next in the TakeOffAeronefList
	 * 
	 * @return isNext
	 */
	private boolean isNextAeronef() {
		boolean isNext = false;
		Terminal airportTerminal = airport.getTerminal(); // aerogare de l'aerogare
		List<Aeronef> airportAeronefsList = airportTerminal.getTakeOffAeronefsList(); // Liste des avions de la gare
		if (!airportAeronefsList.isEmpty()) {
			for (Aeronef aeronef : airportAeronefsList) {
				if (aeronef.getDeparture().equals(airport.getName())) {
					isNext = true;
				}
			}
		}
		return isNext;
	}

	/**
	 * Get the next Aeronef to takeOff
	 * 
	 * @return Aeronef to takeoff
	 */
	public Aeronef nextTakeOffAeronef() {
		Terminal airportTerminal = airport.getTerminal(); // aerogare de l'aerogare
		List<Aeronef> airportAeronefsList = airportTerminal.getTakeOffAeronefsList(); // Liste des avions de la gare
		
		Aeronef takeOffAeronef = airportAeronefsList.get(airportAeronefsList.size() - 1);
		// Avion qui va decoller est le dernier de la liste des avions de la gare
		return takeOffAeronef;

	}

	public synchronized void enter() {
		if (flyAeronef == 3 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * getter getAirport
	 * @return airport
	 */
	/*
	 * getter getAirport
	 * return airport, Airport
	 */
	public Airport getAirport() {
		return airport;
	}

	/**
	 * setter setAirport
	 * @param airport
	 */
	/*
	 * setter setAirport
	 * param:
	 * 		airport:Airport
	 */
	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	/**
	 * getter isNextTakeOff
	 * @return nextTakeOff
	 */
	/*
	 * getter isNextTakeOff
	 * returns nextTakeOff, boolean
	 */
	public boolean isNextTakeOff() {
		return nextTakeOff;
	}

	/**
	 * setter setNextTakeOff 
	 * @param nextTakeOff
	 */
	/*
	 * setter setNextTakeOff
	 * param:
	 * 		nextTakeOff : boolean
	 */
	public void setNextTakeOff(boolean nextTakeOff) {
		this.nextTakeOff = nextTakeOff;
	}

	/**
	 * getter getFlyAeronef
	 * @return flyAeronef
	 */
	/*
	 * getter getFlyAeronef
	 * return flyAeronef, int
	 */
	public int getFlyAeronef() {
		return flyAeronef;
	}

	/**
	 * setter setFlyAeronef
	 * @param flyAeronef
	 */
	/*
	 * setter setFlyAeronef
	 * param:
	 * 		flyAeronef : int
	 */
	public void setFlyAeronef(int flyAeronef) {
		this.flyAeronef = flyAeronef;
	}

}
