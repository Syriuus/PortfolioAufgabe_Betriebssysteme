package main;

import java.util.ArrayList;

import algorithms.PrioScheduling;
import util.RandomTasks;
import util.SimulatedProcess;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<SimulatedProcess> List =  PrioScheduling.order(RandomTasks.getRandom(5));
		
		for(SimulatedProcess i : List) {
			System.out.println(i);
		}
		

	}

}
