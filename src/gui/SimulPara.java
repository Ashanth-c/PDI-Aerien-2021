

package gui;
/*!
 * @file SimulPara.java
 * @author Khadija
 * @author Ashanth
 * @author Maeva
 * @version 1.0
 * @date 06/04/2021
 */

public class SimulPara {
	
	/*!
	 * @brief This class contains necessary simulation parameters
	 * @author Ashanth
	 * @author Khadija aeronef manager
	 * @author Maeva mountain manager
	 */
	
	public static final int LINE_TOTAL_LENGTH = 70000;
	
	public static final int BLOCK_LENGTH = 1000;
		
	public static final int TERMINAL_MIN_PLACE = 15;
	public static final int TERMINAL_MAX_PLACE = 70;

	public static final int AERODROME_MIN_RUNWAY = 1;
	public static final int AERODROME_MAX_RUNWAY = 4;

	public static final int AERODROME_MIN_RUNWAY_LENGHT = 300;
	public static final int AERODROME_MAX_RUNWAY_LENGHT = 700;
	
	public static final int Airport_MIN_STAY = 4;
	public static final int Airport_MAX_STAY = 10;

	public static final int Aeronef_INTERVALL = 50;
	public static final int Aeronef_MIN_SPEED = 4000;
	public static final int Aeronef_MAX_SPEED = 11200;

	public static final int SIMULATION_SPEED = 2000;
	
	public static final int SIMULATION_URGENCE_SPEED = 800;
	
	public static final int SIMULATION_SLEEP = 1000;

	public static final String[] MOUNTAINS= new String[] {"montagne 1","montagne 2", "montagne 3", "montagne4"};

	public static final int[] MOUNTAINS_X=new int[] {600,750,960,960};

	public static final int[] MOUNTAINS_Y=new int[] {200+10,450,500,280};

	public static final int[] ALTITUDE =new int[] {0,4000, 6100, 11200};
	
	
}
