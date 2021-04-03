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
 * @param abscisse
 * @param ordonnee
 */

	public Mountain(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
/*!
 * 
 * Mountain()
 * @param abscisse
 * @param ordonnee
 * @param name
 * @param altitude
 * @param country
 */
	public Mountain(int abscisse, int ordonnee, String name, int altitude, String country) {
		super(abscisse, ordonnee, name, altitude);
		this.country = country;
	}
/*!
 * getCountry()
 * @brief retourne le pays ou se trouve le montagne
 * @return country
 */
	public String getCountry() {
		return country;
	}
/*!
 * setCountry()
 * @param country
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
