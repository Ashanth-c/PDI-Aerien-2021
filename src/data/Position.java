package data;
/**
 * 
 * @author Maeva
 *
 * Classe qui décrit la position d'un point
 * Classe définie par l'abscisse et l'ordonnée de ce point
 */
public class Position {
	private float abscisse;
	private float ordinate;
/**
 * Constructeur Position
 * 
 * @param abscisse
 * @param ordinate
 */
	/*
	 * Constructeur Position
	 * param:
	 * 		abscisse, ordinate : float
	 */
	public Position(float abscisse, float ordinate) {
		super();
		this.abscisse = abscisse;
		this.ordinate = ordinate;

	}
/**
 * getter getAbscisse
 * @return abscisse
 */
	/*
	 * getter getAbscisse
	 * return abscisse, float 
	 */
	public float getAbscisse() {
		return abscisse;
	}
/**
 * setter setAbscisse
 * @param abscisse
 */
	/*
	 * setter setAbscisse
	 * param:
	 * 		abscisse : float
	 */
	public void setAbscisse(float abscisse) {
		this.abscisse = abscisse;
	}
/**
 * getter getOrdonnee
 * @return ordinate
 */
	/*
	 * getter getOrdonnee
	 * 
	 * return ordinate, float
	 */
	public float getOrdonnee() {
		return ordinate;
	}
/**
 * setter setOrdonnee
 * @param ordinate
 */
	/*
	 * setter setOrdonnee
	 * param:
	 * 		ordinate : float
	 */
	public void setOrdonnee(float ordinate) {
		this.ordinate = ordinate;
	}
/**
 * toString method
 */
	/*
	 * to String method
	 */
	@Override
	public String toString() {
		return "Position [abscisse=" + abscisse + ", ordinate=" + ordinate + "]";
	}
}