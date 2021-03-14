package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InformationPanel extends JPanel {

	/**
	 *  @author Khadija
	 *	
	 */
	private static final long serialVersionUID = 1L;
	private PaintStrategy paintStrategy = new PaintStrategy();
	private JButton urgentLandingButton;
	private JButton generateMountainButton;

	public InformationPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		init();
	}

	public void init() {

		add(DiplayElement.getPanelchangebutton());
		/*
		urgentLandingButton=new JButton("Urgent Landing Button");
		add(urgentLandingButton);
		
		generateMountainButton=new JButton("Generate random mountain");
*/
	}
