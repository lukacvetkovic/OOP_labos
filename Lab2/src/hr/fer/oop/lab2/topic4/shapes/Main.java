package hr.fer.oop.lab2.topic4.shapes;

import hr.fer.oop.lab1.topic2.pic.Picture;
import hr.fer.oop.lab1.topic2.pic.PictureDisplay;

public class Main {
	static final int WIDTH = 100;
	static final int HEIGHT = 100;

	public static void main(String[] args) {

		DrawableShapeCreator factory = new RandomShapeFactory(WIDTH, HEIGHT);
		DrawableShape[] shapes = factory.create(5);
		Picture pic = new Picture(WIDTH, HEIGHT);

		for (DrawableShape s : shapes) {
			if (s != null) {
				s.drawOnPicture(pic);
			}

		}
		PictureDisplay.showPicture(pic);

	}

}
