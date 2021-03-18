
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
	private List<AeronefManager> aeronefManagers = new ArrayList<AeronefManager>();
	private List<FlockBirds> birds = new ArrayList<FlockBirds>();
	private List<Mountain> mountains = new ArrayList<Mountain>();
	private List<Airport> airportsList =  new ArrayList<Airport>();
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

		airportsList = initAiport();
		CreateLine(airportsList);
		initAeronefs(airportsList);
		for (Airport airport : airportsList) {
			AirportManager newAirportManager = new AirportManager(airport);
			airportManagersMap.put(airport.getName(), newAirportManager);
		}

	}

	public List<Airport> initAiport() {

		List<Airport> aiportList = new ArrayList<Airport>();
		
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

		aiportList.add(brisbaneAirport);
		aiportList.add(yakutskAirport);
		aiportList.add(cdgAirport);
		aiportList.add(ouagadougouAirport);
		aiportList.add(mendozaAirport);
		aiportList.add(yellowknifeAirport);

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
			int numAeronefs = Utility.getRandom(5, 10);
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
				int totaParkAeronefs = airport.getTerminal().getTotaParkAeronefs()+1;

				
				Aeronef aeronef = Utility.createAeronef(aeronefAbscisse, aeronefOrdonnee, aeronefName, airport.getType(), modelAeronefs, destinationName, airport.getName(), 300, 100, 0, 1000, false);
				airport.getTerminal().getTakeOffAeronefsList().add(aeronef);
				airport.getTerminal().setTotaParkAeronefs(totaParkAeronefs);
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
		
		String nameDeparture = departure.trim().substring(0, 5);
		String nameDestination = destination.trim().substring(0, 5);
		return nameDeparture + "To" + nameDestination;
	}

	public List<Airport> getAirportsList() {
		return airportsList;
	}

	public void setAirportsList(List<Airport> airportsList) {
		this.airportsList = airportsList;
	}

}