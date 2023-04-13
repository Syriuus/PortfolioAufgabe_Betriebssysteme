package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import algorithms.*;
import util.RandomTasks;
import util.SimulatedProcess;

public class MainGUI {
    private JFrame frame;
    private JComboBox<String> algorithmSelector;
    private JButton runButton;
    private JTextArea outputArea;

    public MainGUI() {
        // Initialize components
        frame = new JFrame("Algorithm Selector");
        algorithmSelector = new JComboBox<String>(new String[]{"PräemptivEDFScheduling", "LastComeFirstServed"});
        runButton = new JButton("Run Algorithm");
        outputArea = new JTextArea();

        // Set layout
        frame.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Select an algorithm: "));
        topPanel.add(algorithmSelector);
        topPanel.add(runButton);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Set size and visibility
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Add action listeners
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAlgorithm = (String) algorithmSelector.getSelectedItem();
                ArrayList<SimulatedProcess> processes = RandomTasks.getRandom(10);
                ArrayList<Character> result = null;
                if (selectedAlgorithm.equals("PräemptivEDFScheduling")) {
                    result = PräemptivEDFScheduling.order(processes);
                } else if (selectedAlgorithm.equals("LastComeFirstServed")) {
                    result = LastComeFirstServed.order(processes);
                }
                if (result != null) {
                    outputArea.setText("");
                    for (Character c : result) {
                        outputArea.append(c.toString());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}