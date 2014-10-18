package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

public class Rectangle {
	
	public double width,height;
	Point x;
	Point y;

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
		
	}
	
	public void drawOnPicture(Picture slika){
		//ne znam kak to	
		
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
