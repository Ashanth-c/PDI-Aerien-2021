package data;

/**
 * 
 * @author Maeva
 *	Décrit un aérodrome avec un nombre total de pistes et la longueur des pistes
 */
public class Aerodrome {
	private int totalRunway;
	private int runwayLenght;

/**
 * 
 * @param totalRunway
 * @param runwayLenght
 */
	/*
	 * Constructor Aerodrome
	 * Param : 
	 * 		totalRunway : int
	 * 		runwayLenght : int
	 * 
	 */
	public Aerodrome(int totalRunway, int runwayLenght) {
		super();
		this.totalRunway = totalRunway;
		this.runwayLenght = runwayLenght;
	}

/**
 * Constructor Aerodrome
 */
	/*
	 * Constructor Aerodrome
	 */
	public Aerodrome() {
		super();
	}
	
/**
 * getter getTotalRunway
 * @return totalRunway
 */
	/*
	 * Getter getTotalRunway
	 * 
	 * retourne totalRunway, int
	 */
	public int getTotalRunway() {
		return totalRunway;
	}

/**
 * setter setTotalRunway
 * @param totalRunway
 */
	/*
	 * Setter setTotalRunway
	 * Params :
	 * 		totalRunway : int
	 * 
	 */
	public void setTotalRunway(int totalRunway) {
		this.totalRunway = totalRunway;
	}

/**
 * getter getRunwayLenght
 * @return runwayLenght
 */
	/*
	 * Getter getRunwayLenght
	 * 
	 * return runwayLenght, int
	 */
	public int getRunwayLenght() {
		return runwayLenght;
	}

/**
 * setter setRunwayLenght
 * @param runwayLenght
 */
	/*
	 * Setter setRunwayLenght
	 * Params:
	 * 		runwayLenght : int
	 * 
	 */

	public void setRunwayLenght(int runwayLenght) {
		this.runwayLenght = runwayLenght;
	}

/**
 * 
 */
	/*
	 * toString method
	 * return a String
	 */
	@Override
	public String toString() {
		return "\nTotal runway: " + totalRunway + "\nRunway lenght: " + runwayLenght;
	}

}
