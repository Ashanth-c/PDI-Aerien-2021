
package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import data.Position;
import data.FlockBirds;
import data.Line;
import data.Moutain;
import data.Aeronef;
import gui.SimulPara;


public class Simulation {
	private Line line;
	private List<ObstacleManager> blockManagers = new ArrayList<ObstacleManager>();
	private List<AeronefManager> AeronefManagers = new ArrayList<AeronefManager>();
	private	List<AirportManager> airportManagers = new ArrayList<AirportManager>();
	private List<FlockBirds> birds = new ArrayList<FlockBirds>();
	private List<Moutain> mountains = new ArrayList<Moutain>();

	public Simulation() {
		LineBuilder lineBuilder = new LineBuilder();
		//lineBuilder.buildLine(SimulPara.LINE_TOTAL_LENGTH, SimulPara.BLOCK_LENGTH);
//		line = lineBuilder.getBuiltLine();
  }


public Line getLine() {
		return line;
	}
  
}

