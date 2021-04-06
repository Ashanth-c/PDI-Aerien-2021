package process;

import java.util.List;

import data.Aeronef;
import data.Airport;
import data.Line;
import data.Terminal;
import gui.SimulPara;
/*!
 * @file AirportManager.java
 * @brief Classe gérant les aéroports, Cette classe est une classe fille de la classe Thread.
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
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
			running = isNextAeronef() ;
		}
	}

	/*!
	 * isTerminalFull()
	 * @brief Méthode qui dit si le terminal est plein ou non
	 * 
	 * @return isFull  booleen qui ditermine si le terminal est plein
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

	/*!
	 * addAeronefTerminal()
	 * @brief Méthode qui ajoute un Aeronef dans le terminal
	 * 
	 * @param newAeronef avion
	 */
	public void addAeronefTerminal(Aeronef newAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getLandingAeronefsList();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() + 1;

		AirportAeronefsList.add(newAeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}


	/*!
	 * destinationVerification()
	 * @brief Vérification si la destination de l'Aeronef est la même que celle de l'aéroport
	 * 
	 * @param aeronef avion
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

	/*!
	 * @brief Vérification si le départ de l'Aeronef est le même que celui de l'aéroport
	 * departureVerification()
	 * @param aeronef avion
	 * @return true si le départ est l'aéroport, ou faux si ce n'est pas le cas
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

	/*!
	 * removeAeronefTerminal()
	 * @brief Supprime un Aeronef du terminal
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

	/*!
	 * airportTakeOffAuthorization()
	 * @brief Donner à un Aeronef l'autorisation de décoller
	 * 
	 * @param goingAeronef
	 * @return true s'il a l'autorisation, sinon false
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

	/*!
	 * airportLandingAuthorization()
	 * @brief Donner à un Aeronef l'autorisation d'atterrir
	 * @param goingAeronef
	 * @return true s'il a l'autorisation, sinon false
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

	/*!
	 *  isNextAeronef()
	 * @brief Définit la valeur isNext true pour un Aeronef
	 * @brief si un Aeronef est le suivant dans la TakeOffAeronefList
	 * @return isNext
	 */
	private boolean isNextAeronef() {
		boolean isNext = false;
		Terminal airportTerminal = airport.getTerminal(); // aérogare de l'aérogare
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

	/*!
	 * nextTakeOffAeronef()
	 * @brief Obtenez le prochain Aeronef à décoller
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
	
	/*!
	 * getter getAirport()
	 * @return airport
	 * @brief retourne l'aeroport
	 */
	
	public Airport getAirport() {
		return airport;
	}

	/*!
	 * setter setAirport()
	 * @param airport
	 * @brief change l'aéroport
	 */

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	/*!
	 * getter isNextTakeOff()
	 * @return nextTakeOff
	 */

	public boolean isNextTakeOff() {
		return nextTakeOff;
	}

	/*!
	 * setter setNextTakeOff ()
	 * @param nextTakeOff
	 */

	public void setNextTakeOff(boolean nextTakeOff) {
		this.nextTakeOff = nextTakeOff;
	}

	/*!
	 * getter getFlyAeronef()
	 * @return flyAeronef l'aeronef en vol
	 */

	public int getFlyAeronef() {
		return flyAeronef;
	}

	/*!
	 * setter setFlyAeronef()
	 * @param flyAeronef l'aeronef en vol
	 */

	public void setFlyAeronef(int flyAeronef) {
		this.flyAeronef = flyAeronef;
	}

}
