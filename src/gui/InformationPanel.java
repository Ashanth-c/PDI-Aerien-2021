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
import data.Position;
import process.AeronefManager;
import process.Simulation;
import process.Utility;

public class InformationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton panelChangeButton;
	private JButton launchSimulationButton;
	private JButton urgenceLandingButton;
	private DisplayElement instance;
	private Simulation simulation;
	private Position position;

	public InformationPanel(DisplayElement instance,Simulation simulation) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.instance = instance;
		this.simulation = simulation;
		init();
	}

	
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
	
	public void printAeronefDetail(int x, int y) {
		List<AeronefManager> aeronefManagers = simulation.getAeronefManagers();
		for (AeronefManager aeronefManager : aeronefManagers) {
			Aeronef aeronef = aeronefManager.getAeronef();
			if (aeronef.getAbscisse()+30>=x && aeronef.getOrdonnee()+30>=y && aeronef.getAbscisse()-30<=x && aeronef.getOrdonnee()-30<=y) {
				position=aeronef;
			}
		}
	}
	
	public void printElementDetail(int x, int y) {
		List<Airport> airportsList = simulation.getAirportsList();
		List<AeronefManager> aeronefManagers = simulation.getAeronefManagers();
		for (AeronefManager aeronefManager : aeronefManagers) {
			Aeronef aeronef = aeronefManager.getAeronef();
			for (Airport airport : airportsList) {
				if (airport.getAbscisse()+30>=x && airport.getOrdonnee()+30>=y && airport.getAbscisse()-30<=x && airport.getOrdonnee()-30<=y) {
					position=airport;
				}
				else {
					if (aeronef.getAbscisse()+30>=x && aeronef.getOrdonnee()+30>=y && aeronef.getAbscisse()-30<=x && aeronef.getOrdonnee()-30<=y) {
						position=aeronef;
					}
				}
		}
		
		}
		
		
	}

	public void printAirportInfo(Airport airport,Graphics2D g2) {
		g2.drawString(airport.getName(), 50, 70);
	}
	
	void drawString(Graphics2D g2, String text, int x, int y) {
	    for (String line : text.split("\n"))
	        g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
	}
	
	public Aeronef urgentAeronef(int key) {
		List<AeronefManager> aeronefManagers = simulation.getAeronefManagers();
		List<Airport> airportsList = simulation.getAirportsList();
		Aeronef aeronef = aeronefManagers.get(key).getAeronef();
		for (Airport airport : airportsList) {
			if (airport.getAbscisse()==aeronef.getAbscisse() && airport.getOrdonnee()==aeronef.getOrdonnee()) {
				int random = Utility.getRandom(0, aeronefManagers.size()-1);
				return aeronef = urgentAeronef(random);
			}
		}
		return aeronef;
	}


	public Simulation getSimulation() {
		return simulation;
	}


	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}
}
