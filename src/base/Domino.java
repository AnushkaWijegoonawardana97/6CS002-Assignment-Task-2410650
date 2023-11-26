package base;

/**
 * @author Kevan Buckley, maintained by __student
 * @version 2.0, 2014
 */

public class Domino implements Comparable<Domino> {
	private int high;
	private int low;
	private int hx;
	private int hy;
	private int lx;
	private int ly;
	private boolean placed = false;

	public Domino(int high, int low) {
		super();
		this.setHigh(high);
		this.setLow(low);
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public void place(int hx, int hy, int lx, int ly) {
		this.setHx(hx);
		this.setHy(hy);
		this.setLx(lx);
		this.setLy(ly);
		setPlaced(true);
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("[");
		result.append(Integer.toString(getHigh()));
		result.append(Integer.toString(getLow()));
		result.append("]");
		if (!isPlaced()) {
			result.append("unplaced");
		} else {
			result.append("(");
			result.append(Integer.toString(getHx() + 1));
			result.append(",");
			result.append(Integer.toString(getHy() + 1));
			result.append(")");
			result.append("(");
			result.append(Integer.toString(getLx() + 1));
			result.append(",");
			result.append(Integer.toString(getLy() + 1));
			result.append(")");
		}
		return result.toString();
	}

	/** turn the domino around 180 degrees clockwise */

	public void invert() {
		int tx = getHx();
		setHx(getLx());
		setLx(tx);

		int ty = getHy();
		setHy(getLy());
		setLy(ty);
	}

	public boolean ishl() {
		return getHy() == getLy();
	}

	public int compareTo(Domino arg0) {
		if (this.getHigh() < arg0.getHigh()) {
			return 1;
		}
		return this.getLow() - arg0.getLow();
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHx() {
		return hx;
	}

	public void setHx(int hx) {
		this.hx = hx;
	}

	public int getHy() {
		return hy;
	}

	public void setHy(int hy) {
		this.hy = hy;
	}

	public int getLx() {
		return lx;
	}

	public void setLx(int lx) {
		this.lx = lx;
	}

	public int getLy() {
		return ly;
	}

	public void setLy(int ly) {
		this.ly = ly;
	}

	public boolean isPlaced() {
		return placed;
	}

	public void setPlaced(boolean placed) {
		this.placed = placed;
	}

}
