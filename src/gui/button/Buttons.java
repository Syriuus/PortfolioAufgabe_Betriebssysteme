package gui.button;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.GUI;
import gui.button.buttonEvents.ExitButtonEvent;
import gui.button.buttonEvents.GenerateTasksButtonEvent;
import gui.button.buttonEvents.SortButtonEvent;

public class Buttons {

	private static JButton exitButton;
	private static JButton generateTasksButton;
	private static JButton sortButton;
	
	private static String exitButtonText = "Exit";
	private static String generateTasksButtonText = "Generate tasks";
	private static String sortButtonText = "Sort";
	
	public static void generateButtons() {
		
		exitButton = new JButton(exitButtonText);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExitButtonEvent.exitButton();
			}
		});
		exitButton.setFont(new Font(GUI.getFontType(), Font.PLAIN, 12));
		exitButton.setBounds(10, 600, 85, 21);
		
		
		
		sortButton = new JButton(sortButtonText);
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortButtonEvent.sortButton();
			}
		});
		sortButton.setFont(new Font(GUI.getFontType(), Font.PLAIN, 12));
		sortButton.setBounds(465, 600, 85, 21);
		
		
		
		generateTasksButton = new JButton(generateTasksButtonText);
		generateTasksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateTasksButtonEvent.generateTasksButton();
			}
		});
		generateTasksButton.setFont(new Font(GUI.getFontType(), Font.PLAIN, 12));
		generateTasksButton.setBounds(206, 600, 123, 21);
		
		
		
		GUI.getMainFrame().getContentPane().add(exitButton);
		GUI.getMainFrame().getContentPane().add(sortButton);
		GUI.getMainFrame().getContentPane().add(generateTasksButton);
	}
}
