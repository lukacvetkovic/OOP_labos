package hr.fer.oop.lab2.topic2.calculator;

/**
 * Class that makes register (container) for one object.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Register {
	/**
	 * Value of the register.
	 */
	private Object value;

	/**
	 * Constructor makes instance of register and sets object value to null;
	 */
	public Register() {
		this.value = null;
	}

	/**
	 * Resets the register. Sets object value to null;
	 */
	public void clear() {
		this.value = null;
	}

	/**
	 * Returns string value of object.
	 */
	public String toString() {
		return String.valueOf(value);
	}

	/**
	 * Getter for value.
	 * 
	 * @return value.
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Setter for value.
	 * 
	 * @param value
	 *            is object we want to set registers value to.
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
