package gui.table;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

import gui.SortedListGUI;
import gui.table.tableModel.SortedTableModel;
import util.CellCalculator;
import util.ColorPicker;

public class SortedTable {
	
	private static JTable table;
	
	public static void generateTable(ArrayList<Character> sortedList) {
		CellCalculator.calculateCellNumber(sortedList);
		SortedTableModel.generateSortedTableModel();
		
		table = new JTable(SortedTableModel.getSortedTableModel());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for(int i = 0; i<CellCalculator.getCount(); i++) {
			Character c = CellCalculator.getCharacters().get(i);
			Color cellColor = ColorPicker.getColor(c - 65);
			System.out.println(1000*CellCalculator.getProcessTime().get(i)/sortedList.size());
			table.getColumnModel().getColumn(i).setPreferredWidth((int) (1000*CellCalculator.getProcessTime().get(i)/sortedList.size()));
			table.getColumnModel().getColumn(i).setCellRenderer(new ColumnColorRenderer(cellColor, Color.black));
		}
		SortedTableModel.getSortedTableModel().addRow(CellCalculator.getCharacters().toArray());
		SortedTableModel.getSortedTableModel().addRow(CellCalculator.getProcessTime().toArray());
		
		SortedListGUI.getSortedFrame().getContentPane().add(table);
	}
}
class ColumnColorRenderer extends DefaultTableCellRenderer {
	   /**
	 * 
	 */
	private static final long serialVersionUID = -2319442658236336743L;
	Color backgroundColor, foregroundColor;
	   public ColumnColorRenderer(Color backgroundColor, Color foregroundColor) {
	      super();
	      this.backgroundColor = backgroundColor;
	      this.foregroundColor = foregroundColor;
	   }
	   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,   boolean hasFocus, int row, int column) {
	      Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	      cell.setBackground(backgroundColor);
	      cell.setForeground(foregroundColor);
	      return cell;
	   }
	}
