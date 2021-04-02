package data;

/**
 * @file Aerodrome.java
 * @brief Classe representant un Aerodrome d'un aeroport, il permet au aeronefs n'atterir et de décoller grace a des piste d'atterisage
 * @author Ashanth
 * @version 1.0
 * @date 06/04/2021
 */
public class Aerodrome {
	private int totalRunway;
	private int runwayLenght;

	 /**
	  * @brief Creer un aerodrome avec le nombre de piste d'atterissage/decollage et longueur specifié 
	  * @param totalRunway Nombre de piste d'atterisage/decollage
	  * @param runwayLenght Longeur d'une piste d'atterisage/decollage
	  */
	public Aerodrome(int totalRunway, int runwayLenght) {
		super();
		this.totalRunway = totalRunway;
		this.runwayLenght = runwayLenght;
	}

	/**
	 * @brief Creer un aerodrome
	 */
	public Aerodrome() {
		super();
	}
	
	/**
	 * @brief Retourne le nombres de piste dans l'aerodrome, permet d'indiquer si un aeronef peut atterir/decoller ou pas
	 * @return totalRunway, le nombre de piste dans l'aerodrome
	 */
	public int getTotalRunway() {
		return totalRunway;
	}

	/**
	 * @brief Change la valeur du nombre de piste de l'aerodrome par rapport a la valeur entrer en parametre 
	 * @param totalRunway Nombre de piste total dans l'aerodrome
	 */
	public void setTotalRunway(int totalRunway) {
		this.totalRunway = totalRunway;
	}

	/**
	 * @brief Retourne la longueur d'une piste d'atterisage/decollage, cette method sert pour l'animation des aeronef sur le l'affiche de l'aggrandisement d'un aeroport    
	 * @return runwayLenght, La longueur d'une piste
	 */
	public int getRunwayLenght() {
		return runwayLenght;
	}

	/**
	 * @brief Change la valeur de longueur d'une piste de l'aerodrome par rapport a la valeur entrer en parametre 
	 * @param runwayLenght, La nouvelle longueur d'une piste  
	 */
	public void setRunwayLenght(int runwayLenght) {
		this.runwayLenght = runwayLenght;
	}

	/**
	 * 
	 * @brief Retourne une chaine de caractere representant l'aerodrome avec les information du nombre de piste et leur longueur
	 * @return Une chaine de caractere qui represente l'aerodrome 
	 */
	@Override
	public String toString() {
		return "\nTotal runway: " + totalRunway + "\nRunway lenght: " + runwayLenght;
	}

}