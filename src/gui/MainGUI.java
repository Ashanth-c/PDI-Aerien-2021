package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import data.Airport;
import data.City;
import process.AirportManager;
import process.LineBuilder;
import process.Simulation;
import process.Utility;

public class MainGUI extends JFrame{

	private final static Dimension preferredSize = new Dimension(1500, 830);
	private DisplayElement dashboard;
	private Simulation simulation;

	public MainGUI(String title) {
		super(title);
		init();
		
	}

	private void init() {
		setExtendedState(MAXIMIZED_BOTH);
		simulation = new Simulation();
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		dashboard = new DisplayElement(simulation);

		contentPane.add(dashboard, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
	}
	
}