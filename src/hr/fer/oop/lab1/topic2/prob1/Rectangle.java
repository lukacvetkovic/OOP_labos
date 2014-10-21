package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * Klasa Rectangle stvara objekt tipa rectangle (pravokutnik) sa zadanim
 * parametrima. Pomocu metode drawOnPicture na sliku crta taj objekt.
 * 
 * @author Luka Cvetkoviæ
 *
 */
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

	/**
	 * Crta sliku objekta Rectangle.
	 * 
	 * @param slika
	 *            na koju crta.
	 */
	public void drawOnPicture(Picture slika) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				/*
				 * if(slika.getWidth()<gornjiLijevi.x + i &&
				 * slika.getHeight()<gornjiLijevi.y + j){
				 * slika.turnPixelOn(gornjiLijevi.x + i, gornjiLijevi.y + j); }
				 */
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
