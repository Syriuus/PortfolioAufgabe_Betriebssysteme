package algorithms;

import java.util.ArrayList;

import util.Calculate;
import util.SimulatedProcess;

public class LastComeFirstServed {

	public static ArrayList<Character> order(ArrayList<SimulatedProcess> List) {
		ArrayList<Character> IDOutputListe = new ArrayList<>();
		ArrayList<SimulatedProcess> processList = Calculate.duplicateList(List);
		int Systemtime = 0;
		int MaxSystemtime = Calculate.MaxSystemtime(processList);
		boolean Blocked = false;
		SimulatedProcess IdleProcessNegativePriority = new SimulatedProcess('x',0,0,-1,0);
		SimulatedProcess NextProcess = IdleProcessNegativePriority;
		while(Systemtime < MaxSystemtime)
		{
			if(!Blocked) 
			{
				NextProcess = CalculateNextProcess(processList, Systemtime);
				Blocked = true;
			}
		
			
			IDOutputListe.add(NextProcess.getId());
			NextProcess.RemainingRuntimeMinusOne();
			if(NextProcess.getRemainingRuntime() <= 0) 
			{
				Blocked = false;
				processList.remove(NextProcess);
			}
			
			Systemtime++;
		}
		return IDOutputListe;
}
		private static SimulatedProcess CalculateNextProcess(ArrayList<SimulatedProcess> processList, int Systemtime )
		{
		SimulatedProcess NextProcess = new SimulatedProcess('x',0,0,-1,0);
		for(SimulatedProcess i : processList)
		{
			
			if(i.getArrivaltime() > Systemtime) continue;
			
			if(i.getArrivaltime() > NextProcess.getArrivaltime())
				{
					NextProcess = i; 
				}
		}
		return NextProcess;
		}
}	
		/*ArrayList<Character> charList = new ArrayList<Character>();
		Iterator<SimulatedProcess> iterator = List.iterator();
		SimulatedProcess previousProcess = null;
		while (iterator.hasNext()) {
			SimulatedProcess simProcess = iterator.next();
			if (previousProcess == null) {

			} else if (previousProcess.getArrivaltime() <= passedTime && simProcess.getArrivaltime() > passedTime) {
				charList.add(previousProcess.getId());
				passedTime += previousProcess.getRuntime();
			}

			if (iterator.hasNext()) {
				previousProcess = simProcess;
			}

		}
		Collections.reverse(List);
		for (SimulatedProcess i : List) {
			if (!charList.contains(i.getId())) {
				charList.add(i.getId());
			}
		}

		return charList;
	}*/


/*
 * Ein Prozess trifft zum Zeitpunkt 0 ein und hat eine Runtime. Sobald dieser
 * Prozess fertig ist wird der aktuellst-eingetroffene Prozess angefangen.
 * 
 * Beispiel: ID, Laufzeit, Prio, Arrival J 16 7 37 I 12 17 35 H 14 10 30 G 1 2
 * 25 F 19 1 19 E 3 9 16 D 16 14 10 C 19 13 7 B 6 11 4 A 11 9 0
 * 
 * A dauert 11ms, es wird also der Prozess mit <=11ms Arrival gesucht und als
 * nächstes Ausgegeben/Angefangen
 */