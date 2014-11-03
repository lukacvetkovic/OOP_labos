package hr.fer.oop.lab2.topic1.collections;

/**
 * Class TableEntry makes the object TableEntery with parameters key,value and
 * pointer to next object of TableEntry.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class TableEntry {

	private Object key;
	private Object value;
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
