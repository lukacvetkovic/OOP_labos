package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

public class Line {
	public float duljina;
	public Point pocetak, kraj;

	public Line(Point pocetak, Point kraj) {
		super();
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.duljina=(float) Math.sqrt((kraj.x-pocetak.x)^2+(kraj.y-pocetak.y)^2);
		
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
			Point pomocni=new Point((int) (pocetak.x+duljina),pocetak.y);
			setKraj(pomocni);
		}
		float komadicVisine=(float) Math.sqrt(((duljina/(kraj.x-pocetak.x))*(duljina/(kraj.x-pocetak.x)))-1);
		for (int i = pocetak.x; i < kraj.x; i++) {
			slika.turnPixelOn(i, (int) (komadicVisine+i));
		}

	}

	public void setKraj(Point kraj) {
		this.kraj = kraj;
	}

}
