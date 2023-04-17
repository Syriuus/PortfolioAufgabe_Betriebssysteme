package gui.button.buttonEvents;

import java.util.ArrayList;

import algorithms.FirstComeFirstServed;
import algorithms.HighestResponseRatioNext;
import algorithms.LastComeFirstServed;
import algorithms.LongestJobFirstScheduling;
import algorithms.LongestRemainingTimeFirstScheduling;
import algorithms.NichtPräemptivEDFScheduling;
import algorithms.NichtPräemptivPrioScheduling;
import algorithms.PräemptivEDFScheduling;
import algorithms.PräemptivPrioScheduling;
import algorithms.RoundRobinScheduling;
import algorithms.ShortestJobFirstScheduling;
import algorithms.ShortestRemainingTimeFirstScheduling;
import gui.GUI;
import gui.SortedListGUI;
import gui.schedulerSelector.SchedulerSelector;
import util.SchedulerMode;
import util.SimulatedProcess;

public class SortButtonEvent {

	private static ArrayList<SimulatedProcess> randomList = null;
	private static SchedulerMode schedulerMode;
	private static ArrayList<Character> sortedList = null;
	
	public static void sortButton() {
		randomList = GUI.getRandomList();
		schedulerMode = SchedulerSelector.getMode();
		
		switch(schedulerMode) {
		case EarliestDeadlineFirstNonPreemptive:
			sortedList = NichtPräemptivEDFScheduling.order(randomList);
			break;
		case EarliestDeadlineFirstPreemptive:
			sortedList = PräemptivEDFScheduling.order(randomList);
			break;
		case FirstComeFirstServed:
			sortedList = FirstComeFirstServed.order(randomList);
			break;
		case HighestResponseRatioNext:
			sortedList = HighestResponseRatioNext.order(randomList);
			break;
		case LastComeFirstServed:
			sortedList = LastComeFirstServed.order(randomList);
			break;
		case LongestJobFirst:
			sortedList = LongestJobFirstScheduling.order(randomList);
			break;
		case LongestRemainingTimeFirst:
			sortedList = LongestRemainingTimeFirstScheduling.order(randomList);
			break;
		case PrioritySchedulingNonPreemptive:
			sortedList = NichtPräemptivPrioScheduling.order(randomList);
			break;
		case PrioritySchedulingPreemptive:
			sortedList = PräemptivPrioScheduling.order(randomList);
			break;
		case RoundRobin:
			sortedList = RoundRobinScheduling.order(randomList);
			break;
		case ShortestJobFirst:
			sortedList = ShortestJobFirstScheduling.order(randomList);
			break;
		case ShortestRemainingTimeFirst:
			sortedList = ShortestRemainingTimeFirstScheduling.order(randomList);
			break;
		default:
			break;
		}
		
		SortedListGUI.openSortedGUI(sortedList);
	}
}
