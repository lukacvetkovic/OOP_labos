package hr.fer.oop.topic10.db;

import hr.fer.oop.week9.db.StudentRecord;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CourseDatabase {

	private Map<String, CourseRecord> dataBase = new LinkedHashMap<>();

	public CourseDatabase(List<String> rows) {

		for (String row : rows) {
			String[] rowSplit = row.split("\t");
			addToDatabase(rowSplit);
		}

	}

	private void addToDatabase(String[] rowSplit) {
		dataBase.put(rowSplit[0], new CourseRecord(rowSplit[0], rowSplit[1]));

	}

	public CourseRecord findById(String courseId) {
		for (Map.Entry<String, CourseRecord> entry : dataBase.entrySet()) {
			String key = entry.getKey();
			if (key.equals(courseId)) {
				return dataBase.get(key);
			}
		}
		return null;
	}

	public CourseRecord findFirstByName(String s) {

		for (Map.Entry<String, CourseRecord> entry : dataBase.entrySet()) {

			String name = entry.getValue().getCourseName();
			if (s.contains("*")) {
				if (s.startsWith("*")) {
					String ending = s.split("\\*")[1];
					if (ending.length() <= name.length()) {
						String last = name.substring(name.length()
								- ending.length());
						if (last.equalsIgnoreCase(ending)) {
							return entry.getValue();
						}
					}
				} else if (s.endsWith("*")) {
					String beggining = s.split("\\*")[0];
					if (beggining.length() <= name.length()) {
						String first = name.substring(0, beggining.length());
						if (first.equalsIgnoreCase(beggining)) {
							return entry.getValue();
						}
					}
				} else {
					String beggining = s.split("\\*")[0];
					String ending = s.split("\\*")[1];
					if (beggining.length() <= name.length()
							&& ending.length() <= name.length()) {
						String first = name.substring(0, beggining.length());
						String last = name.substring(name.length()
								- ending.length());
						if (first.equalsIgnoreCase(beggining)
								&& last.equalsIgnoreCase(ending)) {
							return entry.getValue();
						}
					}
				}
			} else {
				if (name.equalsIgnoreCase(s)) {
					return entry.getValue();
				}
			}

		}
		return null;

	}

	public void fancyPrintDb(List<CourseRecord> courseList) {

		int idLenght = 0, nameLength = 0;

		if (courseList.size() != 0) {

			for (int i = 0; i < courseList.size(); i++) {
				if (courseList.get(i).getCourseId().length() > idLenght) {
					idLenght = courseList.get(i).getCourseId().length();
				}
				if (courseList.get(i).getCourseName().length() > nameLength) {
					nameLength = courseList.get(i).getCourseName().length();
				}
			}

			printBorder(idLenght, nameLength);

			for (CourseRecord record : courseList) {
				System.out.println("| "

						+ String.format("%-" + idLenght + "s",
								record.getCourseId())
						+ " | "
						+ String.format("%-" + nameLength + "s",
								record.getCourseName()) + " |");
			}
			printBorder(idLenght, nameLength);
		}

		System.out.println("Records selected: " + courseList.size());
	}

	public void fancyPrintAllDb() {

		List<CourseRecord> records = new ArrayList<CourseRecord>();
		for (Map.Entry<String, CourseRecord> entry : dataBase.entrySet()) {
			records.add(entry.getValue());
		}

		fancyPrintDb(records);
	}

	private void printBorder(int idLenght, int nameLength) {
		System.out.print("+");
		for (int i = 0; i < idLenght + 2; i++) {
			System.out.print("=");
		}
		System.out.print("+");
		for (int i = 0; i < nameLength + 2; i++) {
			System.out.print("=");
		}
		System.out.println("+");

	}

}
