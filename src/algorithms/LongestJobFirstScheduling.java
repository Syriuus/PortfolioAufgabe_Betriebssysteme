package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.SimulatedProcess;

public class LongestJobFirstScheduling {
	public static ArrayList<SimulatedProcess> order(ArrayList<SimulatedProcess> unsortedProcessList){

		Collections.sort(unsortedProcessList, new AttributeComparator(2));
		return unsortedProcessList;
	}
}