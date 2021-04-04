
package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.Position;
import data.FlockBirds;
import data.Line;
import data.Mountain;
import data.Aeronef;
import data.Airport;
import data.City;
import gui.SimulPara;
/*!
 * @file Simulation.java
 * @brief Classe lance la simulation sur la vue principale
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class Simulation {
	private Line line;
	private List<AeronefManager> aeronefManagers = new ArrayList<AeronefManager>();
	private List<FlockBirds> birds = new ArrayList<FlockBirds>();
	private List<Mountain> mountains = new ArrayList<Mountain>();
	private List<Airport> airportsList =  new ArrayList<Airport>();
	private Map<String, AirportManager> airportManagersMap = new HashMap<String, AirportManager>();
/*!
 * Constructor Simulation 
 */
	public Simulation() {
		initSimulation();
	}
/*!
 * getter getLine()
 * @return line la ligne entre deux aeroports
 */
	public Line getLine() {
		return line;
	}
/*!
 * addAeronef()
 * @param aeronef
 */
	public void addAeronef(Aeronef aeronef) {
		AeronefManager newAeronefManager = new AeronefManager(aeronef);
		aeronefManagers.add(newAeronefManager);

	}
/*!
 * initSimulation()
 * 
 * @brief Launches the simulation
 */
	public void initSimulation() {

		//We create a list of Airports
		airportsList = initAiport();
		
		//Lines are created between the airports of the list
		createLine(airportsList);
		initObstacle();
		
		//
		initAeronefs(airportsList);
		for (Airport airport : airportsList) {
			AirportManager newAirportManager = new AirportManager(airport);
			airportManagersMap.put(airport.getName(), newAirportManager);
		}

	}
/*!
 * initAirport()
 * @return airportList
 * 
 * @brief Creates six airports and adds them in an Airport list
 */
	public List<Airport> initAiport() {

		List<Airport> airportList = new ArrayList<Airport>();
		
		City yellowknife = new City("Yellowknife", "Canada");
		City melbourne = new City("Melbourne", "Australia");
		City ouagadougou = new City("Ouagadougou", "Burkina Faso");
		City mendoza = new City("Mendoza", "Argentina");
		City paris = new City("Paris", "France");
		City yakutsk = new City("Yakutsk", "Russia");

		Airport yellowknifeAirport = Utility.createAirport(285, 165, "Yellowknife Airport", "Civil/Cargo", yellowknife, "2007");
		Airport brisbaneAirport = Utility.createAirport(1115, 618, "Melbourne Airport", "Cargo", melbourne, "1988");
		Airport mendozaAirport = Utility.createAirport(415, 630, "Governor Francisco Gabrielli International Airport", "Civil", mendoza, "1941");
		Airport ouagadougouAirport = Utility.createAirport(615, 405, "Ouagadougou Airport", "Civil/Cargo/Military", ouagadougou, "1960");
		Airport cdgAirport = Utility.createAirport(645, 240, "Charles de Gaulle Airport", "Civil/Cargo", paris, "1974");
		Airport yakutskAirport = Utility.createAirport(1050, 180, "Yakutia Airlines", "Military", yakutsk, "2002");

		airportList.add(brisbaneAirport);
		airportList.add(yakutskAirport);
		airportList.add(cdgAirport);
		airportList.add(ouagadougouAirport);
		airportList.add(mendozaAirport);
		airportList.add(yellowknifeAirport);

		return airportList;
	}
/*!
 * CreateLine()
 * @param airports
 * 
 * @brief Creates a line between every airports of a given list of airports
 */
	public void createLine(List<Airport> airports) {
		LineBuilder lineBuilder = new LineBuilder();

		for (Airport airport1 : airports) {
			for (Airport airport2 : airports) {
			//each airport's name is unique so a line isn't created between the same airport
			if (!(airport1.getName().equals(airport2.getName()))) {
					lineBuilder.addLines(airport1, airport2);
				}
			}
		}
	}
