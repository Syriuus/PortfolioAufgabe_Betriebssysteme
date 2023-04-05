package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import util.SimulatedProcess;

public class LastComeFirstServed {
	
private static int passedTime = 0;
	
public static ArrayList<Character> order(ArrayList<SimulatedProcess> List) {
	ArrayList<Character> charList = new ArrayList<Character>();
	Iterator<SimulatedProcess> iterator = List.iterator();
	SimulatedProcess previousProcess = null;
	while(iterator.hasNext()) {
		SimulatedProcess simProcess = iterator.next();
		if(previousProcess == null) {
			
		}
		else if(previousProcess.getArrivaltime() <= passedTime && simProcess.getArrivaltime() > passedTime) {
			charList.add(previousProcess.getId());
			passedTime += previousProcess.getRuntime();
		}
		
		if(iterator.hasNext()) {
			previousProcess = simProcess;
		}
		
	}
	Collections.reverse(List);
	for(SimulatedProcess i : List) {
		if(!charList.contains(i.getId())) {
			charList.add(i.getId());
		}
	}
	
	return charList;
}
}


