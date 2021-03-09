
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

public class Utility {

	/**
	 * Reads a image from an image file.
	 * 
	 * @param filePath the path (from "src") of the image file
	 * @return the read file
	 */
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}

	public static void unitTime() {
		try {
			Thread.sleep(SimulPara.SIMULATION_SPEED);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static City createCity(String cityName, String countryName) {

		return new City(cityName, countryName);
	}
	
	public static Airport createAirport(int abscisse, int ordonnee, String name, String type, City city, String openingDate) {
		Aerodrome aerodrome = createAerodrome();
		Terminal terminal = createTerminal();
		List<Line> linesList = new ArrayList<Line>();
		Airport airport = new Airport(abscisse, ordonnee, name, type, aerodrome, terminal, city, openingDate, linesList);
		ElementManager.addAirport(name, airport);
		return airport;
	}
	
	public static Aeronef createAeronef(int abscisse, int ordonnee, String type, String model, String destination, String departure,int totalSeats, int fuel, int altitude, int speed, boolean urgent) {
		
		Aeronef aeronef = new Aeronef(abscisse, ordonnee, type, model, destination, departure, totalSeats, fuel, altitude, speed, urgent);
		Airport departureAirport = ElementManager.getAiportFromName(departure);
		AirportManager airportManager =new AirportManager(departureAirport);
		airportManager.addAeronefTerminal(aeronef);
		return aeronef;
	}
	
	public static Mountain createMountain(int abscisse, int ordonnee, String name, int altitude, String country) {
		Mountain mountain = new Mountain(abscisse, ordonnee, name, altitude, country);
		ElementManager.addObstacle(mountain);
		return mountain;
	}

	public static FlockBirds createFlockBirds(int abscisse, int ordonnee, String name, int altitude, int numberOfBirds, int speed) {
		FlockBirds flockBirds = new FlockBirds(abscisse, ordonnee, name, altitude, numberOfBirds, speed);	
		ElementManager.addObstacle(flockBirds);
		return flockBirds;
	}

	
	public static void createLine(Airport airport1, Airport airport2) {
		LineBuilder builder = new LineBuilder();
		builder.addLines(airport1, airport2);
	}
	
	private static Terminal createTerminal() {
		List<Aeronef> terminalList = new ArrayList<Aeronef>();
		int totalParkingPlace = getRandom(SimulPara.TERMINAL_MIN_PLACE, SimulPara.TERMINAL_MAX_PLACE);

		return new Terminal(totalParkingPlace, 0, terminalList);

	}
	
	private static Aerodrome createAerodrome() {
		int runwayLenght = getRandom(SimulPara.AERODROME_MIN_RUNWAY_LENGHT, SimulPara.AERODROME_MAX_RUNWAY_LENGHT);
		int totalRunway = getRandom(SimulPara.AERODROME_MIN_RUNWAY, SimulPara.AERODROME_MAX_RUNWAY);
		
		return new Aerodrome(totalRunway, runwayLenght);

	}

	private static int getRandom(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}
}
