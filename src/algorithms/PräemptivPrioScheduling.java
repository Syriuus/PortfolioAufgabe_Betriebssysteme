package algorithms;

import java.util.ArrayList;
import util.Calculate;
import util.SimulatedProcess;

public class PräemptivPrioScheduling {
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> List) {
		
		ArrayList<Character> IDOutputListe = new ArrayList<>();
		ArrayList<SimulatedProcess> processList = Calculate.duplicateList(List);
		int Systemtime = 0;
		int MaxSystemtime = Calculate.MaxSystemtime(processList);
		
		
		//Folgender Block Arbeitet jedes Zeitframe einzeln ab.
		SimulatedProcess IdleProcess = new SimulatedProcess('x',0,0,0,0);
		SimulatedProcess NextProcess = IdleProcess;
		while(Systemtime < MaxSystemtime)
		{
			NextProcess = CalculateNextProcess(processList,Systemtime);
			IDOutputListe.add(NextProcess.getId());
			NextProcess.RemainingRuntimeMinusOne();
			if(NextProcess.getRemainingRuntime() <= 0) processList.remove(NextProcess);
			Systemtime++;
		}
		return IDOutputListe;
	}
	private static SimulatedProcess CalculateNextProcess(ArrayList<SimulatedProcess> processList, int Systemtime )
	{
	SimulatedProcess NextProcess = new SimulatedProcess('x',0,0,0,0);
	for(SimulatedProcess i : processList)
	{
		
		if(i.getArrivaltime() > Systemtime) continue;				
		if(i.getPriority() > NextProcess.getPriority()); NextProcess = i;				
	
	}
	return NextProcess;
	}
	}
