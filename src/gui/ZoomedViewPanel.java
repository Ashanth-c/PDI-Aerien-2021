package gui;

/*!
 * @file ZoomedViewPanel.java
 * @brief Classe qui Zoom sur l'aeroport
 * @author Ashanth
 * @author Khadija
 * @author Maeva
 * @version 1.0
 * @date 06/04/2021
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;
import data.Aeronef;
import data.Airport;
import data.City;
import process.Simulation;
import process.Utility;

public class ZoomedViewPanel extends JPanel {
	private Simulation simulation;
	private Airport zoomAirport;
	private int numberTakeoffAeoronef;
	private int numberLandingAeoronef;
		
	/*!
     * ZoomedViewPanel() 
     * @brief zoomer sur l'aeroport
     */
	public ZoomedViewPanel(Simulation simulation) {
		this.simulation = simulation;
		setAirport();
		this.numberTakeoffAeoronef = zoomAirport.getTerminal().getTakeOffAeronefsList().size();
		this.numberLandingAeoronef = 0;
		setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}
		
	/*!
	 * 
	 */
	private void setAirport() {
		// TODO Auto-generated method stub
		List<Airport> airportsList = simulation.getAirportsList();
		for (Airport airport : airportsList) {
			if(airport.getCity().getCountry().contains("France")) {
				this.zoomAirport = airport;
			}
		}		
	}
	
	/*!
     * paintComponent()
	 * @param g le grapghcs
	 * @brief paint different Component of zoom view
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setFont(new Font("Arial", Font.PLAIN, 15));
		setAirport();
		drawRunway(g2);
		initTerminal(g2);
		initInformation(g2);
		printAeronefs(g2);
	}
	
	public void initInformation(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		int textPosition = 40;
		g2.setFont(new Font("Arial", Font.BOLD, 50));
		g2.drawRect(35, 130, 265, 650);
		drawString(g2, zoomAirport.getName(), 340, 10);
		g2.setFont(new Font("Arial", Font.PLAIN, 15));
		g2.drawString("Next Departure Aeronefs:", 50, 360);
		g2.drawString("Landing Aeronefs:", 50, 560);
		g2.drawString("Airport Information:", 50, 150);
		printAirportInfo(g2);
		List<Aeronef> takeOffAeronefsList = zoomAirport.getTerminal().getTakeOffAeronefsList();
		for (Aeronef aeronef : takeOffAeronefsList) {
			drawString(g2, aeronef.getName(), 70, 330+textPosition);
			textPosition=textPosition+20;
		}
		textPosition=40;
		List<Aeronef> landingAeronefsList = zoomAirport.getTerminal().getLandingAeronefsList();
		for (Aeronef aeronef : landingAeronefsList) {
			drawString(g2, aeronef.getName(), 70, 530+textPosition);
			textPosition=textPosition+20;
		}
	}
	
	private void printAirportInfo(Graphics2D g2) {
		String name = zoomAirport.getName();
		City city = zoomAirport.getCity();
		String openingDate = zoomAirport.getopeningDate();
		String type = zoomAirport.getType();
		float abscissa = zoomAirport.getAbscissa();
		float ordinate = zoomAirport.getOrdinate();
		int totalRunway = zoomAirport.getAerodrome().getTotalRunway();
		
		g2.drawString("Name : "+name, 70, 170);
		g2.drawString("City : "+city, 70, 190);
		g2.drawString("Type : "+type, 70, 210);
		g2.drawString("Opening Date : "+openingDate, 70, 230);
		g2.drawString("Total Runway : "+totalRunway, 70, 250);
		g2.drawString("Coordinate : ("+abscissa+" , "+ordinate+")", 70, 270);
	}

	public void drawString(Graphics2D g2, String text, int x, int y) {
	    for (String line : text.split("\n"))
	        g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
	}
	
	public void drawRunway(Graphics2D g2) {
		int totalRunway = zoomAirport.getAerodrome().getTotalRunway();
		for (int i = 0; i < totalRunway; i++) {
			g2.drawImage(Utility.readImage("src/images/piste.png"),385,300+(i*100),this);
		}
	}
	
		/*!
     		 * initAirstrip()
	 	 * @param g2 le grapghcs
	     	 * @brief le chemin de l'aeronef dans la vue zoomée est sous forme rectangle
	 	 */
	public void initAirstrip(Graphics2D g2) {

		makeRectangle(g2,400, 25+200, 450, 60);
		makeRectangle(g2,15+400, 85+200, 435, 60);
	
		makeRectangle(g2,400, 195+200, 450, 60);		
		makeRectangle(g2,15+400, 255+200, 435, 60);

	}
	/*!
     	 * initTerminal()
	 * @param g2 e graphics
	 * 
	 * @brief initialize le terminal sur la vue zoomee
	 */
	public void initTerminal(Graphics2D g2) {
		g2.setFont(new Font("Arial", Font.PLAIN, 20));
		int totalParkingPlace = zoomAirport.getTerminal().getTotalParkingPlace();
		int totaParkAeronefs = zoomAirport.getTerminal().getTotaParkAeronefs();
		String data="number of parked aeronefs :\n                 "+totaParkAeronefs+" / "+ totalParkingPlace; 
		g2.setColor(Color.BLACK);
		g2.fillOval(900, 250, 420, 420);
		g2.fillRect(850, 190, 100, 550);
		g2.setColor(Color.WHITE);
		drawString(g2, data, 990, 380);
	
	}
	
	
	public void printAeronefs(Graphics2D g2) {
		
		int takeOffSize = zoomAirport.getTerminal().getTakeOffAeronefsList().size();
		int landingSize = zoomAirport.getTerminal().getLandingAeronefsList().size();
		
		if(numberTakeoffAeoronef>takeOffSize) {
			int differenceTakeOff = numberTakeoffAeoronef-takeOffSize;
			numberTakeoffAeoronef=takeOffSize;
			moveTakeOffAeronef(g2, differenceTakeOff);
		}
		if(numberLandingAeoronef<landingSize) {
			int differenceLanding = numberLandingAeoronef+landingSize;
			numberLandingAeoronef=landingSize;
			moveLandingAeronef(g2, differenceLanding);
		}
	}
	
	
	public void moveTakeOffAeronef(Graphics2D g2,int numberAeronef) {
		int start = 395;
		for (int index = 0; index < numberAeronef; index++) {
				g2.drawImage(Utility.readImage("src/images/turboprop_airplane2.png"),start,320,50,50,this);
				start+=200;
		
		}
		
	}
	
	public void moveLandingAeronef(Graphics2D g2,int numberAeronef) {
		int start = 395;
		for (int index = 0; index < numberAeronef; index++) {
				g2.drawImage(Utility.readImage("src/images/turboprop_airplane.png"),start,420,50,50,this);
				start+=100;
		
		}
		
	}
	
	/*!
     	 * makeRectangle()
	 * @param g2 le graphics
	 * @param x le premier cordonnee pour tracer le rectangle
	 * @param y le deuxieme cordonnee pour tracer le rectangle
	 * @param z le troisieme cordonnee pour tracer le rectangle
	 * @param t le quatrieme cordonnee pour tracer le rectangle
	 * 
	 * @brief initialise le terminal sur la vue zoomee
	 */
	public void makeRectangle(Graphics2D g2, int x, int y, int z, int t) {
		
		BasicStroke oldStroke=(BasicStroke) g2.getStroke();
		float thickness=2;
		BasicStroke newStroke=new BasicStroke(thickness);
		
		g2.setColor(Color.BLACK);
		g2.setStroke(newStroke);
		g2.drawRect(x, y, z, t);
		g2.setColor(Color.WHITE);
		g2.fillRect(x, y, z, t);
		g2.setStroke(oldStroke);
	}

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

}

