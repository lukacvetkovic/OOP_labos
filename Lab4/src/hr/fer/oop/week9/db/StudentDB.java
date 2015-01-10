package hr.fer.oop.week9.db;

import hr.fer.oop.lab4.topic1.zadatak2.CommandStatus;
import hr.fer.oop.lab4.topic1.zadatak2.ShellCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentDB {

	public static void main(String[] args) throws IOException {

		File file = new File("database.txt");

		BufferedReader reader = new BufferedReader(new FileReader(file));

		List<String> rows = new LinkedList<String>();
		String read = reader.readLine();
		while (read != null) {
			rows.add(read);
			read = reader.readLine();
		}
		StudentDatabase db = new StudentDatabase(rows);

		System.out.println("Search database by querry:");

		while (true) {

			System.out.println("> ");

			BufferedReader input = new BufferedReader(new InputStreamReader(
					System.in));
			List<StudentRecord> studentList = new ArrayList<StudentRecord>();
			String line = input.readLine();
			if (input.equals("exit")) {
				System.out.println("Thank you for using DB");
				break;
			}
			if (line.startsWith("query ")) {
				line = line.replace("query ", "");
				System.out.println(line);
			}
			String[] tempArray = line.split("=");

			switch (tempArray[0].trim()) {
			case "jmbag":
				studentList.add(db.forJMBAG(tempArray[1].trim().replace("\"",
						"")));
				fancyIspis(studentList);
				break;
			case "lastName":
				studentList = db.filter(new LastNameFilter(tempArray[1].trim()
						.replace("\"", "")));
				fancyIspis(studentList);
				break;
			default:
				System.out.println("No such command");

			}

		}

	}

	private static void fancyIspis(List<StudentRecord> studentList) {
		int surnameLength = 0, nameLength = 0;

		if (studentList.size() != 0) {

			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getLastName().length() > surnameLength) {
					surnameLength = studentList.get(i).getLastName().length();
				}
				if (studentList.get(i).getFirstName().length() > nameLength) {
					nameLength = studentList.get(i).getFirstName().length();
				}
			}

			System.out.print("+");
			for (int i = 0; i < 12; i++) {
				System.out.print("=");
			}
			System.out.print("+");
			for (int i = 0; i < surnameLength + 2; i++) {
				System.out.print("=");
			}
			System.out.print("+");
			for (int i = 0; i < nameLength + 2; i++) {
				System.out.print("=");
			}
			System.out.println("+===+");

			for (StudentRecord record : studentList) {
				System.out.println("| "
						+ record.getJmbag()
						+ " | "
						+ String.format("%-" + surnameLength + "s",
								record.getLastName())
						+ " | "
						+ String.format("%-" + nameLength + "s",
								record.getFirstName()) + " | "
						+ record.getFinalGrade() + " |");
			}

			System.out.print("+");
			for (int i = 0; i < 12; i++) {
				System.out.print("=");
			}
			System.out.print("+");
			for (int i = 0; i < surnameLength + 2; i++) {
				System.out.print("=");
			}
			System.out.print("+");
			for (int i = 0; i < nameLength + 2; i++) {
				System.out.print("=");
			}
			System.out.println("+===+");
		}

		System.out.println("Records selected: " + studentList.size());

	}
}
