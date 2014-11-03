package hr.fer.oop.lab2.topic2.calculator;

public class Main {

	public static void main(String[] args) {
		String s;
		SimpleCalc c = new SimpleCalc();

		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);

		c.pressDigit(1);
		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);

		c.pressDigit(0);
		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);

		c.pressMinus();
		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);

		c.pressDigit(2);
		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);

		c.pressDigit(9);
		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);

		c.pressPlus();
		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);

		c.pressDigit(3);
		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);

		c.pressEquals();
		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);

		c.pressClear();
		s = c.getDisplay();
		System.out.println(s);
		s = c.toString();
		System.out.println(s);
	}
}
