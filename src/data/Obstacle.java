package data;
/**
 * 
 * @author Maeva
 * Classe qui décrit un Obstacle
 * Classe définie par un nom et l'altitude de l'obstacle
 * 
 * Cette classe est une classe fille de la classe Posititon
 */
public class Obstacle extends Position {
	private String name;
	private int altitude;
/**
 * Constructeur Obstacle
 * 
 * @param abscisse
 * @param ordonnee
 */
	public Obstacle(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
/**
 * Constructeur Obstacle
 * 
 * @param abscisse
 * @param ordonnee
 * @param name
 * @param altitude
 */
	public Obstacle(int abscisse, int ordonnee, String name, int altitude) {
		super(abscisse, ordonnee);
		this.name = name;
		this.altitude = altitude;
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
	 * getter getName
	 */
	public void setName(String name) {
		this.name = name;
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
	 * 		altitude: int
	 */
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
/**
 * toString method
 */
	/*
	 * toString method
	 */
	@Override
	public String toString() {
		return "Obstacle [name=" + name + ", altitude=" + altitude + "]";
	}

}
