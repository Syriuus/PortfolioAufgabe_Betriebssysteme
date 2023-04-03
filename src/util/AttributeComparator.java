package util;

import java.util.Comparator;

public class AttributeComparator implements Comparator<SimulatedProcess> {
	
	private final int attribute;
	
	/*
	 * 0 -> Last Come First Served
	 * 1 -> Shortest Job First
	 * 2 -> Longest Job First
	 */
	
	public AttributeComparator (int attribute) {
		this.attribute = attribute;
	}
	
	@Override
	public int compare (SimulatedProcess p1, SimulatedProcess p2) {
		switch (attribute) {
		case 0: return p2.getArrivaltime() - p1.getArrivaltime();
		case 1: return p1.getRuntime() - p2.getRuntime();
		case 2: return p2.getRuntime() - p1.getRuntime();
		default: return 0;
		}
	}
}
