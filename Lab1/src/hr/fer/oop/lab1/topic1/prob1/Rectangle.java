package hr.fer.oop.lab1.topic1.prob1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Klasa Rectangle sa main metodom koja sadrzi visinu(width) i sirinu(height).
 * Ucitava parametre dok nisu odgovarajuci (veci od 0). Racuna opseg i povrsinu
 * pravokutika. Sadrži metodu inputOfParameters s pomocu kojih ucitava podatke.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Rectangle {

	/**
	 * Main metoda racuna opseg i povrsinu pravokutnika.
	 * 
	 * @param args
	 *            koristimo za unos podataka.
	 * @throws IOException
	 *             kod unosa podataka.
	 */
	public static void main(String[] args) throws IOException {

		double width = 0;
		double height = 0;

		if (args.length == 2) {
			width = Integer.valueOf(args[0]);
			height = Integer.valueOf(args[1]);
		}

		else {
			System.out.println("Nothing was given");
			width = inputOfParameters(true);
			height = inputOfParameters(false);
		}
		if (width < 0 || height < 0) {
			if (width < 0) {
				System.out.println("Width is negative");
				width = inputOfParameters(true);
			} else {
				System.out.println("Height is negative");
				height = inputOfParameters(false);
			}
		}

		double perimeter = 2 * height + 2 * width;

		System.out.println("You have specified a rectangle with width " + width
				+ " and height " + height + ". Its area is " + width * height
				+ " and its perimeter is " + perimeter + ".");

	}

	/**
	 * Metoda pomocu koje s parametrom chosing odlucujemo da li ucitavamo sirinu
	 * ili visinu.
	 * 
	 * True za sirinu false za visinu.
	 * 
	 * @param choosing
	 *            za true ucitavamo width a za false height.
	 * @return value of height/width
	 * @throws IOException
	 *             kod citanja podataka
	 */
	private static Integer inputOfParameters(Boolean choosing)
			throws IOException {
		BufferedReader ulaz = new BufferedReader(new InputStreamReader(
				System.in));
		String input;
		while (true) {
			if (choosing) {
				System.out.println("Please provide width:");
			} else {
				System.out.println("Please provide height:");
			}
			input = ulaz.readLine().trim();

			if (input.isEmpty()) {
				System.out.println("Nothing was given");
				continue;
			} else {
				if (Integer.valueOf(input) >= 0) {
					return Integer.valueOf(input);
				} else {
					if (choosing) {
						System.out.println("Width is negative");
						continue;
					} else {
						System.out.println("Height is negative");
					}
				}
			}

		}

	}

}
