package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import process.Simulation;
import process.Utility;
import process.ObstacleManager;
import process.AeronefManager;

public class GlobalViewPanel extends JPanel {

	private Simulation simulation;
	private PaintStrategy paintStrategy = new PaintStrategy();


	public GlobalViewPanel() {
		setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;
		initLine(g2);
		initAirport(g2);
		printWorldMap(g2);
	}

	public void initAirport(Graphics2D g2) {
		printAirport(g2, 300, 200);  // Aéroport de colombie britannique ,Canada 	 (civil)
		printAirport(g2, 1020, 330); // Aéroport de Hong Kong 				 (military)
		printAirport(g2, 1100, 550); //Aéroport de Brisbane, Australie 			 (cargo)
		printAirport(g2, 500, 530);  // Aéroport Rio de janeiro, Brésil 		 (military)
		printAirport(g2, 615, 320);  //Aéroport de Casablanca, Maroc			 (civil)
		printAirport(g2, 300, 340);  // Aéroport de Mexico, Amérique			 (military)
		printAirport(g2, 645, 240);  //Aéroport de charle de gaulle,France		 (civil)
		printAirport(g2, 900, 200);  // Aéroport de Moscou 				 (cargo)

	}
	
	
	public void initLine(Graphics2D g2) {
		float[] dashPattern = {4, 4};
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2, dashPattern, 0));
		
		/* civil & civil = blue
		 * cargo & civil =red
		 * military & military = green
		 * cargo & military= cyan
		 * civil & military = orange
		 */
		
		
		
		
		g2.setColor(Color.BLUE);
		g2.drawLine(615+15,320+40,645+15,240+40);
		
		g2.setColor(Color.BLUE);
		g2.drawLine(615+15,320+40,300+15,200+40);
		
		g2.setColor(Color.ORANGE);
		g2.drawLine(615+15,320+40,500+15,530+40);
		
		g2.setColor(Color.ORANGE);
		g2.drawLine(300+15,200+40,500+15,530+40);
		
		g2.setColor(Color.ORANGE);
		g2.drawLine(615+15,320+40,300+15,340+40);
		
		g2.setColor(Color.CYAN);
		g2.drawLine(300+15,340+40,300+15,200+40);
		
		g2.setColor(Color.BLUE);
		g2.drawLine(300+15,200+40,645+15,240+40);
		
		g2.setColor(Color.ORANGE);
		g2.drawLine(645+15,240+40,1020+15,330+40);
		
		g2.setColor(Color.ORANGE);
		g2.drawLine(645+15,240+40,300+15,340+40);
		
		g2.setColor(Color.CYAN);
		g2.drawLine(1020+15,330+40,1100+15,550+40);
		
		g2.setColor(Color.GREEN);
		g2.drawLine(500+15,530+40,300+15,340+40);
		
		g2.setColor(Color.GREEN);
		g2.drawLine(500+15,530+40,1020+15,330+40);
		
		g2.setColor(Color.GREEN);
		g2.drawLine(300+15,340+40,1020+15,330+40);
		
		g2.setColor(Color.RED);
		g2.drawLine(1100+15,550+40,615+15,320+40);
		
		g2.setColor(Color.CYAN);
		g2.drawLine(1100+15,550+40,500+15,530+40);
		
		g2.setColor(Color.CYAN);
		g2.drawLine(900+15,200+40,1020+15,330+40);
		
		g2.setColor(Color.RED);
		g2.drawLine(900+15,200+40,645+15,240+40);
		
		g2.setColor(Color.RED);
		g2.drawLine(900+15,200+40,615+15,320+40);
		
		g2.setColor(Color.RED);
		g2.drawLine(900+15,200+40,300+15,200+40);
		
		g2.setColor(Color.CYAN);
		g2.drawLine(900+15,200+40,500+15,530+40);
		
		
	}

	


	public void printAirport(Graphics2D g2, int abscisse, int ordonate) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(6));
		g2.drawImage(Utility.readImage("src/images/airport.png"), abscisse, ordonate, 30, 40, this);
	}
	
	public void printWorldMap(Graphics2D g2) {
//		System.out.println(this.getWidth());
		g2.drawImage(Utility.readImage("src/images/world_map.png"), 100, 50, 1175, 699, this);
	}
}
