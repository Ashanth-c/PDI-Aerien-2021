package gui;

/**
 * Zoom on an airport
 * 
 * @author Maeva
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import process.Simulation;

public class ZoomedViewPanel extends JPanel {
	private Simulation simulation;

	public ZoomedViewPanel() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;

		initTerminal(g2);
		initAirstrip(g2);
		
	}
	
	public void initAirstrip(Graphics2D g2) {

		makeRectangle(g2,400, 25+200, 450, 60);
		makeRectangle(g2,15+400, 85+200, 435, 60);
	
		makeRectangle(g2,400, 195+200, 450, 60);		
		makeRectangle(g2,15+400, 255+200, 435, 60);

	}

	public void initTerminal(Graphics2D g2) {
		
		g2.setColor(Color.BLACK);
		g2.drawOval(450+400, 220/2+200, 240/2, 240/2);
		g2.setColor(Color.WHITE);
		g2.fillOval(450+400, 220/2+200, 240/2, 240/2);
		makeRectangle(g2,450+400, 10+200, 60, 315);

	}
	
	
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

