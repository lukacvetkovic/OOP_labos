package hr.fer.oop.lab2.topic4.shapes;

import java.util.Random;

/**
 * Class that creates random or specific shapes.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class RandomShapeFactory implements DrawableShapeCreator {

	int maxHight;
	int maxWidth;

	/**
	 * Constructor that makes RandomShapeFactory with parameters of maxHeight
	 * and maxWidth of picture.
	 * 
	 * @param maxHight
	 *            is maximal height of picture.
	 * @param maxWidth
	 *            is maximal width of picture.
	 */
	public RandomShapeFactory(int maxHight, int maxWidth) {
		super();
		if (maxHight < 0) {
			throw new IllegalArgumentException("Max hight must be positive");
		} else if (maxWidth < 0) {
			throw new IllegalArgumentException("Max width must be positive");
		}
		this.maxHight = maxHight;
		this.maxWidth = maxWidth;
	}

	@Override
	public DrawableShape[] create(int num) {
		if (num < 1) {
			throw new IllegalArgumentException(
					"Number of shapes must be positive");
		}
		DrawableShape[] shapes = new DrawableShape[num];
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			System.out.println(i);
			switch (random.nextInt(3) + 1) {
			case 1:
				shapes[i] = create("rectangle");
				break;
			case 2:
				shapes[i] = create("circle");
				break;
			case 3:
				shapes[i] = create("line");
				break;
			}
		}
		return shapes;
	}

	@Override
	public DrawableShape create(String typeOfShape) {

		Random random = new Random();
		Point p;
		switch (typeOfShape) {
		case "rectangle":
			p = new Point(random.nextInt(maxWidth), random.nextInt(maxHight));
			Rectangle newRectangle = new Rectangle(random.nextInt(maxWidth
					- p.x - 1) + 1, random.nextInt(maxHight - p.y - 1) + 1, p);
			System.out.println("Kvadrat :" + newRectangle.height + ","
					+ newRectangle.width + "koji pocinje u tocki: "
					+ newRectangle.gornjiLijevi.x + ","
					+ newRectangle.gornjiLijevi.y);
			return newRectangle;

		case "circle":
			p = new Point(random.nextInt(maxWidth), random.nextInt(maxHight));
			Circle newCircle = new Circle(Math.min(
					Math.min(p.x, maxHight - p.x) - 1,
					Math.min(p.y, maxHight - p.y) - 1), p);
			System.out.println("Krug:" + newCircle.radius + "u tocki:" + p.x
					+ "," + p.y);
			return newCircle;

		case "line":
			p = new Point(random.nextInt(maxWidth), random.nextInt(maxHight));
			Point second = new Point(random.nextInt(maxHight - p.x) + p.x + 1,
					random.nextInt(maxWidth));
			while (second.x >= 100) {
				second = new Point(random.nextInt(maxHight - p.x) + p.x + 1,
						random.nextInt(maxWidth));
			}

			Line newLine = new Line(p, second);
			System.out.println("Linija: pocetna tocka:" + p.x + "," + p.y
					+ " a druga tocka je random");
			return newLine;
		default:
			throw new InvalidTypeOfShapeException("Shape is invalid");
		}
	}
}
