package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainGUI extends JFrame {

	private final static Dimension preferredSize = new Dimension(1500, 830);
	private DiplayElement dashboard;

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {
		setExtendedState(MAXIMIZED_BOTH);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		dashboard = new DiplayElement();
		
		contentPane.add(dashboard, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setResizable(false);
	}

}