package data;

import java.util.ArrayList;
import java.util.List;

public class Terminal {
	private int totalParkingPlace;
	private int totaParkAeronefs;
	private ArrayList<Aeronef> aeronefs;

	public Terminal(int totalParkingPlace, int totaParkAeronefs) {
		super();
		this.totalParkingPlace = totalParkingPlace;
		this.totaParkAeronefs = totaParkAeronefs;
	}

	public Terminal(int totalParkingPlace, int totaParkAeronefs, ArrayList<Aeronef> aeronefs) {
		super();
		this.totalParkingPlace = totalParkingPlace;
		this.totaParkAeronefs = totaParkAeronefs;
		this.aeronefs = aeronefs;
	}

	public int getTotalParkingPlace() {
		return totalParkingPlace;
	}

	public void setTotalParkingPlace(int totalParkingPlace) {
		this.totalParkingPlace = totalParkingPlace;
	}

	public int getTotaParkAeronefs() {
		return totaParkAeronefs;
	}

	public void setTotaParkAeronefs(int totaParkAeronefs) {
		this.totaParkAeronefs = totaParkAeronefs;
	}

	public ArrayList<Aeronef> getAeronefs() {
		return aeronefs;
	}

	public void setAeronefs(ArrayList<Aeronef> aeronefs) {
		this.aeronefs = aeronefs;
	}

}
