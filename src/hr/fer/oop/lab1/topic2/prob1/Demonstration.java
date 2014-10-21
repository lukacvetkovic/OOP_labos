package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;
import hr.fer.oop.lab1.topic2.pic.PictureDisplay;

/**
 * Klasa s mainom u kojem provjeravamo da objekti rade zadane akcije.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Demonstration {
	/**
	 * Main metoda sluzi za testiranje i stvaranje objekata.
	 * 
	 * @param args
	 *            (ne koristi se)
	 */
	public static void main(String[] args) {
		Picture slika = new Picture(100, 50);

		Point jedan = new Point(30, 15);
		Point dva = new Point(40, 30);
		Point tri = new Point(50, 15);
		Point cetiri = new Point(70, 20);
		Point pet = new Point(20, 40);
		Point sest = new Point(25, 20);
		Rectangle rectangle1 = new Rectangle(150, 15, jedan);
		Rectangle rectangle2 = new Rectangle(10, 10, dva);
		Line line1 = new Line(tri, cetiri);
		Line line2 = new Line(dva, tri);
		Circle krug1 = new Circle(7, pet);
		Circle krug2 = new Circle(5, sest);

		PictureDisplay display = new PictureDisplay();
		rectangle1.drawOnPicture(slika);
		line1.drawOnPicture(slika);
		krug1.drawOnPicture(slika);
		rectangle2.drawOnPicture(slika);
		line2.drawOnPicture(slika);
		krug2.drawOnPicture(slika);
		// slika.renderImageToStream(System.out);
		display.showPicture(slika);
	}

}
