package data;

/*!
 * @file Line.java
 * @brief Classe définie la ligne entre un aéroport de départ et un aéroport de destination
 * @author Ashanth
 * @author Khadija
 * @author Maeva
 * @version 1.0
 * @date 06/04/2021
 */
public class Line {
	private Airport departure;
	private Airport destination;
	
	/*!
 	 * Line()
 	 * @param departure l'aéroport de départ: debut de ligne
 	 * @param destination l'aéroport de destination: fin de ligne
 	 */
	public Line(Airport departure, Airport destination) {
		super();
		this.departure = departure;
		this.destination = destination;
	}
	/*!
         * Line()
 	 */
	public Line() {
		super();
	}


	/*!
 	 * getdeparture()
	 * @brief retourne la deparature de la ligne l'aéroport de départ
 	 * @param departure l'aéroport de départ: début de ligne
 	 */
	public Airport getdeparture() {
		return departure;
	}
	/*!
 	 * setdeparture()
	 * @brief changer la deparature de la ligne l'aéroport de départ
 	 * @param departure l'aéroport de départ: début de ligne
 	 */

	public void setdeparture(Airport departure) {
		this.departure = departure;
	}
	
	/*!
 	 * getdestination()
	 * @brief retourne la distination de la ligne
   	 * @return destination l'aéroport de destination: fin de ligne
 	 */
	public Airport getdestination() {
		return destination;
	}
	/*!
 	 * setdestination()
	 * @brief changer la fin de la ligne l'aéroport de destination
 	 * @param destination l'aéroport de destination: fin de ligne
 	 */
	public void setdestination(Airport destination) {
		this.destination = destination;
	}
	/*!
 	 * toString()
	 * @return une chaine de caractère affiche les informations de la ligne
	 */

	@Override
	public String toString() {
		return "Departure = " + departure.getName() + ", Destination = " + destination.getName() + "\n";
	}
}
