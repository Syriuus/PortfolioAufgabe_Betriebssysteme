package util;

import java.util.ArrayList;

public class Calculate {
	public static int MaxSystemtime(ArrayList<SimulatedProcess> List)
	{
		ArrayList<SimulatedProcess> processList = Calculate.duplicateList(List);
		SimulatedProcess LastProcessInList = processList.get(processList.size() - 1);
		int MaxSystemtime = LastProcessInList.getArrivaltime() + LastProcessInList.getRuntime();
		int RuntimeAddTemp = 0;
		for (SimulatedProcess i : processList) {
			RuntimeAddTemp += i.getRuntime();
		}
		if (RuntimeAddTemp > MaxSystemtime)
			MaxSystemtime = RuntimeAddTemp;
		return MaxSystemtime;
	}
	public static boolean ProcessArrived(ArrayList<SimulatedProcess> processList, int Systemtime)
	{
	    boolean ProcessArrived = false;
		for(SimulatedProcess i: processList) 
		{
			if(i.getArrivaltime() <= Systemtime) {
				ProcessArrived = true;
			}
		}
				return ProcessArrived;
	}
	public static ArrayList<SimulatedProcess> duplicateList(ArrayList<SimulatedProcess> List){
		ArrayList<SimulatedProcess> dupList = new ArrayList<>();
		for(SimulatedProcess i : List) {
			dupList.add(new SimulatedProcess(i));
		}
		return dupList;
	}
}
