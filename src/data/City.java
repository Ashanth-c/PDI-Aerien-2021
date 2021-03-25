package data;
/**
 * 
 * @author Maeva
 *
 * Classe qui définie une ville
 * Classe définie par le nom d'une ville et où elle se trouve
 */
public class City {
	private String name;
	private String country;
/**
 * Constructor City
 * @param name
 * @param country
 */
	
/* City Constructor
 * param:
 * 		name : String
 * 		country : String
 */
	public City(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	

/**
 * Constructor City
 */
	/*
	 * City Constructor
	 * 
	 */
	public City() {
		super();
	}
	
/**
 * getter getName
 * @return name
 */
	/*
	 * getter getName
	 * 
	 * return name
	 */
	public String getName() {
		return name;
	}
/**
 * setter setName
 * @param name
 */
	/*
	 * setter setName
	 * param:
	 * 		name : String
	 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * getter getCountry
 * @return country
 */
	/*
	 * getter getCountry
	 * 
	 * return country, String
	 */
	public String getCountry() {
		return country;
	}
/**
 * setter setCountr
 * @param country
 */
	/*
	 * setter setCountry
	 * param:
	 * 		country : String
	 */
	public void setCountry(String country) {
		this.country = country;
	}
/**
 * toString method 
 * 
 */
	@Override
	public String toString() {
		return name +", "+ country;
	}
}
