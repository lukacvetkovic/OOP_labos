package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;
import hr.fer.oop.lab1.topic2.pic.PictureDisplay;

/**
 * Klasa s mainom u kojem provjeravamo da objekti rade zadane akcije
 * 
 * @author Cveki
 *
 */
public class Demonstration {

	public static void main(String[] args) {
		Picture slika = new Picture(1000, 500);
		
		
		Point jedan = new Point(50,150);
		Point dva = new Point(400, 300);
		Point tri=new Point(500,150);
		Point cetiri=new Point(700,200);
		Point pet= new Point(200,400);
		Point sest= new Point(250,200);
		Rectangle rectangle1 = new Rectangle(100, 150, jedan);
		Rectangle rectangle2= new Rectangle(150,100,dva);
		Line line1 = new Line(tri, cetiri);
		Line line2 = new Line(dva, tri);		
		Circle krug1 = new Circle(75, pet);
		Circle krug2= new Circle(50,sest);
		
		
		PictureDisplay display = new PictureDisplay();
		rectangle1.drawOnPicture(slika);
		line1.drawOnPicture(slika);
		krug1.drawOnPicture(slika);
		rectangle2.drawOnPicture(slika);
		line2.drawOnPicture(slika);
		krug2.drawOnPicture(slika);
		display.showPicture(slika);
	}

}
