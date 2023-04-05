package algorithms;

import java.util.ArrayList;
import util.SimulatedProcess;

public class RoundRobinScheduling {
	public static ArrayList<SimulatedProcess> order (ArrayList<SimulatedProcess> processList) {
		ArrayList<SimulatedProcess> sortedProcessList = new ArrayList<SimulatedProcess>();
		
		int runtime = 0;
		
		while (!processList.isEmpty()) {
			boolean runtimeCount = false;
			
			for (int i = 0; i < processList.size(); i++) {
				SimulatedProcess process = processList.get(i);
				if (process.getRemainingRuntime() > 0 && process.getArrivaltime() <= runtime) {
					
					sortedProcessList.add(process);
					process.setRemainingRuntime(process.getRemainingRuntime() - 1);
					
					if (process.getRemainingRuntime() == 0) processList.remove(i);
					
					runtime++;
					runtimeCount = true;
				}
			}
			if (!runtimeCount) runtime++;
		}
		
		return sortedProcessList;
	}
}
