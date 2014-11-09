package hr.fer.oop.lab2.topic4.shapes;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * Class rectangle makes a rectangle shape with parameters.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Rectangle implements DrawableShape {

	public double width, height;
	public Point gornjiLijevi;

	/**
	 * Constructor which create instance of rectangle with parameters width,
	 * height and upper left point of the rectangle.
	 * 
	 * @param width
	 *            is width of rectangle.
	 * @param height
	 *            is height of rectangle.
	 * @param gornjiLijevi
	 *            is upper left point of the rectangle.
	 */
	public Rectangle(double width, double height, Point gornjiLijevi) {
		super();
		if (width < 1 || height < 1) {
			throw new IllegalArgumentException(
					"Width and height must me 1 or more");
		} else if (gornjiLijevi == null) {
			throw new IllegalArgumentException("Left upper point can't be null");
		}

		this.width = width;
		this.height = height;
		this.gornjiLijevi = gornjiLijevi;

	}

	/**
	 * Constructor which create instance of rectangle where parameters is copied
	 * from another rectangle.
	 * 
	 * @param rectangle
	 *            is rectangle from which constructor copy parameters.
	 */
	public Rectangle(Rectangle rectangle) {
		super();
		if (rectangle == null) {
			throw new IllegalArgumentException(
					"Parameter rectangle can't be null");
		}
		this.width = rectangle.width;
		this.height = rectangle.height;
		this.gornjiLijevi = rectangle.gornjiLijevi;

	}

	/**
	 * Method that draws the shape rectangle on picture.
	 * 
	 * @param slika
	 *            is picture where method turns pixels on/off.
	 */
	public void drawOnPicture(Picture slika) {
		if (slika == null) {
			throw new IllegalArgumentException("Picture can't be null");
		}
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

	/**
	 * Getter for width.
	 * 
	 * @return width.
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Setter for width.
	 * 
	 * @param width
	 *            is parameter that width is set.
	 */
	public void setWidth(double width) {
		if (width < 1) {
			throw new IllegalArgumentException("Width must be 1 or more");
		}
		this.width = width;
	}

	/**
	 * Getter for height.
	 * 
	 * @return height.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Setter for height.
	 * 
	 * @param height
	 *            is parameter that height is set.
	 */
	public void setHeight(double height) {
		if (height < 1) {
			throw new IllegalArgumentException("Height must be 1 or more");
		}
		this.height = height;
	}

}
