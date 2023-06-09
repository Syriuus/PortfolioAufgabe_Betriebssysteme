package algorithms;

import java.util.ArrayList;
import util.Calculate;
import util.SimulatedProcess;

public class NichtPräemptivEDFScheduling {
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> List) {
		ArrayList<Character> IDOutputListe = new ArrayList<>();
		ArrayList<SimulatedProcess> processList = Calculate.duplicateList(List);
		int Systemtime = 0;
		int MaxSystemtime = Calculate.MaxSystemtime(processList);

		boolean Blocked = false;
		SimulatedProcess NextProcess = new SimulatedProcess('x', 0, 0, 0, 100);
		while (Systemtime < MaxSystemtime) {
			if (!Blocked) {
				NextProcess = CalculateNextProcess(processList,Systemtime);
				Blocked = true;
			}
			IDOutputListe.add(NextProcess.getId());
			NextProcess.RemainingRuntimeMinusOne();
			if (NextProcess.getRemainingRuntime() <= 0) {
				Blocked = false;
				processList.remove(NextProcess);
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
