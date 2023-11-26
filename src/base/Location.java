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
	private int columnInitial;
	private int rowInitial;
	private DIRECTION direactionInitial;
	private int tmporyInitial;

	public enum DIRECTION {
		VERTICAL, HORIZONTAL
	};

	public int getColumnInitial() {
		return columnInitial;
	}

	public void setColumnInitial(int columnInitial) {
		this.columnInitial = columnInitial;
	}

	public int getRowInitial() {
		return rowInitial;
	}

	public void setRowInitial(int rowInitial) {
		this.rowInitial = rowInitial;
	}

	public DIRECTION getDireactionInitial() {
		return direactionInitial;
	}

	public void setDireactionInitial(DIRECTION direactionInitial) {
		this.direactionInitial = direactionInitial;
	}

	public int getTmporyInitial() {
		return tmporyInitial;
	}

	public int setTmporyInitial(int tmporyInitial) {
		this.tmporyInitial = tmporyInitial;
		return tmporyInitial;
	}

	public Location(int r, int c) {
		this.setRowInitial(r);
		this.setColumnInitial(c);
	}

	public Location(int r, int c, DIRECTION d) {
		this(r, c);
		this.setDireactionInitial(d);
	}

	public String toString() {
		if (getDireactionInitial() == null) {
			setTmporyInitial(getColumnInitial() + 1);
			return "(" + (getTmporyInitial()) + "," + (getRowInitial() + 1) + ")";
		} else {
			setTmporyInitial(getColumnInitial() + 1);
			return "(" + (getTmporyInitial()) + "," + (getRowInitial() + 1) + "," + getDireactionInitial() + ")";
		}
	}

	public void drawGridLines(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		for (setTmporyInitial(0); getTmporyInitial() <= 7; tmporyInitial++) {
			g.drawLine(20, 20 + getTmporyInitial() * 20, 180, 20 + getTmporyInitial() * 20);
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
