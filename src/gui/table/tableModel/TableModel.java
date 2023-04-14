package gui.table.tableModel;

import javax.swing.table.DefaultTableModel;

import gui.GUI;

public class TableModel {
	
	private static DefaultTableModel tableModel;
	
	public static void initTableModel() {
		tableModel = new DefaultTableModel(GUI.getCol(), 0);
	}
	
	public static DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	

}