/*!
 * initAeronefs()
 * @param airportsList
 * 
 * @brief Sets aeronefs at their start up position depending on the aeronefs in the airportsList
 */
	public void initAeronefs(List<Airport> airportsList) {
		for (Airport airport : airportsList) {
			//this describes the maximum of aeronefs allowed per line
			int numAeronefs = Utility.getRandom(5, 10);
			
			//for each aeronef in each airport
			for (int indexAeronefs = 0; indexAeronefs < numAeronefs; indexAeronefs++) {
				
				//we set a list of lines of each airport
				List<Line> linesList = airport.getLinesList();
				
				//sets a random index assigned to each aeronef for each airport
				int indexDestination = Utility.getRandom(0, linesList.size() - 1);
				
				/*
				 * if airport's name is one of the aeronefs' destination
				 * we change the index
				 */
				while ((airport.getName().equals(linesList.get(indexDestination).getdestination().getName()))) {
					indexDestination = Utility.getRandom(0, linesList.size() - 1);
				}
				
				//
				Airport destinationAirport = linesList.get(indexDestination).getdestination();
				String destinationName = destinationAirport.getName();
				String destinationCity = destinationAirport.getCity().getName();
				String modelAeronefs = getModelAeronefs(airport.getType());
				String aeronefName = getAeronefName(airport.getCity().getName(), destinationCity) + indexAeronefs;
				String aeronefType = getAeronefType(airport.getType(), destinationAirport.getType());
				
				//for each aeronef, set their base position as their airport's coordinates
				int aeronefAbscisse = (int) airport.getAbscissa();
				int aeronefOrdonnee = (int) airport.getOrdinate();
				
				//additionnal aeronef sets the total parked aeronef to increase
				int totaParkAeronefs = airport.getTerminal().getTotaParkAeronefs()+1;

				//each aeronef is created
				Aeronef aeronef = Utility.createAeronef(aeronefAbscisse, aeronefOrdonnee, aeronefName, aeronefType , modelAeronefs, destinationName, airport.getName(), 300, 100, 0, 1000);
				
				//each aeronef is added to the list of "taking off aeronefs" for each airport's terminal 
				airport.getTerminal().getTakeOffAeronefsList().add(aeronef);
				
				//setting the new value of totally parked Aeronefs
				airport.getTerminal().setTotaParkAeronefs(totaParkAeronefs);
				
				//adding aeronef to a new aeronefManager
				AeronefManager aeronefManager = new AeronefManager(aeronef);
				aeronefManagers.add(aeronefManager);
			}
		}
	}
	
	/*!
	 * @brief Cette methode creer les differents obstacle de la simulation 
	 */
	public void initObstacle() {
		Mountain stanlet = Utility.createMountain(710, 410, "Mount Stanlet", 5109, "Uganda");
		Mountain teton = Utility.createMountain(312, 265, "Grand Teton", 6699, "USA");
		Mountain rinjani = Utility.createMountain(965, 495, "Mount Rinjani", 4726, "Indonesia");
		Mountain khuiten = Utility.createMountain(1000, 210, "Khuiten Peak", 4856, "Mongolia");
		
		mountains.add(khuiten);
		mountains.add(teton);
		mountains.add(stanlet);
		mountains.add(rinjani);
	}
	
public Simulation(List<FlockBirds> birds, List<Mountain> mountains) {
		super();
		this.birds = birds;
		this.mountains = mountains;
	}
	/*!
 * getter getAeronefManagers()
 * @return aeronefManagers le manager des aeronefs
 */
	public List<AeronefManager> getAeronefManagers() {
		return aeronefManagers;
	}
/*!
 * setter setAeronefManagers()
 * @param aeronefManagers
 */
	public void setAeronefManagers(List<AeronefManager> aeronefManagers) {
		this.aeronefManagers = aeronefManagers;
	}
/*!
 * getter getAirportManagersMap
 * @return airportManagersMap
 */
	public Map<String, AirportManager> getAirportManagersMap() {
		return airportManagersMap;
	}
/*!
 * setter setAiportManagersMap()
 * @param airportManagersMap
 */
	public void setAirportManagersMap(Map<String, AirportManager> airportManagersMap) {
		this.airportManagersMap = airportManagersMap;
	}

/*!
 * getter getModelAeronefs()
 * @brief Given an index and type of an aeronef returns its model
 * @param type le type de l'aeronef
 * @return a String
 * 
 */
	public String getModelAeronefs(String type) {
		int aeronefName = Utility.getRandom(0, 3);
		if (type.equals("Military")) {
			switch (aeronefName) {
			case 0: {
				return "Dassault Rafale";
			}
			case 1: {
				return "F-35 Lightning II";
			}
			case 2: {
				return "Mikoyan MiG-25 Foxbat";
			}
			default:
				return "McDonnell Douglas F-15 Eagle";
			}
		} else {
			switch (aeronefName) {
			case 0: {
				return "Boeing 737";
			}
			case 1: {
				return "Boeing 777";
			}
			case 2: {
				return "Airbus A320";
			}
			default:
				return "Airbus A380";
			}
		}

	}
	
/*!
 * getter getAeronefType()
 * @param  departureAirportType le type de l'aroport de depart
 * @param destinationAirportType le type de l'aroport de destination
 * @return a String 
 * 
 * @brief retourne le type de l'aeronef
 */
	public String getAeronefType(String departureAirportType, String destinationAirportType) {
		String type = null;
		if(departureAirportType.contains("Military")&&!departureAirportType.contains("Civil")) {
			if(destinationAirportType.contains("Military")) {
				type = "Military";
			}
		}
		else if(destinationAirportType.contains("Military")&&!destinationAirportType.contains("Civil")) {
			if(departureAirportType.contains("Military")) {
				type =  "Military";
			}
		}
		else {
			type = departureAirportType;
		}
		return type;
	}
	
/*!
 * getAeronefName()
 * 
 * @param departure 
 * @param destination
 * @return a string
 * 
 * @brief This sets an aeronef's name depending on what's its startpoint and what's its destination
 */
	public String getAeronefName(String departure, String destination) {
		
		//takes away the spaces and at keeps the 6 first characters of each variable
		String nameDeparture = departure.trim().substring(0, 5);
		String nameDestination = destination.trim().substring(0, 5);
		return nameDeparture + "To" + nameDestination;
	}
/*!
 * getter getAirportsList()
 * @return aiportsList la liste des aeroports
 */
	public List<Airport> getAirportsList() {
		return airportsList;
	}
/*!
 * setter setAirportsList()
 * @param airportsList la liste des aeroports 
 */
	public void setAirportsList(List<Airport> airportsList) {
		this.airportsList = airportsList;
	}
	
	public List<Mountain> getMountainsList() {
		return mountains;
	}
	public void setMountainsList(List<Mountain> mountains) {
		this.mountains = mountains;
	}

}
