
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DiplayElement extends JPanel {

	/**
	 *  @author Khadija & Maeva
	 */
	private static final long serialVersionUID = 1L;
	private PaintStrategy paintStrategy = new PaintStrategy();
	private GlobalViewPanel globalView = new GlobalViewPanel();
	private AirportPanel airportPanel = new AirportPanel();
	private InformationPanel informationPanel = new InformationPanel();
	private ZoomedViewPanel zoomedView=new ZoomedViewPanel();
	private static final JButton panelChangeButton= new JButton("View Airport");


	public DiplayElement() {
		super();
		setPreferredSize(getPreferredSize());
		this.setLayout(new BorderLayout());
		this.add(informationPanel, BorderLayout.WEST);
		this.add(globalView, BorderLayout.CENTER);
		
		buttonInit(this);
		
	}

	public void buttonInit(DiplayElement displayElement) {
		getPanelchangebutton().addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	
			globalView.setVisible(false);
			
            displayElement.add(zoomedView,BorderLayout.CENTER);
		}
        });
	}
	
	public static JButton getPanelchangebutton() {
		return panelChangeButton;
	}
	
}
