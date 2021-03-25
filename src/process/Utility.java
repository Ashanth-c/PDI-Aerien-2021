
package process;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import data.Aerodrome;
import data.Aeronef;
import data.Airport;
import data.City;
import data.FlockBirds;
import data.Line;
import data.Mountain;
import data.Obstacle;
import data.Terminal;
import gui.SimulPara;
/**
 * 
 * @author
 *	
 *	Classe contenant les méthodes utilitaires
 */
public class Utility {

	/**
	 * readImage method
	 * 
	 * @param filePath the path (from "src") of the image file
	 * @return the read file
	 * 
	 * Reads a image from an image file.
	 */
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}
/**
 *  unitTime method 
 *  causes the currently executing thread to sleep for 1000 milliseconds, 
 */
	public static void unitTime() {
		try {
			Thread.sleep(SimulPara.SIMULATION_SLEEP);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
/**
 * 	createCity method
 * @param cityName
 * @param countryName
 * @return city
 * 
 * Creates a new city with a given city name and an country name
 * 
 */
	public static City createCity(String cityName, String countryName) {

		return new City(cityName, countryName);
	}
/**
 *  createAirport	
 * @param abscisse
 * @param ordonnee
 * @param name
 * @param type
 * @param city
 * @param openingDate
 * @return airport
 * 
 * Creates an airport
 */
	public static Airport createAirport(int abscisse, int ordonnee, String name, String type, City city, String openingDate) {
		Aerodrome aerodrome = createAerodrome();
		Terminal terminal = createTerminal();
		List<Line> linesList = new ArrayList<Line>();
		Airport airport = new Airport(abscisse, ordonnee, name, type, aerodrome, terminal, city, openingDate, linesList);
		ElementManager.addAirport(name, airport);
		return airport;
	}
/**
 * 	createAeronef method
 * @param abscisse
 * @param ordonnee
 * @param name
 * @param type
 * @param model
 * @param destination
 * @param departure
 * @param totalSeats
 * @param fuel
 * @param altitude
 * @param speed
 * @return aeronef
 * 
 * Creates an aeronef
 */
	public static Aeronef createAeronef(int abscisse, int ordonnee, String name, String type, String model, String destination, String departure,int totalSeats, int fuel, int altitude, int speed) {
		
		Aeronef aeronef = new Aeronef(abscisse, ordonnee, name, type, model, destination, departure, totalSeats, fuel, altitude, speed, false,false);
		return aeronef;
	}
/**
 * createMountain	
 * @param abscisse
 * @param ordonnee
 * @param name
 * @param altitude
 * @param country
 * @return mountain
 * 
 * Creates a mountain
 */
	public static Mountain createMountain(int abscisse, int ordonnee, String name, int altitude, String country) {
		Mountain mountain = new Mountain(abscisse, ordonnee, name, altitude, country);
		ElementManager.addObstacle(mountain);
		ElementManager.addMountain(mountain);
		return mountain;
	}
/**
 * createFlockBirds
 * 
 * @param abscisse
 * @param ordonnee
 * @param name
 * @param altitude
 * @param numberOfBirds
 * @param speed
 * @param absCenter
 * @param ordCenter
 * @return flockBirds
 * 
 *	Creates flockBirds
 */
	public static FlockBirds createFlockBirds(int abscisse, int ordonnee, String name, int altitude, int numberOfBirds, int speed, int absCenter, int ordCenter) {
		FlockBirds flockBirds = new FlockBirds(abscisse, ordonnee, name, altitude, numberOfBirds, speed);
		double radius = getRadiusFlockBirds(flockBirds, absCenter, ordCenter);
		flockBirds.setRadius(radius);
		ElementManager.addObstacle(flockBirds);
		ElementManager.addFlockBirds(flockBirds);
		return flockBirds;
	}

/**
 * createLine method
 * @param airport1
 * @param airport2
 * 
 * Creates lines between two airports
 */
	public static void createLine(Airport airport1, Airport airport2) {
		LineBuilder builder = new LineBuilder();
		builder.addLines(airport1, airport2);
	}
/**
 * 	createTerminal method
 * @return terminal
 * 
 * Creates a terminal that has between 15 and 70 total parking places
 */
	private static Terminal createTerminal() {
		List<Aeronef> terminalList = new ArrayList<Aeronef>();
		List<Aeronef> terminalLandList = new ArrayList<Aeronef>();		

		int totalParkingPlace = getRandom(SimulPara.TERMINAL_MIN_PLACE, SimulPara.TERMINAL_MAX_PLACE);

		return new Terminal(totalParkingPlace, 0, terminalList ,terminalLandList);

	}
/**
 * createAerodrom method	
 * @return aerodrome
 * 
 * Creates an Aerodrome with 
 * 		runway length between 300 and 700 feet
 * 		totalrunway between 1 and 4
 * 
 */
	private static Aerodrome createAerodrome() {
		int runwayLenght = getRandom(SimulPara.AERODROME_MIN_RUNWAY_LENGHT, SimulPara.AERODROME_MAX_RUNWAY_LENGHT);
		int totalRunway = getRandom(SimulPara.AERODROME_MIN_RUNWAY, SimulPara.AERODROME_MAX_RUNWAY);
		
		return new Aerodrome(totalRunway, runwayLenght);

	}
/**
 * getRandom method
 * @param min
 * @param max
 * @return random number
 * 
 * Returns a random number between the chosen values set as entries
 */
	public static int getRandom(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}
/**
 * getRadiusFlockBirds methods
 * @param flockBirds
 * @param abCenter
 * @param odrCenter
 * @return radius
 * 
 * Returns the radius of a flockbirds group
 */
	private static double getRadiusFlockBirds(FlockBirds flockBirds, int abCenter, int odrCenter) {
		float flockBirdsAbscisse = flockBirds.getAbscisse();
		float flockBirdsOrdonnee = flockBirds.getOrdonnee();
		double radius = Math.sqrt(Math.pow((abCenter-flockBirdsAbscisse), 2)+(Math.pow((odrCenter-flockBirdsOrdonnee), 2)));
		
		return radius;
	}
}