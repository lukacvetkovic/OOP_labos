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
		// TODO Auto-generated constructor stub
	}

	/*
	 * Enum declaration
	 */
	public static final OperatorButton zero = new OperatorButton("0");
	public static final OperatorButton one = new OperatorButton("1");
	public static final OperatorButton two = new OperatorButton("2");
	public static final OperatorButton three = new OperatorButton("3");
	public static final OperatorButton four = new OperatorButton("4");
	public static final OperatorButton five = new OperatorButton("5");
	public static final OperatorButton six = new OperatorButton("6");
	public static final OperatorButton seven = new OperatorButton("7");
	public static final OperatorButton eight = new OperatorButton("8");
	public static final OperatorButton nine = new OperatorButton("9");

}
