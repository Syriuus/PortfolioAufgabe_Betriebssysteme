package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import util.Calculate;
import util.SimulatedProcess;

public class HighestResponseRatioNext {
	
	private static Double passedTime = 0.0d;
	private static Double answerQuotient = 0.0d;
	
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> List) {
		ArrayList<SimulatedProcess> processList = Calculate.duplicateList(List);
		HashMap<SimulatedProcess, Double> aqMap = new HashMap<SimulatedProcess, Double>();
		ArrayList<Character> sortedList = new ArrayList<>();
		while(!processList .isEmpty()) {
			for(SimulatedProcess i : processList ) {
				answerQuotient = (i.getRuntime() + (passedTime - i.getArrivaltime()))/i.getRuntime();
				aqMap.put(i, answerQuotient);
				// System.out.println(i + "   " + answerQuotient);
			}
			// System.out.println("---------------");
			SimulatedProcess key = Collections.max(aqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
			aqMap.clear();
			for(int i = 0; i<key.getRuntime(); i++) {
				sortedList.add(key.getId());
			}
			processList .remove(key);
			passedTime += key.getRuntime();
		}
		
		
		return sortedList;
	}
}
