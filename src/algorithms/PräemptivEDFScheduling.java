package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.SimulatedProcess;

public class PräemptivEDFScheduling {
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
		SimulatedProcess NextProcess = new SimulatedProcess('x',0,0,0,100);
		while(Systemtime < MaxSystemtime)
		{
			 //Leerlaufprozess.
		
			for(SimulatedProcess i: processList) {
				if(i.getArrivaltime() == Systemtime)
					for(SimulatedProcess j: processList) {
						if (j.getArrivaltime() > Systemtime)
							continue;

						if (j.getDeadline() < NextProcess.getDeadline())	NextProcess = j;

					
					}
			}
			IDOutputListe.add(NextProcess.getId());
			NextProcess.RemainingRuntimeMinusOne();
			if(NextProcess.getRemainingRuntime() <= 0)
				{
				processList.remove(NextProcess);
				NextProcess = new SimulatedProcess('x',0,0,0,100);
				for(SimulatedProcess j: processList) {
					if (j.getArrivaltime() > Systemtime)
						continue;

					if (j.getDeadline() < NextProcess.getDeadline())	NextProcess = j;
			
				}
				}
			Systemtime++;
		}
		return IDOutputListe;
	}
}
