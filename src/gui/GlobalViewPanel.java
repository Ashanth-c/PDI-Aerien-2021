package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import process.Simulation;
import process.Utility;
import process.BlockManager;
import process.AeronefManager;

public class GlobalViewPanel extends JPanel {

	private Simulation simulation;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;
		printLine(g2);
		printAirport(g2);

	}
//il y a encore des erreurs c'est juste pour essayer

	private void printLine(Graphics2D g2) {
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(8));

		// g2.drawImage(Utility.readImage("src/images/military_airplane.png"));

	}

	public void printAirport(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(6));
		g2.drawImage(Utility.readImage("src/images/airport.png"), 0, 0,30,40, this);

//		g2.drawImage(Utility.readImage("src/images/airport.png"));

	}
}
