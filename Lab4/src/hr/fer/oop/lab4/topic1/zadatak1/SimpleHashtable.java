package hr.fer.oop.lab4.topic1.zadatak1;

import java.util.Iterator;

/**
 * SimpleHashtable makes the object with table of objects which type is
 * TableEntery. Variable size indicates number of the table slots that are full.
 * Parameter tableLenght is a helper which contains the integer value of how
 * many slots are there in table.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class SimpleHashtable<K, V> implements Iterable<SimpleHashtable.TableEntry<K, V>> {

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
	 * the table equals to closest higher potention or equal of number 2.
	 * 
	 * @param size
	 */
	public SimpleHashtable(int size) {
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
	public void put(K key, V value) {
		TableEntry<K, V> newOne = new TableEntry<K, V>(key, value, null);
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
			TableEntry<K, V> newOne) {
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
	public V get(K key) {
		Object pom = null;
		int whereTo = Math.abs((key.hashCode())) % tableLenght;

		if (table[whereTo].getKey().equals(key)) {

			return (V) table[whereTo].getValue();
		} else {
			pom = searchForKey(table[whereTo].getNext(), key);
		}
		return (V) pom;

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
	private V searchForKey(TableEntry current, K key) {
		if (current == null) {
			return null;
		} else if (current.getKey().equals(key)) {
			return (V) current.getValue();
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
	public boolean containsKey(K key) {
		boolean find = false;
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
	private boolean findIfContains(TableEntry current, K key) {
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
	public boolean containsValue(V value) {
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
	private boolean foundByValue(TableEntry current, V value) {
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
	public void remove(K key) {
		int whereTo = Math.abs((key.hashCode())) % (table.length);
		TableEntry<K, V> temp;

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
	private void removeRecursive(TableEntry first, TableEntry second, K key) {
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

	/**
	 * Class TableEntry makes the object TableEntery with parameters key,value
	 * and pointer to next object of TableEntry.
	 * 
	 * @author Luka Cvetkoviæ
	 *
	 */
	public static class TableEntry<K, V> {
		/**
		 * Value of the key object.
		 */
		private K key;
		/**
		 * Value of the value object.
		 */
		private V value;
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
		public TableEntry(K key, V value, TableEntry tableEntry) {
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
		public V getValue() {
			return value;
		}

		/**
		 * Setter for value.
		 * 
		 * @param value
		 *            new value that you want to set to object.
		 */
		public void setValue(V value) {
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
		public K getKey() {
			return key;
		}

		/**
		 * Method that makes String which we can print it with ease.
		 */
		public String toString() {
			return ("[" + key + "]=[" + value + "]  ");
		}
	}

	/**
	 * Class that mimics Iterator on table entry.
	 * 
	 * @author Luka Cvetkoviæ
	 *
	 */
	private class MyIterator implements Iterator<TableEntry<K, V>>{

		private TableEntry tableEntry;
		private int trenutni;

		public MyIterator() {
			this.tableEntry = null;
			this.trenutni = 0;
		}

		/**
		 * Method that checks if there is next entry in table.
		 */
		@Override
		public boolean hasNext() {
			if (tableEntry == null) {
				for (int i = trenutni; i < tableLenght; i++) {
					if (table[i] != null) {
						return true;
					}
				}
			} else if (tableEntry != null && tableEntry.next != null) {
				return true;
			}

			else {
				for (int i = trenutni; i < tableLenght; i++) {
					if (table[i] != null) {
						return true;
					}
				}
				return false;

			}
			return false;

		}

		/**
		 * Method that returns next entry from tableEntry.
		 */
		@Override
		public TableEntry<K, V> next() {

			if (tableEntry == null) {
				for (int i = this.trenutni; i < tableLenght; i++) {
					if (table[i] != null) {
						this.tableEntry = table[i];
						this.trenutni = i + 1;
						break;
					}

				}
				return tableEntry;
			}

			else if (tableEntry.next != null) {
				tableEntry = tableEntry.next;
				return tableEntry;
			}

			else {

				for (int i = this.trenutni; i < tableLenght; i++) {

					if (table[i] != null) {
						this.tableEntry = table[i];
						this.trenutni = i + 1;
						return this.tableEntry;

					}

				}

				return null;
			}

		}
	}

	/**
	 * Method that returns iterator.
	 */
	@Override
	public Iterator iterator() {
		return new MyIterator();
	}

	public Iterable<V> values() {
		return new Iterable<V>() {

			@Override
			public Iterator<V> iterator() {
				return new Iterator<V>() {

					private MyIterator wrapped = new MyIterator();

					@Override
					public boolean hasNext() {
						return wrapped.hasNext();
					}

					@Override
					public V next() {
						return wrapped.next().value;
					}
				};
			}
		};

	}
	
	public Iterable<K> key() {
		return new Iterable<K>() {

			@Override
			public Iterator<K> iterator() {
				return new Iterator<K>() {

					private MyIterator wrapped = new MyIterator();

					@Override
					public boolean hasNext() {
						return wrapped.hasNext();
					}

					@Override
					public K next() {
						return wrapped.next().key;
					}
				};
			}
		};

	}
	
	

}
