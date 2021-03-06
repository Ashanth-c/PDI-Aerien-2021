package data;

/*!
 * @file City.java
 * @brief Classe representant la ville, définie par le nom d'une ville et où elle se trouve
 * @author Khadija
 * @author Ashanth
 * @author Maeva
 * @version 1.0
 * @date 06/04/2021
 */
public class City {
	private String name;
	private String country;
/*!
 * City()
 * @param name le nom de la ville
 * @param country le pays ou se situe cette ville
 */
public City(String name, String country) {
	super();
	this.name = name;
	this.country = country;
}
	

/*!
 * City()
 */
	
public City() {
	super();
}
	
/*!
 * getName()
 * @brief retourne le nom de la ville
 * @return name le nom de la ville
 */
	
public String getName() {
	return name;
}
/*!
 * setName()
 * @brief changer le nom de la ville
 * @param name le nom de la ville
 */
public void setName(String name) {
	this.name = name;
}
/*!
 * getCountry()
 * @brief retourne le pays de la ville
 * @return country le pays ou se situe cette ville
 */
	
public String getCountry() {
	return country;
}
/*!
 * setCountry()
 * @brief changer le nom du pays
 * @param country le pays ou se situe cette ville
 */

public void setCountry(String country) {
	this.country = country;
}
/*!
 * toString()
 * @return une chaine de caractere de la ville et son pays
 */
@Override
public String toString() {
	return name +", "+ country;
    }
}
