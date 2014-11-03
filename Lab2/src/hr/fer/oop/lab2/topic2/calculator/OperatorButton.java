package hr.fer.oop.lab2.topic2.calculator;

public class OperatorButton extends Button{

	protected OperatorButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	public static final OperatorButton plus =  new OperatorButton("+");
	public static final OperatorButton minus =  new OperatorButton("-");
}
