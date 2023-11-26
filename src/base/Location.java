package base;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Kevan Buckley, maintained by __student
 * @version 2.0, 2014
 */

public class Location extends SpacePlace {
	public int columnInitial;
	public int rowInitial;
	public DIRECTION direactionInitial;
	public int tmporyInitial;

	public enum DIRECTION {
		VERTICAL, HORIZONTAL
	};

	public Location(int r, int c) {
		this.rowInitial = r;
		this.columnInitial = c;
	}

	public Location(int r, int c, DIRECTION d) {
		this(r, c);
		this.direactionInitial = d;
	}

	public String toString() {
		if (direactionInitial == null) {
			tmporyInitial = columnInitial + 1;
			return "(" + (tmporyInitial) + "," + (rowInitial + 1) + ")";
		} else {
			tmporyInitial = columnInitial + 1;
			return "(" + (tmporyInitial) + "," + (rowInitial + 1) + "," + direactionInitial + ")";
		}
	}

	public void drawGridLines(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		for (tmporyInitial = 0; tmporyInitial <= 7; tmporyInitial++) {
			g.drawLine(20, 20 + tmporyInitial * 20, 180, 20 + tmporyInitial * 20);
		}
		for (int see = 0; see <= 8; see++) {
			g.drawLine(20 + see * 20, 20, 20 + see * 20, 160);
		}
	}

	public static int getInt() {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				return Integer.parseInt(r.readLine());
			} catch (Exception e) {
			}
		} while (true);
	}
}
