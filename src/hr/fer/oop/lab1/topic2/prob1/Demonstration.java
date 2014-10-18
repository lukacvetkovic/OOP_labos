package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;
import hr.fer.oop.lab1.topic2.pic.PictureDisplay;

public class Demonstration {

	public static void main(String[] args) {
		Picture slika= new Picture(500, 1000);
		Point jedan=new Point(10,40);
		Point dva=new Point(40,10);
		Rectangle rectangle=new Rectangle(10,10, jedan, dva);
		PictureDisplay display= new PictureDisplay();
		rectangle.drawOnPicture(slika);
		display.showPicture(slika);
	}

}
