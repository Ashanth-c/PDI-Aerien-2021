package test;

import java.util.ArrayList;
import java.util.List;

import data.*;
import process.*;

public class ProcessTest {

	public static void main(String[] args) {

//		authorizationTest();
//		travelTest();
//		avoidObstacleTest();
		try {
			avoidFlockBirdsTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Methode pour tester les autorisation de vols */
	public static void travelTest() {

		/* Create CDG airport with all elements */
		List<Aeronef> cdgAeronefs = new ArrayList<Aeronef>();
		Terminal cdgTerminal = new Terminal(50, 0, cdgAeronefs);
		Aerodrome cdgAerodrome = new Aerodrome(4, 25);
		City cdgCity = new City("Paris", "France");
		List<Line> cdgLines = new ArrayList<Line>();
		Airport cdg = new Airport(0, 0, "Charle de Gaulle", "Civil", cdgAerodrome, cdgTerminal, cdgCity, "1975",
				cdgLines);
		AirportManager cdgManager = new AirportManager(cdg);

		// Create Jaffna airport with all elements
		List<Aeronef> jafAeronefs = new ArrayList<Aeronef>();
		Terminal jafTerminal = new Terminal(20, 0, jafAeronefs);
		Aerodrome jafAerodrome = new Aerodrome(2, 25);
		City jafCity = new City("Jaffna", "Tamil Eelam");
		List<Line> jafLines = new ArrayList<Line>();
		Airport jaf = new Airport(300, 260, "Jaffna Airport", "All", jafAerodrome, jafTerminal, jafCity, "1943",
				jafLines);
		AirportManager jafManager = new AirportManager(jaf);

		// Create a Line between CDG and Jaffna
		LineBuilder lineBuilder = new LineBuilder();
		lineBuilder.addLines(cdg, jaf);

		// Create a Aeronef From CDG to Jaffna aiport
		Aeronef cdgTojafA250 = new Aeronef(0, 0, "Civil", "A250", "Jaffna Airport", "Charle de Gaulle", 50, 100, 5000,
				250);
		AeronefManager cdgTManager = new AeronefManager(cdgTojafA250);

		cdgManager.addAeronefTerminal(cdgTojafA250);

		/************** test travel ************/
		int abscisse = (int) cdgTojafA250.getAbscisse();
		int ordonnee = (int) cdgTojafA250.getOrdonnee();
		System.out.println("Coordonnee de cdgTojafA250 avant decollage: " + abscisse + " , " + ordonnee);
		BlockManager blockManager = new BlockManager();
		float abscisseVariationValue = blockManager.abscisseVariationValue(cdgTojafA250, jaf, 100);
		float ordoneeVariationValue = blockManager.ordoneeVariationValue(cdgTojafA250, jaf, 100);

		while (((int) cdgTojafA250.getAbscisse() != jaf.getAbscisse())
				&& ((int) cdgTojafA250.getOrdonnee() != jaf.getOrdonnee())) {
			blockManager.MoveAeronefAbcsisse(cdgTojafA250, abscisseVariationValue);
			blockManager.MoveAeronefOrdonnee(cdgTojafA250, ordoneeVariationValue);
			abscisse = (int) cdgTojafA250.getAbscisse();
			ordonnee = (int) cdgTojafA250.getOrdonnee();
			System.out.println("Coordonnee de cdgTojafA250 : " + cdgTojafA250.getAbscisse() + " , "
					+ (int) cdgTojafA250.getOrdonnee());
		}

		System.out.println("Coordonnee de cdgTojafA250 apres decollage: " + abscisse + " , " + ordonnee);

	}

	public static void authorizationTest() {
		/* Create CDG airport with all elements */
		List<Aeronef> cdgAeronefs = new ArrayList<Aeronef>();
		Terminal cdgTerminal = new Terminal(50, 0, cdgAeronefs);
		Aerodrome cdgAerodrome = new Aerodrome(4, 25);
		City cdgCity = new City("Paris", "France");
		List<Line> cdgLines = new ArrayList<Line>();
		Airport cdg = new Airport(15, 5, "Charle de Gaulle", "Civil", cdgAerodrome, cdgTerminal, cdgCity, "1975",
				cdgLines);
		AirportManager cdgManager = new AirportManager(cdg);

		// Create Jaffna airport with all elements
		List<Aeronef> jafAeronefs = new ArrayList<Aeronef>();
		Terminal jafTerminal = new Terminal(20, 0, jafAeronefs);
		Aerodrome jafAerodrome = new Aerodrome(2, 25);
		City jafCity = new City("Jaffna", "Tamil Eelam");
		List<Line> jafLines = new ArrayList<Line>();
		Airport jaf = new Airport(30, 60, "Jaffna Airport", "All", jafAerodrome, jafTerminal, jafCity, "1943",
				jafLines);
		AirportManager jafManager = new AirportManager(jaf);

		// Create a Line between CDG and Jaffna
		LineBuilder lineBuilder = new LineBuilder();
		lineBuilder.addLines(cdg, jaf);

		// Create a Aeronef From CDG to Jaffna aiport
		Aeronef cdgTojafA250 = new Aeronef(0, 0, "Civil", "A250", "Jaffna Airport", "Charle de Gaulle", 50, 100, 5000,
				250);
		AeronefManager cdgTManager = new AeronefManager(cdgTojafA250);
		// Create a Aeronef From CDG to Athena airport (who don't exist)
		Aeronef cdgToathA380 = new Aeronef(0, 0, "Civil", "A380", "Athena Airport", "Charle de Gaulle", 200, 100, 500,
				200);

		// Add Aeronef to CDG's terminal
		cdgManager.addAeronefTerminal(cdgToathA380);
		cdgManager.addAeronefTerminal(cdgTojafA250);

		boolean airportTakeOffAuthorization = cdgManager.airportTakeOffAuthorization(cdgTojafA250);
		boolean airportLandingAuthorization = cdgManager.airportLandingAuthorization(cdgToathA380);
		System.out
				.println("The Aeronef cdgTojafA250 has the authorization to take off: " + airportTakeOffAuthorization);
		System.out.println("The Aeronef cdgTojafA380 has the authorization to land: " + airportLandingAuthorization);

	}

	public static void avoidObstacleTest() {
		/* Create CDG airport with all elements */
		List<Aeronef> cdgAeronefs = new ArrayList<Aeronef>();
		Terminal cdgTerminal = new Terminal(50, 0, cdgAeronefs);
		Aerodrome cdgAerodrome = new Aerodrome(4, 25);
		City cdgCity = new City("Paris", "France");
		List<Line> cdgLines = new ArrayList<Line>();
		Airport cdg = new Airport(15, 5, "Charle de Gaulle", "Civil", cdgAerodrome, cdgTerminal, cdgCity, "1975",
				cdgLines);
		AirportManager cdgManager = new AirportManager(cdg);

		// Create Jaffna airport with all elements
		List<Aeronef> jafAeronefs = new ArrayList<Aeronef>();
		Terminal jafTerminal = new Terminal(20, 0, jafAeronefs);
		Aerodrome jafAerodrome = new Aerodrome(2, 25);
		City jafCity = new City("Jaffna", "Tamil Eelam");
		List<Line> jafLines = new ArrayList<Line>();
		Airport jaf = new Airport(300, 260, "Jaffna Airport", "All", jafAerodrome, jafTerminal, jafCity, "1943",
				jafLines);
		AirportManager jafManager = new AirportManager(jaf);

		// Create a Line between CDG and Jaffna
		LineBuilder lineBuilder = new LineBuilder();
		lineBuilder.addLines(cdg, jaf);

		// Create a Aeronef From CDG to Jaffna aiport
		Aeronef cdgTojafA250 = new Aeronef(0, 0, "Civil", "A250", "Jaffna Airport", "Charle de Gaulle", 50, 100, 5000,
				250);
		AeronefManager cdgTManager = new AeronefManager(cdgTojafA250);

		Moutain moutain = new Moutain(10, 20, "Mount Everest", 8848, "China");
		BlockManager blockManager = new BlockManager(moutain);

		System.out.println("L'altitude de l'aeronef cdgTojafA250 :" + cdgTojafA250.getAltitude() + "m");
		float abscisseVariationValue = blockManager.abscisseVariationValue(cdgTojafA250, jaf, 100);
		float ordoneeVariationValue = blockManager.ordoneeVariationValue(cdgTojafA250, jaf, 100);
		while (((int) cdgTojafA250.getAbscisse() != jaf.getAbscisse())
				&& ((int) cdgTojafA250.getOrdonnee() != jaf.getOrdonnee())) {
			blockManager.MoveAeronefAbcsisse(cdgTojafA250, abscisseVariationValue);
			blockManager.MoveAeronefOrdonnee(cdgTojafA250, ordoneeVariationValue);
			blockManager.avoidMountain(moutain, cdgTojafA250);

		}
		System.out.println("L'altitude de l'aeronef cdgTojafA250 :" + cdgTojafA250.getAltitude() + "m");

	}

	public static void avoidFlockBirdsTest() throws InterruptedException {

		/* Create CDG airport with all elements */
		List<Aeronef> cdgAeronefs = new ArrayList<Aeronef>();
		Terminal cdgTerminal = new Terminal(50, 0, cdgAeronefs);
		Aerodrome cdgAerodrome = new Aerodrome(4, 25);
		City cdgCity = new City("Paris", "France");
		List<Line> cdgLines = new ArrayList<Line>();
		Airport cdg = new Airport(15, 5, "Charle de Gaulle", "Civil", cdgAerodrome, cdgTerminal, cdgCity, "1975",
				cdgLines);
		AirportManager cdgManager = new AirportManager(cdg);

		// Create Jaffna airport with all elements
		List<Aeronef> jafAeronefs = new ArrayList<Aeronef>();
		Terminal jafTerminal = new Terminal(20, 0, jafAeronefs);
		Aerodrome jafAerodrome = new Aerodrome(2, 25);
		City jafCity = new City("Jaffna", "Tamil Eelam");
		List<Line> jafLines = new ArrayList<Line>();
		Airport jaf = new Airport(300, 260, "Jaffna Airport", "All", jafAerodrome, jafTerminal, jafCity, "1943",
				jafLines);
		AirportManager jafManager = new AirportManager(jaf);

		// Create a Line between CDG and Jaffna
		LineBuilder lineBuilder = new LineBuilder();
		lineBuilder.addLines(cdg, jaf);

		// Create a Aeronef From CDG to Jaffna aiport
		Aeronef cdgTojafA250 = new Aeronef(0, 0, "Civil", "A250", "Jaffna Airport", "Charle de Gaulle", 50, 100, 5000,
				250);
		AeronefManager cdgTManager = new AeronefManager(cdgTojafA250);
		/** test travel **/
		int abscisse = (int) cdgTojafA250.getAbscisse();
		int ordonnee = (int) cdgTojafA250.getOrdonnee();

		//Génération de flock birds
		FlockBirds flockbirds = new FlockBirds(0, 0, "pigeons", 5000, 25, 15);
		BlockManager blockManager2 = new BlockManager(flockbirds);

		//Génération des threads
		Thread mountainThread = new Thread();
		mountainThread.start();
		Thread flockbirdThread = new Thread();
		flockbirdThread.start();

		System.out.println(
				"Coordonnees des oiseaux au départ: " + flockbirds.getAbscisse() + " , " + flockbirds.getOrdonnee());
		System.out.println("Coordonnee de cdgTojafA250 avant decollage: " + abscisse + " , " + ordonnee);

		for (double i = 0; i <= 2 * (Math.PI); i++) {
			blockManager2.avoidFlockBirds(flockbirds, cdgTojafA250);
			blockManager2.moveFlockBirds(flockbirds, 100, i);

			System.out.println("Coordonnees des " + flockbirds.getName() + " : " + (float) flockbirds.getAbscisse()
					+ " , " + (float) flockbirds.getOrdonnee());

		}
		System.out.println(
				"Coordonnees de des oiseaux à la fin: " + flockbirds.getAbscisse() + " , " + flockbirds.getOrdonnee());

		float abscisseVariationValue = blockManager2.abscisseVariationValue(cdgTojafA250, jaf, 100);
		float ordoneeVariationValue = blockManager2.ordoneeVariationValue(cdgTojafA250, jaf, 100);

		// mountainThread.sleep(5000);

		while (((int) cdgTojafA250.getAbscisse() != jaf.getAbscisse())
				&& ((int) cdgTojafA250.getOrdonnee() != jaf.getOrdonnee())) {

			blockManager2.MoveAeronefAbcsisse(cdgTojafA250, abscisseVariationValue);
			blockManager2.MoveAeronefOrdonnee(cdgTojafA250, ordoneeVariationValue);
			abscisse = (int) cdgTojafA250.getAbscisse();
			ordonnee = (int) cdgTojafA250.getOrdonnee();

		}

	}

}
