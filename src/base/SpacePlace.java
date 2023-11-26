package base;

/**
 * @author Kevan Buckley, maintained by __student
 * @version 2.0, 2014
 */

public class SpacePlace {
	private int xOrg;
	private int yOrg;
	private PolarCoordinates polarCoordinates;

	public SpacePlace() {
		xOrg = 0;
		yOrg = 0;
		polarCoordinates = new PolarCoordinates(0.0, 0.0);
	}

	public SpacePlace(PolarCoordinates polarCoordinates) {
		this.xOrg = 0;
		this.yOrg = 0;
		this.polarCoordinates = polarCoordinates;
	}

	public int getxOrg() {
		return xOrg;
	}

	public void setxOrg(int xOrg) {
		this.xOrg = xOrg;
	}

	public int getyOrg() {
		return yOrg;
	}

	public void setyOrg(int yOrg) {
		this.yOrg = yOrg;
	}

	public PolarCoordinates getPolarCoordinates() {
		return polarCoordinates;
	}

	public void setPolarCoordinates(PolarCoordinates polarCoordinates) {
		this.polarCoordinates = polarCoordinates;
	}
}