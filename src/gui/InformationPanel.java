package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import data.Aeronef;
import data.Airport;
import data.Mountain;
import data.Position;
import process.AeronefManager;
import process.Simulation;
import process.Utility;
/*!
 * @file InformationPanel.java
 * @brief Ce panneau contient des informations permettant de mieux comprendre les aéronefs et les aéroports imprimés
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class InformationPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private JButton panelChangeButton;
	private JButton launchSimulationButton;
	private JButton urgenceLandingButton;
	private DisplayElement instance;
	private Simulation simulation;
	private Position position;
	/*!
	 * InformationPanel()
	 * @param instance le changement entre les panneaux
	 * @param simulation lancer l'action 
	 * @brief affiche les différentes informations des différentes objet du panneau
	 */
	public InformationPanel(DisplayElement instance,Simulation simulation) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.instance = instance;
		this.simulation = simulation;
		init();
	}

	/*!
	 * paintComponent()
	 * @param g le graghics
	 * @brief painting components
	 */
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(225, 223, 225));
		   g2.fillRect(0, 0, this.getWidth(), this.getHeight());
	
		   if (position!=null) {
			   g2.setColor(Color.black);
			   g2.setFont(new Font("default", Font.BOLD, 12));
			drawString(g2, position.toString(), 12, 110);
		}
	}
	/*!
	 * init()
	 * @brief ajouter les différentes bouttons de la vue
	 */
	public void init() {

		panelChangeButton = new JButton("View Airport");
		launchSimulationButton = new JButton("Launch Simulation");
		urgenceLandingButton=new JButton("Urgent Landing Button");
		urgenceLandingButton.setAlignmentX(CENTER_ALIGNMENT);
		panelChangeButton.setAlignmentX(CENTER_ALIGNMENT);
		launchSimulationButton.setAlignmentX(CENTER_ALIGNMENT);
		add(Box.createVerticalStrut(5));
		add(launchSimulationButton);
		add(Box.createVerticalStrut(5));
		add(panelChangeButton);
		add(Box.createVerticalStrut(5));
		add(urgenceLandingButton);



		
		urgenceLandingButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Aeronef aeronef = null;
				List<AeronefManager> aeronefManagers = simulation.getAeronefManagers();
				int random = Utility.getRandom(0, aeronefManagers.size()-1);
				aeronef = urgentAeronef(random);
				System.out.println("aaaaaaaaaaaa"+aeronef.getName());
				aeronef.setUrgent(true);
			}
		});
		
		panelChangeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub		
				boolean change = instance.isDisplayerGlobal();
					if (change) {
						instance.setDisplayerGlobal(false);
					} 
					else {
						instance.setDisplayerGlobal(true);
					}
					instance.printDashbord();
			}
		});
		
			launchSimulationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Thread simulationThread = new Thread(instance);
				simulationThread.start();
				
			}
		});
	}
	/*!
	 * printAeronefDetail()
	 * @param x le cordonnée d'abscisse d'aeronef
	 * @param y le cordonnée d'ordonnee d'aeronef
	 * @brief afficher les detail des aeronefs
	 */
	public void printAeronefDetail(int x, int y) {
		List<AeronefManager> aeronefManagers = simulation.getAeronefManagers();
		for (AeronefManager aeronefManager : aeronefManagers) {
			Aeronef aeronef = aeronefManager.getAeronef();
			if (aeronef.getAbscissa()+30>=x && aeronef.getOrdinate()+30>=y && aeronef.getAbscissa()-30<=x && aeronef.getOrdinate()-30<=y) {
				position=aeronef;
			}
		}
	}
	/*!
	 * printElementDetail()
	 * @param x le cordonnée d'abscisse de l'element
	 * @param y le cordonnée d'ordonnee de l'element 
	 * @brief afficher les detail de l'element
	 */
	public void printElementDetail(int x, int y) {
		List<Airport> airportsList = simulation.getAirportsList();
		List<AeronefManager> aeronefManagers = simulation.getAeronefManagers();
		List<Mountain> mountainsList = simulation.getMountainsList();
		for (Mountain mountain : mountainsList) {
			if (mountain.getAbscissa()+30>=x && mountain.getOrdinate()+30>=y && mountain.getAbscissa()-30<=x && mountain.getOrdinate()-30<=y) {
				position=mountain;
			}
		}
		for (AeronefManager aeronefManager : aeronefManagers) {
			Aeronef aeronef = aeronefManager.getAeronef();
			for (Airport airport : airportsList) {
				if (airport.getAbscissa()+30>=x && airport.getOrdinate()+30>=y && airport.getAbscissa()-30<=x && airport.getOrdinate()-30<=y) {
					position=airport;
				}
				else {
					if (aeronef.getAbscissa()+30>=x && aeronef.getOrdinate()+30>=y && aeronef.getAbscissa()-30<=x && aeronef.getOrdinate()-30<=y) {
						position=aeronef;
					}
				}
			}
		}
		
	}
	/*!
	 * printAirportInfo()
	 * @param airport un aeroport
	 * @param g2 le graphics
	 * @brief dessiner l'aeroport
	 */
	public void printAirportInfo(Airport airport,Graphics2D g2) {
		g2.drawString(airport.getName(), 50, 70);
	}
	/*!
	 * drawString()
	 * @param text une chaine de caractere
	 * @param g2 le graphics
	 * @param x le cordonnée d'abscisse de l'element
	 * @param y le cordonnée d'ordonnee de l'element 
	 * @brief dessiner l'aeroport
	 */
	void drawString(Graphics2D g2, String text, int x, int y) {
	    for (String line : text.split("\n"))
	        g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
	}
	/*!
	 * urgentAeronef()
	 * @param key un cle d'aeronef 
	 * @brief retourne l'aeronef en urgent 
	 */
	public Aeronef urgentAeronef(int key) {
		List<AeronefManager> aeronefManagers = simulation.getAeronefManagers();
		List<Airport> airportsList = simulation.getAirportsList();
		Aeronef aeronef = aeronefManagers.get(key).getAeronef();
		for (Airport airport : airportsList) {
			if (airport.getAbscissa()==aeronef.getAbscissa() && airport.getOrdinate()==aeronef.getOrdinate() && !(aeronef.isFlying())) {
				int random = Utility.getRandom(0, aeronefManagers.size()-1);
				return aeronef = urgentAeronef(random);
			}
		}
		return aeronef;
	}
	/*!
	 * getSimulation()
	 * @brief retourne l'aeronef en urgent 
	 * @return simulation l'action sur la fenetre
	 */
	public Simulation getSimulation() {
		return simulation;
	}

	/*!
	 * setSimulation()
	 * @brief changer la simulation 
	 * @return simulation l'action sur la fenetre
	 */
	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}
}
