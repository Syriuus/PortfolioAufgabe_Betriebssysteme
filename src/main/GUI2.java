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
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI2 {
	private static JFrame mainFrame;
	private static JTable table;
	private static JTextField numberBoundariesTextfield;
	@SuppressWarnings("rawtypes")
	private static JComboBox schedulerSelector;
	private static JLabel schedulerTextLabel;
	private static JLabel countTextLabel;
	private static JButton exitButton;
	private static JButton generateTasksButton;
	private static JButton sortButton;
	
	private static String fontType = "Tahoma";
	private static String guiName = "PenGUIn";
	private static String schedulerText = "Scheduler:";
	private static String countText = "Number of processes:";
	private static String textFieldText = "Input a number between 1 and 26";
	private static String exitButtonText = "Exit";
	private static String generateTasksButtonText = "Generate tasks";
	private static String sortButtonText = "Sort";
	
	static ArrayList<SimulatedProcess> randomList = null;
	private static DefaultTableModel tableModel;
	private static String col[] = {"ID","Runtime","Priority", "Arrivaltime", "Deadline"};

	
	
	public static void main(String[] args) throws Exception {
		
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		tableModel = new DefaultTableModel(col, 0);
		
		generateFrame();
		generateSchedulerSelector();
		generateLabel();
		generateTable();
		generateTextfield();
		generateButtons();
		
		mainFrame.getContentPane().add(schedulerSelector);
		mainFrame.getContentPane().add(schedulerTextLabel);
		mainFrame.getContentPane().add(table);
		mainFrame.getContentPane().add(countTextLabel);
		mainFrame.getContentPane().add(numberBoundariesTextfield);
		mainFrame.getContentPane().add(exitButton);
		mainFrame.getContentPane().add(sortButton);
		mainFrame.getContentPane().add(generateTasksButton);
		
		mainFrame.setVisible(true);
	}
	
	private static void generateFrame() {
		mainFrame = new JFrame(guiName);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setSize(559, 668);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void generateSchedulerSelector() {
		schedulerSelector = new JComboBox();
		schedulerSelector.setFont(new Font(fontType, Font.PLAIN, 12));
		schedulerSelector.setModel(new DefaultComboBoxModel(SchedulerMode.values()));
		schedulerSelector.setBounds(70, 18, 457, 21);
	}
	
	private static void generateLabel() {
		schedulerTextLabel = new JLabel(schedulerText);
		schedulerTextLabel.setFont(new Font(fontType, Font.PLAIN, 12));
		schedulerTextLabel.setBounds(10, 13, 95, 29);
		countTextLabel = new JLabel(countText);
		countTextLabel.setFont(new Font(fontType, Font.PLAIN, 12));
		countTextLabel.setBounds(10, 52, 143, 13);
	}
	
	private static void generateTable() {
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
	}
	
	private static void generateTextfield() {
		numberBoundariesTextfield = new JTextField();
		numberBoundariesTextfield.setFont(new Font(fontType, Font.PLAIN, 12));
		numberBoundariesTextfield.setText(textFieldText);
		numberBoundariesTextfield.setBounds(129, 50, 214, 19);
	}
	
	private static void generateButtons() {
		exitButton = new JButton(exitButtonText);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
			}
		});
		exitButton.setFont(new Font(fontType, Font.PLAIN, 12));
		exitButton.setBounds(10, 600, 85, 21);
		
		sortButton = new JButton(sortButtonText);
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		sortButton.setFont(new Font(fontType, Font.PLAIN, 12));
		sortButton.setBounds(465, 600, 85, 21);
		
		generateTasksButton = new JButton(generateTasksButtonText);
		generateTasksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer numberOfProcesses = Integer.parseInt(numberBoundariesTextfield.getText());
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
		generateTasksButton.setFont(new Font(fontType, Font.PLAIN, 12));
		generateTasksButton.setBounds(206, 600, 123, 21);
	}
}
