package hr.fer.oop.lab2.topic2.calculator;

public class Registar {
	private Object value;

	public Registar() {
		this.value = null;
	}

	public void clear() {
		this.value = null;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
