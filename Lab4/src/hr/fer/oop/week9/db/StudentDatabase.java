package hr.fer.oop.week9.db;

import hr.fer.oop.topic10.db.CourseRecord;
import hr.fer.oop.week9.stat.Extension;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class StudentDatabase {

	private Map<String, StudentRecord> dataBase = new LinkedHashMap<>();

	/**
	 * @return the dataBase
	 */
	public Map<String, StudentRecord> getDataBase() {
		return dataBase;
	}

	public StudentDatabase(List<String> rows) {

		for (String row : rows) {
			String[] rowSplit = row.split("\t");
			addToDatabase(rowSplit);
		}

	}

	private void addToDatabase(String[] rowSplit) {
		dataBase.put(rowSplit[0], new StudentRecord(rowSplit[0], rowSplit[1],
				rowSplit[2], rowSplit[3]));

	}

	public StudentRecord forJMBAG(String jmbag) {
		for (Map.Entry<String, StudentRecord> entry : dataBase.entrySet()) {
			String key = entry.getKey();
			if (key.equals(jmbag)) {
				return dataBase.get(key);
			}
		}
		return null;
	}

	public List<StudentRecord> filter(IFilter filter) {
		List<StudentRecord> studentList = new ArrayList<>();
		for (Map.Entry<String, StudentRecord> entry : dataBase.entrySet()) {
			String key = entry.getKey();
			if (filter.accepts(entry.getValue())) {
				studentList.add(entry.getValue());
			}
		}

		return studentList;
	}

	public void fancyPrintDb(List<StudentRecord> studentList) {


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

	public void fancyPrintAllDb() {

		List<StudentRecord> records = new ArrayList<StudentRecord>();
		for (Map.Entry<String, StudentRecord> entry : dataBase.entrySet()) {
			records.add(entry.getValue());
		}

		fancyPrintDb(records);
	}

}
