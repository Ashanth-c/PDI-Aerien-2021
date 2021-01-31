package process;

import java.util.List;

import data.Aeronef;
import data.Airport;
import data.Line;
import data.Terminal;

public class AirportManager {
	private Airport airport;

	public AirportManager(Airport airport) {
		super();
		this.airport = airport;
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

	public boolean departureVerification(Aeronef aeronef) {
		boolean verification = false;
		String airportName = airport.getName();
		List<Line> aiportLines = airport.getLinesList();
		String aeronefDestination = aeronef.getDestination();
		String airportDestination;

		if (aeronef.getDeparture().equals(airportName)) {
			for (Line line : aiportLines) {
				airportDestination = line.getdestination().getName();
				if (aeronefDestination.equals(airportDestination)) {
					verification = true;
				}
			}

		}
		return verification;

	}
	
	public boolean destinationVerification(Aeronef aeronef) {
		boolean verification = false;
		String airportName = airport.getName();
		List<Line> aiportLines = airport.getLinesList();
		String aeronefDeparture = aeronef.getDeparture();
		String airportDeparture;

		if (aeronef.getDestination().equals(airportName)) {
			for (Line line : aiportLines) {
				airportDeparture = line.getdeparture().getName();
				if (aeronefDeparture.equals(airportDeparture)) {
					verification = true;
				}
			}

		}
		return verification;

	}

	public void removeAeronefTerminal(Aeronef outAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		int newTotaParkAeronefs = airportTerminal.getTotaParkAeronefs() - 1;

		AirportAeronefsList.remove(outAeronef);
		airportTerminal.setTotaParkAeronefs(newTotaParkAeronefs);
	}

	public boolean airportTakeOffAuthorization(Aeronef goingAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		boolean authorization = false;

		if (departureVerification(goingAeronef) && AirportAeronefsList.contains(goingAeronef)) {
			removeAeronefTerminal(goingAeronef);
			authorization = true;
		}
		return authorization;
	}

	public boolean giveAuthorizaton(Aeronef comingAeronef) {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> AirportAeronefsList = airportTerminal.getAeronefs();
		boolean authorization = false;

		if (destinationVerification(comingAeronef) && (!AirportAeronefsList.contains(comingAeronef))) {
			addAeronefTerminal(comingAeronef);
			authorization = true;
		}
		return authorization;
	}

	public boolean airportLandingAuthorization(Aeronef commingAeronef) {
		boolean authorization = false;
		String airportType = airport.getType();
		String aeronefType = commingAeronef.getType();

		if (airportType.equals("All") || airportType.equals(aeronefType)) {
			if (isTerminalFull().equals("Not Full")) {
				authorization = giveAuthorizaton(commingAeronef);
			}
		}
		return authorization;
	}

	public Aeronef nextTakeOffAeronef() {
		Terminal airportTerminal = airport.getTerminal();
		List<Aeronef> airportAeronefsList = airportTerminal.getAeronefs();

		Aeronef takeOffAeronef = airportAeronefsList.get(airportAeronefsList.size() - 1);
		return takeOffAeronef;
		
	}

}
