package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import util.SimulatedProcess;

public class HighestResponseRatioNext {
	
	private static Double passedTime = 0.0d;
	private static Double answerQuotient = 0.0d;
	
	public static ArrayList<SimulatedProcess> order(ArrayList<SimulatedProcess> List) {
		HashMap<SimulatedProcess, Double> aqMap = new HashMap<SimulatedProcess, Double>();
		ArrayList<SimulatedProcess> sortedList = new ArrayList<>();
		while(!List.isEmpty()) {
			for(SimulatedProcess i : List) {
				answerQuotient = (i.getRuntime() + (passedTime - i.getArrivaltime()))/i.getRuntime();
				aqMap.put(i, answerQuotient);
				// System.out.println(i + "   " + answerQuotient);
			}
			// System.out.println("---------------");
			SimulatedProcess key = Collections.max(aqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
			aqMap.clear();
			sortedList.add(key);
			List.remove(key);
			passedTime += key.getRuntime();
		}
		
		
		return sortedList;
	}
}
