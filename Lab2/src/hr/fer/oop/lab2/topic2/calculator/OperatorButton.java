package hr.fer.oop.lab2.topic2.calculator;

/**
 * Class that makes OpratorButton, extends Button class, has enum value and
 * button can be (+) or (-).
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class OperatorButton extends Button {
	/**
	 * Protected constructor to make instance of Button. Button can be (+) or
	 * (-).
	 * 
	 * @param string
	 *            is the name of the button.
	 */
	protected OperatorButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Enum declaration
	 */
	public static final OperatorButton plus = new OperatorButton("+");
	public static final OperatorButton minus = new OperatorButton("-");
}
