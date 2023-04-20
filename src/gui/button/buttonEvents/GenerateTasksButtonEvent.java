package gui.button.buttonEvents;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.GUI;
import gui.table.Table;
import gui.table.tableModel.TableModel;
import gui.textField.TextField;
import util.RandomTasks;
import util.SimulatedProcess;

public class GenerateTasksButtonEvent {
	
	private static Integer numberOfProcesses;
	
	public static void generateTasksButton() {
		try {
			numberOfProcesses = Integer.parseInt(TextField.getTextFieldContent());
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(new JFrame(), TextField.getText(), "Error",
			        JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(numberOfProcesses <= 26 && numberOfProcesses > 0) {
			try {
				GUI.setRandomList(RandomTasks.getRandom(numberOfProcesses));
			} catch (Exception e) {
				
			}
		} else {
			JOptionPane.showMessageDialog(new JFrame(), TextField.getText(), "Error",
			        JOptionPane.ERROR_MESSAGE);
			return;
		}
		Table.getTable().setBounds(10, 100, 516, 16*numberOfProcesses+16);
		TableModel.getTableModel().setRowCount(0);
		TableModel.getTableModel().addRow(GUI.getCol());
		for(SimulatedProcess i : GUI.getRandomList()) {
			Object[] obj = {i.getId(), i.getRuntime(), i.getArrivaltime(), i.getPriority(), i.getDeadline()};
			TableModel.getTableModel().addRow(obj);
		}
		
		
	}
}
