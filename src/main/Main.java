package main;

import java.util.ArrayList;

import algorithms.*;
import util.RandomTasks;
import util.SimulatedProcess;

public class Main {

	public static void main(String[] args) throws Exception {

		ArrayList<SimulatedProcess> List2 = RandomTasks.getRandom(10);
		
		System.out.println("ID, Laufzeit, Prio, Arrival");

		for (SimulatedProcess i : List2) {
			System.out.println(i); // dies ist der Test ob Mac besser ist als Windows
		}
		System.out.println("----------------");
		ArrayList<Character> List = PräemptivEDFScheduling.order(List2);

		/*
		 * ArrayList<Character> List =
		 * LastComeFirstServed.order(RandomTasks.getRandom(10));
		 */

		

		for (Character i : List) {
			System.out.print(i); // dies ist der Test ob Mac besser ist als Windows
		}

		// Input-Ausgabe -> ID, Laufzeit, Prio, Arrival

	}

}