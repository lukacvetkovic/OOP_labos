package hr.fer.oop.topic10.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import hr.fer.oop.week9.db.StudentDatabase;

/**
 * Class that makes instance of other databases.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Database {

	private CourseDatabase courseDatabase;
	private EnrolmentDatabase enrolmentDatabase;
	private StudentDatabase studentDatabase;
	/**
	 * Constructor for databases.
	 * @param courseTxt txt file for courses.
	 * @param enrolmentTxt txt file for enrolment.
	 * @param studentTxt txt file for students.
	 * @throws IOException when file not found
	 */
	public Database(String courseTxt, String enrolmentTxt, String studentTxt)
			throws IOException {

		List<String> rows = readInData(courseTxt);

		courseDatabase = new CourseDatabase(rows);

		rows = readInData(enrolmentTxt);

		enrolmentDatabase = new EnrolmentDatabase(rows);

		rows = readInData(studentTxt);

		studentDatabase = new StudentDatabase(rows);

	}
	/**
	 * Private class for reading dara
	 * @param input
	 * @return row
	 * @throws IOException
	 */
	private List<String> readInData(String input) throws IOException {
		List<String> rows = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(input));
		String read = reader.readLine();
		while (read != null) {
			rows.add(read);
			read = reader.readLine();
		}

		return rows;

	}

	/**
	 * Getter for courseDatabase.
	 * @return the courseDatabase
	 */
	public CourseDatabase getCourseDatabase() {
		return courseDatabase;
	}

	/**
	 * Getter for enrolmentDatabase.
	 * @return the enrolmentDatabase
	 */
	public EnrolmentDatabase getEnrolmentDatabase() {
		return enrolmentDatabase;
	}

	/**
	 * Getter for studentDatabase
	 * @return the studentDatabase
	 */
	public StudentDatabase getStudentDatabase() {
		return studentDatabase;
	}

}
