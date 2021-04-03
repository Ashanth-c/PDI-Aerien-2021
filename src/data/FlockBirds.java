package data;

/*!
 * @file FlockBirds.java
 * @brief Classe representant un groupe d'oiseau
 * Cette classe est une classe fille d'Obstacle
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class FlockBirds extends Obstacle {
	private int numberOfBirds;
	private int speed;
	private double radius;
	private double teta=0;
/*!
 * FlockBirds()	
 * @param abscisse
 * @param ordonnee
 */
	
	public FlockBirds(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
/**
 * FlockBirds()
 * @param abscisse
 * @param ordonnee
 * @param numberOfBirds
 * @param speed
 */
	
	public FlockBirds(int abscisse, int ordonnee, int numberOfBirds, int speed) {
		super(abscisse, ordonnee);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}
/*!
 * FlockBirds()
 * @param abscisse
 * @param ordonnee
 * @param name
 * @param altitude
 * @param numberOfBirds
 * @param speed
 */
	public FlockBirds(int abscisse, int ordonnee, String name, int altitude, int numberOfBirds, int speed) {
		super(abscisse, ordonnee, name, altitude);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}
/*!
 * getNumberofBirds()
 * @brief retourne le nombre de groupe des oiseaux
 * @return numberOfBirds
 */
	public int getNumberOfBirds() {
		return numberOfBirds;
	}
/*!
 * setNumberofBirds()
 * @param numberOfBirds
 */
	public void setNumberOfBirds(int numberOfBirds) {
		this.numberOfBirds = numberOfBirds;
	}
/*!
 * getSpeed()
 * @brief retourne la vitesse des oiseaux
 * @return speed
 */
	public int getSpeed() {
		return speed;
	}
/*!
 * setSpeed()
 * @param speed
 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
/*!
 * toString()
 * @return une chaine de caractère qui affiche le nom des groupes des oiseaux
 */
	@Override
	public String toString() {
		return "FlockBirds " + getName();
	}
/*!
 * getRadius()
 * @return radius
 */
	public double getRadius() {
		return radius;
	}
/*!
 * setRadius()
 * @param radius
 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
/*!
 * getTeta()
 * @brief retourne l'angle teta
 * @return teta
 */
	public double getTeta() {
		return teta;
	}
/*!
 * setTeta()
 * @param teta
 */
	public void setTeta(double teta) {
		this.teta = teta;
	}

}
