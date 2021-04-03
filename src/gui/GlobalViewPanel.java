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
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
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


/*!
 * @file GlobalViewPanel.java
 * @brief Classe trace les différents composants des panneaux
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class GlobalViewPanel extends JPanel {

	private Simulation simulation;
 
	/*!
	 * GlobalViewPanel()
	 * @brief lancer la simulation da la vue globale 
	 * @param simulation l'action des différent objet sur la fenetre
	 */
	public GlobalViewPanel(Simulation simulation) {
		this.simulation = simulation;
		setBackground(new Color(12,56,10));
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	/*!
	 * paintComponent ()
	 * @param g le graghigs
	 * @brief tracer les différentes objet de la simulation sur la vue globale
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;
		initLine(g2);
		printWorldMap(g2);
		printAeronef(g2);
		printGuiAirport(g2);
		initMountain(g2);
		
	}
	/*!
	 * printGuiAirport()
	 * @param g2 le graghigs
	 * @brief tracer le gui de l'aeroport
	 */
	public void printGuiAirport(Graphics2D g2) {

		Map<String, AirportManager> airportManagersMap = simulation.getAirportManagersMap();
		for (Entry<String, AirportManager> airportManager : airportManagersMap.entrySet()) {
			Airport airport = airportManager.getValue().getAirport();
			int abscisse = (int) airport.getAbscisse();
			int ordonnee = (int) airport.getOrdonnee();
			String airportType = printAirportType(airport.getType());
			printAirport(g2, abscisse, ordonnee,airportType);

		}
	}
	/*!
	 * printAeronef()
	 * @param g2 le graghigs
	 * @brief tracer l'aeronef sur la vue globale
	 */
	public void printAeronef(Graphics2D g2) {
		g2.setColor(Color.RED);
		g2.setFont(new Font("default", Font.BOLD, 10));
		List<AeronefManager> aeronefManagersMap = simulation.getAeronefManagers();
		for (AeronefManager aeronefManager : aeronefManagersMap) {
			if(aeronefManager.getAeronef().isFlying()) {
				drawAeronef(aeronefManager, g2);
			}
		}
	}
	/*!
	 * initLine()
	 * @param g2 le graghigs
	 * @brief tracer les lignes entre les aeroports sur la vue globale
	 */
	public void initLine(Graphics2D g2) {
		float[] dashPattern = { 9, 9 };
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2, dashPattern, 0));

		List<Airport> airportsList = simulation.getAirportsList();
		for (Airport airport : airportsList) {
			List<Line> linesList = airport.getLinesList();
			for (Line line : linesList) {
				int departureAbscisse = (int) line.getdeparture().getAbscisse() + 10;
				int departureOrdonate = (int) line.getdeparture().getOrdonnee() + 32;
				int destinationAbscisse = (int) line.getdestination().getAbscisse() + 10;
				int destinationOrdonate = (int) line.getdestination().getOrdonnee() + 32;

				if (!line.toString().contains("Departure = " + airport.getName())) {
					g2.setColor(new Color(147,209,138));
					g2.drawLine(departureAbscisse, departureOrdonate, destinationAbscisse, destinationOrdonate);
				}
			}
		}
	}
	/*!
	 * printAirport()
	 * @param g2 le graghigs
	 * @param abscisse Le coordonnee x de l'aeroport
	 * @param ordonate Le coordonnee y de l'aeroport
	 * @param type le type de l'aeroport
	 * @brief tracer les aeroports sur la vue globale
	 */
	public void printAirport(Graphics2D g2, int abscisse, int ordonate,String type) {
		g2.setStroke(new BasicStroke(6));
		if(type.equals("CM")) {
			g2.drawImage(Utility.readImage("src/images/airportMilitaryCivil.png"), abscisse, ordonate, 30, 37, this);
		}
		else if(type.equals("M")) {
			g2.drawImage(Utility.readImage("src/images/airportMilitary.png"), abscisse, ordonate, 25, 32, this);
		}
		else {
			g2.drawImage(Utility.readImage("src/images/airport1.png"), abscisse, ordonate, 25, 30, this);
		}
	}
	/*!
	 * printWorldMap()
	 * @param g2 le graghigs
	 * @brief tracer la carte du monde sur la vue globale
	 */
	public void printWorldMap(Graphics2D g2) {

		g2.drawImage(Utility.readImage("src/images/world_map1.png"), 100, 50, 1175, 699, this);
	}
	/*!
	 * printMountain()
	 * @param g2 le graghigs
	 * @brief tracer les montagnes sur la vue globale
	 */
	public void printMountain(Graphics2D g2, int abscisse, int ordonate, String name, int altitude, String country) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		Utility.createMountain(abscisse, ordonate, name, altitude, country);
		g2.drawImage(Utility.readImage("src/images/mountain.png"), abscisse, ordonate, 30, 40, this);
	}

	/*!
	 * initMountain()
	 * @param g2 le graghigs
	 * @brief initialise les montagnes
	 */
	public void initMountain(Graphics2D g2) {
		for (int i=0;i<4;i++) {
			printMountain(g2,SimulPara.MOUNTAINS_X[i],SimulPara.MOUNTAINS_Y[i],SimulPara.MOUNTAINS[i],SimulPara.ALTITUDE[3],"random");
		}
	}

	/*!
	 * drawAeronef()
	 * @param g2 le graghigs
	 * @param aeronefManager gère les fonctions de l'aeronef
	 * @brief tracer les aeronefs sur la vue globale
	 */
	public void drawAeronef(AeronefManager aeronefManager, Graphics2D g2) {
		Aeronef aeronef = aeronefManager.getAeronef();
		int abscisse = (int) aeronef.getAbscisse() + 7;
		int ordonate = (int) aeronef.getOrdonnee() + 20;
		String direction = aeronefManager.getDirection();
		int aeronefHeight = getAeronefHeight(aeronef.getDetectObstacle());
		int aeronefWidth = getAeronefWidth(aeronef.getDetectObstacle());
		BufferedImage image=null;
		if(aeronef.getUrgent()) {
			image = (BufferedImage) Utility.readImage("src/images/urgent_turbojet.png");
		}
		else {
			if(aeronef.getType().contains("Military")&&!(aeronef.getType().contains("Civil"))) {
				image = (BufferedImage) Utility.readImage("src/images/military_airplane.png");
			}
			else {
			image = (BufferedImage) Utility.readImage("src/images/turboprop_airplane1.png");
			}
		}
		
		if (direction.equals("Est-West")) {
			double rotationRequired = Math.toRadians (180);
			double locationX = image.getWidth() / 2;
			double locationY = image.getHeight() / 2;
			AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
			g2.drawImage(op.filter(image, null), abscisse,ordonate,aeronefHeight,aeronefWidth, null);
		} else if (direction.equals("West-Est")) {
			g2.drawImage(image, abscisse, ordonate, 20, 26, this);

			}
	}
	/*!
	 * printAirportType()
	 * @param type le type de l'aeroport
	 * @brief tracer les aeronefs sur la vue globale
	 * @return un string qui indique le type de l'aeroport
	 */
	public String printAirportType(String type) {
		if(type.contains("Military")) {
			if(type.contains("Civil")) {
				return "CM";
			}else {
				return "M";
			}
		}
		else {
			return "C";
		}
	}
	/*!
	 * getAeronefHeight()
	 * @param obstacle l'obstacle trouvé sur la ligne de vol
	 * @brief  changer l'altitude de l'avion ça depend de l'obstacle
	 * @return height l'altitude de lavion 
	 */
	public int getAeronefHeight(String obstacle) {
		int height=0;
		switch (obstacle) {
			case "No": {
				height = 20;
				break;
			}
			case "Aeronef":{
				height = 15;
				break;
			}
			case "Obstacle":{
				height = 30;
				break;
			}
			default:{
				height = 20;
				break;
			}
		}
		return height;
	}
	/*!
	 * getAeronefWidth()
	 * @param obstacle l'obstacle trouvé sur la ligne de vol
	 * @brief  retourne le largeur de l'avion
	 * @return width largeur de lavion 
	 */
	public int getAeronefWidth(String obstacle) {
		
		int width=0;
		switch (obstacle) {
			case "No": {
				width = 26;
				break;
			}
			case "Aeronef":{
				width = 21;
				break;
			}
			case "Obstacle":{
				width = 36;
				break;
			}
			default:{
				width = 26;
				break;
			}
		}
		return width;
	}
	/*!
	 * getSimulation()
	 * @brief  lancer la simulation principale
	 * @return Simulation l'action sur la page
	 */
	public Simulation getSimulation() {
		return simulation;
	}
	/*!
	 * setSimulation()
	 * @brief  changer le lancement de la simulation principale
	 */
	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}
}
