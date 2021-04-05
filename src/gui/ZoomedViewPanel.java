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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.List;

import javax.swing.JPanel;

import data.Airport;
import process.Simulation;

public class ZoomedViewPanel extends JPanel {
	private Simulation simulation;
	private Airport zoomAirport;
		/*!
     		 * ZoomedViewPanel() 
	     	 * @brief zoomer sur l'aeroport
	 	 */
	public ZoomedViewPanel(Simulation simulation) {
		this.simulation = simulation;
		setAirport();
		setBackground(Color.LIGHT_GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
	}
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

		initTerminal(g2);
		initAirstrip(g2);
		
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
		
		g2.setColor(Color.BLACK);
		g2.drawOval(450+400, 220/2+200, 240/2, 240/2);
		g2.setColor(Color.WHITE);
		g2.fillOval(450+400, 220/2+200, 240/2, 240/2);
		makeRectangle(g2,450+400, 10+200, 60, 315);

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
}

