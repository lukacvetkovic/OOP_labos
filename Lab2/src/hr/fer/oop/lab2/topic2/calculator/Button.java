package hr.fer.oop.lab2.topic2.calculator;

/**
 * Class that creates Button, has enum value and can be (=) or (C).
 * 
 * @author Luka Cvetkoviæ
 *
 */

public class Button {
	protected String buttonName;

	/**
	 * Protected constructor to make instance of Button. Button can be (=) or (C).
	 * 
	 * @param string
	 *            is the name of the button.
	 */
	protected Button(String string) {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Enum declaration
	 */
	public static final Button equals = new Button("=");
	public static final Button clear = new Button("C");
}
