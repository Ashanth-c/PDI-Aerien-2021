package test;

import java.util.ArrayList;
import java.util.List;

import data.*;
import process.*;

public class ProcessTest {

	public static void main(String[] args) {

		testAirportAuthorization();

		Moutain moutain = new Moutain(45, 2, "Mount Everest", 8848, "China");
		

	}

	/*Methode pour tester les autorisation de vols*/
	public static void testAirportAuthorization() {

		List<Aeronef> cdgAeronefs = new ArrayList<Aeronef>(); //Creation d'une liste d'aeronef pour l'aerogare de CDG
		Terminal cdgTerminal = new Terminal(50, 0, cdgAeronefs);  // Creation de aerogare de CDG avec le nombre de place max, nob de place occupé et liste d'aeronef
		Aerodrome cdgAerodrome = new Aerodrome(4, 25); //Creation de l'aerodrome de CDG avec le nb de piste est leur longueur
		City cdgCity = new City("Paris", "France"); //Creation de la ville ou ce trouve l'aeroport CDG
		List<Line> cdgLines = new ArrayList<Line>(); //Creation de la liste des lignes de l'aeroport CDG
		Airport cdg = new Airport(15, 5, "Charle de Gaulle", "Civil", cdgAerodrome, cdgTerminal, cdgCity, "1975",
				cdgLines); //Creation de CDG
		AirportManager cdgManager = new AirportManager(cdg); //Creation d'un gestionnaire pour l'aeroport CDG

		List<Aeronef> jafAeronefs = new ArrayList<Aeronef>();
		Terminal jafTerminal = new Terminal(20, 0, jafAeronefs);
		Aerodrome jafAerodrome = new Aerodrome(2, 25);
		City jafCity = new City("Jaffna", "Tamil Eelam");
		List<Line> jafLines = new ArrayList<Line>();
		Airport jaf = new Airport(30, 60, "Jaffna Airport", "All", jafAerodrome, jafTerminal, jafCity, "1943",
				jafLines);
		AirportManager jafManager = new AirportManager(jaf);

		Aeronef cdgTojafA250 = new Aeronef(0, 0, "Civil", "A250", "Jaffna Airport", "Charle de Gaulle", 50, 100, 0,
				250);
		Aeronef cdgToathA380 = new Aeronef(0, 0, "Civil", "A380", "Athena Airport", "Charle de Gaulle", 200, 100, 500,
				200);
		AeronefManager cdgTManager =new AeronefManager(cdgTojafA250); // gestionnaire pour l'aeronef cdgTojafA250

		cdgManager.addAeronefTerminal(cdgToathA380); //Ajout d'un aeronef A380 dans l'aerogare de CDG
		cdgManager.addAeronefTerminal(cdgTojafA250); //Ajout d'un aeronef A250 dans l'aerogare de CDG

		LineBuilder lineBuilder = new LineBuilder(); //Creation de constructeur de ligne
		lineBuilder.addLines(cdg, jaf); //Creation d'une ligne de vol entre JafFna Airport et CDG
		
		System.out.println("The " + cdgTojafA250 + " has the authorization : "
				+ cdgManager.airportTakeOffAuthorization(cdgTojafA250)); //Affiche le resultat d'autorisation de decollage d'un vol de CDG

	}

}
