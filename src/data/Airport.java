package data;

import java.util.List;
/**
 * 
 * @author Maeva
 *
 *	Classe qui décrit un aéroport
 *	Classe définie par un nom, un type, un aerodrome, un terminal, une ville, une date d'entrée et une liste de lignes
 *
 */
public class Airport extends Position {
	private String name;
	private String type;
	private Aerodrome aerodrome;
	private Terminal terminal;
	private City city;
	private String openingDate;
	private List<Line> linesList;

	/**
	 * 
	 * @param abscisse
	 * @param ordonnee
	 */
	/*
	 * Constructor Airport
	 * param :
	 * 		abscisse : int
	 * 		ordonnee : int
	 * 
	 */
	public Airport(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
	
	/**
	 * Airport Constructor
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
	
	/*
	 * Constructor Airport
	 * param :
	 * 		abscisse, ordonnée : int
	 * 		type, openingDate : String
	 * 		city : City
	 * 		terminal : Terminal
	 * 		lineslist : List<Line>
	 * 		aerodrome : Aerodrome
	 *	
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
/**
 *  getter getName
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
	 *  setter setName
	 *  param :
	 *  	name : String
	 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * getter getAerodrome
 * @return aerodome
 */
	/*
	 * getter getAerodrome
	 * 
	 * return aerodrome, Aerodrome
	 */
	public Aerodrome getAerodrome() {
		return aerodrome;
	}
/**
 * setter setAerodrome
 * @param aerodrome
 */
	/*
	 * setter setAerodrome
	 * param:
	 * 		aerodrome : Aerodrome
	 */
	public void setAerodrome(Aerodrome aerodrome) {
		this.aerodrome = aerodrome;
	}
/**
 * getter getTerminal
 * @return terminal
 */
	/*
	 * getter getTerminal
	 * 
	 * return terminal
	 */
	public Terminal getTerminal() {
		return terminal;
	}
/**
 * setter setTerminal
 * @param terminal
 */
	/*
	 * setter setTerminal
	 * param:
	 * 		terminal :Terminal
	 */
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
/**
 * getter getCity
 * @return city
 */
	/*
	 * getter getCity
	 * 
	 * return city, City
	 */
	public City getCity() {
		return city;
	}
/**
 * setter setCity
 * @param city
 */
	/*
	 * setter setCity
	 * param:
	 * 		city : City
	 */
	public void setCity(City city) {
		this.city = city;
	}
/**
 * getter getopeningDate
 * @return openingDate
 */
	/*
	 * getter getopeningDate
	 * 
	 * return openingDate, String
	 */
	public String getopeningDate() {
		return openingDate;
	}
/**
 * setter setopeningDate
 * @param openingDate
 */
	/*
	 * setter setopeningDate
	 * param:
	 * 		openingDate : String
	 */
	public void setopeningDate(String openingDate) {
		this.openingDate = openingDate;
	}
/**
 * getter getLinesList
 * @return linesList
 */
	/*
	 * getter getLinesList
	 * 
	 * return linesList, List<Line>
	 */
	public List<Line> getLinesList() {
		return linesList;
	}
/**
 * setter setLinesList
 * @param linesList
 */
	/*
	 * setter setLinesList
	 * param :
	 * 		linesList : List<Line>
	 */
	public void setLinesList(List<Line> linesList) {
		this.linesList = linesList;
	}
/**
 * getter getType
 * @return type
 */
	/*
	 * getter getType
	 * 
	 * return type, String
	 */
	public String getType() {
		return type;
	}
/**
 * setter setType
 * @param type
 */
	/*
	 * setter setType
	 * param :
	 * 		type : String
	 */
	public void setType(String type) {
		this.type = type;
	}
/**
 * toString method
 * 
 */
	/*
	 * toString method
	 */
	@Override
	public String toString() {
		return "AIRPORT :\nName: " + name + "\nType: " + type + aerodrome + terminal
				+ "\nCity: " + city + "\nOpening Date: " + openingDate;
	}

}
