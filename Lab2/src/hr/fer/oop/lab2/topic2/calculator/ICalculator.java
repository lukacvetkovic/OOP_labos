package hr.fer.oop.lab2.topic2.calculator;

/**
 * 
 * Interface that helps us create Calculator.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public interface ICalculator {
	/**
	 * Returns string value of display as a string.
	 * 
	 * @return string value of display.
	 */
	String getDisplay();

	/**
	 * Method that checks what button is pressed and by it's value run other
	 * methods.
	 * 
	 * @param b
	 *            is pressed button.
	 */
	void press(Button b);
}
