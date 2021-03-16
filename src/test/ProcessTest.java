package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import data.*;
import process.*;

public class ProcessTest {

	public static void main(String[] args) {
			
		Simulation simulation = new Simulation();
		List<Airport> airportsList = simulation.getAirportsList();
		Airport airport = airportsList.get(1);
		List<Aeronef> aeronefs = airport.getTerminal().getTakeOffAeronefsList();
		Aeronef aeronef = aeronefs.get(0);
		AeronefManager aeronefManager = new AeronefManager(aeronef);
		AirportManager airportManager1 = new AirportManager(airport);
		System.out.println(aeronefs.size());
		System.out.println(airport.getTerminal().getTotaParkAeronefs());
//		airportManager1.start();
		
//		aeronefManager.start();
		//		
//		while(true) {
//			aeronefManager.travelAeronef();
			
			System.out.println(airport.getTerminal().getLandingAeronefsList());

//
//		}
//		
			for (Airport airport1 : airportsList) {
				System.out.println(airport1.getName());
			}
				  
//				 System.out.println(value.getAirport().getLinesList());

				
//		Utility.createMountain(150, 130, "Mount Everest", 8848, "China");
//		FlockBirds flockBirds = Utility.createFlockBirds(50, 50, "Pivert", 5000, 30, 150, 150, 550);
//		ObstacleManager manager = new ObstacleManager(flockBirds);
//		
//		int i=0;
//		while(i!=23) {
//		
//			manager.moveFlockBirds(flockBirds.getRadius());
//			System.out.println(flockBirds.getAbscisse() + " ; " + flockBirds.getOrdonnee());
//			i++;
//		
//		}
//
//		City parisCity = new City("Paris", "France");
//		City jaffnaCity = new City("Jaffna", "Tamil Eelam");
//
//		Airport cdg  =	Utility.createAirport(0, 0, "Charle de Gaulle", "Civil", parisCity , "1975");
//		AirportManager cdgManager = new AirportManager(cdg);
//		Airport jaffna = Utility.createAirport(300, 260, "Jaffna Airport", "Civil", jaffnaCity, "1945");
//		AirportManager jaffnaManager = new AirportManager(jaffna);
//		Utility.createLine(cdg, jaffna);
//		Aeronef cdgTojaf = Utility.createAeronef(0, 0,"cdgTojaf1", "Civil", "A250", "Jaffna Airport", "Charle de Gaulle", 100, 100, 0, 0, false);
//
//		cdgManager.start();
//		System.out.println(cdg.getTerminal().getTotaParkAeronefs());

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
