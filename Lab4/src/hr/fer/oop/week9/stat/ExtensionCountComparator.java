package hr.fer.oop.week9.stat;

import java.util.Comparator;

/**
 * Comparator for sizes.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class ExtensionCountComparator implements Comparator<Extension> {

	private boolean ascDesc;

	public ExtensionCountComparator(boolean ascDesc) {
		super();
		this.ascDesc = ascDesc;
	}

	@Override
	public int compare(Extension o1, Extension o2) {
		int comparison;

		// TRUE je rastuca
		if (ascDesc) {
			comparison = (int) (o1.size - o2.size);
			if (comparison != 0)
				return comparison;

		} else {
			comparison = (int) (o2.size - o1.size);
			if (comparison != 0)
				return comparison;
		}

		return 0;
	}

}
