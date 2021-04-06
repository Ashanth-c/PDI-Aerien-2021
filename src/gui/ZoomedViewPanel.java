package gui;

/*!
 * @file ZoomedViewPanel.java
 * @brief Classe qui affiche l'aéroport Charles de Gaulle en gros plan
 * @author Ashanth
 * @author Khadija
 * @author Maeva
 * @version 1.0
 * @date 06/04/2021
 */

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
     * @brief Constructeur qui va créer le panel de zoom sur l'aéroport
     * @param simulation La simulation où s'effectue les décollage et attérisage
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
	 * @brief Récupére l'aéroport sur lequel on efectue un agrandissement
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
	 * @brief paint different Component of zoom view
	 * @param g Objet graphique qui va dessiner les differents éléments souhaité
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setFont(new Font("Arial", Font.PLAIN, 15));
		setAirport();
		drawRunway(g2);
		printTerminal(g2);
		printInformation(g2);
		printAeronefs(g2);
	}
	
	/*!
	 * @brief Cette fonction affiche toutes les informations concernant l'aéroport Charles de Gaulle ainsi que les différent atterissage et décollage d'aeronef sur l'aéroport
	 * @param g2 Objet graphique qui va dessiner les differents éléments souhaité
	 */
	public void printInformation(Graphics2D g2) {
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
	
	/*!
	 * @brief Fonction qui affiche les informations historique de l'aéroport Charles de Gaulle
	 * @param g2 Objet graphique qui va dessiner les differents éléments souhaité
	 */
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

	/*!
	 * @brief Cette methode va dessiner une chaine de caractères en prenant en comptes les retours à la ligne
	 * @param g2 Objet graphique qui va dessiner les differents éléments souhaité
	 * @param text Chaine de caractères que l'on souhaite dessiner
	 * @param x Abscisse à laquelle on souhaite dessiner la chaine de caractères
	 * @param y Ordonnée à laquelle on souhaite dessiner la chaine de caractères
	 */
	public void drawString(Graphics2D g2, String text, int x, int y) {
	    for (String line : text.split("\n"))
	        g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
	}
	
	/*!
	 * @brief Cette methode dessine les pistes d'atterissage et décollage de l'aéroport
	 * @param g2 Objet graphique qui va dessiner les differents éléments souhaité
	 */
	public void drawRunway(Graphics2D g2) {
		int totalRunway = zoomAirport.getAerodrome().getTotalRunway();
		for (int i = 0; i < totalRunway; i++) {
			g2.drawImage(Utility.readImage("src/images/piste.png"),385,300+(i*100),this);
		}
	}
	
	/*!
     * initTerminal()
     * @brief Dessine l'aérogare de l'aéroport et affiche le nombres d'aérnefs garé 
	 * @param g2 Objet graphique qui va dessiner les differents éléments souhaité
	 */
	public void printTerminal(Graphics2D g2) {
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
	
	/*!
	 * Cette methode dessine les aéronefs qui atterisent ou décollent
	 * @param g2 Objet graphique qui va dessiner les differents éléments souhaité
	 */
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
	
	/*!
	 * @brief Methode qui permet l'animation des aéronefs qui décollent
	 * @param g2 Objet graphique qui va dessiner les differents éléments souhaité
	 * @param numberAeronef Nombres d'aéronefs qui viennent de décoller
	 */
	public void moveTakeOffAeronef(Graphics2D g2,int numberAeronef) {
		int start = 395;
		for (int index = 0; index < numberAeronef; index++) {
				g2.drawImage(Utility.readImage("src/images/turboprop_airplane2.png"),start,320,50,50,this);
				start+=200;
		
		}
		
	}
	
	/*!
	 *@brief Methode qui permet l'animation des aéronefs qui atterisent
	 * @param g2 Objet graphique qui va dessiner les differents éléments souhaité
	 * @param numberAeronef Nombres d'aéronefs qui viennent d'atterir
	 */
	public void moveLandingAeronef(Graphics2D g2,int numberAeronef) {
		int start = 395;
		for (int index = 0; index < numberAeronef; index++) {
				g2.drawImage(Utility.readImage("src/images/turboprop_airplane.png"),start,420,50,50,this);
				start+=100;
		}
		
	}

	
	/*!
	 * @brief Retourne la simulation actuelle
	 */
	public Simulation getSimulation() {
		return simulation;
	}

	/*!
	 * @brief simulation Change la simulation actuelle
	 * @param simulation Nouvelle simulation
	 */
	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}

}
