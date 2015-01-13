package hr.fer.oop.week9.stat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Class that anylize the files and searches for extensions , first letters,
 * size and counts the files.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Anylizer {
	/**
	 * This is where program starts.
	 * 
	 * @param args
	 *            are used for path to file.
	 * @throws IOException
	 *             when there is no file.
	 */
	public static void main(String[] args) throws IOException {

		Path path = null;

		if (args.length != 0) {
			path = Paths.get(args[0]);
			System.out.println(path);
		} else {
			System.out.println("No parameter");
		}

		try {

			Path novi = path.toRealPath();

		} catch (IOException e1) {
			System.out.println("Error, no such directory");

		}

		MyFileVisitor visitor = new MyFileVisitor();

		Files.walkFileTree(path, visitor);

		List<Extension> sortedListExtension = new ArrayList<Extension>();
		List<FirstLetter> sortedFirstLetterList = new ArrayList<FirstLetter>();

		for (Entry<String, Extension> entry : visitor.extensionMap.entrySet()) {
			sortedListExtension.add(entry.getValue());
		}

		for (Entry<String, FirstLetter> entry : visitor.firstLetterMap
				.entrySet()) {
			sortedFirstLetterList.add(entry.getValue());

		}

		List<Comparator<Extension>> simpleComparators = new ArrayList<Comparator<Extension>>();
		simpleComparators.add(new ExtensionCountComparator(false));
		simpleComparators.add(new ExtensionNameComparator(true));

		sortedListExtension.sort(new ChainedComparator(simpleComparators));

		sortedFirstLetterList.sort(new FirstLetterNameComparator(true));

		System.out
				.println("EKSTENZIJE: ------------------------------------------");
		for (Extension extension : sortedListExtension) {
			System.out.println(extension.name + "\t" + extension.count + "\t"
					+ extension.size);
		}

		System.out
				.println("\nPOCETNA SLOVA:-----------------------------------------");
		for (FirstLetter firstLetter : sortedFirstLetterList) {
			System.out.println(firstLetter.letter + "\t" + firstLetter.count
					+ "\t" + firstLetter.size);
		}

		System.out.println("\nUkupno je pronaðeno : " + visitor.counter
				+ " datoteka");
		System.out.println("\nUkupna velièina je : " + visitor.sizeAll + " b");

	}

}
