package hr.fer.oop.lab2.topic4.shapes;

/**
 * Interface which helps us making the field of shapes or shapes of some type.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public interface DrawableShapeCreator {
	/**
	 * Creates array of different random generated shapes. *
	 * 
	 * @param num
	 *            is the number of shapes.
	 * @return array of shapes.
	 */
	public DrawableShape[] create(int num);

	/**
	 * Create instance of shape.
	 * 
	 * @param typeOfShape
	 *            is shape which we want instance of.
	 * @return instance of shape.
	 */
	public DrawableShape create(String typeOfShape);

}
