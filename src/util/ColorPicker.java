package util;

import java.awt.Color;
import java.util.ArrayList;

public class ColorPicker {
	
	private static ArrayList<Color> colors = new ArrayList<>();
	
	public static void init() {
		colors.add(new Color(128,128,255));
		colors.add(Color.cyan);
		colors.add(Color.green);
		colors.add(Color.magenta);
		colors.add(Color.orange);
		colors.add(Color.pink);
		colors.add(Color.red);
		colors.add(Color.yellow);
		colors.add(new Color(64, 142, 145));
		colors.add(new Color(86, 157, 170));
		colors.add(new Color(25, 55, 109));
		colors.add(new Color(91, 206, 255));
		colors.add(new Color(255, 153, 241));
		colors.add(new Color(255, 0,89));
		colors.add(new Color(128,128,0));
		colors.add(new Color(128, 0, 0));
		colors.add(new Color(0,128,128));
		colors.add(new Color(178,34,34));
		colors.add(new Color(184,134,11));
		colors.add(new Color(189,183,107));
		colors.add(new Color(34,139,34));
		colors.add(new Color(0,250,154));
		colors.add(new Color(72,209,204));
		colors.add(new Color(0,191,255));
		colors.add(new Color(238,130,238));
		colors.add(new Color(255,20,147));
		colors.add(new Color(192, 192,192));
	}
	
	public static Color getColor(int i) {
		return colors.get(i);
	}
}
