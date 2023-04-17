package util;

import java.util.ArrayList;

public class CellCalculator {
	
	private static ArrayList<Character> characters;
	private static ArrayList<Double> processTime;
	private static int count;

	public static void calculateCellNumber(ArrayList<Character> List) {
		
		characters = new ArrayList<>();
		processTime = new ArrayList<>();
		count = 1;
		
		
		double time = 0.0;
		Character lastChar = List.get(0);
		characters.add(lastChar);
		for(Character i : List) {
			if(i != lastChar) {
				lastChar = i;
				characters.add(lastChar);
				count++;
				processTime.add(time);
				time = 1;
			}
			else {
				time++;
			}
			
		}
		processTime.add(time);
		System.out.println(characters);
		System.out.println(processTime);
	}

	public static ArrayList<Character> getCharacters() {
		return characters;
	}

	public static ArrayList<Double> getProcessTime() {
		return processTime;
	}

	public static int getCount() {
		return count;
	}
}
