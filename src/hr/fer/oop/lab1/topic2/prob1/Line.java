package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * Klasa Line stvara objekt tipa line (crta) sa zadanim parametrima. Pomocu
 * metode drawOnPicture na sliku crta taj objekt
 * 
 * @author Cveki
 *
 */
public class Line {
	public float duljina;
	public Point pocetak, kraj;

	public Line(Point pocetak, Point kraj) {
		super();
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.duljina = (float) Math.sqrt((kraj.x - pocetak.x) ^ 2
				+ (kraj.y - pocetak.y) ^ 2);

	}

	public Line(float duljina, Point pocetak) {
		super();
		this.duljina = duljina;
		this.pocetak = pocetak;

	}

	public Line(Line line) {
		super();
		this.duljina = line.duljina;
		this.pocetak = line.pocetak;
		this.kraj = line.kraj;
	}

	public void drawOnPicture(Picture slika) {
		if (kraj == null) {
			Point pomocni = new Point((int) (pocetak.x + duljina), pocetak.y);
			setKraj(pomocni);
		}

		int dx = kraj.x - pocetak.x;
		int dy = kraj.y - pocetak.y;
		for (int j = pocetak.x; j <= kraj.x; j++) {
			float y = pocetak.y + dy * (j - pocetak.x) / dx;
			slika.turnPixelOn(j, (int) y);
		}

	}

	public void setKraj(Point kraj) {
		this.kraj = kraj;
	}

}
