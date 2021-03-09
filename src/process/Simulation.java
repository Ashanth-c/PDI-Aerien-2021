
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
import gui.SimulPara;

public class Simulation {
	private Line line;
	private List<ObstacleManager> obstacleManagers = new ArrayList<ObstacleManager>();
	private List<AeronefManager> aeronefManagers = new ArrayList<AeronefManager>();
	private List<FlockBirds> birds = new ArrayList<FlockBirds>();
	private List<Mountain> mountains = new ArrayList<Mountain>();
	private Map<String, AirportManager> airportManagers = new HashMap<String, AirportManager>();

	public Simulation() {
		LineBuilder lineBuilder = new LineBuilder();
		// lineBuilder.buildLine(SimulPara.LINE_TOTAL_LENGTH, SimulPara.BLOCK_LENGTH);
//		line = lineBuilder.getBuiltLine();
	}

	public Line getLine() {
		return line;
	}

	public void addAeronef(Aeronef aeronef) {
		AeronefManager newAeronefManager = new AeronefManager(aeronef);
		aeronefManagers.add(newAeronefManager);

	}
	
	public void addAirport(Airport airport) {
		AirportManager newAirportManager = new AirportManager(airport);
		String airportName = airport.getName();
		airportManagers.put(airportName, newAirportManager);
	}
	
}
