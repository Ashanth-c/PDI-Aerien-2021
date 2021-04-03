package data;

/*!
 * @file Obstacle.java
 * @brief Classe qui décrit un Obstacle, définie par un nom et l'altitude de l'obstacle
 * Cette classe est une classe fille de la classe Posititon
 * @author Maeva
 * @author Ashanth
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class Obstacle extends Position {
	private String name;
	private int altitude;
/*!
 * Obstacle()
 * 
 * @param abscisse Le coordonnee X de l'obstacle 
 * @param ordinate Le coodonee Y de l'obstacle
 */
	public Obstacle(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
/*!
 * Obstacle()
 * 
 * @param abscissa Le coordonnee X de l'obstacle
 * @param ordinate Le coodonee Y de l'obstacle
 * @param name le nom de l'obstacle
 * @param altitude l'altitude de l'obstacle
 */
	public Obstacle(int abscisse, int ordonnee, String name, int altitude) {
		super(abscisse, ordonnee);
		this.name = name;
		this.altitude = altitude;
	}
/*
 * getName()
 * @brief retourne le nom de l'obstacle
 * @return name le nom de l'obstacle
 */
	public String getName() {
		return name;
	}
/*!
 * setName()
 * @brief changer le nom de l'obstacle
 * @param name le nom de l'obstacle
 */

	public void setName(String name) {
		this.name = name;
	}
/*!
 * getAltitude()
 * @brief retourne l'altitude de l'obstacle
 * @return altitude l'altitude de l'obstacle
 */ 

	public int getAltitude() {
		return altitude;
	}
/*!
 * setAltitude()
 * @brief changer l'altitude de l'obstacle
 * @param altitude l'altitude de l'obstacle
 */

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
/*!
 * toString()
 * @return une chaine de caractère affiche le nom de l'obstacle et son altitude
 */

	@Override
	public String toString() {
		return "Obstacle [name=" + name + ", altitude=" + altitude + "]";
	}

}
