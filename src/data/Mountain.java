package data;

/**
 * 
 * @author Maeva
 * 
 * Classe décrivant une montagne
 * Classe définie par le nom du pays où se trouve la montagne
 * 
 * Cette classe est une classe fille d'Obstacle
 *
 */
public class Mountain extends Obstacle {
	private String country;
/**
 * Constructeur Mountain
 * @param abscisse
 * @param ordonnee
 */
	/*
	 * Constructeur Mountain
	 * param:
	 * 		abscisse, ordonnee : int
	 */
	public Mountain(int abscisse, int ordonnee) {
		super(abscisse, ordonnee);
	}
/**
 * 
 * Constructeur Mountain
 * @param abscisse
 * @param ordonnee
 * @param name
 * @param altitude
 * @param country
 */
	/*
	 * Constructeur Mountain
	 * param:
	 * 		absicsse, ordonne : int
	 * 		name, country : String
	 * 		altitude : int
	 */
	public Mountain(int abscisse, int ordonnee, String name, int altitude, String country) {
		super(abscisse, ordonnee, name, altitude);
		this.country = country;
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
 * setter setCountry
 * @param country
 */
	/*
	 * setter setCountry
	 * param:
	 * 		country: String
	 */
	public void setCountry(String country) {
		this.country = country;
	}
/**
 * toString method
 */
	/*
	 * toString method
	 * return String
	 */
	@Override
	public String toString() {
		return "Mountain "+getName();
	}

}
