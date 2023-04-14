package gui.schedulerSelector;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import gui.GUI;
import util.SchedulerMode;

public class SchedulerSelector {
	
	@SuppressWarnings("rawtypes")
	private static JComboBox schedulerSelector;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void generateSchedulerSelector() {
		schedulerSelector = new JComboBox();
		schedulerSelector.setFont(new Font(GUI.getFontType(), Font.PLAIN, 12));
		schedulerSelector.setModel(new DefaultComboBoxModel(SchedulerMode.values()));
		schedulerSelector.setBounds(70, 18, 457, 21);
		GUI.getMainFrame().getContentPane().add(schedulerSelector);
	}
}
