package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import process.Simulation;
import process.BlockManager;
import process.AeronefManager;

public class GlobalViewPanel extends JPanel {
	
	private static final int START_X = 100;
	private static final int START_Y = 200;
	private Simulation simulation;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;
		printLine(g2);
		printAirport(g2);

	}

	
	private void printLine(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.setStroke(new BasicStroke(8));
		g2.drawLine(START_X, START_Y, START_X + simulation.getLine().getTotalLength(), START_Y);
		g2.drawImage(SimulationUtility.readImage("src/images/military_airplane.png.png"));
		
	}
	
	
	
	

	public void printAirport(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(6));
		
		
		g2.drawImage(SimulationUtility.readImage("src/images/airport.png"));
	

	}
