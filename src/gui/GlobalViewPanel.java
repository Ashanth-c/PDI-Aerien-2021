package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import data.Aeronef;
import data.Airport;
import data.Line;
import process.Simulation;
import process.Utility;
import process.ObstacleManager;
import process.AeronefManager;
import process.AirportManager;

public class GlobalViewPanel extends JPanel {

	private Simulation simulation;
	private PaintStrategy paintStrategy = new PaintStrategy();

	public GlobalViewPanel(Simulation simulation) {
		this.simulation = simulation;
		setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;
		initLine(g2);
		printGuiAirport(g2);
		printWorldMap(g2);
		printAeronef(g2);
		initMountain(g2);
		
	}

	public void printGuiAirport(Graphics2D g2) {

		Map<String, AirportManager> airportManagersMap = simulation.getAirportManagersMap();
		for (Entry<String, AirportManager> airportManager : airportManagersMap.entrySet()) {
			Airport airport = airportManager.getValue().getAirport();
			int abscisse = (int) airport.getAbscisse();
			int ordonnee = (int) airport.getOrdonnee();
			printAirport(g2, abscisse, ordonnee);

		}
	}

	public void printAeronef(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.setFont(new Font("default", Font.BOLD, 10));
		List<AeronefManager> aeronefManagersMap = simulation.getAeronefManagers();
		List<Airport> airportsList = simulation.getAirportsList();
		for (AeronefManager aeronefManager : aeronefManagersMap) {
			Aeronef aeronef = aeronefManager.getAeronef();
			int abscisse = (int) aeronef.getAbscisse() + 7;
			int ordonate = (int) aeronef.getOrdonnee() + 20;
			String direction = aeronefManager.getDirection();
			String altitute = "altitude " + String.valueOf(aeronef.getAltitude());
			g2.setColor(Color.BLUE);
			g2.setStroke(new BasicStroke(6));
			for (Airport airport : airportsList) {
				
			}
			if (direction.equals("Est-West")) {
						g2.drawImage(Utility.readImage("src/images/turboprop_airplane.png"), abscisse, ordonate, 20, 26, this);

					} else if (direction.equals("West-Est")) {
						g2.drawImage(Utility.readImage("src/images/turboprop_airplane.png"), abscisse, ordonate, 20, 26, this);

				}
		}
	}

	public void initLine(Graphics2D g2) {
		float[] dashPattern = { 4, 4 };
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2, dashPattern, 0));

		List<Airport> airportsList = simulation.getAirportsList();
		for (Airport airport : airportsList) {
			List<Line> linesList = airport.getLinesList();
			for (Line line : linesList) {
				int departureAbscisse = (int) line.getdeparture().getAbscisse() + 10;
				int departureOrdonate = (int) line.getdeparture().getOrdonnee() + 32;
				int destinationAbscisse = (int) line.getdestination().getAbscisse() + 10;
				int destinationOrdonate = (int) line.getdestination().getOrdonnee() + 32;

				if (!line.toString().contains("Departure = "+airport.getName())) {
					g2.setColor(setLineColor(airport.getName()));
					g2.drawLine(departureAbscisse, departureOrdonate, destinationAbscisse, destinationOrdonate);
				}
			}
		}
	}

	public void printAirport(Graphics2D g2, int abscisse, int ordonate) {
		g2.setStroke(new BasicStroke(6));
		g2.drawImage(Utility.readImage("src/images/airport.png"), abscisse, ordonate, 25, 30, this);
	}

	public void printWorldMap(Graphics2D g2) {

		g2.drawImage(Utility.readImage("src/images/world_map.png"), 100, 50, 1175, 699, this);
	}

	public void printMountain(Graphics2D g2, int abscisse, int ordonate, String name, int altitude, String country) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		Utility.createMountain(abscisse, ordonate, name, altitude, country);
		g2.drawImage(Utility.readImage("src/images/mountain.png"), abscisse, ordonate, 30, 40, this);
	}

	
	public void initMountain(Graphics2D g2) {
		for (int i=0;i<4;i++) {
			printMountain(g2,SimulPara.MOUNTAINS_X[i],SimulPara.MOUNTAINS_Y[i],SimulPara.MOUNTAINS[i],SimulPara.ALTITUDE[3],"random");
		}
	}
	
	public Color setLineColor(String name) {
		switch (name) {
		case "Melbourne Airport": {
			
			return new Color(128, 190, 32);
		}
		case "Yakutia Airlines": {
			
			return new Color(188, 0, 0);
		}
		case "Charles de Gaulle Airport": {
	
			return new Color(255, 126, 0);
		}
		case "Ouagadougou Airport": {
	
			return new Color(69, 41, 154);
		}
		case "Governor Francisco Gabrielli International Airport": {
	
			return new Color(217, 220, 24);
		}
		case "Yellowknife Airport": {
	
			return new Color(162, 19, 96);
		}
		default:

			return Color.BLACK;
		}
		
	}

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}
}
