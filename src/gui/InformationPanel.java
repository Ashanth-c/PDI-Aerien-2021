package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InformationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PaintStrategy paintStrategy = new PaintStrategy();
	private JButton panelChangeButton;

	public InformationPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		init();
	}

	public void init() {

		panelChangeButton = new JButton("View AIport");
		add(panelChangeButton);

	}

}
