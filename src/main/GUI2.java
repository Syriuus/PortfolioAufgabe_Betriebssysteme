package main;

import java.util.ArrayList;

import algorithms.LastComeFirstServed;
import util.RandomTasks;
import util.SimulatedProcess;

public class GUI2 {
	public static void main(String[] args) throws Exception {
		ArrayList<SimulatedProcess> List2 = RandomTasks.getRandom(10);
		System.out.println("ID, Laufzeit, Prio, Arrival");
		
		for(SimulatedProcess i : List2) {
			System.out.println(i);
		}

		System.out.println("----------------");
		for (Character i : LastComeFirstServed.order(List2)) {
			System.out.print(i);
		}
		for(SimulatedProcess i : List2) {
			System.out.println(i);
		}
		System.out.println("----------------");
		for (Character i : LastComeFirstServed.order(List2)) {
			System.out.print(i);
		}
        
	}
}
