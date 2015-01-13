package hr.fer.oop.week9.stat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator that has list of other comparator so that we can sort list by few
 * parameters.
 * 
 * @author Luka Cvetkoviæ
 *
 * @param <T>
 *            is typse of comparator.
 */
public class ChainedComparator<T> implements Comparator<T> {
	private List<Comparator<T>> simpleComparators;

	public ChainedComparator(List<Comparator<T>> simpleComparators) {
		this.simpleComparators = simpleComparators;
	}

	public int compare(T o1, T o2) {
		for (Comparator<T> comparator : simpleComparators) {
			int result = comparator.compare(o1, o2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}
}