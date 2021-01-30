package process;

import java.util.List;

import data.Aeronef;
import data.Airport;
import data.Terminal;

public class AirportManager {
	private Airport airport;

	public AirportManager(Airport airport) {
		super();
		this.airport = airport;
	}

	public boolean airportTakeOffAuthorization(Aeronef goingAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		String airportName = airport.getName();
		boolean authorization = false;

		if (goingAeronef.getDeparture().equals(airportName) && AirportAeronefsList.contains(goingAeronef)) {
			removeAeronefTerminal(goingAeronef);
			authorization = true;
		}
		return authorization;
	}

	public boolean giveAuthorizaton(Aeronef goingAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		String airportName = airport.getName();
		boolean authorization = false;

		if (goingAeronef.getDestination().equals(airportName) && (!AirportAeronefsList.contains(goingAeronef))) {
			addAeronefTerminal(goingAeronef);
			authorization = true;
		}
		return authorization;
	}

	public boolean airportLandingAuthorization(Aeronef commingAeronef) {
		boolean authorization = false;
		String airportType = airport.getType();
		String aeronefType = commingAeronef.getType();

		if (airportType.equals("all") || airportType.equals(aeronefType)) {
			if (isTerminalFull().equals("Not Full")) {
				authorization = giveAuthorizaton(commingAeronef);
			}
		}

		return authorization;
	}

	public String isTerminalFull() {
		String isfull = "Full";
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> airportAeronefsList = airportTerminal.getAeronefs();

		if (airportAeronefsList.size() < airportTerminal.getTotalParkingPlace()) {
			isfull = "Not Full";
		}
		return isfull;
	}

	public void addAeronefTerminal(Aeronef newAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() + 1;

		AirportAeronefsList.add(newAeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	public void removeAeronefTerminal(Aeronef outAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() - 1;

		AirportAeronefsList.remove(outAeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	public Aeronef nextTakeOffAeronef() {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> airportAeronefsList = airportTerminal.getAeronefs();

		Aeronef takeOffAeronef = airportAeronefsList.get(airportAeronefsList.size() - 1);
		return takeOffAeronef;
	}

}
