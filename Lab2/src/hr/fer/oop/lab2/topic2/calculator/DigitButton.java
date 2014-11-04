package hr.fer.oop.lab2.topic2.calculator;

/**
 * Class that makes DigitButton, extends Button class, has enum value and button
 * can be digit (0-9).
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class DigitButton extends Button {
	/**
	 * Protected constructor to make instance of DigitButton. Button can be
	 * number (0-9).
	 * 
	 * @param string
	 *            is the name of the button.
	 */
	protected DigitButton(String string) {
		super(string);
	}

	/*
	 * Enum declaration
	 */
	public static final DigitButton zero = new DigitButton("0");
	public static final DigitButton one = new DigitButton("1");
	public static final DigitButton two = new DigitButton("2");
	public static final DigitButton three = new DigitButton("3");
	public static final DigitButton four = new DigitButton("4");
	public static final DigitButton five = new DigitButton("5");
	public static final DigitButton six = new DigitButton("6");
	public static final DigitButton seven = new DigitButton("7");
	public static final DigitButton eight = new DigitButton("8");
	public static final DigitButton nine = new DigitButton("9");

}
