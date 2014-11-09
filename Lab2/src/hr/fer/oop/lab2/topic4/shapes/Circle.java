package hr.fer.oop.lab2.topic4.shapes;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * Class circle makes a circle shape with parameters.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Circle implements DrawableShape {

	public float radius;
	public Point centre;

	/**
	 * Constructor which creates an instance of Circle with parameters radius
	 * and point center.
	 * 
	 * @param radius
	 *            is the radius of the circle
	 * @param centre
	 *            is the point where the centre of the shape is.
	 */
	public Circle(float radius, Point centre) {
		super();
		if (radius < 1) {
			throw new IllegalArgumentException("Radius must be 1 or more");
		} else if (centre == null) {
			throw new IllegalArgumentException("Centre can't be null");
		}
		this.radius = radius;
		this.centre = centre;
	}

	public Circle(Circle circle) {

		this(circle.radius, circle.centre);
	}

	/**
	 * Method that draws the shape circle on picture.
	 * 
	 * @param slika
	 *            is picture where method turns pixels on/off.
	 */
	public void drawOnPicture(Picture slika) {
		if (slika == null) {
			throw new IllegalArgumentException("Picture can't be null");
		}

		for (int i = (int) (centre.x - radius); i <= (int) centre.x + radius; i++) {
			for (int j = (int) (centre.y - radius); j <= (int) (centre.y + radius); j++) {
				if (((i - centre.x) * (i - centre.x))
						+ ((j - centre.y) * (j - centre.y)) <= radius * radius) {
					slika.turnPixelOn(i, j);
				}
			}
		}

	}

	/**
	 * Getter for radius.
	 * 
	 * @return radius of circle.
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * Setter for radius.
	 * 
	 * @param radius
	 *            is parameter which we want to set our radius to.
	 */
	public void setRadius(float radius) {
		if (radius < 1) {
			throw new IllegalArgumentException("Radius must be 1 or more");
		}
		this.radius = radius;
	}

}
