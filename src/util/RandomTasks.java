package util;

import java.util.ArrayList;
import java.util.Random;

public class RandomTasks {
public static ArrayList<SimulatedProcess> getRandom(int count) throws Exception {
		
		ArrayList<SimulatedProcess> ProcessList = new ArrayList<SimulatedProcess>();
		Random random = new Random();
		int total_arrival_time = 0;
		
		if(count<= 0 || count > 26) {
			throw new IndexOutOfBoundsException("Bitte gebe eine zahl zwischen 1 und 26 an");
		}
		
		for(int i = 0; i<count; i++) {
			int randomRuntime = random.nextInt(1, 20);
			int randomPriority = random.nextInt(1, 20);
			ProcessList.add(new SimulatedProcess((char) (i + 65), randomRuntime, randomPriority, total_arrival_time, total_arrival_time));
			total_arrival_time += random.nextInt(1, 7);
		}
		return ProcessList;
	}

}
