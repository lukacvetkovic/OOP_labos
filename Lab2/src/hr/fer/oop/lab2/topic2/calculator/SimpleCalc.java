package hr.fer.oop.lab2.topic2.calculator;

public class SimpleCalc implements ICalculator {

	Registar display = new Registar();
	Registar memory = new Registar();
	Registar operator = new Registar();

	public SimpleCalc() {
		super();
		display.setValue(0);
		memory.setValue(0);
		operator.setValue(null);

	}

	@Override
	public String getDisplay() {
		return String.valueOf(display.getValue());
	}

	@Override
	public void press(Button b) {
		if (b instanceof DigitButton) {
			this.pressDigit(Integer.valueOf(b.buttonName));
		} else if (b instanceof OperatorButton) {
			if (b.buttonName.equals("+")) {
				this.pressPlus();
			} else {
				this.pressMinus();
			}
		} else {
			if (b.buttonName.equals("=")) {
				this.pressEquals();
			} else {
				this.pressClear();
			}
		}
	}

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

	public void pressClear() {
		display.setValue(0);
		memory.setValue(0);
		operator.setValue(null);
	}

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