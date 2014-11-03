package hr.fer.oop.lab2.topic2.calculator;

/**
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Button {
	protected String buttonName;

	protected Button(String string) {
		// TODO Auto-generated constructor stub
	}

	public static final Button equals = new Button("=");
	public static final Button clear = new Button("C");
}
