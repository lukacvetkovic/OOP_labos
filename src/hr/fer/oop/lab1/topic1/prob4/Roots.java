package hr.fer.oop.lab1.topic1.prob4;

/**
 * Klasa Roots za racunanje korijena kompleksnih brojeva Sadrzi main metodu s
 * kojoj se sav postupak racuna.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Roots {
	/**
	 * Main metoda ucitava argumente preko args polja i provjerava njihovu
	 * ispravnost. Broj argumenata mora biti 3: realni dio, imaginarni dio,
	 * zeljeni korijen.
	 * 
	 * @param args
	 *            polje koje se sastoji od 3 elementa: realni dio, imaginarni
	 *            dio, zeljeni korijen.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Greska ako unesemo pogresan broj argumenata
		 */
		if (args.length != 3) {
			System.err.println("Wrong argument numbers");
		}

		double realniDio, imaginarniDio, korijen;
		double r, arg;

		realniDio = Double.valueOf(args[0]);
		imaginarniDio = Double.valueOf(args[1]);
		korijen = Double.valueOf(args[2]);

		/*
		 * Korijen mora biti veci od 1
		 */
		if (korijen < 1) {
			System.err.println("Third parameter must be 2 or more");
			System.exit(-1);
		}

		System.out
				.println("You requested calculation of 2. roots. Solutions are:");

		r = Math.sqrt(realniDio * realniDio + imaginarniDio * imaginarniDio);
		arg = Math.atan(imaginarniDio / realniDio);

		for (int i = 0; i < korijen; i++) {
			double prvi, drugi;
			prvi = Math.pow(r, (1.0 / korijen))
					* Math.cos((arg + 2 * i * Math.PI) / korijen);
			drugi = Math.pow(r, (1.0 / korijen))
					* Math.sin((arg + 2 * i * Math.PI) / korijen);

			if (prvi == 0) {
				System.out.println(i + 1 + ")" + Math.round(drugi) + "i");
			} else if (drugi == 0 && Math.round(prvi) != 0) {
				System.out.println(i + ")" + prvi);
			} else if (drugi < 0) {
				System.out.println(i + 1 + ")" + Math.round(prvi)
						+ Math.round(drugi) + "i");

			} else {
				System.out.println(i + 1 + ")" + Math.round(prvi) + "+"
						+ Math.round(drugi) + "i");
			}

		}
	}

}
