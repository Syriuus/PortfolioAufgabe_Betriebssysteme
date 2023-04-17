package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.SimulatedProcess;

public class PrioScheduling{
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> List) {
		ArrayList<Character> sortedList = new ArrayList<>();
		Collections.sort(List, new AttributeComparator(3));
		for(SimulatedProcess i : List) {
			sortedList.add(i.getId());
		}
		return sortedList;
	}
}