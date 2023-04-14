package gui.label;

import java.awt.Font;

import javax.swing.JLabel;

import gui.GUI;

public class Labels {
	private static JLabel schedulerTextLabel;
	private static JLabel countTextLabel;
	private static String schedulerText = "Scheduler:";
	private static String countText = "Number of processes:";
	
	public static void generateLabel() {
		schedulerTextLabel = new JLabel(schedulerText);
		schedulerTextLabel.setFont(new Font(GUI.getFontType(), Font.PLAIN, 12));
		schedulerTextLabel.setBounds(10, 13, 95, 29);
		countTextLabel = new JLabel(countText);
		countTextLabel.setFont(new Font(GUI.getFontType(), Font.PLAIN, 12));
		countTextLabel.setBounds(10, 52, 143, 13);
		GUI.getMainFrame().getContentPane().add(schedulerTextLabel);
		GUI.getMainFrame().getContentPane().add(countTextLabel);
	}

}
