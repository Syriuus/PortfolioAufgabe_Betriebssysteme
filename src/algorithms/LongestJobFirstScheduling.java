package algorithms;

import java.util.ArrayList;
import util.Calculate;
import util.SimulatedProcess;

public class LongestJobFirstScheduling {
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> processList) {
		ArrayList<Character> IDOutputListe = new ArrayList<>();

		int Systemtime = 0;
		int MaxSystemtime = Calculate.MaxSystemtime(processList);
		boolean Blocked = false;
		SimulatedProcess NextProcess = new SimulatedProcess('x', 0, 0, 0, 0);
		while (Systemtime < MaxSystemtime) {
			if (!Blocked) {
				if(Calculate.ProcessArrived(processList,Systemtime)) NextProcess = CalculateNextProcess(processList, Systemtime);
				Blocked = true;	
			}
			//if(NextProcess.getId()=='x') NextProcess.setRemainingRuntime(0);
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
	SimulatedProcess NextProcess = new SimulatedProcess('x', 0, 0, 0, 0);
	for (SimulatedProcess i : processList) {

		if (i.getArrivaltime() > Systemtime) continue;
		if (i.getRuntime() > NextProcess.getRuntime())	NextProcess = i;
	}
	return NextProcess;
}
}