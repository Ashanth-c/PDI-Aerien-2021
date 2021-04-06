
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

/*!
 * @file Utility.java
 * @brief Classe contenant les méthodes utilitaires
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class Utility {

	/*
	 * readImage()
	 * 
	 * @param filePath le chemin (à partir de "src") du fichier image
	 * @return le fichier lu
	 * 
	 * @brief Reads a image from an image file.
	 */
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}
/*!
 *  unitTime()
 *  @brief provoque la mise en veille du thread en cours d'exécution pendant 1000 millisecondes,
 */
	public static void unitTime() {
		try {
			Thread.sleep(SimulPara.SIMULATION_SLEEP);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
/*!
 * createCity()
 * @param cityName le nom de la ville
 * @param countryName le nom de la pays
 * @return city la ville
 * 
 * @brief Crée une nouvelle ville avec un nom de ville donné et un nom de pays
 * 
 */
	public static City createCity(String cityName, String countryName) {

		return new City(cityName, countryName);
	}
/*!
 *  createAirport()	
 * @param abscisse le cordonnee x de l'aeroport
 * @param ordonnee le cordonnee y de l'aeroport
 * @param name le nom de l'aeroport
 * @param type le type de l'aeroport
 * @param city la ville de l'aeroport
 * @param openingDate la date d'ouverture de l'aeroport
 * @return airport
 * 
 * @brief Crée un aéroport
 */
	public static Airport createAirport(int abscisse, int ordonnee, String name, String type, City city, String openingDate) {
		Aerodrome aerodrome = createAerodrome();
		Terminal terminal = createTerminal();
		List<Line> linesList = new ArrayList<Line>();
		Airport airport = new Airport(abscisse, ordonnee, name, type, aerodrome, terminal, city, openingDate, linesList);
		ElementManager.addAirport(name, airport);
		return airport;
	}
/*!
 * createAeronef()
 * @param abscisse le cordonnee x de l'aeroport
 * @param ordonnee le cordonnee y de l'aeroport
 * @param name le nom de l'aeronef
 * @param type le type de l'aeronef
 * @param model le model de l'aeronef
 * @param destination l'aeroport de destination
 * @param departure l'aeroport de depart
 * @param totalSeats
 * @param fuel
 * @param altitude l'altitude de l'aeronef
 * @param speed la vitesse de l'aeronef
 * @return aeronef
 * 
 * @brief Creates an aeronef
 */
	public static Aeronef createAeronef(int abscisse, int ordonnee, String name, String type, String model, String destination, String departure,int totalSeats, int fuel, int altitude, int speed) {
		
		Aeronef aeronef = new Aeronef(abscisse, ordonnee, name, type, model, destination, departure, totalSeats, fuel, altitude, speed, false, "No", false);
		ElementManager.addAeronef(aeronef);
		return aeronef;
	}
/*!
 * createMountain	
 * @param abscisse le cordonnee x de la montagne
 * @param ordonnee le cordonnee y de la montagne
 * @param name le nom de l'aeronef
 * @param altitude l'altitude de la montagne
 * @param country le pays de la montagne
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
/*!
 * createFlockBirds
 * 
 * @param abscisse le cordonnee x des oiseaux
 * @param ordonnee le cordonnee y des oiseaux
 * @param name le nom des oiseaux
 * @param altitude l'altitude des oiseaux
 * @param numberOfBirds le nombre des groupes des oiseaux
 * @param speed la vitesse des oiseaux
 * @param absCenter l'abscisse du centre
 * @param ordCenter l'ordonne du centre
 * @return flockBirds le groupe des oiseaux
 * 
 * @brief Creer flockBirds
 */
	public static FlockBirds createFlockBirds(int abscisse, int ordonnee, String name, int altitude, int numberOfBirds, int speed, int absCenter, int ordCenter) {
		FlockBirds flockBirds = new FlockBirds(abscisse, ordonnee, name, altitude, numberOfBirds, speed);
		double radius = getRadiusFlockBirds(flockBirds, absCenter, ordCenter);
		flockBirds.setRadius(radius);
		ElementManager.addObstacle(flockBirds);
		ElementManager.addFlockBirds(flockBirds);
		return flockBirds;
	}

/*!
 * createLine()
 * @param airport1
 * @param airport2
 * 
 * @brief Creer les lignes entre les aeroports
 */
	public static void createLine(Airport airport1, Airport airport2) {
		LineBuilder builder = new LineBuilder();
		builder.addLines(airport1, airport2);
	}
/*!
 * createTerminal()
 * @return terminal
 * 
 * @brief Crée un terminal qui compte entre 15 et 70 places de parking au total
 */
	private static Terminal createTerminal() {
		List<Aeronef> terminalList = new ArrayList<Aeronef>();
		List<Aeronef> terminalLandList = new ArrayList<Aeronef>();		

		int totalParkingPlace = getRandom(SimulPara.TERMINAL_MIN_PLACE, SimulPara.TERMINAL_MAX_PLACE);

		return new Terminal(totalParkingPlace, 0, terminalList ,terminalLandList);

	}
/*!
 * createAerodrom()	
 * @return aerodrome
 * 
 * @brief Crée un aérodrome avec une longueur de piste comprise entre 300 et 700 pieds au total, piste entre 1 et 4
 * 
 */
	private static Aerodrome createAerodrome() {
		int runwayLenght = getRandom(SimulPara.AERODROME_MIN_RUNWAY_LENGHT, SimulPara.AERODROME_MAX_RUNWAY_LENGHT);
		int totalRunway = getRandom(SimulPara.AERODROME_MIN_RUNWAY, SimulPara.AERODROME_MAX_RUNWAY);
		
		return new Aerodrome(totalRunway, runwayLenght);

	}
/*!
 * getRandom()
 * @param min
 * @param max
 * @return random number
 * 
 * @brief Renvoie un nombre aléatoire entre les valeurs choisies définies comme entrées
 */
	public static int getRandom(int min, int max) {
		return (int) (Math.random() * (max + 1 - min)) + min;
	}
/*!
 * getRadiusFlockBirds()
 * @param flockBirds
 * @param abCenter
 * @param odrCenter
 * @return radius
 * 
 * @brief Renvoie le rayon d'un groupe Flockbirds
 */
	private static double getRadiusFlockBirds(FlockBirds flockBirds, int abCenter, int odrCenter) {
		float flockBirdsAbscisse = flockBirds.getAbscissa();
		float flockBirdsOrdonnee = flockBirds.getOrdinate();
		double radius = Math.sqrt(Math.pow((abCenter-flockBirdsAbscisse), 2)+(Math.pow((odrCenter-flockBirdsOrdonnee), 2)));
		
		return radius;
	}
}
