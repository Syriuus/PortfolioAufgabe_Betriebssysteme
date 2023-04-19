package algorithms;

import java.util.ArrayList;
import util.Calculate;
import util.SimulatedProcess;

public class PräemptivEDFScheduling {
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> List) {
		
		ArrayList<Character> IDOutputListe = new ArrayList<>();
		ArrayList<SimulatedProcess> processList = Calculate.duplicateList(List);
		int Systemtime = 0;
		int MaxSystemtime = Calculate.MaxSystemtime(processList);
				
		//Folgender Block Arbeitet jedes Zeitframe einzeln ab.
		SimulatedProcess NextProcess = new SimulatedProcess('x',0,0,0,100);
		while(Systemtime < MaxSystemtime)
		{
			 //Leerlaufprozess.
		
			if(Calculate.ProcessArrived(processList, Systemtime)) NextProcess = CalculateNextProcess(processList,Systemtime);
			IDOutputListe.add(NextProcess.getId());
			NextProcess.RemainingRuntimeMinusOne();
			if(NextProcess.getRemainingRuntime() <= 0)
				{
				processList.remove(NextProcess);
				NextProcess = CalculateNextProcess(processList,Systemtime);
				}
			Systemtime++;
		}
		return IDOutputListe;
	}
	
	private static SimulatedProcess CalculateNextProcess(ArrayList<SimulatedProcess> processList, int Systemtime )
	{		
		SimulatedProcess NextProcess = new SimulatedProcess('x',100,0,0,100);	//IdleProcess
	for(SimulatedProcess j: processList) {
				if (j.getArrivaltime() > Systemtime) continue;				
				if (j.getDeadline() < NextProcess.getDeadline())	NextProcess = j;
			
	}
	if(NextProcess.getId()=='x') NextProcess.setRemainingRuntime(0);
	return NextProcess;
}
}