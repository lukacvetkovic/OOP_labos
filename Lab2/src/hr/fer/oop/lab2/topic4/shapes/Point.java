package hr.fer.oop.lab2.topic4.shapes;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * Class that is a Point with parameters x and y.
 * 
 * @author professor
 *
 */
public class Point {
	public int x;
	public int y;

	/**
	 * Constructor for making instance of point.
	 * 
	 * @param x
	 *            is the x coordinate.
	 * @param y
	 *            is the y coordinate.
	 */
	public Point(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException(
					"Coordinates must have positive parameters");
		}
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructor for making instance of point.
	 * 
	 * @param t
	 *            is another point from which constructor makes copy of x and y.
	 */
	public Point(Point t) {
		this(t.x, t.y);
	}

	/**
	 * Returns the X and Y coordinate of point as a string.
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/**
	 * Method that turns a pixel on on the picture.
	 * 
	 * @param slika
	 *            is picture where method turns pixels on.
	 */
	public void drawOnPicture(Picture slika) {
		if (slika == null) {
			throw new IllegalArgumentException("Picture can't be null");
		}
		if (slika.getHeight() < x && slika.getWidth() < y) {
			slika.turnPixelOn(x, y);
		} else {
			System.err.println("Pixel ne postoji na slici");
		}

	}

}
