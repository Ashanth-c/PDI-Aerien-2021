package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GlobalViewPanel extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// We used Graphic2D for more draw options.
		Graphics2D g2 = (Graphics2D) g;

	}

	public void printAirport(Graphics2D g2) {

	}
}