package data;
/**
 * 
 * @author Maeva
 *
 * Classe décrivant un groupe d'oiseau
 * Classe définie par le nombre d'oiseaux par groupe, leur vitesse, leur radius et l'angle de leur trajectoire
 *
 * Cette classe est une classe fille d'Obstacle
 */
public class FlockBirds extends Obstacle {
	private int numberOfBirds;
	private int speed;
	private double radius;
	private double teta=0;
/**
 * Constructeur FlockBirds	
 * @param abscisse
 * @param ordonnee
 */
	/*
	 * Constructeur FlockBirds
	 * param:
	 * 		abscisse : int
	 * 		ordonnee : int
	 * 
	 * 
	 */
	public FlockBirds(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
/**
 * Constructeur FlockBirds
 * @param abscisse
 * @param ordonnee
 * @param numberOfBirds
 * @param speed
 */
	/*
	 * Constructeur FlockBirds
	 * 
	 *param:
	 *		abscisse : int
	 *		ordonnee : int
	 *		numberOfBirds : int
	 *		speed : int
	 */
	public FlockBirds(int abscisse, int ordonnee, int numberOfBirds, int speed) {
		super(abscisse, ordonnee);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}
/**
 * Constructeur FlockBirds
 * @param abscisse
 * @param ordonnee
 * @param name
 * @param altitude
 * @param numberOfBirds
 * @param speed
 */
	/*
	 * Constructeur FlockBirds
	 * 
	 * param:
	 * 		abscisse, ordonnee : int
	 * 		name : String
	 * 		altitude, numberofBirds, speed : int
	 */
	public FlockBirds(int abscisse, int ordonnee, String name, int altitude, int numberOfBirds, int speed) {
		super(abscisse, ordonnee, name, altitude);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}
/**
 * getter getNumberofBirds
 * @return numberOfBirds
 */
	/*
	 * getter getNumberofBirds
	 * 
	 * return numberOfBirds
	 */
	public int getNumberOfBirds() {
		return numberOfBirds;
	}
/**
 * setter setNumberofBirds
 * @param numberOfBirds
 */
	/*
	 * setter setNumberOfBirds
	 * param:
	 * 		numberOfBirds : int
	 */
	public void setNumberOfBirds(int numberOfBirds) {
		this.numberOfBirds = numberOfBirds;
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
	 * param :
	 * 		speed : int
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
/**
 * toString method
 */
	/*
	 * toString method
	 */
	@Override
	public String toString() {
		return "FlockBirds " + getName();
	}
/**
 * getter getRadius
 * @return radius
 */
	/*
	 * getter getRadius
	 * return radius, double
	 */
	public double getRadius() {
		return radius;
	}
/**
 * setter setRadius
 * @param radius
 */
	/*
	 * setter setRadius
	 * param:
	 * 		radius : double
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
/**
 * getter getTeta
 * @return teta
 */
	/*
	 * getter getTeta
	 * 
	 * return teta, double
	 */
	public double getTeta() {
		return teta;
	}
/**
 * setter setTeta
 * @param teta
 */
	/*
	 * setter setTeta
	 * param:
	 * 		teta : int
	 */
	public void setTeta(double teta) {
		this.teta = teta;
	}

}