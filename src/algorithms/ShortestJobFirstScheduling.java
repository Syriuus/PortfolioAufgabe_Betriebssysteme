package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.Calculate;
import util.SimulatedProcess;

public class ShortestJobFirstScheduling {
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> processList) {
		
		ArrayList<Character> IDOutputListe = new ArrayList<>();
		int Systemtime = 0;
		int MaxSystemtime = Calculate.MaxSystemtime(processList);

		boolean Blocked = false;
		SimulatedProcess IdleProcessHighRuntime = new SimulatedProcess('x',100,0,0,0);
		SimulatedProcess NextProcess = IdleProcessHighRuntime;
		while (Systemtime < MaxSystemtime) 
		{
			if (!Blocked) 
			{
				if(Calculate.ProcessArrived(processList,Systemtime)) NextProcess = CalculateNextProcess(processList, Systemtime);
				Blocked = true;
			}
			if(NextProcess.getId()=='x') NextProcess.setRemainingRuntime(0);
			IDOutputListe.add(NextProcess.getId());
			NextProcess.RemainingRuntimeMinusOne();
			if (NextProcess.getRemainingRuntime() <= 0) 
			{
				NextProcess = CalculateNextProcess(processList, Systemtime);
				//eventuell auch bei prozess ende neu einsortieren lassen ?
				Blocked = false;
				processList.remove(NextProcess);
			}

			Systemtime++;
		}
		return IDOutputListe;
	}
	
	private static SimulatedProcess CalculateNextProcess(ArrayList<SimulatedProcess> processList, int Systemtime )
	{		
		SimulatedProcess NextProcess = new SimulatedProcess('x',100,0,0,0);	//IdleProcess high runtime
	for(SimulatedProcess j: processList) {
				if (j.getArrivaltime() > Systemtime) continue;				
				if (j.getRemainingRuntime() < NextProcess.getRemainingRuntime())	NextProcess = j;			
	}
	if(NextProcess.getId()=='x') NextProcess.setRemainingRuntime(0);
	return NextProcess;
}
}
