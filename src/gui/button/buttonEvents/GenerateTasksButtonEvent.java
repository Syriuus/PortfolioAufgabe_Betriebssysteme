package gui.button.buttonEvents;

import gui.GUI;
import gui.table.Table;
import gui.table.tableModel.TableModel;
import gui.textField.TextField;
import util.RandomTasks;
import util.SimulatedProcess;

public class GenerateTasksButtonEvent {
	
	public static void generateTasksButton() {
		Integer numberOfProcesses = Integer.parseInt(TextField.getTextFieldContent());
		try {
			GUI.setRandomList(RandomTasks.getRandom(numberOfProcesses));
		} catch (Exception e1) {
			System.out.println("Error");
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
