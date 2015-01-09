package hr.fer.oop.lab4.topic1.zadatak2.Comparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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