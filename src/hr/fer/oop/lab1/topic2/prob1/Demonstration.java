package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;
import hr.fer.oop.lab1.topic2.pic.PictureDisplay;

public class Demonstration {

	public static void main(String[] args) {
		Picture slika= new Picture(50, 100);
		PictureDisplay display= new PictureDisplay();
		display.showPicture(slika);
	}

}
