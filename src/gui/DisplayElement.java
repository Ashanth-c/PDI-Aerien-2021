package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import data.Airport;
import process.AirportManager;
import process.Simulation;
import process.Utility;

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

	public DisplayElement(Simulation simulation) {
		super();
//		timer = new Timer(delay, taskPerformer);
		this.simulation = simulation;
		this.globalView = new GlobalViewPanel(simulation);
		this.informationPanel = new InformationPanel(this);
		setPreferredSize(getPreferredSize());
		this.setLayout(new BorderLayout());
		this.add(informationPanel, BorderLayout.WEST);

		this.add(globalView, BorderLayout.CENTER);
//		this.add(zoomedView,BorderLayout.CENTER);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		  //milliseconds
		timer.start();		  	  
		Worker worker = new Worker();
		worker.execute();
	}
	
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
	
	private class Worker extends SwingWorker<Integer, String>{

		@Override
		protected Integer doInBackground() throws Exception {
			// TODO Auto-generated method stub
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
	
	private class ActionTimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			globalView.repaint();
			zoomedView.repaint();
		}
		
	}

	public boolean isDisplayerGlobal() {
		return displayerGlobal;
	}

	public void setDisplayerGlobal(boolean displayerGlobal) {
		this.displayerGlobal = displayerGlobal;
	}

}
