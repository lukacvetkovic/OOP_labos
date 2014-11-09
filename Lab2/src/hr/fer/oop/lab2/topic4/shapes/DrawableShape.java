package hr.fer.oop.lab2.topic4.shapes;

/**
 * Interface for drawing shapes to picture.
 */
import hr.fer.oop.lab1.topic2.pic.Picture;

public interface DrawableShape {
	/**
	 * Method that draws shape on picture.
	 * 
	 * @param picture
	 *            is picture where it will be drown.
	 */
	public void drawOnPicture(Picture picture);
}
