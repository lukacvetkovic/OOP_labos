package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

public class Circle {

	public float radius;
	public Point centre;



	public Circle(float radius, Point centre) {
		super();
		this.radius = radius;
		this.centre = centre;
	}

	public Circle(Circle circle) {

		this(circle.radius, circle.centre);
	}

	public void drawOnPicture(Picture slika) {
		for (int i = (int) (centre.x - radius); i <= (int) (centre.y + radius); i++) {
			for (int j = (int) (centre.y - radius); j <= (int) (centre.y + radius); j++) {
				if (((i - centre.x) * (i - centre.x))
						+ ((j - centre.y) * (j - centre.y)) <= radius * radius) {
					slika.turnPixelOn(i, j);
				}
			}
		}
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

}
