package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import util.SimulatedProcess;

public class PrioScheduling{
	public static ArrayList<SimulatedProcess> order(ArrayList<SimulatedProcess> Liste) {
		
		Map<Character, Integer> map = new HashMap<>();
		LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<SimulatedProcess> sortedList = new ArrayList<>();
        
		for(SimulatedProcess i : Liste) { // UUID und Prio in extra Map
			map.put(i.getId(), i.getPriority());
		}
		
		for (Entry<Character, Integer> entry : map.entrySet()) { // Prio in eine ArrayList
            list.add(entry.getValue());
        }
		
		Collections.sort(list); // ArrayList sortieren
        for (int num : list) { // für jede Nummer in der Liste
            for (Entry<Character, Integer> entry : map.entrySet()) { // und jeden Eintrag in der Map
                if (entry.getValue().equals(num)) {  // wird wenn die nummer mit der Liste mit der der Map übereinstimmt
                    sortedMap.put(entry.getKey(), num); // der Eintrag in die Sortierte Map hinzugefügt
                }
            }
        }
        
        for(Entry<Character, Integer> entry : sortedMap.entrySet()) { // für jeden eintrag in der Sortierten Map
        	for(SimulatedProcess i : Liste) { // und jeden Process in der Liste
        		if(i.getId() == entry.getKey()) { //wenn die UUIDs übereinstimmen
            		sortedList.add(i); // wird es in die sortierte Liste hinzugefügt
            	}
    		}
        }
		return sortedList;
	}
}