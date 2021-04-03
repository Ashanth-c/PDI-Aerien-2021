package data;

/*!
 * @file Mountain.java
 * @brief Classe décrivant une montagne, définie par le nom du pays où se trouve la montagne
 * @author Khadija
 * @author Ashanth
 * @author Maeva
 * @version 1.0
 * @date 06/04/2021
 */
public class Mountain extends Obstacle {
	private String country;
/*!
 * Mountain()
 * @param abscisse Le coordonnee X de la montagne 
 * @param ordinate Le coodonee Y de la montagne 
 */

	public Mountain(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
/*!
 * 
 * Mountain()
 * @param abscisse Le coordonnee X de la montagne 
 * @param ordinate Le coodonee Y de la montagne 
 * @param name le nom de la montagne
 * @param altitude l'altitude de la montagne
 * @param country le pays de la montagne
 */
	public Mountain(int abscisse, int ordonnee, String name, int altitude, String country) {
		super(abscisse, ordonnee, name, altitude);
		this.country = country;
	}
/*!
 * getCountry()
 * @brief retourne le pays ou se trouve le montagne
 * @return country le pays ou se situe le montagne
 */
	public String getCountry() {
		return country;
	}
/*!
 * setCountry()
 * @brief changer le pays ou se trouve le montagne
 * @param country le pays ou se situe le montagne
 */
	public void setCountry(String country) {
		this.country = country;
	}
/*!
 * toString()
 * @return une chaine de caractere represente le montagne et ses informations
 */

	@Override
	public String toString() {
		return "Mountain "+getName();
	}

}
