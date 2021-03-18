package data;

import java.util.List;

public class Terminal {
	private int totalParkingPlace;
	private int totaParkAeronefs;
	private List<Aeronef> takeOffAeronefsList;
	private List<Aeronef> landingAeronefsList;

	public Terminal(int totalParkingPlace, int totaParkAeronefs) {
		super();
		this.totalParkingPlace = totalParkingPlace;
		this.totaParkAeronefs = totaParkAeronefs;
	}

	public Terminal(int totalParkingPlace, int totaParkAeronefs, List<Aeronef> takeOffAeronefs, List<Aeronef> landingAeronefs) {
		super();
		this.totalParkingPlace = totalParkingPlace;
		this.totaParkAeronefs = totaParkAeronefs;
		this.takeOffAeronefsList = takeOffAeronefs;
		this.landingAeronefsList = landingAeronefs;
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

	@Override
	public String toString() {
		return "\nTota park aeronefs: " + totaParkAeronefs+"/"+totalParkingPlace;
	}

	public List<Aeronef> getTakeOffAeronefsList() {
		return takeOffAeronefsList;
	}

	public void setTakeOffAeronefsList(List<Aeronef> takeOffAeronefsList) {
		this.takeOffAeronefsList = takeOffAeronefsList;
	}

	public List<Aeronef> getLandingAeronefsList() {
		return landingAeronefsList;
	}

	public void setLandingAeronefsList(List<Aeronef> landingAeronefsList) {
		this.landingAeronefsList = landingAeronefsList;
	}

}
