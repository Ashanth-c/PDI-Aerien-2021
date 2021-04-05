package data;

import java.util.List;

/*!
 * @file Terminal.java
 * @brief Classe qui décrit un terminal.définie par un nombre de places de parking total,le nombre d'aéronefs ayant attéri, la liste des aeronefs en décollage
 * @brief et le nombre d'aeronef d'aeronefs en train d'attérir.
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class Terminal {
	private int totalParkingPlace;
	private int totaParkAeronefs;
	private List<Aeronef> takeOffAeronefsList;
	private List<Aeronef> landingAeronefsList;
/*!
 * Terminal()
 * 
 * @param totalParkingPlace
 * @param totaParkAeronefs
 */
	public Terminal(int totalParkingPlace, int totaParkAeronefs) {
		super();
		this.totalParkingPlace = totalParkingPlace;
		this.totaParkAeronefs = totaParkAeronefs;
	}
/*!
 * Terminal()
 * 
 * @param totalParkingPlace
 * @param totaParkAeronefs
 * @param takeOffAeronefs
 * @param landingAeronefs
 */
	public Terminal(int totalParkingPlace, int totaParkAeronefs, List<Aeronef> takeOffAeronefs, List<Aeronef> landingAeronefs) {
		super();
		this.totalParkingPlace = totalParkingPlace;
		this.totaParkAeronefs = totaParkAeronefs;
		this.takeOffAeronefsList = takeOffAeronefs;
		this.landingAeronefsList = landingAeronefs;
	}
/*!
 * getTotalParkingPlace()
 * @return totalParkingPlace
 */
	public int getTotalParkingPlace() {
		return totalParkingPlace;
	}
/*!
 * setTotalParkingPlace()
 * @param totalParkingPlace
 */
	public void setTotalParkingPlace(int totalParkingPlace) {
		this.totalParkingPlace = totalParkingPlace;
	}
/*!
 * getTotaParkAeronefs()
 * @return totaParkAeronefs
 */
	public int getTotaParkAeronefs() {
		return totaParkAeronefs;
	}
/*!
 * setTotaParkAeronefs()
 * @param totaParkAeronefs
 */
	public void setTotaParkAeronefs(int totaParkAeronefs) {
		this.totaParkAeronefs = totaParkAeronefs;
	}
/*!
 * toString()
 * @return une chaine de caractère qui affiche le terminal et ses informations
 */

	@Override
	public String toString() {
		return "\nTotal park aeronefs: " + totaParkAeronefs+"/"+totalParkingPlace;
	}
/*!
 * getTakeOffAeronef()
 * @return takeOffAeronefList
 */
	public List<Aeronef> getTakeOffAeronefsList() {
		return takeOffAeronefsList;
	}
/*!
 * setTakeOffAeronefsList()
 * @param takeOffAeronefsList
 */
	public void setTakeOffAeronefsList(List<Aeronef> takeOffAeronefsList) {
		this.takeOffAeronefsList = takeOffAeronefsList;
	}
/*!
 * getLandingAeronefsList()
 * @return landingAeronefsList
 */
	public List<Aeronef> getLandingAeronefsList() {
		return landingAeronefsList;
	}
/*!
 * setLandingAeronefsList()
 * @param landingAeronefsList
 */
	public void setLandingAeronefsList(List<Aeronef> landingAeronefsList) {
		this.landingAeronefsList = landingAeronefsList;
	}

}
