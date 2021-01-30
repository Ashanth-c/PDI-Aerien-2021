package engine;

import java.util.List;

public class Terminal {
	private int totalParkingPlace;
	private int totaParkAeronefs;
	private List<Aeronef> aeronefs;

	public Terminal(int totalParkingPlace, int totaParkAeronefs) {
		super();
		this.totalParkingPlace = totalParkingPlace;
		this.totaParkAeronefs = totaParkAeronefs;
	}

	public Terminal(int totalParkingPlace, int totaParkAeronefs, List<Aeronef> aeronefs) {
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

	public List<Aeronef> getAeronefs() {
		return aeronefs;
	}

	public void setAeronefs(List<Aeronef> aeronefs) {
		this.aeronefs = aeronefs;
	}

}
