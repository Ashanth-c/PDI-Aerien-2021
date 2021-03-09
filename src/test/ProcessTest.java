package test;

import java.util.ArrayList;
import java.util.List;

import data.*;
import process.*;

public class ProcessTest {

	public static void main(String[] args) {
			
		Utility.createMountain(150, 130, "Mount Everest", 8848, "China");		
		City parisCity = new City("Paris", "France");
		City jaffnaCity = new City("Jaffna", "Tamil Eelam");
		
		Airport cdg  =	Utility.createAirport(0, 0, "Charle de Gaulle", "Civil", parisCity , "1975");
		AirportManager cdgManager = new AirportManager(cdg);
		Airport jaffna = Utility.createAirport(300, 260, "Jaffna Airport", "Civil", jaffnaCity, "1945");
		AirportManager jaffnaManager = new AirportManager(jaffna);
		Utility.createLine(cdg, jaffna);
		Aeronef cdgTojaf = Utility.createAeronef(0, 0, "Civil", "A250", "Jaffna Airport", "Charle de Gaulle", 100, 100, 0, 0, false);

		cdgManager.start();
		System.out.println(cdg.getTerminal().getTotaParkAeronefs());
		
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
