package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

public class Rectangle {
	
	public double width,height;
	Point gornjiLijevi;
	Point gornjiDesni;
	
	
	
	
	public Rectangle(double width, double height, Point gornjiLijevi,
			Point gornjiDesni) {
		super();
		this.width = width;
		this.height = height;
		this.gornjiLijevi = gornjiLijevi;
		this.gornjiDesni = gornjiDesni;
	}
	
	public Rectangle(Rectangle rectangle) {
		super();
		this.width = rectangle.width;
		this.height = rectangle.height;
		this.gornjiLijevi = rectangle.gornjiLijevi;
		this.gornjiDesni = rectangle.gornjiDesni;
		
	}
	
	

	public void drawOnPicture(Picture slika){
		slika.turnPixelOn(gornjiLijevi.x, gornjiDesni.y);
		Point pom=new Point(gornjiLijevi.x,(int) (gornjiLijevi.y+height));
		slika.turnPixelOn(pom.x,pom.y);
		
		slika.turnPixelOn(gornjiDesni.x,gornjiDesni.y );
		Point novi=new Point(gornjiDesni.x,(int) (gornjiDesni.y+height));
		slika.turnPixelOn(novi.x,(int) (novi.y+height*2) );
		
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	

}
