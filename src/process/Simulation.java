
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

public class Simulation {
	private Line line;
	private List<ObstacleManager> obstacleManagers = new ArrayList<ObstacleManager>();
	private List<AeronefManager> aeronefManagers = new ArrayList<AeronefManager>();
	private List<FlockBirds> birds = new ArrayList<FlockBirds>();
	private List<Mountain> mountains = new ArrayList<Mountain>();
	private Map<String, AirportManager> airportManagersMap = new HashMap<String, AirportManager>();

	public Simulation() {
		initSimulation();
	}

	public Line getLine() {
		return line;
	}

	public void addAeronef(Aeronef aeronef) {
		AeronefManager newAeronefManager = new AeronefManager(aeronef);
		aeronefManagers.add(newAeronefManager);

	}

	public void initSimulation() {

		List<Airport> airportsList = initAiport();
		CreateLine(airportsList);
		initAeronefs(airportsList);
		for (Airport airport : airportsList) {
			AirportManager newAirportManager = new AirportManager(airport);
			airportManagersMap.put(airport.getName(), newAirportManager);
		}

	}

	public List<Airport> initAiport() {

		List<Airport> aiportList = new ArrayList<Airport>();
		City sanFrancisco = new City("San Francisco", "United States");
		City hongKong = new City("Hong Kong", "China");
		City brisbane = new City("Brisbane", "Australia");
		City casablanca = new City("Casablanca", "Morocco");
		City rio = new City("Rio de Janeiro", "Brazil");
		City mexico = new City("Mexico City", "Mexico");
		City paris = new City("Paris", "France");
		City moscow = new City("Moscow", "Russia");

		Airport sfAirport = Utility.createAirport(245, 270, "San Francisco International Airport", "Civil/Cargo",
				sanFrancisco, "1927");
		Airport hgkgAirport = Utility.createAirport(1020, 330, "Shek Kong Airfield", "Military", hongKong, "1950");
		Airport brisbaneAirport = Utility.createAirport(1100, 550, "Brisbane Airport", "Cargo", brisbane, "1988");
		Airport rioAirport = Utility.createAirport(500, 530, "Galeão Air Force Base", "Military", rio, "1941");
		Airport casablancaAirport = Utility.createAirport(615, 320, "Mohammed V International Airport", "Civil",
				casablanca, "1963");
		Airport MexicoAirport = Utility.createAirport(300, 340, "Mexico City International Airport", "Civil", mexico,
				"1931");
		Airport cdgAirport = Utility.createAirport(645, 240, "Charles de Gaulle Airport", "Civil", paris, "1974");
		Airport moscowAirport = Utility.createAirport(900, 200, "Sheremetyevo International Airport", "Cargo", moscow,
				"1959");

		aiportList.add(MexicoAirport);
		aiportList.add(brisbaneAirport);
		aiportList.add(moscowAirport);
		aiportList.add(cdgAirport);
		aiportList.add(casablancaAirport);
		aiportList.add(rioAirport);
		aiportList.add(hgkgAirport);
		aiportList.add(sfAirport);

		return aiportList;
	}

	public void CreateLine(List<Airport> airports) {
		LineBuilder lineBuilder = new LineBuilder();

		for (Airport airport1 : airports) {
			for (Airport airport2 : airports) {
				if (!(airport1.getName().equals(airport2.getName()))) {
					lineBuilder.addLines(airport1, airport2);
				}
			}
		}
	}

	public void initAeronefs(List<Airport> airportsList) {
		for (Airport airport : airportsList) {
			int numAeronefs = Utility.getRandom(1, airport.getTerminal().getTotalParkingPlace());
			for (int indexAeronefs = 0; indexAeronefs < numAeronefs; indexAeronefs++) {
				List<Line> linesList = airport.getLinesList();
				int indexDestination = Utility.getRandom(0, linesList.size() - 1);
				while ((airport.getName().equals(linesList.get(indexDestination).getdestination().getName()))) {
					indexDestination = Utility.getRandom(0, linesList.size() - 1);
				}
				Airport destinationAirport = linesList.get(indexDestination).getdestination();
				String destinationName = destinationAirport.getName();
				String destinationCity = destinationAirport.getCity().getName();
				String modelAeronefs = getModelAeronefs(airport.getType());
				String aeronefName = getAeronefName(airport.getCity().getName(), destinationCity) + indexAeronefs;
				int aeronefAbscisse = (int) airport.getAbscisse();
				int aeronefOrdonnee = (int) airport.getOrdonnee();
				Aeronef aeronef = Utility.createAeronef(aeronefAbscisse, aeronefOrdonnee, aeronefName, airport.getType(), modelAeronefs, destinationName, airport.getName(), 300, 100, 0, 1000, false);
				AeronefManager aeronefManager = new AeronefManager(aeronef);
				aeronefManagers.add(aeronefManager);
			}
		}
	}

	public List<AeronefManager> getAeronefManagers() {
		return aeronefManagers;
	}

	public void setAeronefManagers(List<AeronefManager> aeronefManagers) {
		this.aeronefManagers = aeronefManagers;
	}

	public Map<String, AirportManager> getAirportManagersMap() {
		return airportManagersMap;
	}

	public void setAirportManagersMap(Map<String, AirportManager> airportManagersMap) {
		this.airportManagersMap = airportManagersMap;
	}

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

	public String getAeronefName(String departure, String destination) {
		String nameDeparture = departure.substring(0, 5);
		String nameDestination = destination.substring(0, 5);
		return nameDeparture + "To" + nameDestination;
	}

}