package gui;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;

import gui.button.Buttons;
import gui.label.Labels;
import gui.schedulerSelector.SchedulerSelector;
import gui.table.Table;
import gui.textField.TextField;
import util.SimulatedProcess;

public class GUI {
	private static JFrame mainFrame;
	
	private static String fontType = "Tahoma";
	private static String guiName = "Scheduler Simulation GUI";
	private static String col[] = {"ID","Runtime", "Arrivaltime", "Priority", "Deadline"};
	
	private static ArrayList<SimulatedProcess> randomList = null;

public static JFrame getGUI() throws Exception {
		
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		generateFrame();
		SchedulerSelector.generateSchedulerSelector();
		Labels.generateLabel();
		Table.generateTable();
		Buttons.generateButtons();
		TextField.generateTextfield();
		
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		return mainFrame;
	}
	
	public static JFrame getMainFrame() {
		return mainFrame;
	}
	public static Object[] getCol() {
		return col;
	}	
	public static String getFontType() {
		return fontType;
	}
	public static ArrayList<SimulatedProcess> getRandomList() {
		return randomList;
	}

	public static void setRandomList(ArrayList<SimulatedProcess> randomList) {
		GUI.randomList = randomList;
	}
	public static Container getContentPane() {
		return mainFrame.getContentPane();
	}
	
	private static void generateFrame() {
		mainFrame = new JFrame(guiName);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setSize(559, 668);
	}
}
