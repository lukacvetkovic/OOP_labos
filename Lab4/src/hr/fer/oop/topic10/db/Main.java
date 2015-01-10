package hr.fer.oop.topic10.db;

import hr.fer.oop.week9.db.StudentRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

		Database database = new Database("predmeti.txt", "upisaniPredmeti.txt",
				"database.txt");

		database.getCourseDatabase().fancyPrintAllDb();
		database.getEnrolmentDatabase().fancyPrintAllDb();
		database.getStudentDatabase().fancyPrintAllDb();

		StudentRecord[] list = { database.getStudentDatabase().forJMBAG(
				"0000000050") };

		database.getStudentDatabase().fancyPrintDb((Arrays.asList(list)));

		database.getEnrolmentDatabase().newCourse("0000000057", "3");

		database.getEnrolmentDatabase().fancyPrintDb(
				(List<EnrolmentRecord>) database.getEnrolmentDatabase()
						.findByStudent("0000000057"));

		database.getEnrolmentDatabase().updateEnrolment(
				new EnrolmentRecord("3", "0000000057", "3"));

		database.getEnrolmentDatabase().fancyPrintDb(
				(List<EnrolmentRecord>) database.getEnrolmentDatabase()
						.findByStudent("0000000057"));

		database.getEnrolmentDatabase().deleteRecord("0000000057", "3");

		database.getEnrolmentDatabase().fancyPrintDb(
				(List<EnrolmentRecord>) database.getEnrolmentDatabase()
						.findByStudent("0000000057"));

	}
}
