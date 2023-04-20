package gui.button.buttonEvents;

import gui.GUI;

public class ExitButtonEvent {
	
	public static void exitButton() {
		GUI.getMainFrame().dispose();
		System.exit(0);
	}

}
