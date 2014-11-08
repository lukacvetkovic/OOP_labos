package hr.fer.oop.lab2.topic3.collectionsimproved;

/**
 * SimpleHashtable makes the object with table of objects which type is
 * TableEntery. Variable size indicates number of the table slots that are full.
 * Parameter tableLenght is a helper which contains the integer value of how
 * many slots are there in table.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class SimpleHashtable {

	public int size;
	public TableEntry[] table;
	/**
	 * Int value of the table lenght.
	 */
	private int tableLenght;

	/**
	 * Default constructor that makes the object SimpleHashtable and sets table
	 * length to 16.
	 */
	public SimpleHashtable() {
		super();
		this.size = 0;
		this.table = new TableEntry[16];
		this.tableLenght = 16;
	}

	/**
	 * Constructor that makes the object SimpleHashtable and sets the size of
	 * the table equals to closest higher potency or equal of number 2.
	 * 
	 * @param size
	 *            is size of the table.
	 */
	public SimpleHashtable(int size) {

		if (size < 1) {
			throw new IllegalArgumentException("Size must be positive.");

		}
		float pom;
		if (size % 2 == 0) {
			pom = size;
		} else {
			pom = (float) (Math.log10(size) / Math.log10(2));
			pom = (float) (Math.floor(pom) + 1);
			pom = (float) Math.pow(2, (int) pom);
			pom = (int) pom;
		}

		this.size = 0;
		System.out.println(pom);
		this.table = new TableEntry[(int) pom];
		this.tableLenght = (int) pom;
	}

	/**
	 * Makes new TableEntry object with parameters key and value and put it in
	 * TableEntery table.
	 * 
	 * @param key
	 *            object to set TableEntry object key.
	 * @param value
	 *            object to set TableEntery object value.
	 */
	public void put(Object key, Object value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Key and value can't be null");
		}
		TableEntry newOne = new TableEntry(key, value, null);
		int whereTo = Math.abs((key.hashCode())) % tableLenght;

		if (table[whereTo] == null) {
			table[whereTo] = newOne;
		} else {

			if (table[whereTo].getKey().equals(key)) {
				table[whereTo].setValue(value);
				size--;
			} else if (table[whereTo].getNext() == null) {
				table[whereTo].setNext(newOne);

			} else {
				setLastNext(table[whereTo], table[whereTo].getNext(), newOne);
			}
		}

		size++;

	}

	/**
	 * Helper method that recursively go to the last iteration where the object
	 * must to be put.
	 * 
	 * @param behind
	 *            is object of the TableEntry that has reference to current
	 *            object.
	 * @param current
	 *            is object of the TableEntery where we are checking if it is OK
	 *            to put new TableEntery.
	 * @param newOne
	 *            is object of TableEntery which we wanna put in table.
	 */
	private void setLastNext(TableEntry behind, TableEntry current,
			TableEntry newOne) {
		if (current == null) {
			behind.setNext(newOne);
		} else if (current.getKey().equals(newOne.getKey())) {
			current.setValue(newOne.getValue());
			size--;
		} else {
			setLastNext(current, current.getNext(), newOne);
		}

	}

	/**
	 * Method that returns value where key is equal to key in table.
	 * 
	 * @param key
	 *            parameter by which we search the table.
	 * @return value of the object where key is equal to key in parameter.
	 */
	public Object get(Object key) {
		if (key == null) {
			throw new IllegalArgumentException("Key can't be null");
		}
		Object pom;
		int whereTo = Math.abs((key.hashCode())) % tableLenght;

		if (table[whereTo].getKey().equals(key)) {

			return table[whereTo].getValue();
		} else {
			pom = searchForKey(table[whereTo].getNext(), key);
		}
		return pom;

	}

	/**
	 * Helper method to search for key recursively.
	 * 
	 * @param current
	 *            TableEntry object that we are searching by key.
	 * @param key
	 *            parameter by which we search the table.
	 * @return value of the object where key is equal to key in parameter.
	 */
	private Object searchForKey(TableEntry current, Object key) {
		if (current == null) {
			return null;
		} else if (current.getKey().equals(key)) {
			return current.getValue();
		} else {
			return searchForKey(current.getNext(), key);
		}
	}

	/**
	 * Method to get the number of objects that are in table.
	 * 
	 * @return number of objects in table.
	 */
	public int size() {
		return size;
	}

	/**
	 * Method that searches the table if there is object with the same key in
	 * there.
	 * 
	 * @param key
	 *            is object that we search for.
	 * @return true if there is object with equal key, false if there is not
	 *         object with equal key.
	 */
	public boolean containsKey(Object key) {
		if (key == null) {
			throw new IllegalArgumentException("Key can't be null");
		}

		boolean find = false;
		if (key == null) {
			return false;
		}
		int whereTo = Math.abs((key.hashCode())) % tableLenght;
		if (table[whereTo] == null) {
			return false;
		} else if (table[whereTo].getKey().equals(key)) {
			return true;
		} else {
			find = findIfContains(table[whereTo].getNext(), key);
		}
		return find;

	}

	/**
	 * Helper method to recursively iterate through whole table.
	 * 
	 * @param current
	 *            TableEntry object that we are searching by key.
	 * @param key
	 *            is object that we search for.
	 * @return true if there is object with equal key, false if there is not
	 *         object with equal key.
	 */
	private boolean findIfContains(TableEntry current, Object key) {
		if (current == null) {
			return false;
		} else if (current.getKey().equals(key)) {
			return true;
		} else {
			return findIfContains(current.getNext(), key);
		}

	}

	/**
	 * Method that searches the table if there is object with the same value in
	 * there.
	 * 
	 * @param value
	 *            is object that we search for.
	 * @return true if there is object with equal value, false if there is not
	 *         object with equal value.
	 */
	public boolean containsValue(Object value) {
		boolean foundIt = false;
		for (TableEntry instance : table) {
			if (instance != null && instance.getValue().equals(value)) {
				foundIt = true;
				return foundIt;
			} else {
				if (instance != null) {
					foundIt = foundByValue(instance.getNext(), value);
				}
				if (foundIt) {
					return true;
				}
			}

		}
		return foundIt;

	}

	/**
	 * Helper method to recursively iterate through whole table.
	 * 
	 * @param current
	 *            TableEntry object that we are searching by value.
	 * @param value
	 *            is object that we search for.
	 * @return
	 */
	private boolean foundByValue(TableEntry current, Object value) {
		if (current == null) {
			return false;
		} else if (current.getValue().equals(value)) {
			return true;
		} else
			return foundByValue(current.getNext(), value);
	}

	/**
	 * Method that removes the object from table with equal key.
	 * 
	 * @param key
	 *            parameter by witch we search te table
	 */
	public void remove(Object key) {
		if (key == null) {
			throw new IllegalArgumentException("Key can't be null");
		}
		int whereTo = Math.abs((key.hashCode())) % (table.length);
		TableEntry temp;

		if (table[whereTo] == null) {
			return;
		}
		if (table[whereTo].getKey().equals(key)) {
			temp = table[whereTo].getNext();
			table[whereTo] = temp;
			size--;
		} else {
			removeRecursive(table[whereTo], table[whereTo].getNext(), key);
		}

	}

	/**
	 * Helper method to recursively iterate through whole table.
	 * 
	 * @param first
	 *            object of the TableEntry that has next reference to second
	 *            object.
	 * @param second
	 *            the object in witch we search if it has equal key.
	 * @param key
	 *            parameter by witch we search the objects.
	 */
	private void removeRecursive(TableEntry first, TableEntry second, Object key) {
		if (second == null) {
			return;
		} else if (second.getKey().equals(key)) {
			first.setNext(second.getNext());
			size--;
		} else {
			removeRecursive(second, second.getNext(), key);
		}

	}

	/**
	 * Method that checks if we have put any object in table
	 * 
	 * @return true if we have and false if we did not.
	 */
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else {
			return false;
		}
	}

	/**
	 * Method that makes string of the whole object so we can print it with
	 * ease.
	 */
	public String toString() {
		String s = null;
		for (TableEntry entry : table) {
			while (entry != null) {
				s += entry.toString();
				entry = entry.getNext();
			}
			s += "\n";
		}
		return s;
	}
}
