package gui.textField;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import gui.GUI;

public class TextField {
	
	private static JTextField numberBoundariesTextfield;
	
	private static String textFieldText = "Input a number between 1 and 26";

	public static void generateTextfield() {
		numberBoundariesTextfield = new JTextField();
		numberBoundariesTextfield.setFont(new Font(GUI.getFontType(), Font.PLAIN, 12));
		numberBoundariesTextfield.setText(textFieldText);
		numberBoundariesTextfield.setBounds(129, 50, 214, 19);
		numberBoundariesTextfield.addFocusListener(new FocusListener() {


			public void focusGained(FocusEvent e) {
				numberBoundariesTextfield.setText(""); 
			}


			public void focusLost(FocusEvent e) {

			}

			});  
		GUI.getMainFrame().getContentPane().add(numberBoundariesTextfield);
	}
	
	public static String getTextFieldContent() {
		return numberBoundariesTextfield.getText();
	}
	public static String getText() {
		return textFieldText;
	}
}
