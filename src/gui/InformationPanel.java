package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InformationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PaintStrategy paintStrategy = new PaintStrategy();
	private JButton panelChangeButton;
	private JButton launchSimulationButton;
	private JButton urgenceLandingButton;
	private DisplayElement instance;
	

	public InformationPanel(DisplayElement instance) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.instance = instance;
		init();
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

}
