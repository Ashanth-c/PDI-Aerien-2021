package data;

import java.util.List;

	/*!
 	 * @file Airport.java
 	 * @brief Classe qui décrit un aéroport
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
	 * Airport()
	 * @param abscisse
	 * @param ordonnee
	 */
	
	public Airport(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
	
	/*!
	 * Airport()
	 * 
	 * @param abscisse
	 * @param ordonnee
	 * @param name
	 * @param type
	 * @param aerodrome
	 * @param terminal
	 * @param city
	 * @param openingDate
	 * @param linesList
	 */
	
	public Airport(int abscisse, int ordonnee, String name, String type, Aerodrome aerodrome, Terminal terminal,
			City city, String openingDate, List<Line> linesList) {
		super(abscisse, ordonnee);
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
 	 * @return name
 	 */
	public String getName() {
		return name;
	}

	/*!
	 * setName()
	 * @param name
	 */	
	public void setName(String name) {
		this.name = name;
	}

	/*!
 	 * getAerodrome()
 	 * @return aerodome
 	 */
	public Aerodrome getAerodrome() {
		return aerodrome;
	}

	/*!
 	 * setAerodrome()
 	 * @param aerodrome
 	 */
	public void setAerodrome(Aerodrome aerodrome) {
		this.aerodrome = aerodrome;
	}

	/*!
	 * getTerminal()
 	 * @return terminal
 	 */
	public Terminal getTerminal() {
		return terminal;
	}

	/*!
	 * setTerminal()
	 * @param terminal
	 */
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	/*!
	 * getCity()
	 * @return city
	 */
	public City getCity() {
		return city;
	}

	/*!
 	 * setCity()
 	 * @param city
 	 */
	public void setCity(City city) {
		this.city = city;
	}

	/*!
	 * getopeningDate()
	 * @return openingDate
	 */
	public String getopeningDate() {
		return openingDate;
	}

	/*!
	 * setopeningDate()
	 * @param openingDate
	 */
	public void setopeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	/*!
	 * getLinesList()
	 * @return linesList
	 */
	public List<Line> getLinesList() {
		return linesList;
	}

	/*!
	 * setLinesList()
	 * @param linesList
	 */
	public void setLinesList(List<Line> linesList) {
		this.linesList = linesList;
	}

	/*!
	 * getType()
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/*!
	 * setType()
	 * @param type
 	 */
	public void setType(String type) {
		this.type = type;
	}

	/*!
	 * toString() 
	 * 
	 */
	@Override
	public String toString() {
		return "AIRPORT :\nName: " + name + "\nType: " + type + aerodrome + terminal
				+ "\nCity: " + city + "\nOpening Date: " + openingDate;
	}

}
