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
 * @param abscissa Le coordonnée X des oiseaux
 * @param ordinate Le coordonnée Y des oiseaux
 */
	
	public FlockBirds(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
/**
 * FlockBirds()
 * @param abscissa Le coordonnee X des oiseaux
 * @param ordinate Le coodonee Y des oiseaux
 * @param numberOfBirds nombre des groupes des oiseaux
 * @param speed l'altitude des oiseaux
 */
	
	public FlockBirds(int abscisse, int ordonnee, int numberOfBirds, int speed) {
		super(abscisse, ordonnee);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}
/*!
 * FlockBirds()
 * @param abscissa Le coordonnee X des oiseaux
 * @param ordinate Le coodonee Y des oiseaux
 * @param name le nom de groupe des oiseaux
 * @param altitude l'altitude des oiseaux
 * @param numberOfBirds nombre des groupes des oiseaux
 * @param speed la vitesse des oiseaux
 */
	public FlockBirds(int abscisse, int ordonnee, String name, int altitude, int numberOfBirds, int speed) {
		super(abscisse, ordonnee, name, altitude);
		this.numberOfBirds = numberOfBirds;
		this.speed = speed;
	}
/*!
 * getNumberofBirds()
 * @brief retourne le nombre de groupe des oiseaux
 * @return numberOfBirds nombre des groupes des oiseaux
 */
	public int getNumberOfBirds() {
		return numberOfBirds;
	}
/*!
 * setNumberofBirds()
 * @brief changer le nombre de groupe des oiseaux
 * @param numberOfBirds
 */
	public void setNumberOfBirds(int numberOfBirds) {
		this.numberOfBirds = numberOfBirds;
	}
/*!
 * getSpeed()
 * @brief retourne la vitesse des oiseaux
 * @return speed la vitesse des oiseaux
 */
	public int getSpeed() {
		return speed;
	}
/*!
 * setSpeed()
 * @brief changer la vitesse des oiseaux
 * @param speed la vitesse des oiseaux
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
 * @return radius l'angle de changement de position des oiseaux
 */
	public double getRadius() {
		return radius;
	}
/*!
 * setRadius()
 * @param radius l'angle de changement de position des oiseaux
 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
/*!
 * getTeta()
 * @brief retourne l'angle teta
 * @return teta l'angle
 */
	public double getTeta() {
		return teta;
	}
/*!
 * setTeta()
 * @brief changer l'angle teta
 * @param teta l'angle
 */
	public void setTeta(double teta) {
		this.teta = teta;
	}

}
