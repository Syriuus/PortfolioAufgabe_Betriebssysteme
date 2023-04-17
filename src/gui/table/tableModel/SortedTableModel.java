package gui.table.tableModel;

import javax.swing.table.DefaultTableModel;

import util.CellCalculator;

public class SortedTableModel {

	private static DefaultTableModel sortedTableModel;
	
	public static void generateSortedTableModel() {
		sortedTableModel = new DefaultTableModel();
		for(int i = 0; i<CellCalculator.getCount(); i++) {
			sortedTableModel.addColumn(i);
		}
	}

	public static DefaultTableModel getSortedTableModel() {
		return sortedTableModel;
	}
	
}
