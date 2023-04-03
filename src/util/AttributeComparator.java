package util;

import java.util.Comparator;

public class AttributeComparator implements Comparator<SimulatedProcess> {
	
	private final int attribute;
	
	/*
	 * 0 -> Earliest Deadline First
	 * 1 -> Shortest Job First
	 * 2 -> Longest Job First´
	 * 3 -> Priority Sort
	 */
	
	public AttributeComparator (int attribute) {
		this.attribute = attribute;
	}
	
	@Override
	public int compare (SimulatedProcess p1, SimulatedProcess p2) {
		switch (attribute) {
		case 0: return p1.getDeadline() - p2.getDeadline();
		case 1: return p1.getRuntime() - p2.getRuntime();
		case 2: return p2.getRuntime() - p1.getRuntime();
		case 3: return p2.getPriority() - p1.getPriority();
		default: return 0;
		}
	}
}
