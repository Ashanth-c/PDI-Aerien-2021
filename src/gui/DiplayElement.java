package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class DiplayElement extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PaintStrategy paintStrategy = new PaintStrategy();
	private GlobalViewPanel globalView = new GlobalViewPanel();
	private AirportPanel airportPanel = new AirportPanel();
	private InformationPanel informationPanel = new InformationPanel();

	public DiplayElement() {
		super();
		this.setLayout(new BorderLayout());
		this.add(globalView,BorderLayout.CENTER);
		this.add(informationPanel,BorderLayout.WEST);
		//setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		setBackground(Color.WHITE);
	}

}
