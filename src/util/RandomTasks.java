package util;

import java.util.ArrayList;
import java.util.Random;

public class RandomTasks {
public static ArrayList<SimulatedProcess> getRandom(int count) throws Exception {
		
		ArrayList<SimulatedProcess> ProcessList = new ArrayList<SimulatedProcess>();
		Random random = new Random();
		int total_arrival_time = 0;
		
		for(int i = 0; i<count; i++) {
			int randomRuntime = random.nextInt(1, 20);
			int randomPriority = random.nextInt(1, 20);
			int randomDeadline = random.nextInt(8, 40);
			ProcessList.add(new SimulatedProcess((char) (i + 65), randomRuntime, randomPriority, total_arrival_time, randomDeadline));
			if(randomRuntime == 1) {
				total_arrival_time += randomRuntime;
			}
			else if(randomRuntime < 8) {
				total_arrival_time += random.nextInt(1, randomRuntime);
			}
			else {
				total_arrival_time += random.nextInt(1, 7);
			}
		}
		return ProcessList;
	}

}
