package process;

import java.util.List;

import engine.Aeronef;
import engine.Airport;
import engine.Terminal;

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
		boolean authorization = true;

		if (aeronef.getDeparture().equals(airportName) && AirportAeronefsList.contains(aeronef)) {
			AirportAeronefsList.remove(aeronef);
		} else {
			authorization = false;
		}
		return authorization;
	}

	public boolean giveAuthorizaton(Aeronef aeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		String airportName = airport.getName();
		boolean authorization = false;

		if (aeronef.getDestination().equals(airportName) && (!AirportAeronefsList.contains(aeronef))) {
			AirportAeronefsList.add(aeronef);
			authorization = true;
		}
		return authorization;
	}

	public boolean airportLandingAuthorization(Aeronef aeronef) {
		boolean authorization = false;
		String airportType = airport.getType();
		String aeronefType = aeronef.getType();

		if (airportType.equals("all") || airportType.equals(aeronefType)) {
			authorization = giveAuthorizaton(aeronef);
		}

		return authorization;
	}

}
