package hr.fer.oop.lab1.topic2.prob1;

import java.util.Random;

class Path {	
	
	protected Point[] points;
		
	
	public Path(int noOfPoints) {
		points = new Point[noOfPoints];
		Random r = new Random();
		for(int i=0; i<noOfPoints; i++){
			int x = r.nextInt(Constants.MAX_X)+1;
			int y = r.nextInt(Constants.MAX_Y) + 1;
			Point p = new Point(x , y);
			points[i] = p;
		}
	}
	
	public Path(Point[] points) {			
		this.points = new Point[points.length];
		for(int i=0; i<points.length; i++){
			this.points[i] = new Point(points[i]);
		}
	}
	
	public Path(int x1, int y1, int x2, int y2, int...xy) {
		//we'll assume that number of arguments is even (later we'll use exceptions)
		points = new Point[2 + xy.length / 2];
		points[0] = new Point(x1, y1);
		points[1] = new Point(x2, y2);
		for(int i=0; i<xy.length / 2 ; i++){
			points[i+2] = new Point(xy[2 * i], xy[2 * i+1]);
		}
	}
	
	public Point[] getPoints() {
		return points;
	}
	
	public double length() {
		double d = 0;
		for(int i=0; i<points.length - 1; i++) {
			Point a = points[i];
			Point b = points[i+1];
			d += Math.sqrt((b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y)); 
		}
		return d;
	}
}

