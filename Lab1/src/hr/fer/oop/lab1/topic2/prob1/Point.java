package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * Stavara toèku s x i y koortinatama.
 * 
 * @author proffesor
 *
 */
public class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point t) {
		this(t.x, t.y);
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	/**
	 * Crta jedan pixel na slici.
	 * @param slika na koju crta.
	 */
	public void drawOnPicture(Picture slika) {
		if(slika.getHeight()<x && slika.getWidth()<y){
			slika.turnPixelOn(x, y);
		}
		else{
			System.err.println("Pixel ne postoji na slici");
		}
		

	}

}
