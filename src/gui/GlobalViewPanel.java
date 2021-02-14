package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import process.Simulation;
import process.Utility;
import process.BlockManager;
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
		printLine(g2);
		initAirport(g2);
	}

	public void initAirport(Graphics2D g2) {
		printAirport(g2, 260, 300);
		printAirport(g2, 500, 500);
		printAirport(g2, 1300, 650);
		printAirport(g2, 90, 100);
		printAirport(g2, 1200, 50);
		printAirport(g2, 700, 450);
		printAirport(g2, 1000, 300);
		printAirport(g2, 760, 150);

	}
//il y a encore des erreurs c'est juste pour essayer

	private void printLine(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(8));

		// g2.drawImage(Utility.readImage("src/images/military_airplane.png"));

	}

	public void printAirport(Graphics2D g2, int abscisse, int ordonate) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(6));
		g2.drawImage(Utility.readImage("src/images/airport.png"), abscisse, ordonate, 30, 40, this);		
	}
}
