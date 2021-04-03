package data;

/*!
 * @file Aeronef.java
 * @brief Un aéronef represente un element volant d'un aeroport à un autre
 * Aeronef est heritiere de la classe Position
 * @author Ashanth
 * @author Khadija
 * @author Maeva
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
	private String detectObstacle;
	private boolean isFlying;

	/*!
	 * Aeronef()
	 * @brief Creer un Aeronef au position (abscisse,ordonnee) donnne en parametre 
	 * @param abscissa Le coordonnee X de l'aeronef 
	 * @param ordinate Le coodonee Y de l'aeronef
	 */
	public Aeronef(int abscissa, int ordinate) {
		super(abscissa, ordinate);
	}
	
	/*!
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
			int totalSeats, int fuel, int altitude, int speed, boolean urgent, String detectObstacle, boolean isfly) {
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

	/*! 
	 * getType()
	 * @brief Retourne le type de l'aeronef, Cette methode permet de determiner dans quelle type d'aeroport l'aeronef peut atterir
	 * @return type, le type de l'aeronef
	 */
	public String getType() {
		return type;
	}

	/*!
	 * setType()
	 * @brief Change le type de l'aeronef
	 * @param type Nouveau type de l'aeronef 
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*! 
	 * getModel()
	 * @brief Retourne le modele de l'aeronef
	 * @return model, le nom du model de l'aeronef
	 */
	public String getModel() {
		return model;
	}

	/*!
	 * setModel()
	 * @brief Change le modele de l'aeronef par un autre
	 * @param model Nouveau modele de l'aeronef
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/*!
	 * getDestination()
	 * @brief Retourne le nom de l'aeroport de destination, cette methode permet de connaitre la destination de l'aeronef
	 * @return destination, le nom de l'aeroport de destination
	 */
	public String getDestination() {
		return destination;
	}

	/*!
	 * setDestination()
	 * @brief Change la valeur du nom de l'aeroport de destination
	 * @param destination Nom du nouvel aeroport de destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/*!
	 * getDeparture()
	 * @brief il retourne le deparature de l'aeronef
	 * @return departure nom de l'aeroport de départ
	 */
	public String getDeparture() {
		return departure;
	}

	/*!
	 * setDeparture()
	 * @brief Change la valeur du nom de l'aeroport de depart
	 * @param departure nom de l'aeroport de depart
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}

	/*!
	 * getTotalSeats()
	 * @brief retourne le nombre de place dans un aeronef
	 * @return totalSeats Nombre de place total dans l'aeronef
	 */
	public int getTotalSeats() {
		return totalSeats;
	}

	/*!
	 * setTotalSeats()
	 * @brief Change la valeur des nombres de palce dans un aeronef 
	 * @param totalSeats Nombre de place total dans l'aeronef
	 */
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	

	/*!
	 * getFuel()
	 * @brief retourne le niveau d'essence de l'aeronef
	 * @return fuel Valeur indiquant le niveau d'essence de l'aeronef
	 */
	public int getFuel() {
		return fuel;
	}

	/*!
	 * setFuel()
	 * @brief Change la valeur du niveau d'essence de l'aeronef 
	 * @param fuel Valeur indiquant le niveau d'essence de l'aeronef
	 */
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	/*!
	 * getAltitude()
	 * @brief il retourne l'altitude de l'aeronef
	 * @return altitude c'est la valeur d'altitude de l'aeronef
	 */
	public int getAltitude() {
		return altitude;
	}

	/*!
	 * setAltitude()
	 * @brief Change l'altitude de l'aeronef 
	 * @param altitude c'est la valeur d'altitude de l'aeronef
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	/*!
	 * getSpeed()
	 * @brief il retourne la vitesse de l'aeronef
	 * @return speed la vitesse de l'aeronef
	 */
	public int getSpeed() {
		return speed;
	}

	/*!
	 * setSpeed()
	 * @brief Changement de la vitesse d'aeronef 
	 * @param speed la vitesse de l'aeronef
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/*!
	 * getUrgent()
	 * @brief retourne si l'aeronef va s'atterir en urgence ou non 
	 * @return urgent Booleen qui indique si l'aeronef doit atterir en urgence
	 */
	public boolean getUrgent() {
		return urgent;
	}

	/*!
	 * setUrgent()
	 * @brief changement d'etat d'atterir en urgence 
	 * @param urgent Booleen qui indique si l'aeronef doit atterir en urgence
	 */
	public void setUrgent(boolean urgent) {
		this.urgent=urgent;
	}

	/*!
	 * getName()
	 * @brief il retourne le nom de l'aeronef
	 * @return name Nom de l'aeronef composé des initiale des aeroports de depart et d'arrive ainsi que d'un numero qui incremente
	 */
	public String getName() {
		return name;
	}

	/*!
	 * setName()
	 * @brief changement de nom de l'aeronef
	 * @param name Nom de l'aeronef composé des initiale des aeroports de depart et d'arrive ainsi que d'un numero qui incremente
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*!
	 * isDetectObstacle()
	 * @brief il rdetecte s'il y en a des obstacles
	 * @return detectObstacle Boobleen qui indique si l'aeronef a detecté un obstacle proche
	 */
	public String getDetectObstacle() {
		return  detectObstacle;
	}

	/*!
	 * setDetectObstacle()
	 * @param detectObstacle Boobleen qui indique si l'aeronef a detecté un obstacle proche
	 */
	public void setDetectObstacle(String detectObstacle) {
		this.detectObstacle = detectObstacle;
	}
	
	/*!
	 * isFlying()
	 * @brief il vérifie s'il l'aeronef est en vol
	 * @return isFlying Booleen qui indique si un aeronef est en vol
	 */
	public boolean isFlying() {
		return isFlying;
	}
	
	/*!
	 * setFlying()
	 * @brief change l'etat de l'aeronef en vol ou l'inverse
	 * @param isFlying Booleen qui indique si un aeronef est en vol
	 */
	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}
	
	/*!
	 * toString()
	 * @brief Retourne une chaine de caractere representant l'aeronef  avec ses informations 
	 * @return Une chaine de caractere qui represente l'aeronef 
	 */
	@Override
	public String toString() {
		return "AERONEF\nNname: "+ name + "\nType: " + type + "\nModel: " + model + "\nDestination:\n" + destination + "\nDeparture:\n"
				+ departure + "\nTotal Seats: " + totalSeats + "\nFuel: " + fuel + "\nAltitude: " + altitude + "\nSpeed: "
				+ speed;
	}

}
