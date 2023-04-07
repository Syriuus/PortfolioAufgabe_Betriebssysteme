package main;

import java.util.ArrayList;

import algorithms.*;
import util.RandomTasks;
import util.SimulatedProcess;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<SimulatedProcess> List2 = RandomTasks.getRandom(10);
		
		for(SimulatedProcess i : List2) {
			System.out.println(i); // dies ist der Test ob Mac besser ist als Windows
		}
		
		ArrayList<SimulatedProcess> List =  RoundRobinScheduling.order(List2);
		
		/*ArrayList<Character> List =  LastComeFirstServed.order(RandomTasks.getRandom(10));*/
		
		System.out.println("----------------");
		
		for(SimulatedProcess i : List) {
			System.out.println(i); // dies ist der Test ob Mac besser ist als Windows
		}
		
		//Input-Ausgabe -> ID, Laufzeit, Prio, Arrival

	}

}