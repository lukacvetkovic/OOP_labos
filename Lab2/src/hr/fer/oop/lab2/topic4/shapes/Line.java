package hr.fer.oop.lab2.topic4.shapes;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * Class line makes a line shape with parameters.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Line implements DrawableShape {
	public float duljina;
	public Point pocetak, kraj;

	/**
	 * Constructor that makes instance of line.
	 * 
	 * @param pocetak
	 *            is Point where line begins.
	 * @param kraj
	 *            is Point where line ends.
	 */
	public Line(Point pocetak, Point kraj) {
		super();
		if (pocetak == null || kraj == null) {
			throw new IllegalArgumentException(
					"Begining point or ending point can't be null");
		}

		this.pocetak = pocetak;
		this.kraj = kraj;
		this.duljina = (float) Math.sqrt((kraj.x - pocetak.x) ^ 2
				+ (kraj.y - pocetak.y) ^ 2);

	}

	/**
	 * Constructor that makes instance of line.
	 * 
	 * @param duljina
	 *            is the length of line.
	 * @param pocetak
	 *            is point where line starts.
	 */
	public Line(float duljina, Point pocetak) {
		super();
		if (duljina < 1) {
			throw new IllegalArgumentException("Lenght must be 1 or more");
		} else if (pocetak == null) {
			throw new IllegalArgumentException("Begining point can't be null");
		}
		this.duljina = duljina;
		this.pocetak = pocetak;

	}

	/**
	 * Constructor that makes instance of line.
	 * 
	 * @param line
	 *            is another line that constructor copy parameters from.
	 */
	public Line(Line line) {
		super();
		if (line == null) {
			throw new IllegalArgumentException("Line can't be null");
		}
		this.duljina = line.duljina;
		this.pocetak = line.pocetak;
		this.kraj = line.kraj;
	}

	/**
	 * Method that draws the shape line on picture.
	 * 
	 * @param slika
	 *            is picture where method turns pixels on/off.
	 */
	public void drawOnPicture(Picture slika) {
		if (slika == null) {
			throw new IllegalArgumentException("Picture can't be null");
		}
		if (kraj == null) {
			Point pomocni = new Point((int) (pocetak.x + duljina), pocetak.y);
			setKraj(pomocni);
		}

		int dx = kraj.x - pocetak.x;
		int dy = kraj.y - pocetak.y;
		for (int j = pocetak.x; j <= kraj.x; j++) {
			float y = pocetak.y + dy * (j - pocetak.x) / dx;
			if (slika.getHeight() < y && slika.getWidth() < j) {
				slika.turnPixelOn(j, (int) y);
			}
			slika.turnPixelOn(j, (int) y);
		}

	}

	/**
	 * Setter for Point where line ends.
	 * 
	 * @param kraj
	 *            is Point where line ends.
	 */
	public void setKraj(Point kraj) {
		if (kraj == null) {
			throw new IllegalArgumentException("End point can't be null");
		}
		this.kraj = kraj;
	}

}
