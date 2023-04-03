package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.SimulatedProcess;

public class LongestJobFirstScheduling {
	public static ArrayList<SimulatedProcess> order(ArrayList<SimulatedProcess> unsortedProcessList){
		ArrayList<SimulatedProcess> sortedProcessList = new ArrayList<SimulatedProcess>(unsortedProcessList);

		Collections.sort(sortedProcessList, new AttributeComparator(2));
		return sortedProcessList;
	}
}