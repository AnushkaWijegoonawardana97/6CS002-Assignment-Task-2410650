package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The PictureFrame class represents the visual frame for the Abominodo game. It
 * includes methods for drawing the grid, headings, dominos, and other
 * components.
 * 
 * Author: Kevan Buckley, maintained by __student Version: 2.0, 2014
 */

public class PictureFrame {
	public Main master = null;

	/**
	 * The DominoPanel class is an inner class that extends JPanel. It handles the
	 * drawing of the game components.
	 */
	class DominoPanel extends JPanel {
		private static final long serialVersionUID = 4190229282411119364L;

		/**
		 * Draws the domino grid.
		 */
		public void drawGrid(Graphics g) {
			for (int are = 0; are < 7; are++) {
				for (int see = 0; see < 8; see++) {
					drawDigitGivenCentre(g, 30 + see * 20, 30 + are * 20, 20, master.grid[are][see]);
				}
			}
		}

		/**
		 * Draws the column and row headings.
		 */
		public void drawHeadings(Graphics g) {
			for (int are = 0; are < 7; are++) {
				fillDigitGivenCentre(g, 10, 30 + are * 20, 20, are + 1);
			}

			for (int see = 0; see < 8; see++) {
				fillDigitGivenCentre(g, 30 + see * 20, 10, 20, see + 1);
			}
		}

		/**
		 * Draws a placed domino on the grid.
		 */
		public void drawDomino(Graphics g, Domino d) {
			if (d.isPlaced()) {
				int y = Math.min(d.getLy(), d.getHy());
				int x = Math.min(d.getLx(), d.getHx());
				int w = Math.abs(d.getLx() - d.getHx()) + 1;
				int h = Math.abs(d.getLy() - d.getHy()) + 1;
				g.setColor(Color.WHITE);
				g.fillRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
				g.setColor(Color.RED);
				g.drawRect(20 + x * 20, 20 + y * 20, w * 20, h * 20);
				drawDigitGivenCentre(g, 30 + d.getHx() * 20, 30 + d.getHy() * 20, 20, d.getHigh(), Color.BLUE);
				drawDigitGivenCentre(g, 30 + d.getLx() * 20, 30 + d.getLy() * 20, 20, d.getLow(), Color.BLUE);
			}
		}

		/**
		 * Draws a digit given its center coordinates.
		 */
		void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
			int radius = diameter / 2;
			g.setColor(Color.BLACK);
			// g.drawOval(x - radius, y - radius, diameter, diameter);
			FontMetrics fm = g.getFontMetrics();
			// convert the string to an integer
			String txt = Integer.toString(n);
			g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
		}

		/**
		 * Draws a digit given its center coordinates and color.
		 */
		void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n, Color c) {
			int radius = diameter / 2;
			g.setColor(c);
			// g.drawOval(x - radius, y - radius, diameter, diameter);
			FontMetrics fm = g.getFontMetrics();
			String txt = Integer.toString(n);
			g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
		}

		/**
		 * Fills a digit circle given its center coordinates.
		 */
		void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
			int radius = diameter / 2;
			g.setColor(Color.GREEN);
			g.fillOval(x - radius, y - radius, diameter, diameter);
			g.setColor(Color.BLACK);
			g.drawOval(x - radius, y - radius, diameter, diameter);
			FontMetrics fm = g.getFontMetrics();
			String txt = Integer.toString(n);
			g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
		}

		/**
		 * Overrides the paintComponent method to paint the game components.
		 */
		@Override
		protected void paintComponent(Graphics g) {
			g.setColor(Color.YELLOW);
			g.fillRect(0, 0, getWidth(), getHeight());

			Location l = new Location(1, 2);

			if (master.mode == 1) {
				paintComponentDraw(g, l);
				master.drawGuesses(g);
			}
			if (master.mode == 0) {
				paintComponentDraw(g, l);
				master.drawDominoes(g);
			}
		}

		/**
		 * Draws the grid lines, headings, and the domino grid.
		 */
		private void paintComponentDraw(Graphics g, Location l) {
			l.drawGridLines(g);
			drawHeadings(g);
			drawGrid(g);
		}

		/**
		 * Overrides the getPreferredSize method to set the preferred size of the panel.
		 */
		@Override
		public Dimension getPreferredSize() {
			// the application window always prefers to be 202x182
			return new Dimension(202, 182);
		}
	}

	public DominoPanel dp;

	/**
	 * Initializes the PictureFrame with the given Main object.
	 */
	public void PictureFrameAction(Main sf) {
		master = sf;
		if (dp == null) {
			JFrame f = new JFrame("Abominodo");
			dp = new DominoPanel();
			f.setContentPane(dp);
			f.pack();
			f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			f.setVisible(true);
		}
	}

}