package data;
/**
 * 
 * @author Maeva
 * 
 * Classe définie par un aéroport de départ et un aéroport de destination
 *
 */
public class Line {
	private Airport departure;
	private Airport destination;
/**
 * Constructeur Line
 * @param departure
 * @param destination
 */
	/*
	 * Constructeur Line
	 * param :
	 * 		departure : Airport
	 * 		destination : Airport
	 */
	public Line(Airport departure, Airport destination) {
		super();
		this.departure = departure;
		this.destination = destination;
	}
/**
 * Constructeur Line
 */
	/*
	 * Constructeur Line
	 */
	public Line() {
		super();
	}
/**
 * getter getdeparture
 * @return departure
 * 
 */
	/*
	 * getter getdeparture
	 * return departure, Airport
	 */
	public Airport getdeparture() {
		return departure;
	}
/**
 * setter setdeparture
 * @param departure
 */
	/*
	 * setter setdeparture
	 * param:
	 * 		departure : Airport
	 */
	public void setdeparture(Airport departure) {
		this.departure = departure;
	}
/**
 * getter getdestination
 * @return destination
 */
	/*
	 * getter getdestination
	 * 
	 * return destination, Airport
	 */
	public Airport getdestination() {
		return destination;
	}
/**
 * setter setdestination
 * @param destination
 */
	/*
	 * setter setdestination
	 * param:
	 * 		destination : Airport
	 */
	public void setdestination(Airport destination) {
		this.destination = destination;
	}
/**
 * 	toString method
 * 
 */
	/*
	 * toString method
	 */
	@Override
	public String toString() {
		return "Departure = " + departure.getName() + ", Destination = " + destination.getName() + "\n";
	}
}
