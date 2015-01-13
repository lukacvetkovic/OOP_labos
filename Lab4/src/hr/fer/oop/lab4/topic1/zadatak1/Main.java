package hr.fer.oop.lab4.topic1.zadatak1;
/**
 * Class where program for testing SimpleHashtable starts.
 * @author Luka Cvetkoviæ
 *
 */
public class Main {

	public static void main(String[] args) {
		SimpleHashtable<String,Integer> exams = new SimpleHashtable<>();
		exams.put("Ivana", Integer.valueOf(5));
		exams.put("Janko", Integer.valueOf(4));
		for(String name : exams.key()) {
		 System.out.println("Ime = " + name);
		}
		for(Integer grade : exams.values()) {
		 System.out.println("Ocjena = " + grade);
		}
		for(SimpleHashtable.TableEntry<String,Integer> pair : exams) {
		
		 System.out.println("(Ime, Ocjena) = (" + pair.getKey()+", "+pair.getValue()+")");
		}


	}

}
