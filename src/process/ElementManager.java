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

public class ElementManager {
	private static Map<String, Airport> airportMap = new HashMap<String, Airport>();
	private static List<Aeronef> aeronefsList = new ArrayList<Aeronef>();
	private static List<Obstacle> obstaclesList = new ArrayList<Obstacle>();
	private static List<FlockBirds> flockBirdsList = new ArrayList<FlockBirds>();
	private static List<Mountain> mountainsList = new ArrayList<Mountain>();

	public ElementManager() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public static void addAeronef(Aeronef aeronef) {
		aeronefsList.add(aeronef);
	}
	
	public static void addAirport(String key, Airport value) {
		airportMap.put(key, value);
	}
	
	public static void addObstacle(Obstacle obstacle) {
		obstaclesList.add(obstacle);
	}
	
	public static void addFlockBirds(FlockBirds flockbirds) {
		flockBirdsList.add(flockbirds);
	}
	
	public static void addMountain(Mountain mountain) {
		mountainsList.add(mountain);
	}
	
	public static String checkAirportsAround(Aeronef aeronef) {
		String airportName = "SearchEmergencyAirport";
		float aeronefOrdonnee = aeronef.getOrdonnee();
		float aeronefAbscisse = aeronef.getAbscisse();
		
		for(Entry<String, Airport> airportM : airportMap.entrySet()) {
			Airport airport = airportM.getValue();
			if (aeronefAbscisse+100>=airport.getAbscisse() && aeronefOrdonnee+100>=airport.getOrdonnee() && aeronefAbscisse-100<=airport.getAbscisse() && aeronefOrdonnee-100<=airport.getOrdonnee()) {
				System.out.println("Atterissage en urgence réussi");
				airportName = airport.getName();
			}
		}
		return airportName;
	}
	
	public static float abscisseVariationValue(Aeronef aeronef, Airport destinationAirport, int time) {
		float aeronefAbscisse = aeronef.getAbscisse();
		float airportAbscisse = destinationAirport.getAbscisse();
		time/=100;

		float abscisseVariation = (airportAbscisse - aeronefAbscisse) / time;

		return abscisseVariation;

	}

	public static float ordoneeVariationValue(Aeronef aeronef, Airport destinationAirport, int time) {
		float aeronefOrdonnee = aeronef.getOrdonnee();
		float airportOrdonnee = destinationAirport.getOrdonnee();
		time/=100;

		float ordonneeVariation = (airportOrdonnee - aeronefOrdonnee) / time;

		return ordonneeVariation;

	}
	
	public static Airport getAiportFromName(String airportName) {
			return airportMap.get(airportName);
	}
	
	public static void ObstacleMouvement() {
		for (FlockBirds flockBirds : flockBirdsList) {
			if (flockBirds.toString().contains("Birds")) {
				ObstacleManager birdsManager = new ObstacleManager(flockBirds);
				double flockBirdRadius = flockBirds.getRadius();
				birdsManager.moveFlockBirds(flockBirdRadius);
			}

		}
		
	}
	
	public static void avoidObstacle(Aeronef aeronef) {
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
	}	
}