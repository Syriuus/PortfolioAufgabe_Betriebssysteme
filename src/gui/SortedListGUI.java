package gui;

import java.util.ArrayList;
import javax.swing.JFrame;

import gui.table.SortedTable;

import javax.swing.BoxLayout;

public class SortedListGUI {

	private static String sortedGUIName = "Sorted Tasks";
	private static JFrame sortedFrame;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void openSortedGUI(ArrayList<Character> sortedList) {
		
		sortedFrame = new JFrame(sortedGUIName);
		sortedFrame.setSize(1000, 100);
		sortedFrame.getContentPane().setLayout(new BoxLayout(sortedFrame.getContentPane(), BoxLayout.X_AXIS));
		
		SortedTable.generateTable(sortedList);

		sortedFrame.setVisible(true);
	}
	public static JFrame getSortedFrame() {
		return sortedFrame;
	}
}

