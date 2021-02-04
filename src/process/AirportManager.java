package process;

import java.util.List;

import data.Aeronef;
import data.Airport;
import data.Line;
import data.Terminal;

public class AirportManager {
	private Airport airport;

	public AirportManager(Airport airport) {
		super();
		this.airport = airport;
	}

	/*
	 * Methde qui retourne "Full" si l'aerogare est complet sinon il retourne
	 * "Not Full"
	 */
	public String isTerminalFull() {
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

	/* Methode qui ajoute un Aeronef dans un aerogare */
	public void addAeronefTerminal(Aeronef newAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() + 1;

		AirportAeronefsList.add(newAeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	/* Methode qui verifie la destination d'un aeronef */
	public boolean departureVerification(Aeronef aeronef) {
		boolean verification = false; // Resultat de la verification
		String airportName = airport.getName(); // Nom de l'aeroport
		List<Line> aiportLines = airport.getLinesList(); // Liste des Lignes de vols de l'aeroport
		String aeronefDestination = aeronef.getDestination(); // Nom de la destination de l'aeronef
		String airportDestination; //

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

	/*Methode qui verifie le lieu de depart d'un aeronef
	 * Pareil que la methode d'avant mais avec invertion entre destination et departure
	 * */
	public boolean destinationVerification(Aeronef aeronef) {
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

	/*Methode qui enleve un aeronef de l'aerogare*/
	public void removeAeronefTerminal(Aeronef outAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() - 1;

		AirportAeronefsList.remove(outAeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	/*Methode qui donne l'autorisation a un avion de decoller*/
	public boolean airportTakeOffAuthorization(Aeronef goingAeronef) {
		Terminal airportTerminal = airport.getTerminal(); //Aerogare de l'aeroport
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs(); //Liste des avions de l'aerogare
		boolean authorization = false; //autorisattion de decoller

		if (departureVerification(goingAeronef) && AirportAeronefsList.contains(goingAeronef)) { //Si le lieu de depart est bon et que l'aeronef est dans l'aerogare
			removeAeronefTerminal(goingAeronef); //enleve l'aeronef de la gare
			authorization = true; //Mets l'autorisation a vrai
		}
		return authorization;
	}

	/*Methode qui donne l'autorisation d'atterisagge (Peut etre nom a changer)*/
	public boolean giveAuthorizaton(Aeronef comingAeronef) {
		Terminal airportTerminal = airport.getTerminal(); 
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		boolean authorization = false;

		if (destinationVerification(comingAeronef) && (!AirportAeronefsList.contains(comingAeronef))) { //Si le lieu d'arriver est bon et que l'aeronef est dans l'aerogare
			addAeronefTerminal(comingAeronef); //ajoute l'aeronef dans l'aerogare
			authorization = true;
		}
		return authorization;
	}

	/*Methode qui donne l'autorisation final d'atterissage (Peut etre changé de nom) */
	public boolean airportLandingAuthorization(Aeronef commingAeronef) {
		boolean authorization = false; //autorisation initialisé a faux
		String airportType = airport.getType(); //Type d'acceuil de l'aeroport
		String aeronefType = commingAeronef.getType(); //type de l'avion qui arrive

		if (airportType.equals("All") || airportType.equals(aeronefType)) { //si l'aeroport est de type all ou qu'il est le meme que celle de l'avion
			if (isTerminalFull().equals("Not Full")) { //si l'aerogare n'est pas complet
				authorization = giveAuthorizaton(commingAeronef); //donner l'autorisation pour atterir
			}
		}
		return authorization;
	}
 /*Methode pour avoir le prochain avions a decoller*/
	public Aeronef nextTakeOffAeronef() {
		Terminal airportTerminal = airport.getTerminal(); //aerogare de l'aerogare
		List<Aeronef> airportAeronefsList = airportTerminal.getAeronefs(); //Liste des avions de la gare

		Aeronef takeOffAeronef = airportAeronefsList.get(airportAeronefsList.size() - 1); //Avion qui va decoller est le dernier de la liste des avions de la gare
		return takeOffAeronef;

	}

}
