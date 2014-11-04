package hr.fer.oop.lab2.topic2.calculator;

/**
 * 
 * Class that simulates the work on calculator, implements interface
 * ICalculator.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class SimpleCalc implements ICalculator {

	Register display = new Register();
	Register memory = new Register();
	Register operator = new Register();

	/**
	 * Constructor that makes instance of SimpleCalc and sets registers values
	 * do default.
	 */
	public SimpleCalc() {
		super();
		display.setValue(0);
		memory.setValue(0);
		operator.setValue(null);

	}

	/**
	 * Returns string value of display as a string.
	 * 
	 * @return string value of display.
	 */
	@Override
	public String getDisplay() {
		return String.valueOf(display.getValue());
	}

	/**
	 * Method that checks what button is pressed and by it's value run other
	 * methods.
	 * 
	 * @param b
	 *            is pressed button.
	 */
	@Override
	public void press(Button b) {
		if (b instanceof DigitButton) {
			this.pressDigit(Integer.valueOf(b.getButtonName()));
		} else if (b instanceof OperatorButton) {
			if (b.getButtonName().equals("+")) {
				this.pressPlus();
			} else {
				this.pressMinus();
			}
		} else {
			if (b.getButtonName().equals("=")) {
				this.pressEquals();
			} else {
				this.pressClear();
			}
		}
	}

	/**
	 * Simulates the pressed digit on calculator.
	 * 
	 * @param num
	 *            is int what digit is pressed.
	 */
	public void pressDigit(int num) {
		if (num > 9 || num < -1) {
			System.err.println("error");
			return;
		}
		if (display.getValue().equals(0)) {
			display.setValue(num);
		} else {
			int pom = Integer.valueOf(String.valueOf(display.getValue())) * 10;
			pom = pom + num;
			display.setValue(pom);

		}

	}

	/**
	 * Helper method that runs when we press the operation button and the
	 * register operator is not null.
	 */
	private void pressEqualsTemp() {
		if (operator.getValue() == null) {
			System.exit(-1);
		} else {
			if (operator.getValue().equals("+")) {
				int temp;
				temp = Integer.valueOf(String.valueOf(memory.getValue()))
						+ Integer.valueOf(String.valueOf(display.getValue()));
				memory.setValue(temp);
				display.setValue(0);

			}

			if (operator.getValue().equals("-")) {
				int temp;
				temp = Integer.valueOf(String.valueOf(memory.getValue()))
						- Integer.valueOf(String.valueOf(display.getValue()));
				memory.setValue(temp);
				display.setValue(0);

			}
		}

	}

	/**
	 * Simulates the pressed plus(+) on calculator.
	 */
	public void pressPlus() {
		if (operator.getValue() == null) {
			operator.setValue("+");
			memory.setValue(display.getValue());
			display.setValue(0);

		} else {
			pressEqualsTemp();
			operator.setValue("+");
		}
	}

	/**
	 * Simulates the pressed equal(=) on calculator.
	 */
	public void pressEquals() {
		if (operator.getValue() == null) {
			System.exit(-1);
		} else {
			if (operator.getValue().equals("+")) {
				int temp;
				temp = Integer.valueOf(String.valueOf(memory.getValue()))
						+ Integer.valueOf(String.valueOf(display.getValue()));
				pressClear();
				display.setValue(temp);

			}

			else if (operator.getValue().equals("-")) {
				int temp;
				temp = Integer.valueOf(String.valueOf(memory.getValue()))
						- Integer.valueOf(String.valueOf(display.getValue()));
				pressClear();
				display.setValue(temp);

			}
		}

	}

	/**
	 * Simulates the pressed minus(-) on calculator.
	 */
	public void pressMinus() {
		if (operator.getValue() == null) {
			operator.setValue("-");
			memory.setValue(display.getValue());
			display.setValue(0);
		} else {
			pressEqualsTemp();
			operator.setValue("-");
		}
	}

	/**
	 * Resets all the registers values to default.
	 */
	public void pressClear() {
		display.setValue(0);
		memory.setValue(0);
		operator.setValue(null);
	}

	/**
	 * Makes the string which contains the values of all the registers.
	 */
	public String toString() {
		String s;
		s = "(";
		if (!(display.getValue().equals(0))) {
			s += ("D=" + String.valueOf(display.getValue()));
		}
		if (!(memory.getValue().equals(0))) {
			s += (" M=" + String.valueOf(memory.getValue()));
		}
		if (operator.getValue() != null) {
			s += (" O=" + String.valueOf(operator.getValue()));
		}
		s += ")";

		return s;
	}
}