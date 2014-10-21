package hr.fer.oop.lab1.topic1.prob6;

/**
 * Klasa NumberDecompostition radi dekompoziciju broja. Sadrzi main metodu u
 * kojoj je sve implementirano.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class NumberDecomposition {
	/**
	 * Main metoda ispisuje rastav broja na proste faktore. Preko argumenta se
	 * upisuje broj Broj mora biti veci od 0.
	 * 
	 * @param args
	 *            Polje od jednog clana koji je parametar koji je broj kojeg
	 *            rastavljamo na faktore.
	 */
	public static void main(String[] args) {

		int number;
		int djeljenik = 2;
		int pom = 1;

		/*
		 * Polje args mora imati tocno jedan element Element polja je tipa int i
		 * mora biti strogo veci od 0
		 */
		if (args.length != 1) {
			System.err.println("Wrong number of parametars");
		} else if (Integer.valueOf(args[0]) <= 0) {
			System.err.println("Parametar value must be more than 0");
		}

		number = Integer.valueOf(args[0]);
		System.out.println(number);

		while (number > 1) {

			if (number % djeljenik == 0) {
				System.out.println(pom + "." + djeljenik);
				pom++;
				number = number / djeljenik;
			} else {
				djeljenik++;
			}

		}

	}

}
