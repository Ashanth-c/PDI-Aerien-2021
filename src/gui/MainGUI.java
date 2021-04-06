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
/*!
 * @file MainGUI.java
 * @brief L'interface graphique principale de la simulation aeronef
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class MainGUI extends JFrame{

	private final static Dimension preferredSize = new Dimension(1500, 830);
	private DisplayElement dashboard;
	private Simulation simulation;
	/*!
	 *  MainGUI()
	 * @param title le titre du gui 
	 * @brief initialise le  gui
	 */
	public MainGUI(String title) {
		super(title);
		init();
		
	}
	/*!
	 * init()
	 * @brief initialise le gui
	 */
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
