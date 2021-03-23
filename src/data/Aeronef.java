package data;

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
	
	public Aeronef(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}

	public Aeronef(int abscisse, int ordonnee, String name, String type, String model, String destination, String departure,
			int totalSeats, int fuel, int altitude, int speed, boolean urgent,boolean detectObstacle) {
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
	}
	


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean getUrgent() {
		return urgent;
	}
	
	public void setUrgent(boolean urgent) {
		this.urgent=urgent;
	}
	
	@Override
	public String toString() {
		return "AERONEF\nNname: "+ name + "\nType: " + type + "\nModel: " + model + "\nDestination:\n" + destination + "\nDeparture:\n"
				+ departure + "\nTotal Seats: " + totalSeats + "\nFuel: " + fuel + "\nAltitude: " + altitude + "\nSpeed: "
				+ speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDetectObstacle() {
		return detectObstacle;
	}

	public void setDetectObstacle(boolean detectObstacle) {
		this.detectObstacle = detectObstacle;
	}

}
