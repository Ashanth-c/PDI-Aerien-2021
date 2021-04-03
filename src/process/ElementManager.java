package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import data.Aeronef;
import data.Airport;
import data.FlockBirds;
import data.Mountain;
import data.Obstacle;

/*!
 * @file ElementManager.java
 * @brief gérant des éléments.
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */

public class ElementManager {
	private static Map<String, Airport> airportMap = new HashMap<String, Airport>();
	private static List<Aeronef> aeronefsList = new ArrayList<Aeronef>();
	private static List<Obstacle> obstaclesList = new ArrayList<Obstacle>();
	private static List<FlockBirds> flockBirdsList = new ArrayList<FlockBirds>();
	private static List<Mountain> mountainsList = new ArrayList<Mountain>();
/*!
 * ElementManager()
 * @brief gerer l'elelement
 */
	public ElementManager() {
		// TODO Auto-generated constructor stub
		super();
	}
/*!
 * addAeronef()	
 * @param aeronef
 * 
 * @brief Adds an aeronef in aeronefsList
 */
	public static void addAeronef(Aeronef aeronef) {
		aeronefsList.add(aeronef);
	}
/*!
 * addAirport()
 * @param key
 * @param value
 * 
 * @brief Adds an Airport and a key in airportMap
 */
	public static void addAirport(String key, Airport value) {
		airportMap.put(key, value);
	}
/*!
 * addObstacle()
 * @param obstacle
 * 
 * @brief Adds an obstacle in obstaclesList
 */
	public static void addObstacle(Obstacle obstacle) {
		obstaclesList.add(obstacle);
	}
/*!
 * addFlockBirds()	
 * @param flockbirds
 * 
 * @brief Adds flockbirds in flockBirdsList
 */
	public static void addFlockBirds(FlockBirds flockbirds) {
		flockBirdsList.add(flockbirds);
	}
/*!
 * addMountain()
 * @param mountain
 * 
 * @brief Add a mountain in mountainsList
 */
	public static void addMountain(Mountain mountain) {
		mountainsList.add(mountain);
	}

/*!
 * checkAirportsAround()
 * @param aeronef
 * @return airportName
 * 
 * @brief Checks airports around an aeronef, returns the airportName that's closest to an aeronef
 */
	public static String checkAirportsAround(Aeronef aeronef) {
		//setting important variables
		String airportName = "SearchEmergencyAirport";
		float aeronefOrdonnee = aeronef.getOrdonnee();
		float aeronefAbscisse = aeronef.getAbscisse();
		
		//for each airportM in airportMap's entrySet, an airport is set as an airportM's value
		for(Entry<String, Airport> airportM : airportMap.entrySet()) {
			Airport airport = airportM.getValue();
			
			//we check if there is an aeronef near the airport, if yes its name will be returned
			if (aeronefAbscisse+100>=airport.getAbscisse() && aeronefOrdonnee+100>=airport.getOrdonnee() && aeronefAbscisse-100<=airport.getAbscisse() && aeronefOrdonnee-100<=airport.getOrdonnee()) {
				System.out.println("Atterissage en urgence réussi");
				airportName = airport.getName();
			}
		}
		return airportName;
	}
/*!
 * abscisseVariationValue()
 * 
 * @param aeronef
 * @param destinationAirport l'aeroport de destination
 * @param time
 * @return abscisseVariation
 * 
 * @brief returns ( airport's abscisse - aeronef's abscisse) / 100
 */
	public static float abscisseVariationValue(Aeronef aeronef, Airport destinationAirport, int time) {
		float aeronefAbscisse = aeronef.getAbscisse();
		float airportAbscisse = destinationAirport.getAbscisse();
		time/=100;

		float abscisseVariation = (airportAbscisse - aeronefAbscisse) / time;

		return abscisseVariation;

	}
/*!
 * ordonneeVariationValue()
 * 
 * @param aeronef
 * @param destinationAirport
 * @param time
 * @return ordonneeVariation
 * 
 * @brief returns (airport's ordinate - aeronef's abscisse) /100
 */
	public static float ordoneeVariationValue(Aeronef aeronef, Airport destinationAirport, int time) {
		float aeronefOrdonnee = aeronef.getOrdonnee();
		float airportOrdonnee = destinationAirport.getOrdonnee();
		time/=100;

		float ordonneeVariation = (airportOrdonnee - aeronefOrdonnee) / time;

		return ordonneeVariation;

	}
/*!
 * getAirportFromname()
 * @param airportName
 * @return airportName
 * 
 * @brief Uses an Airport's name to return said Airport from airportMap
 */
	public static Airport getAiportFromName(String airportName) {
			return airportMap.get(airportName);
	}
/*!
 * ObstacleMouvement()
 * 
 * @brief Makes flockBirds move 
 */
	public static void ObstacleMouvement() {
		
		/*
		 * For each flockbird in flockBirdsList
		 * if flockBirds' toString contains the "Birds" string
		 * A new ObstacleManager is created for these flockBirds
		 * 
		 * then the flockBirds' radius is taken to use to make them move
		 */
		for (FlockBirds flockBirds : flockBirdsList) {
			
			if (flockBirds.toString().contains("Birds")) {
				ObstacleManager birdsManager = new ObstacleManager(flockBirds);
				double flockBirdRadius = flockBirds.getRadius();
				birdsManager.moveFlockBirds(flockBirdRadius);
			}

		}
		
	}
/*!
 * avoidObstacle()
 * @param aeronef
 * 
 * @brief Makes an aeronef avoid any given obstacle, be it mountain or flockbirds
 */
	public static void avoidObstacle(AeronefManager aeronefM) {
		Aeronef aeronef = aeronefM.getAeronef();
		for (Obstacle obstacle:obstaclesList) {
			if (obstacle.toString().contains("Mount")) {
				ObstacleManager mountainManager = new ObstacleManager(obstacle);
				mountainManager.avoidMountain(aeronef);
			}
			else if (obstacle.toString().contains("Birds")) {
				ObstacleManager birdsManager = new ObstacleManager(obstacle);
				birdsManager.avoidFlockBirds(aeronef);
			}
		}
		for (Aeronef obstacleAeronef : aeronefsList) {
				if(obstacleAeronef.getDestination().equals(aeronef.getDeparture())) {
					if(obstacleAeronef.isFlying()) {
//						aeronefM.avoidOtherAeronef(obstacleAeronef);
				}
			}
		}
	}	
}
