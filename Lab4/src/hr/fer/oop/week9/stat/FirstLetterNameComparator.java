package hr.fer.oop.week9.stat;

import java.util.Comparator;

/**
 * Comparator for First letter of file.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class FirstLetterNameComparator implements Comparator<FirstLetter> {

	private boolean ascDesc;

	public FirstLetterNameComparator(boolean ascDesc) {
		super();
		this.ascDesc = ascDesc;
	}

	@Override
	public int compare(FirstLetter o1, FirstLetter o2) {

		int comparison;

		// TRUE je rastuca
		if (ascDesc) {
			comparison = o1.letter.toLowerCase().compareTo(
					o2.letter.toLowerCase());
			if (comparison != 0)
				return comparison;

		} else {
			comparison = o2.letter.toLowerCase().compareTo(
					o1.letter.toLowerCase());
			if (comparison != 0)
				return comparison;
		}

		return 0;
	}

}
