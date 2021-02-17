package test;

import gui.MainGUI;

public class TestGui {
	
	public static void main(String[] args) {
		MainGUI mainGUI = new MainGUI("Aeronef Similator");
		Thread guiTread = new Thread(mainGUI);
		guiTread.start();
	}

}
