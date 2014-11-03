package hr.fer.oop.lab1.topic1.prob5;

/**
 * Klasa PrimeNumbers ispisuje proste brojeve Sadrži main metodu preko koje
 * racuna proste brojeve.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class PrimeNumbers {
	/**
	 * Main metoda racuna proste brojeve i ispisuje ih. Preko parametra number
	 * odreduje se koliki broj prostih brojeva se ispisuje. Parametar number
	 * mora biti veci od 0.
	 * 
	 * @param args
	 *            polje od jednog clana koji je parametar koji govori koliki
	 *            broj prostih brojeva ispisujemo, mora biti veci od 0.
	 */
	public static void main(String[] args) {

		int number;

		/*
		 * Mora biti samo jedan parametar Parametar mora biti veci od 0
		 */
		if (args.length != 1) {
			System.err.println("Wrong number of parametars");
		} else if (Integer.valueOf(args[0]) <= 0) {
			System.err.println("Parametar value must be more than 0");
		}

		number = Integer.valueOf(args[0]);

		System.out.println("1. " + 2);

		int flag = 3;
		boolean nasao = false;

		for (int i = 1; i < number; i++) {

			while (true) {
				for (int j = 2; j < 10; j++) {
					if (flag % j == 0 && flag != j) {
						nasao = true;
					}
				}

				if (nasao) {
					flag++;
					nasao = false;
				} else {
					break;
				}
			}
			System.out.println(i + 1 + ". " + flag);
			flag++;
			nasao = false;

		}
	}

}
