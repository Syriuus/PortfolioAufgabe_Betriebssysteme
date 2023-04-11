package algorithms;

import java.util.ArrayList;
import java.util.Collections;

import util.AttributeComparator;
import util.SimulatedProcess;

public class NichtPräemptivEDFScheduling {
	public static ArrayList<Character> order(ArrayList<SimulatedProcess> processList) {
		ArrayList<Character> IDOutputListe = new ArrayList<>();

		int Systemtime = 0;

		// Folgender Block dient der Bestimmung der maximalen Systemzeit.
		SimulatedProcess LastProcessInList = processList.get(processList.size() - 1);
		int MaxSystemtime = LastProcessInList.getArrivaltime() + LastProcessInList.getRuntime();
		int RuntimeAddTemp = 0;
		for (SimulatedProcess i : processList) {
			RuntimeAddTemp += i.getRuntime();
		}
		if (RuntimeAddTemp > MaxSystemtime)
			MaxSystemtime = RuntimeAddTemp;

		
		boolean Blocked = false;
		SimulatedProcess NextProcess = new SimulatedProcess('x', 0, 0, 0, 100);
		while (Systemtime < MaxSystemtime) {
			// Leerlaufprozess.

			if (!Blocked) {
				NextProcess = new SimulatedProcess('x', 0, 0, 0, 100);
				for (SimulatedProcess i : processList) {

					if (i.getArrivaltime() > Systemtime)
						continue;

					if (i.getDeadline() < NextProcess.getDeadline()) {
						NextProcess = i;
					}

				}
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
}
