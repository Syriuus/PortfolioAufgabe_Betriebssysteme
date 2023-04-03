package main;

import java.util.ArrayList;

import algorithms.LastComeFirstServed;
import util.RandomTasks;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Character> List =  LastComeFirstServed.order(RandomTasks.getRandom(10));
		
		for(Character i : List) {
			System.out.println(i); // dies ist der Test ob Mac besser ist als Windows
		}
		

	}

}
