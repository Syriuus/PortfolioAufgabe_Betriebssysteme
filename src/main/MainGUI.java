package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import algorithms.*;
import util.RandomTasks;
import util.SimulatedProcess;

public class MainGUI {

    private JFrame frame;
    private JPanel panel;
    private JTextArea outputArea;

    public MainGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Main GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton runButton = new JButton("Run");
        runButton.addActionListener(e -> {
			try {
				runAlgorithm();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        panel.add(runButton, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    private void runAlgorithm() throws Exception {
        ArrayList<SimulatedProcess> List2 = RandomTasks.getRandom(10);

        StringBuilder sb = new StringBuilder();
        for (SimulatedProcess i : List2) {
            sb.append(i).append("\n");
        }
        sb.append("----------------\n");

        ArrayList<Character> List = PräemptivEDFScheduling.order(List2);

        for (Character i : List) {
            sb.append(i);
        }

        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        new MainGUI();
    }

}