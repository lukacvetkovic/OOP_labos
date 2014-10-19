package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

public class Rectangle {

	public double width, height;
	public Point gornjiLijevi;

	public Rectangle(double width, double height, Point gornjiLijevi) {
		super();
		this.width = width;
		this.height = height;
		this.gornjiLijevi = gornjiLijevi;

	}

	public Rectangle(Rectangle rectangle) {
		super();
		this.width = rectangle.width;
		this.height = rectangle.height;
		this.gornjiLijevi = rectangle.gornjiLijevi;

	}

	public void drawOnPicture(Picture slika) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				slika.turnPixelOn(gornjiLijevi.x + i, gornjiLijevi.y + j);
			}
		}

	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
