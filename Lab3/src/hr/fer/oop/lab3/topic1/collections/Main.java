package hr.fer.oop.lab3.topic1.collections;

public class Main {

	public static void main(String[] args) {
		// create collection:
		SimpleHashtable examMarks = new SimpleHashtable(2);
		// fill data:
		examMarks.put("Ivana", Integer.valueOf(2));
		examMarks.put("Ante", Integer.valueOf(2));
		examMarks.put("Jasna", Integer.valueOf(2));
		examMarks.put("Kristina", Integer.valueOf(5));
		examMarks.put("Ivana", Integer.valueOf(5)); // overwrites old grade for
													// Ivana

		for (Object entry : examMarks) {
			SimpleHashtable.TableEntry pair = (SimpleHashtable.TableEntry) entry;
			System.out.printf("%s => %s%n", pair.getKey(), pair.getValue());
		}
		/*
		// query collection:
		String stanje = examMarks.toString();
		System.out.println(stanje);

		Integer kristinaGrade = (Integer) examMarks.get("Kristina");
		System.out.println("Kristina's exam grade is: " + kristinaGrade); // writes:
																			// 5
		// What is collection's size? Must be four!
		System.out.println("Number of stored pairs: " + examMarks.size()); // writes:
																			// 4

		boolean imaval = examMarks.containsValue(Integer.valueOf(5));
		System.out.println(imaval);

		boolean ima = examMarks.containsKey("Ivana");
		System.out.println("Prije izbrisane " + ima);

		examMarks.remove("Ivana");

		stanje = examMarks.toString();
		System.out.println(stanje);

		examMarks.remove("Ante");

		stanje = examMarks.toString();
		System.out.println(stanje);

		ima = examMarks.containsKey("Ivana");
		System.out.println("Nakon izbrisane Ivane " + ima);

		examMarks.remove("Kristina");
		examMarks.remove("Jasna");

		boolean isempty = examMarks.isEmpty();

		System.out.println("prazan = " + isempty);*/
	}

}
