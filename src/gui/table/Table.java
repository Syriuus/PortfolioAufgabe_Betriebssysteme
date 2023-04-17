package gui.table;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import gui.GUI;
import gui.table.tableModel.TableModel;

public class Table {

	private static JTable table;
	
	public static void generateTable() {
		TableModel.initTableModel();
		table = new JTable(TableModel.getTableModel()) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {                
                return false;               
			};
		};
		table.setLocation(0, 0);
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		GUI.getMainFrame().getContentPane().add(table);
	}

	public static JTable getTable() {
		return table;
	}
}
