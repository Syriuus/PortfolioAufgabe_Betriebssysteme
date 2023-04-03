package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.SimulatedProcess;

public class ShortestJobFirstScheduling {
	public static ArrayList<SimulatedProcess> order(ArrayList<SimulatedProcess> unsortedProcessList){

		Collections.sort(unsortedProcessList, new AttributeComparator(1));
		return unsortedProcessList;
	}
}
