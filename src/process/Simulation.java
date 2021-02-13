
package process;

import java.util.ArrayList;
import java.util.HashMap;

import data.Block;
import data.Line;
import data.Aeronef;
import gui.SimulPara;


public class Simulation {
	private Line line;
	private volatile ArrayList<BlockManager> blockManagers = new ArrayList<BlockManager>();
	private volatile HashMap<Integer, BlockManager> blockManagersByPosition = new HashMap<Integer, BlockManager>();

	private ArrayList<AeronefManager> AeronefManagers = new ArrayList<AeronefManager>();

	public Simulation() {
		LineBuilder lineBuilder = new LineBuilder();
		//lineBuilder.buildLine(SimulPara.LINE_TOTAL_LENGTH, SimulPara.BLOCK_LENGTH);
		line = lineBuilder.getBuiltLine();
  }


public Line getLine() {
		return line;
	}
  
}

