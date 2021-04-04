package data;

import java.util.List;

	/*!
 	 * @file Airport.java
 	 * @brief Classe qui represente un a�roport
 	 * @author Ashanth
 	 * @author Khadija
 	 * @author Maeva
 	 * @version 1.0
 	 * @date 06/04/2021
 	 */

public class Airport extends Position {
	private String name;
	private String type;
	private Aerodrome aerodrome;
	private Terminal terminal;
	private City city;
	private String openingDate;
	private List<Line> linesList;

	/*!
	 * @brief Creer un Aeroport au position (abscisse,ordonnee) donnne en parametre 
	 * Airport()
	 * @param abscisse Le coordonnee X de l'aeronef 
	 * @param ordinate Le coodonee Y de l'aeronef
	 */
	
	public Airport(int abscissa, int ordinate) {
		super(abscissa, ordinate);
	}
	
	/*!
	 * Airport()
	 * 
	 * @param abscissa Le coordonnee X de l'aeronef 
	 * @param ordinate Le coodonee Y de l'aeronef
	 * @param name le nom de l'aeroport
	 * @param type le typ d'aeroport
	 * @param aerodrome l'aerodrome de l'aeroport
	 * @param terminal le terminal de l'aeroport
	 * @param city la ville de l'aeroport
	 * @param openingDate la date d'ouverture de l'aeroport
	 * @param linesList la listes des lignes de l'aerport
	 */
	
	public Airport(int abscissa, int ordinate, String name, String type, Aerodrome aerodrome, Terminal terminal,
			City city, String openingDate, List<Line> linesList) {
		super(abscissa, ordinate);
		this.name = name;
		this.type = type;
		this.aerodrome = aerodrome;
		this.terminal = terminal;
		this.city = city;
		this.openingDate = openingDate;
		this.linesList = linesList;
	}

	/*!
	 * getName()
	 * @brief Retourne le nom de l'aeroport
	 * @return name Nom de l'aeroport 
	 */
	public String getName() {
		return name;
	}

	/*!
	 * setName()
	 * @brief Changement du nom de l'aeroport
	 * @param name Nouveau nom de l'aeroport 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*!
 	 * getAerodrome()
	 * @brief Retourne l'aerodrome de l'aeroport
 	 * @return aerodome Aerodrome de l'aeroport
 	 */
	public Aerodrome getAerodrome() {
		return aerodrome;
	}

	/*!
 	 * setAerodrome()
	 * @brief changement d'aerodrome de l'aeroport
 	 * @param aerodrome l'aerodrome de l'aeroprt
 	 */
	public void setAerodrome(Aerodrome aerodrome) {
		this.aerodrome = aerodrome;
	}

	/*!
	 * getTerminal()
	 * @brief il retourne le terminal d'aeroport
 	 * @return terminal le terminal d'aeroport
 	 */
	public Terminal getTerminal() {
		return terminal;
	}

	/*!
	 * setTerminal()
	 * @brief changement de type de l'aeroport
	 * @param terminal le terminal d'aeroport
	 */
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	/*!
	 * getCity()
	 * @brief Retourne la ville de l'aeroport 
	 * @return city la ville de l'aeroport
	 */
	public City getCity() {
		return city;
	}

	/*!
 	 * setCity()
	 * @brief changement de ville de l'aeroport 
 	 * @param city la ville de l'aeroport
 	 */
	public void setCity(City city) {
		this.city = city;
	}

	/*!
	 * getopeningDate()
	 * @brief Retourne la date d'ouverture de l'aeroport 
	 * @return openingDate la date d'ouverture de l'aeroport
	 */
	public String getopeningDate() {
		return openingDate;
	}

	/*!
	 * setopeningDate()
	  * @brief changer la date d'ouverture de l'aeroport 
	 * @param openingDate la date d'ouverture de l'aeroprt
	 */
	public void setopeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	/*!
	 * getLinesList()
	 * @brief Retourne la liste des lignes
	 * @return linesList la liste des lignes passées par un aeroport
	 */
	public List<Line> getLinesList() {
		return linesList;
	}

	/*!
	 * setLinesList()
	  * @brief changer la liste des lignes d'un aeroport
	 * @param linesList la liste des lignes passées par un aeroport
	 */
	public void setLinesList(List<Line> linesList) {
		this.linesList = linesList;
	}

	/*!
	 * getType()
	 * @brief Retourne le type de l'aeroport 
	 * @return type le type d'aeroport
	 */
	public String getType() {
		return type;
	}

	/*!
	 * setType()
	 * @brief changer le type de l'aeroport 
	 * @param type le type de l'aeroport
 	 */
	public void setType(String type) {
		this.type = type;
	}

	/*!
	 * toString() 
	 * @return une chaine de caractère représente l'aeroport et ses informations
	 */
	@Override
	public String toString() {
		return "AIRPORT :\nName: " + name + "\nType: " + type + aerodrome + terminal
				+ "\nCity: " + city + "\nOpening Date: " + openingDate;
	}

}
