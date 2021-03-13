package test;

import java.util.ArrayList;
import java.util.List;

import data.*;
import process.*;

public class ProcessTest {

	public static void main(String[] args) {
			
		Utility.createMountain(150, 130, "Mount Everest", 8848, "China");		
		
		City parisCity = new City("Paris", "France");
		City casaCity = new City("Casablanca", "Maroc");
		City mexicoCity = new City("Mexico", "Amérique");
		City rioCity = new City("Rio de janiro", "Brésil");
		City brisbaneCity = new City("Brisbane", "Australie");
		City moskouCity = new City("Moskou", "Russie");
		City hokoCity = new City("Hong kong", "Chine");
		City colombieCity = new City("Colombie", "Canada");
		
		Airport cdg  =	Utility.createAirport(0, 0, "Charle de Gaulle", "Civil", parisCity , "1975");
		AirportManager cdgManager = new AirportManager(cdg);
		
		Airport casa = Utility.createAirport(300, 260, "Casa Airport", "Civil", casaCity, "1951");
		AirportManager casaManager = new AirportManager(casa);
		
		
		Airport mexico = Utility.createAirport(300, 260, "Mexico Airport", "military", mexicoCity, "1934");
		AirportManager mexicoManager = new AirportManager(mexico);
		
		Airport rio = Utility.createAirport(300, 260, "Rio Airport", "military", rioCity, "1923");
		AirportManager rioManager = new AirportManager(rio);
		
		Airport brisbane = Utility.createAirport(300, 260, "Brisbane Airport", "military", brisbaneCity, "1935");
		AirportManager brisbaneManager = new AirportManager(brisbane);
		
		
		Airport moskou = Utility.createAirport(300, 260, "Moskou Airport", "cargo", moskouCity, "1964");
		AirportManager moskouManager = new AirportManager(moskou);
		
		Airport hoko = Utility.createAirport(300, 260, "hongkong Airport", "military", hokoCity, "1924");
		AirportManager hokoManager = new AirportManager(hoko);
		
		Airport colombie = Utility.createAirport(300, 260, "colombie Airport", "military", colombieCity, "1920");
		AirportManager colombieManager = new AirportManager(colombie);
		
		
		
		//ligne entre maroc et france
		Utility.createLine(cdg, casa);
		Aeronef cdgTocasa = Utility.createAeronef(0, 0, "Civil", "A250", "casa Airport", "Charle de Gaulle", 100, 100, 0, 0, false);
	
		cdgManager.start();
		System.out.println(cdg.getTerminal().getTotaParkAeronefs());
		
		//ligne entre france et Russie
		Utility.createLine(cdg, moskou);
		Aeronef moskouTocdg = Utility.createAeronef(0, 0, "Cargo", "A251", "Charle de Gaulle Airport", "moskou Airport", 100, 100, 0, 0, false);
		
		moskouManager.start();
		System.out.println(moskou.getTerminal().getTotaParkAeronefs());
		
		//ligne entre maroc et Russie
		Utility.createLine(casa, moskou);
		Aeronef casaTomoskou = Utility.createAeronef(0, 0, "Civil", "A252", "Moskou Airport", "Casablanca Airport", 100, 100, 0, 0, false);
		
		casaManager.start();
		System.out.println(casa.getTerminal().getTotaParkAeronefs());
		
		
		//ligne entre rio et Brisbane
		Utility.createLine(rio, brisbane);
		Aeronef rioTobrisbane = Utility.createAeronef(0, 0, "Military", "A253", "Brisbane Airport", "Rio Airport", 100, 100, 0, 0, false);
		
		rioManager.start();
		System.out.println(rio.getTerminal().getTotaParkAeronefs());
		
		
		//ligne entre Brisbane et Hong kong
		Utility.createLine(brisbane, hoko);
		Aeronef brisbaneTohoko = Utility.createAeronef(0, 0, "Military", "A254", "Hong kong Airport", "Brisbane Airport", 100, 100, 0, 0, false);
				
		brisbaneManager.start();
		System.out.println(brisbane.getTerminal().getTotaParkAeronefs());
		
		
//		authorizationTest();
//		travelTest();
//		avoidObstacleTest();
//		try {
//			avoidFlockBirdsTest();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		emergencyLandingTest();
	}

}
