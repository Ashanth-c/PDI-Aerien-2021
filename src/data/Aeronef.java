package data;

/**
 * @file Aeronef.java
 * @brief Un aéronef represente un element volant d'un aeroport à un autre
 * Aeronef est heritiere de la classe Position
 * @author Ashanth
 * @version 1.0
 * @date 06/04/2021
 */
public class Aeronef extends Position {

	private String type;
	private String model;
	private String destination;
	private String departure;
	private String name;
	private int totalSeats;
	private int fuel;
	private int altitude;
	private int speed;
	private boolean urgent;
	private boolean detectObstacle;
	private boolean isFlying;

	/**
	 * @brief Creer un Aeronef au position (abscisse,ordonnee) donnne en parametre 
	 * @param abscissa Le coordonnee X de l'aeronef 
	 * @param ordinate Le coodonee Y de l'aeronef
	 */
	public Aeronef(int abscissa, int ordinate) {
		super(abscissa, ordinate);
	}
	
	/**
	 * @brief Creer un Aeronef au position (abscisse,ordonnee) donnne en parametre avec toute les informations qui definise l'aeronef
	 * @param abscissa Le coordonnee X de l'aeronef 
	 * @param ordinate Le coodonee Y de l'aeronef
	 * @param name Nom de l'aeronef composé des initiale des aeroports de depart et d'arrive ainsi que d'un numero qui incremente
	 * @param type Type de l'aeronef parmis 3 type (Military,Civil/Cargo, Cargo)
	 * @param model Modele de l'aeronef 
	 * @param destination Nom de l'aeroport de destination de l'aeronef
	 * @param departure Nom de l'aeroport de depart de l'aeronef
	 * @param totalSeats Nombre de place total dans l'aeronef
	 * @param fuel Valeur indiquant le niveau d'essence de l'aeronef
	 * @param altitude Valeur indiquant l'altitude de l'aeronef
	 * @param speed Vitesse de l'aeronef en kilimetre/heure
	 * @param urgent Booleen qui indique si l'aeronef doit atterir en urgence
	 * @param detectObstacle Boobleen qui indique si l'aeronef a detecté un obstacle proche
	 * @param isfly Booleen qui indique si un aeronef est en vol
	 */
	public Aeronef(int abscisse, int ordonnee, String name, String type, String model, String destination, String departure,
			int totalSeats, int fuel, int altitude, int speed, boolean urgent,boolean detectObstacle, boolean isfly) {
		super(abscisse, ordonnee);
		this.name=name;
		this.type = type;
		this.model = model;
		this.destination = destination;
		this.departure = departure;
		this.totalSeats = totalSeats;
		this.fuel = fuel;
		this.altitude = altitude;
		this.speed = speed;
		this.urgent=urgent;
		this.detectObstacle = detectObstacle;
		this.isFlying = isfly;
	}

	/**
	 * @brief Retourne le type de l'aeronef, Cette methode permet de determiner dans quelle type d'aeroport l'aeronef peut atterir
	 * @return type, le type de l'aeronef
	 */
	public String getType() {
		return type;
	}

	/**
	 * @brief Change le type de l'aeronef
	 * @param type Nouveau type de l'aeronef 
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @brief Retourne le modele de l'aeronef
	 * @return model, le nom du model de l'aeronef
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @brief Change le modele de l'aeronef par un autre
	 * @param model Nouveau modele de l'aeronef
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @brief Retourne le nom de l'aeroport de destination, cette methode permet de connaitre la destination de l'aeronef
	 * @return destination, le nom de l'aeroport de destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @brief Change la valeur du nom de l'aeroport de destination
	 * @param destination Nom du nouvel aeroport de destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
	 * @brief
	 * @return
	 */
	public String getDeparture() {
		return departure;
	}

	/**
	 * 
	 * @param departure
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}

	/**
	 * 
	 * @return
	 */
	public int getTotalSeats() {
		return totalSeats;
	}

	/**
	 * 
	 * @param totalSeats
	 */
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	

	/**
	 * 
	 * @return
	 */
	public int getFuel() {
		return fuel;
	}

	/**
	 * 
	 * @param fuel
	 */
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	/**
	 * 
	 * @return
	 */
	public int getAltitude() {
		return altitude;
	}

	/**
	 * 
	 * @param altitude
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	/**
	 * 
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getUrgent() {
		return urgent;
	}

	/**
	 * 
	 * @param urgent
	 */
	public void setUrgent(boolean urgent) {
		this.urgent=urgent;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isDetectObstacle() {
		return detectObstacle;
	}

	/**
	 * 
	 * @param detectObstacle
	 */
	public void setDetectObstacle(boolean detectObstacle) {
		this.detectObstacle = detectObstacle;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isFlying() {
		return isFlying;
	}
	
	/**
	 * 
	 * @param isFlying
	 */
	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "AERONEF\nNname: "+ name + "\nType: " + type + "\nModel: " + model + "\nDestination:\n" + destination + "\nDeparture:\n"
				+ departure + "\nTotal Seats: " + totalSeats + "\nFuel: " + fuel + "\nAltitude: " + altitude + "\nSpeed: "
				+ speed;
	}

}
