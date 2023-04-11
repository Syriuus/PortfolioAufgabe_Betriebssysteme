package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.SimulatedProcess;

public class ShortestRemainingTimeFirstScheduling
{
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> processList)
	{
	ArrayList<Character> IDOutputListe = new ArrayList<>();
	int Systemtime = 0;
	
	int MaxSystemtime = CalculateMaxSystemtime(processList);
	
	SimulatedProcess IdleProcessHighRuntime = new SimulatedProcess('x',100,0,0,0);
	SimulatedProcess NextProcess = IdleProcessHighRuntime;
	
	while(Systemtime < MaxSystemtime)
	{
		if(ProcessArrived(processList,Systemtime)) NextProcess = CalculateNextProcess(processList, Systemtime);
		
		NextProcess.RemainingRuntimeMinusOne();
		IDOutputListe.add(NextProcess.getId());		
		
		
		
		if (NextProcess.getRemainingRuntime() <= 0) 
		{			
			processList.remove(NextProcess);
			NextProcess = CalculateNextProcess(processList, Systemtime);
		}
		Systemtime++;
	}
	return IDOutputListe;
	
}
	
	
	
	public static int CalculateMaxSystemtime(ArrayList<SimulatedProcess> processList)
	{
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
	
	
	private static boolean ProcessArrived(ArrayList<SimulatedProcess> processList, int Systemtime)
	{
	    boolean ProcessArrived = false;
		for(SimulatedProcess i: processList) 
		{
			if(i.getArrivaltime() == Systemtime) ProcessArrived = true;
		}
				return ProcessArrived;
	}
	
	
	private static SimulatedProcess CalculateNextProcess(ArrayList<SimulatedProcess> processList, int Systemtime )
	{		
		SimulatedProcess NextProcess = new SimulatedProcess('x',100,0,0,0);
		
	for(SimulatedProcess j: processList) {
				if (j.getArrivaltime() > Systemtime) continue;
					
				if (j.getRemainingRuntime() < NextProcess.getRemainingRuntime())	NextProcess = j;
			
	}
	if(NextProcess.getId()=='x') NextProcess.setRemainingRuntime(0);
	
	return NextProcess;
}
}