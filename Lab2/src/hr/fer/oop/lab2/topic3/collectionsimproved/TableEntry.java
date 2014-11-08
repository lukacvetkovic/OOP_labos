package hr.fer.oop.lab2.topic3.collectionsimproved;

/**
 * Class TableEntry makes the object TableEntery with parameters key,value and
 * pointer to next object of TableEntry.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class TableEntry {
	/**
	 * Value of the key object.
	 */
	private Object key;
	/**
	 * Value of the value object.
	 */
	private Object value;
	/**
	 * Reference to next object of TableEntry.
	 */
	private TableEntry next;

	/**
	 * Constructor to instance object TableEntry.
	 * 
	 * @param key
	 *            is the key of an object
	 * @param value
	 *            is the vale of an object
	 * @param tableEntry
	 *            is pointer to next object of tableEntery
	 */
	public TableEntry(Object key, Object value, TableEntry tableEntry) {
		super();
		if (key == null || value == null) {
			throw new IllegalArgumentException("Key and value can't be null");
		}

		this.key = key;
		this.value = value;
		this.next = tableEntry;
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
	 *            new value that you want to set to object.
	 */
	public void setValue(Object value) {
		if (value == null) {
			throw new IllegalArgumentException("Value can't be null");
		}
		this.value = value;
	}

	/**
	 * Getter for the next Object that current object has pointer on.
	 * 
	 * @return reference to next TableEntery object.
	 */
	public TableEntry getNext() {
		return next;
	}

	/**
	 * Setter for the next instance that current object points to.
	 * 
	 * @param next
	 *            is reference to next object.
	 */
	public void setNext(TableEntry next) {
		this.next = next;
	}

	/**
	 * Getter for key.
	 * 
	 * @return key.
	 */
	public Object getKey() {
		return key;
	}

	/**
	 * Method that makes String which we can print it with ease.
	 */
	public String toString() {
		return ("[" + key + "]=[" + value + "]  ");
	}
}
