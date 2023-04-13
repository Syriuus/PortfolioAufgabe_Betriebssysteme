package main;

import javax.swing.JFrame;
import java.util.ArrayList;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import util.RandomTasks;
import util.SchedulerMode;
import util.SimulatedProcess;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {
	private static JTable table;
	private static JTextField txtZahlVon;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		
		String col[] = {"ID","Runtime","Priority", "Arrivaltime", "Deadline"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		
		JFrame meinFrame = new JFrame("PenGUIn");
		meinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		meinFrame.getContentPane().setLayout(null);
		meinFrame.setSize(574, 668);
		
		JLabel lblNewLabel = new JLabel("Scheduler:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 13, 95, 29);
		meinFrame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(SchedulerMode.values()));
		comboBox.setBounds(70, 18, 457, 21);
		meinFrame.getContentPane().add(comboBox);
		
		table = new JTable(tableModel) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {                
                return false;               
			};
		};
		table.setLocation(0, 0);
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		meinFrame.getContentPane().add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Anzahl der Prozesse:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 52, 143, 13);
		meinFrame.getContentPane().add(lblNewLabel_1);
		
		txtZahlVon = new JTextField();
		txtZahlVon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtZahlVon.setText("Zahl von 1 bis 26");
		txtZahlVon.setBounds(129, 50, 106, 19);
		meinFrame.getContentPane().add(txtZahlVon);
		txtZahlVon.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 600, 85, 21);
		meinFrame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sortieren");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(465, 600, 85, 21);
		meinFrame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Tasks generieren");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer numberOfProcesses = Integer.parseInt(txtZahlVon.getText());
				ArrayList<SimulatedProcess> randomList = null;
				try {
					randomList = RandomTasks.getRandom(numberOfProcesses);
				} catch (Exception e1) {
					System.out.println("Error");
				}
				table.setBounds(10, 100, 516, 16*numberOfProcesses+16);
				tableModel.setRowCount(0);
				tableModel.addRow(col);
				for(SimulatedProcess i : randomList) {
					Object[] obj = {i.getId(), i.getRuntime(), i.getArrivaltime(), i.getPriority(), i.getDeadline()};
					tableModel.addRow(obj);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(206, 600, 123, 21);
		meinFrame.getContentPane().add(btnNewButton_2);
		meinFrame.setVisible(true);
		
	}
}
