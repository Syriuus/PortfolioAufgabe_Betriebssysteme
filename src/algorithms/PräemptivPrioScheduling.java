package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.SimulatedProcess;

public class PräemptivPrioScheduling {
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> processList) {
		
		ArrayList<Character> IDOutputListe = new ArrayList<>();
		
		int Systemtime = 0;
		
		//Folgender Block dient der Bestimmung der maximalen Systemzeit. 
		SimulatedProcess LastProcessInList = processList.get(processList.size()-1);
		int MaxSystemtime = LastProcessInList.getArrivaltime() + LastProcessInList.getRuntime();
		int RuntimeAddTemp = 0;
		for(SimulatedProcess i : processList)
		{
			RuntimeAddTemp += i.getRuntime();
		}
		if (RuntimeAddTemp > MaxSystemtime) MaxSystemtime = RuntimeAddTemp;
		
		
		
		//Folgender Block Arbeitet jedes Zeitframe einzeln ab.
		
		while(Systemtime < MaxSystemtime)
		{
			 //Leerlaufprozess.
			SimulatedProcess NextProcess = new SimulatedProcess('x',0,0,0,0);
			for(SimulatedProcess i : processList)
			{
				
				if(i.getArrivaltime() > Systemtime) continue;
				
				if(i.getPriority() > NextProcess.getPriority()); NextProcess = i;
				

			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			IDOutputListe.add(NextProcess.getId());
			NextProcess.RemainingRuntimeMinusOne();
			if(NextProcess.getRemainingRuntime() <= 0) processList.remove(NextProcess);
			Systemtime++;
		}
		
		
		
		
		
		
		
		
		return IDOutputListe;
	}
}
