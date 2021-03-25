package data;

import java.util.List;
/**
 * 
 * @author Maeva
 *
 *Classe qui décrit un terminal.
 *Classe définie par un nombre de places de parking total, 
 *le nombre d'aéronefs ayant attéri, la liste des aeronefs en décollage
 *et le nombre d'aeronef d'aeronefs en train d'attérir.
 */
public class Terminal {
	private int totalParkingPlace;
	private int totaParkAeronefs;
	private List<Aeronef> takeOffAeronefsList;
	private List<Aeronef> landingAeronefsList;
/**
 * Constructeur Terminal
 * 
 * @param totalParkingPlace
 * @param totaParkAeronefs
 */
	public Terminal(int totalParkingPlace, int totaParkAeronefs) {
		super();
		this.totalParkingPlace = totalParkingPlace;
		this.totaParkAeronefs = totaParkAeronefs;
	}
/**
 * Constructeur Terminal
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
/**
 * getter getTotalParkingPlace
 * @return totalParkingPlace
 */
	public int getTotalParkingPlace() {
		return totalParkingPlace;
	}
/**
 * setter setTotalParkingPlace
 * @param totalParkingPlace
 */
	public void setTotalParkingPlace(int totalParkingPlace) {
		this.totalParkingPlace = totalParkingPlace;
	}
/**
 * getter getTotaParkAeronefs
 * @return totaParkAeronefs
 */
	public int getTotaParkAeronefs() {
		return totaParkAeronefs;
	}
/**
 * setter setTotaParkAeronefs
 * @param totaParkAeronefs
 */
	public void setTotaParkAeronefs(int totaParkAeronefs) {
		this.totaParkAeronefs = totaParkAeronefs;
	}
/**
 * toString method
 */
	/*
	 * toString method
	 */
	@Override
	public String toString() {
		return "\nTota park aeronefs: " + totaParkAeronefs+"/"+totalParkingPlace;
	}
/**
 * getter getTakeOffAeronef
 * @return takeOffAeronefList
 */
	public List<Aeronef> getTakeOffAeronefsList() {
		return takeOffAeronefsList;
	}
/**
 * setter setTakeOffAeronefsList
 * @param takeOffAeronefsList
 */
	public void setTakeOffAeronefsList(List<Aeronef> takeOffAeronefsList) {
		this.takeOffAeronefsList = takeOffAeronefsList;
	}
/**
 * getter getLandingAeronefsList 
 * @return landingAeronefsList
 */
	public List<Aeronef> getLandingAeronefsList() {
		return landingAeronefsList;
	}
/**
 * setter setLandingAeronefsList
 * @param landingAeronefsList
 */
	public void setLandingAeronefsList(List<Aeronef> landingAeronefsList) {
		this.landingAeronefsList = landingAeronefsList;
	}

}
