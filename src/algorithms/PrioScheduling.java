package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.SimulatedProcess;

public class PrioScheduling{
	public static ArrayList<SimulatedProcess> order(ArrayList<SimulatedProcess> List) {
		
		Collections.sort(List, new AttributeComparator(3));
		return List;
	}
}