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

	public boolean airportTakeOffAuthorization(Aeronef aeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		String airportName = airport.getName();
		boolean authorization = false;

		if (aeronef.getDeparture().equals(airportName) && AirportAeronefsList.contains(aeronef)) {
			removeAeronefTerminal(aeronef);
			authorization = true;
		}
		return authorization;
	}

	public boolean giveAuthorizaton(Aeronef aeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		String airportName = airport.getName();
		boolean authorization = false;

		if (aeronef.getDestination().equals(airportName) && (!AirportAeronefsList.contains(aeronef))) {
			addAeronefTerminal(aeronef);
			authorization = true;
		}
		return authorization;
	}

	public boolean airportLandingAuthorization(Aeronef aeronef) {
		boolean authorization = false;
		String airportType = airport.getType();
		String aeronefType = aeronef.getType();

		if (airportType.equals("all") || airportType.equals(aeronefType)) {
			if (isTerminalFull().equals("Not Full")) {
				authorization = giveAuthorizaton(aeronef);
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

	public void addAeronefTerminal(Aeronef aeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() + 1;

		AirportAeronefsList.add(aeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	public void removeAeronefTerminal(Aeronef aeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() - 1;

		AirportAeronefsList.remove(aeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	public Aeronef nextTakeOffAeronef() {
		Aeronef takeOffAeronef;
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> airportAeronefsList = airportTerminal.getAeronefs();

		takeOffAeronef = airportAeronefsList.get(airportAeronefsList.size() - 1);
		return takeOffAeronef;
	}

}
