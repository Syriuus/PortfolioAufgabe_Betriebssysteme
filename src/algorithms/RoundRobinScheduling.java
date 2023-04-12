package algorithms;

import java.util.ArrayList;

import util.Calculate;
import util.SimulatedProcess;

public class RoundRobinScheduling {
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> processList) {

		ArrayList<Character> IDOutputListe = new ArrayList<>();
		ArrayList<SimulatedProcess> RoundRobinListe = new ArrayList<>();
		int Systemtime = 0;
		int MaxSystemtime = Calculate.MaxSystemtime(processList);

		SimulatedProcess NextProcess = new SimulatedProcess('x', 0, 0, 0, 0);

		while (Systemtime < MaxSystemtime) {

			for (SimulatedProcess i : processList) {
				if (Systemtime == i.getArrivaltime())
					RoundRobinListe.add(i);//skript saagt "Neue Prozesse werden am Ende der Warteschlange eingereiht.
			}
			if(RoundRobinListe.size() > 0) {
				NextProcess = RoundRobinListe.get(0);
				
				RoundRobinListe.remove(NextProcess);
				RoundRobinListe.add(NextProcess);
				
				
			}
			else NextProcess = new SimulatedProcess('x', 0, 0, 0, 0);
			
			IDOutputListe.add(NextProcess.getId());
			NextProcess.RemainingRuntimeMinusOne();
			if(NextProcess.getRemainingRuntime() <= 0) 
			{
				processList.remove(NextProcess);
				RoundRobinListe.remove(NextProcess);
			}
			
			Systemtime++;
		}
			return IDOutputListe;

			/*
			 * ArrayList<SimulatedProcess> sortedProcessList = new
			 * ArrayList<SimulatedProcess>();
			 * 
			 * int runtime = 0;
			 * 
			 * while (!processList.isEmpty()) { boolean runtimeCount = false;
			 * 
			 * for (int i = 0; i < processList.size(); i++) { SimulatedProcess process =
			 * processList.get(i); if (process.getRemainingRuntime() > 0 &&
			 * process.getArrivaltime() <= runtime) {
			 * 
			 * sortedProcessList.add(process);
			 * process.setRemainingRuntime(process.getRemainingRuntime() - 1);
			 * 
			 * if (process.getRemainingRuntime() == 0) processList.remove(i);
			 * 
			 * runtime++; runtimeCount = true; } } if (!runtimeCount) runtime++; }
			 * 
			 * return sortedProcessList; }
			 */
		}
	}

