package hr.fer.oop.lab2.topic4.shapes;

/**
 * InvalidTypeOfShapeException is RuntimeException which is used if shape is in
 * incorrect form.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class InvalidTypeOfShapeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the Exception.
	 * 
	 * @param s
	 *            is message in Exception.
	 */
	public InvalidTypeOfShapeException(String s) {
		super(s);
	}

}
