package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import data.Airport;
import process.AirportManager;
import process.Simulation;
import process.Utility;
/*!
 * @file DisplayElement.java
 * @brief change the global view and switch to the information panel either for airplanes or airports and switch to zoomed view for airports
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */

public class DisplayElement extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GlobalViewPanel globalView;
	private InformationPanel informationPanel;
	private ZoomedViewPanel zoomedView = new ZoomedViewPanel();
	private Simulation simulation;
	private Timer timer = new Timer(1000,new ActionTimer());
	private boolean displayerGlobal = true;

	
	/*!
	 * @brief changer la vue globale et passer au panneau d'informations pour les avions ou les aéroports, passer en vue agrandie pour les aéroports
	 * @param simulation l'action des objet sur la vue
	
	 */
	public DisplayElement(Simulation simulation) {
		super();
//		timer = new Timer(delay, taskPerformer);
		this.simulation = simulation;
		this.globalView = new GlobalViewPanel(simulation);
		globalView.addMouseListener(new ViewMouseListener());
		this.informationPanel = new InformationPanel(this,simulation);
		setPreferredSize(getPreferredSize());
		this.setLayout(new BorderLayout());
		this.add(informationPanel, BorderLayout.WEST);

		this.add(globalView, BorderLayout.CENTER);
//		this.add(zoomedView,BorderLayout.CENTER);

	}
	/*! 
	 * run()
	 * @brief lancer la simulation
	 * 
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		  //milliseconds
		timer.start();		  	  
		Worker worker = new Worker();
		worker.execute();
	}
	
	/*! 
	 * printDashbord()
	 * @brief afficher les composants sur la fenetre
	 * 
	 */
	public void printDashbord() {
		if(displayerGlobal) {
			this.remove(zoomedView);
			this.add(globalView, BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
		}
		else {
			this.remove(globalView);
			this.add(zoomedView,BorderLayout.CENTER);
			this.revalidate();
			this.repaint();

		}	
	}
	
	/*! 
	 * Worker()
	 * 
	 */
	private class Worker extends SwingWorker<Integer, String>{

		@Override
		protected Integer doInBackground() throws Exception {
			// TODO Auto-generated method stub
			createNewSimulation();
			boolean launchAirportManager = true;
			if(launchAirportManager) {
			List<Airport> airportsList = simulation.getAirportsList();
//			Airport airport = airportsList.get(0);
		
				for (Airport airport : airportsList) {
					AirportManager airportManager = new AirportManager(airport);
					airportManager.start();
					launchAirportManager=false;
				}
		}
			return null;
		}
		
	}
	/*! 
	 * createNewSimulation()
	 * @brief lancer une nouvelle simulation
	 * 
	 */
	public void createNewSimulation() {
		simulation=new Simulation();
		globalView.setSimulation(simulation);
		informationPanel.setSimulation(simulation);
	}
	
	private class ActionTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			informationPanel.repaint();
			globalView.repaint();
			zoomedView.repaint();
		}
		
	}
private class ViewMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 int x=e.getX();
		 int y=e.getY();
		 informationPanel.printElementDetail(x, y);
//		 informationPanel.printAeronefDetail(x, y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
	/*! 
	 * isDisplayerGlobal()
	 * @brief renvoyer un booleen si le changement est vers la page globale
	 * return displayerGlobal la page globale
	 */
	public boolean isDisplayerGlobal() {
		return displayerGlobal;
	}
	/*! 
	 * setDisplayerGlobal()
	 * @param displayerGlobal
	 * @brief changer la page globale
	 * return displayerGlobal la page globale
	 */
	public void setDisplayerGlobal(boolean displayerGlobal) {
		this.displayerGlobal = displayerGlobal;
	}

	
}
