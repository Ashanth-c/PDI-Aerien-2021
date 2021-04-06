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
 * @brief Classe qui aide à la gestion des éléments présent dans la simulation.
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
	 * @brief Créer un ElementManager qui va aider pour la gestion des éléments
	 */
	public ElementManager() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/*!
	 * addAeronef()	
	 * @brief Ajoute un aeronef dans la liste des aeronefs présent dans la simulation
 	* @param aeronef Nouveau aeronef que l'on souhaite ajouter
 	*/
	public static void addAeronef(Aeronef aeronef) {
		aeronefsList.add(aeronef);
	}
	/*!
	 * addAirport()
	 * @param key
	 * @param value 
	 * @brief Ajoute un aéroport et une clé dans airportMap
	 */
	public static void addAirport(String key, Airport value) {
		airportMap.put(key, value);
	}
/*!
 * addObstacle()
 * @param obstacle
 * 
 * @brief Ajoute un obstacle dans la liste des obstacles
 */
	public static void addObstacle(Obstacle obstacle) {
		obstaclesList.add(obstacle);
	}
/*!
 * addFlockBirds()	
 * @param flockbirds
 * 
 * @brief ajouter flockbirds dans flockBirdsList
 */
	public static void addFlockBirds(FlockBirds flockbirds) {
		flockBirdsList.add(flockbirds);
	}
/*!
 * addMountain()
 * @param mountain
 * 
 * @brief ajouter mountain dans mountainsList
 */
	public static void addMountain(Mountain mountain) {
		mountainsList.add(mountain);
	}

/*!
 * checkAirportsAround()
 * @param aeronef
 * @return airportName
 * 
 * @brief Vérifie les aéroports autour d'un aeronef, renvoie le nom d'aéroport le plus proche d'un aeronef
 */
	public static String checkAirportsAround(Aeronef aeronef) {
		//setting important variables
		String airportName = "SearchEmergencyAirport";
		float aeronefOrdonnee = aeronef.getOrdinate();
		float aeronefAbscisse = aeronef.getAbscissa();
		
		//pour chaque aéroport dans le paramètre entrySet de airportMap, un aéroport est défini comme valeur d'aéroport
		for(Entry<String, Airport> airportM : airportMap.entrySet()) {
			Airport airport = airportM.getValue();
			
			//on vérifie s'il y a un aeronef près de l'aéroport, si oui son nom sera retourné
			if (aeronefAbscisse+100>=airport.getAbscissa() && aeronefOrdonnee+100>=airport.getOrdinate() && aeronefAbscisse-100<=airport.getAbscissa() && aeronefOrdonnee-100<=airport.getOrdinate()) {
				airportName = airport.getName();
			}
		}
		return airportName;
	}
/*!
 * abscisseVariationValue()
 * 
 * @param aeronef
 * @param destinationAirport l'aéroport de destination
 * @param time
 * @return abscisseVariation
 * 
 * @brief returns ( airport's abscisse - aeronef's abscisse) / 100
 */
	public static float abscisseVariationValue(Aeronef aeronef, Airport destinationAirport, int time) {
		float aeronefAbscisse = aeronef.getAbscissa();
		float airportAbscisse = destinationAirport.getAbscissa();
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
		float aeronefOrdonnee = aeronef.getOrdinate();
		float airportOrdonnee = destinationAirport.getOrdinate();
		time/=100;

		float ordonneeVariation = (airportOrdonnee - aeronefOrdonnee) / time;

		return ordonneeVariation;

	}
/*!
 * getAirportFromname()
 * @param airportName
 * @return airportName
 * 
 * @brief Utilise le nom d'un aéroport pour renvoyer ledit aéroport depuis l'aéroport
 */
	public static Airport getAiportFromName(String airportName) {
			return airportMap.get(airportName);
	}
/*!
 * ObstacleMouvement()
 * 
 * @brief Fait bouger les oiseaux
 */
	public static void ObstacleMouvement() {
		
		/*
		 * Pour chaque volée en flockBirdsList
		 * si la chaîne toString de flockBirds contient la chaîne "Birds"
		 * Un nouvel ObstacleManager est créé pour ces flockBirds
		 * puis le rayon du flockBirds est utilisé pour les faire bouger
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
	 * @brief Indique si un aeronef donnée est proche d'une montagne donnée
	 * @param mountainName Nom de la montagne
	 * @param aeronefName Nom de l'aeronef
	 * @return ismountain, boolean qui indique si l'aeronef est proche d'une montagne
	 */
	public static boolean isNearMountain(String mountainName, String aeronefName) {
		boolean ismountain = false;
		if(aeronefName.contains("YelloToM") || aeronefName.contains("MendoToY")) {
			if(mountainName.contains("Teton")) {
				ismountain = true;
			}
		}
		else if(aeronefName.contains("ParisToMelbo") || aeronefName.contains("MelboToP")) {
			if(mountainName.contains("Rinjani")) {
				ismountain = true;
			}			
		}
		else if(aeronefName.contains("YakutToO") || aeronefName.contains("OuagaToYa")) {
			if(mountainName.contains("Khuiten")) {
				ismountain = true;
			}
		}
		else if(aeronefName.contains("OuagaToMel") || aeronefName.contains("MelboToO")) {
			if(mountainName.contains("Cameroon")) {
				ismountain = true;
			}
		}
		return ismountain;
	}
	
/*!
 * avoidObstacle()
 * @param aeronef
 * 
 * @brief Permet à un aeronef d'éviter tout obstacle donné, que ce soit des oiseaux de montagne ou de troupeaux
 */
	public static void avoidObstacle(AeronefManager aeronefM) {
		Aeronef aeronef = aeronefM.getAeronef();
		for (Obstacle obstacle:obstaclesList) {
			if (obstacle.toString().contains("Mount")) {
				ObstacleManager mountainManager = new ObstacleManager(obstacle);
				if(isNearMountain(obstacle.getName(), aeronef.getName())) {
				mountainManager.avoidMountain(aeronef);
				}
			}
			else if (obstacle.toString().contains("Birds")) {
				ObstacleManager birdsManager = new ObstacleManager(obstacle);
				birdsManager.avoidFlockBirds(aeronef);
			}
		}
		for (Aeronef obstacleAeronef : aeronefsList) {
			if(obstacleAeronef.isFlying()) {	
				if(obstacleAeronef.getDestination().equals(aeronef.getDeparture())) {
					aeronefM.avoidOtherAeronef(obstacleAeronef);
				}
			}
		}
	}
}
