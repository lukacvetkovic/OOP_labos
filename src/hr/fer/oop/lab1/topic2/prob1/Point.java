package hr.fer.oop.lab1.topic2.prob1;

/**
 * Stavara toèku s x i y koortinatama
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

}
