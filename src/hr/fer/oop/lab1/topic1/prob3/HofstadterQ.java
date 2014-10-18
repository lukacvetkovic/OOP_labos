package hr.fer.oop.lab1.topic1.prob3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Klasa za racunanje Hofstadterovog reda.
 * 
 * Sadrzi main metodu i D metodu.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class HofstadterQ {
	/**
	 * Main metodom ucitavamo parametre preko BufferedReader-a. Parametar je
	 * clan Hofstadterovog reda koji zelimo dobiti.
	 * 
	 * @param args
	 *            (ne koristi se)
	 * @throws IOException
	 *             pri ucitavanju
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * D(i)=D(i-D(i-1))+D(i-D(i-2)) D(1)=D(2)=1 reference :
		 * http://en.wikipedia.org/wiki/Hofstadter_sequence
		 */
		BufferedReader scanner = new BufferedReader(new InputStreamReader(
				System.in));
		long i = 0;
		long number = 0;
		String input;

		System.out.println("Input the parameter");

		input = scanner.readLine().trim();
		i = Integer.valueOf(input);

		if (i <= 0) {
			System.err.println("Value of parametar is negative");
			System.exit(-1);
		}
		System.out.println("parametar " + i);
		number = D(i);

		System.out
				.println("You requested calculation of "
						+ i
						+ ". number of Hofstadter's Q-sequence. The requested number is "
						+ number + ".");

	}

	/**
	 * Rekurzivnom metodom se racuna Hofstadterov red
	 * formulom:D(i-D(i-1))+D(i-D(i-2)).
	 * 
	 * @param i
	 *            je clan reda kojeg zelimo dobiti
	 * @return i-ti clan reda
	 */
	private static long D(long i) {
		if (i == 1) {
			return 1;
		} else if (i == 2) {
			return 1;
		} else
			return D(i - D(i - 1)) + D(i - D(i - 2));
	}

}
