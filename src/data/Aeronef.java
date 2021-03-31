package data;
/**
 * 
 * @author Maeva
 *	Décrit un aéronef
 *	
 *	Défini par un type, un model, une destination, un départ, un nom, un nombre de sièges
 *	du fuel, l'altitude, la vitesse, s'il est en mode urgent ou non et s'il détecte ou pas
 *	un obstacle
 *
 *	Classe fille de Position
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
 * Constructror Aeronef	
 * 
 * @param abscisse
 * @param ordonnee
 */
	/*
	 * Constructor Aeronef
	 * Param :
	 * 		abscisse : int
	 * 		ordonnee :int
	 */
	public Aeronef(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
/**
 * 
 * Constructor Aeronef
 * 
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
 * @param urgent
 * @param detectObstacle
 */
	/*
	 * Constructor Aeronef
	 * Param:
	 * 		abscisse, ordonnee : int
	 * 		name, type, model : String
	 * 		destination, departure : String
	 * 		totalSeats, fuel, altitude, speed : int
	 * 		urgent, detectObstacle : boolean
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
 * 	getter getType
 * @return type
 */
	/*
	 * Getter getType
	 * 
	 * return type, String
	 */

	public String getType() {
		return type;
	}
/**
 * setter setType
 * @param type
 */
	/*
	 * Setter setType
	 */
	public void setType(String type) {
		this.type = type;
	}
/**
 * getter getModel
 * @return model
 */
	/*
	 * Getter getModel
	 * 
	 * return type, String
	 */
	public String getModel() {
		return model;
	}
/**
 * setter setModel
 * @param model
 */
	/*
	 * Setter setModel
	 * param :
	 * 		model : String 
	 * 
	 */
	public void setModel(String model) {
		this.model = model;
	}
/**
 * getter getDestination
 * @return
 */
	/*
	 * getter getDestination
	 * 
	 * return destination, String
	 */
	public String getDestination() {
		return destination;
	}
/**
 * setter setDestination
 * @param destination
 */
	/*
	 * setter setDestination
	 *Param :
	 *		destination : String 
	 * 
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
/**
 * getter getDeparture
 * @return departure
 */
	/*
	 * getter getDeparture()
	 * 
	 * return departure, string
	 */
	public String getDeparture() {
		return departure;
	}
/**
 * setter setDeparture
 * @param departure
 */
	/*
	 * setter setDeparture
	 * Param :
	 *		departure, String
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
/**
 * getter getTotalSeats
 * @return totalSeats
 */
	/*
	 * getter getTotalSeats
	 * 
	 * return totalSeats, int
	 */
	public int getTotalSeats() {
		return totalSeats;
	}
/**
 * setter setTotalSeats
 * @param totalSeats
 */
	/*
	 * setter setTotalSeats
	 * Param :
	 * 		totalSeats, int
	 */
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
/**
 * getter getFuel
 * @return fuel
 */
	/*
	 * getter getFuel
	 * 
	 * return fuel
	 */
	public int getFuel() {
		return fuel;
	}
/**
 * setter setFuel
 * @param fuel
 */
	/*
	 * setter setFuel
	 * param:
	 * 		fuel : int
	 */
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
/**
 * getter getAltitude
 * @return altitude
 */
	/*
	 * getter getAltitude
	 * 
	 * return altitude, int
	 */
	public int getAltitude() {
		return altitude;
	}
/**
 * setter setAltitude
 * @param altitude
 */
	/*
	 * setter setAltitude
	 * param:
	 * 		altitude : int
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
/**
 * getter getSpeed
 * @return speed
 */
	/*
	 * getter getSpeed
	 * 
	 * return speed, int
	 */
	public int getSpeed() {
		return speed;
	}
/**
 * setter setSpeed
 * @param speed
 */
	/*
	 * setter setSpeed
	 * param:	
	 * 		speed : int
	 * 
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

/**
 * getter getUrgent
 * @return urgent
 */
	/*
	 * getter getUrgent
	 * 
	 * return urgent, boolean
	 */
	public boolean getUrgent() {
		return urgent;
	}
/**
 * setter setUrgent
 * @param urgent
 */
	/*
	 * setter setUrgent
	 * param :
	 * 		urgent : boolean
	 */
	public void setUrgent(boolean urgent) {
		this.urgent=urgent;
	}
/**
 * to String Method
 */
	/*
	 * toString Method
	 * 
	 * return String
	 */
	@Override
	public String toString() {
		return "AERONEF\nNname: "+ name + "\nType: " + type + "\nModel: " + model + "\nDestination:\n" + destination + "\nDeparture:\n"
				+ departure + "\nTotal Seats: " + totalSeats + "\nFuel: " + fuel + "\nAltitude: " + altitude + "\nSpeed: "
				+ speed;
	}
/**
 * getter getName
 * @return name
 */
	/*
	 * getter getName
	 * 
	 * return name, String
	 */
	public String getName() {
		return name;
	}
/**
 * setter setName
 * @param name
 */
	/*
	 * setter setName
	 * param :
	 * 		name : String
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * getter isDetectObstacle
 * @return detectObstacle
 */
	/*
	 * getter isDetectObstacle
	 * 
	 * return detectObstacle, boolean
	 */
	public boolean isDetectObstacle() {
		return detectObstacle;
	}
/**
 * setter setDetectObstacle
 * @param detectObstacle
 */
	/*
	 * setter setDetectObstacle
	 * param:
	 * 		detectObstacle : boolean
	 */
	public void setDetectObstacle(boolean detectObstacle) {
		this.detectObstacle = detectObstacle;
	}
public boolean isFlying() {
	return isFlying;
}
public void setFlying(boolean isFlying) {
	this.isFlying = isFlying;
}

}
