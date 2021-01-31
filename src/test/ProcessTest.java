package test;

import java.util.ArrayList;
import java.util.List;

import data.Aerodrome;
import data.Aeronef;
import data.Airport;
import data.City;
import data.Terminal;
import process.AirportManager;
import process.LineBuilder;
import data.Line;

public class ProcessTest {

	public static void main(String[] args) {
		
		
		
		List<Aeronef> cdgAeronefs = new ArrayList<Aeronef>();
		Terminal cdgTerminal = new Terminal(50, 0, cdgAeronefs);
		Aerodrome cdgAerodrome = new Aerodrome(4, 25);
		City cdgCity = new City("Paris", "France");
		List<Line> cdgLines = new ArrayList<Line>();
		Airport cdg = new Airport("Charle de Gaulle", "Civil", cdgAerodrome, cdgTerminal, cdgCity, "1975", "1974",
				cdgLines);
		AirportManager cdgManager = new AirportManager(cdg);

		List<Aeronef> jafAeronefs = new ArrayList<Aeronef>();
		Terminal jafTerminal = new Terminal(20, 0, jafAeronefs);
		Aerodrome jafAerodrome = new Aerodrome(2, 25);
		City jafCity = new City("Jaffna", "Tamil Eelam");
		List<Line> jafLines = new ArrayList<Line>();
		Airport jaf = new Airport("Jaffna Airport", "All", jafAerodrome, jafTerminal, jafCity, "1943", "1942", jafLines);
		AirportManager jafManager = new AirportManager(jaf);
		
		
		Aeronef cdgTojafA250 = new Aeronef(0, 0, "Civil", "A250", "Jaffna Airport", "Charle de Gaulle", 50, 100, 0, 250);
		Aeronef cdgToathA380 = new Aeronef(0, 0, "Civil", "A380", "Athena Airport", "Charle de Gaulle", 200, 100, 500, 200);
		
		cdgManager.addAeronefTerminal(cdgToathA380);
		cdgManager.addAeronefTerminal(cdgTojafA250);
		
		
		
		LineBuilder lineBuilder = new LineBuilder();
		lineBuilder.addLines(cdg, jaf);
		System.out.println(cdgManager.airportTakeOffAuthorization(cdgTojafA250));

		System.out.println(jaf);

	}

}
