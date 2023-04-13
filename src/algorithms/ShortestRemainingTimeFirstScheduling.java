package algorithms;

import java.util.ArrayList;
import util.SimulatedProcess;
import util.Calculate;

public class ShortestRemainingTimeFirstScheduling
{
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> processList)
	{
	ArrayList<Character> IDOutputListe = new ArrayList<>();
	int Systemtime = 0;
	
	int MaxSystemtime = Calculate.MaxSystemtime(processList);
	
	SimulatedProcess IdleProcessHighRuntime = new SimulatedProcess('x',100,0,0,0);
	SimulatedProcess NextProcess = IdleProcessHighRuntime;
	
	while(Systemtime < MaxSystemtime)
	{
		if(Calculate.ProcessArrived(processList,Systemtime)) NextProcess = CalculateNextProcess(processList, Systemtime);
		
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
	private static SimulatedProcess CalculateNextProcess(ArrayList<SimulatedProcess> processList, int Systemtime )
	{		
		SimulatedProcess NextProcess = new SimulatedProcess('x',100,0,0,0);	//IdleProcess
	for(SimulatedProcess j: processList) {
				if (j.getArrivaltime() > Systemtime) continue;				
				if (j.getRemainingRuntime() < NextProcess.getRemainingRuntime())	NextProcess = j;
			
	}
	if(NextProcess.getId()=='x') NextProcess.setRemainingRuntime(0);
	return NextProcess;
}
}