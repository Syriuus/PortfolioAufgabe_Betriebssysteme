package algorithms;

import java.util.ArrayList;

import util.Calculate;
import util.SimulatedProcess;

public class LongestRemainingTimeFirstScheduling {
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> processList) {
	ArrayList<Character> IDOutputListe = new ArrayList<>();
	int Systemtime = 0;
	int MaxSystemtime = Calculate.MaxSystemtime(processList);

	
	SimulatedProcess NextProcess = new SimulatedProcess('x',0,0,0,0);
	while(Systemtime < MaxSystemtime)
	{
		if(Calculate.ProcessArrived(processList, Systemtime))NextProcess = CalculateNextProcess(processList,Systemtime);
		
		IDOutputListe.add(NextProcess.getId());
		NextProcess.RemainingRuntimeMinusOne();
		if (NextProcess.getRemainingRuntime() <= 0) {			
			processList.remove(NextProcess);
			NextProcess = CalculateNextProcess(processList,Systemtime);
		}
		Systemtime++;
	}
	return IDOutputListe;
	}
	
	private static SimulatedProcess CalculateNextProcess(ArrayList<SimulatedProcess> processList, int Systemtime )
	{	
	SimulatedProcess NextProcess = new SimulatedProcess('x',0,0,0,0);
	for(SimulatedProcess j: processList) {
		if (j.getArrivaltime() > Systemtime)	continue;
		if (j.getRemainingRuntime() > NextProcess.getRemainingRuntime())	NextProcess = j;

	}

return NextProcess;
	}
}
	/*static ArrayList<SimulatedProcess> CurrentList = new ArrayList<SimulatedProcess>();
	static SimulatedProcess Running = null;
	static int Systemtime;

	public static ArrayList<SimulatedProcess> order(ArrayList<SimulatedProcess> unsortedProcessList)
	{
		
		ArrayList<SimulatedProcess> OutputArray = new ArrayList<SimulatedProcess>();
		for (SimulatedProcess X : unsortedProcessList)
		{
			System.out.println(X.getId() + "/" + X.getRuntime() + "/" + X.getArrivaltime());
		}

		Systemtime = 0;
		Running = unsortedProcessList.get(0);

		while (Systemtime < 100)// Scheduling dauer genau bestimmen.
		{
			for (SimulatedProcess SP : unsortedProcessList) // für jeden Prozess wird die Arrivaltime mit der aktuellen
															// Systemzeit
			// verglichen. NewProcessArriving macht das update.
			{

				if (Systemtime == SP.getArrivaltime())
				{
					NewProcessArriving(SP);
				}

			}

			System.out.print(Running.getId());
			OutputArray.add(Systemtime, Running);
			System.out.print(Running.getRemainingRuntime());
			System.out.println(Running.getArrivaltime());
			Running.setRemainingRuntime(Running.getRemainingRuntime() - 1);
			if (Running.getRemainingRuntime() <= 0) 
			{
				CurrentList.remove(Running);
				unsortedProcessList.remove(Running);
				if (CurrentList.isEmpty() && unsortedProcessList.isEmpty())
				{
					return unsortedProcessList = OutputArray;
				}
				SimulatedProcess LongestRemainingTime = CurrentList.get(0);

				for (SimulatedProcess j : CurrentList) {
					if (j.getRemainingRuntime() < LongestRemainingTime.getRemainingRuntime()) 
					{
						LongestRemainingTime = j;
					}
				}
				Running = CurrentList.get(CurrentList.indexOf(LongestRemainingTime));
			}
			Systemtime++;

			// printausgaben durch array[Systemtime] in reihenfolge eingeben anstatt es zu
			// printen

		}
		return unsortedProcessList;

	}

	private static void NewProcessArriving(SimulatedProcess SP)
	{
		CurrentList.add(SP);

		SimulatedProcess LongestRemainingTime = CurrentList.get(0);
		for (SimulatedProcess i : CurrentList)
		{

			if (LongestRemainingTime.getRemainingRuntime() > i.getRemainingRuntime())
				LongestRemainingTime = i;
			if (SP.getRemainingRuntime() <= 0)
				CurrentList.remove(SP);
		}
		Running = LongestRemainingTime;
		// update, dass current process geändert wird.
	}
*/

