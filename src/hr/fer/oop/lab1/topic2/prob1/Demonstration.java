package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;
import hr.fer.oop.lab1.topic2.pic.PictureDisplay;

public class Demonstration {

	public static void main(String[] args) {
		Picture slika= new Picture(500, 1000);
		Point jedan=new Point(100,100);
		Point dva=new Point(150,150);
		/*Rectangle rectangle=new Rectangle(100,400, jedan);
		Line line = new Line(jedan,dva);*/
		Circle krug=new Circle(75,dva);
		PictureDisplay display= new PictureDisplay();
		//rectangle.drawOnPicture(slika);
		//line.drawOnPicture(slika);
		krug.drawOnPicture(slika);
		display.showPicture(slika);
	}

}
