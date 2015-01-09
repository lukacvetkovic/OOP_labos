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

		File file = new File(
				"C:\\Users\\Luka\\Documents\\Programming\\Coding\\Eclipse\\OOP\\Lab4\\src\\hr\\fer\\oop\\week9\\db\\database.txt");

		BufferedReader reader = new BufferedReader(new FileReader(file));

		List<String> rows = new LinkedList<String>();
		String read = reader.readLine();
		while (read != null) {
			rows.add(read);
			read = reader.readLine();
		}
		StudentDatabase db = new StudentDatabase(rows);

		while (true) {

			BufferedReader input = new BufferedReader(new InputStreamReader(
					System.in));
			List<StudentRecord> studentList= new ArrayList<StudentRecord>();
			String line = input.readLine();
			if(input.equals("exit")){
				System.out.println("Thank you for using DB");
				break;
			}
			String[] tempArray = line.split("=");
			
			switch(tempArray[0]){
			case "jmbag":
				studentList.add(db.forJMBAG(tempArray[1].replace("\"", "")));
				fancyIspis(studentList);
				break;
			case "lastName":
				studentList=db.filter(new LastNameFilter(tempArray[1].replace("\"", "")));
				fancyIspis(studentList);
				break;
			default:
				System.out.println("No such command");
				
			}

		}

	}

	private static void fancyIspis(List<StudentRecord> studentList) {
		
		
	}

}
