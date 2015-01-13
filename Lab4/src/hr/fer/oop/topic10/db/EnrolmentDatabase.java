package hr.fer.oop.topic10.db;

import hr.fer.oop.week9.db.StudentRecord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class which have info about enrolment for students and clases.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class EnrolmentDatabase {
	private Map<String, EnrolmentRecord> dataBase = new LinkedHashMap<>();

	public EnrolmentDatabase(List<String> rows) {

		for (String row : rows) {
			String[] rowSplit = row.split("\t");
			addToDatabase(rowSplit);
		}

	}

	/**
	 * Getter for dataBase.
	 * 
	 * @return the dataBase
	 */
	public Map<String, EnrolmentRecord> getDataBase() {
		return dataBase;
	}

	/**
	 * Method that add enrolmentRecords to dataBase.
	 * 
	 * @param rowSplit
	 */
	private void addToDatabase(String[] rowSplit) {
		dataBase.put(rowSplit[0] + rowSplit[1], new EnrolmentRecord(
				rowSplit[0], rowSplit[1], rowSplit[2]));

	}
	/**
	 * Return list of EnrolmentRecords where studentJmbag is equal to parameter
	 * @param studentJMBAG
	 * @return list of EnrolmentRecords.
	 */
	public Collection<EnrolmentRecord> findByStudent(String studentJMBAG) {
		List<EnrolmentRecord> studentEnrolmentList = new ArrayList<EnrolmentRecord>();
		for (Map.Entry<String, EnrolmentRecord> entry : dataBase.entrySet()) {
			if (entry.getValue().getStudentJMBAG().equals(studentJMBAG)) {
				studentEnrolmentList.add(entry.getValue());
			}
		}
		return studentEnrolmentList;

	}
	/**
	 * Return list of EnrolmentRecords where courseId is equal to parameter
	 * @param studentJMBAG
	 * @return list of EnrolmentRecords.
	 */
	public Collection<EnrolmentRecord> findByCourse(String courseID) {

		List<EnrolmentRecord> courseList = new ArrayList<EnrolmentRecord>();
		for (Map.Entry<String, EnrolmentRecord> entry : dataBase.entrySet()) {
			if (entry.getValue().getStudentJMBAG().equals(courseID)) {
				courseList.add(entry.getValue());
			}
		}
		return courseList;

	}
	/**
	 * Return list of EnrolmentRecords where studentJmbag  and courseId is equal to parameter
	 * @param studentJMBAG
	 * @return list of EnrolmentRecords.
	 */
	public EnrolmentRecord findByStudentAndCourse(String studentJMBAG,
			String courseID) {

		for (Map.Entry<String, EnrolmentRecord> entry : dataBase.entrySet()) {
			if (entry.getValue().getStudentJMBAG().equals(courseID)
					&& entry.getValue().getCourseId().equals(courseID)) {
				return entry.getValue();
			}
		}
		return null;

	}

	/**
	 * Adds new course from studentJMBAG and courseID.
	 * @param studentJMBAG
	 * @param courseID
	 * @return
	 */
	public EnrolmentRecord newCourse(String studentJMBAG, String courseID) {

		EnrolmentRecord record = new EnrolmentRecord(courseID, studentJMBAG,
				"0");

		dataBase.put(courseID + studentJMBAG, record);

		return record;

	}
	/**
	 * Updater for EnrolmentRecord.
	 * @param record new EnrolmentRecord.
	 */
	public void updateEnrolment(EnrolmentRecord record) {

		dataBase.get(record.getCourseId() + record.getStudentJMBAG()).setGrade(
				record.getGrade());

	}
	/**
	 * Method that delite record by JMBAG and courseID.
	 * @param studentJMBAG
	 * @param courseID
	 */
	public void deleteRecord(String studentJMBAG, String courseID) {

		dataBase.remove(courseID + studentJMBAG);
	}

	public void fancyPrintDb(List<EnrolmentRecord> enrolmentList) {

		int idlength = 0;

		if (enrolmentList.size() != 0) {

			for (int i = 0; i < enrolmentList.size(); i++) {
				if (enrolmentList.get(i).getCourseId().length() > idlength) {
					idlength = enrolmentList.get(i).getCourseId().length();
				}
			}

			System.out.print("+");
			for (int i = 0; i < idlength + 2; i++) {
				System.out.print("=");
			}
			System.out.print("+");
			for (int i = 0; i < 10 + 2; i++) {
				System.out.print("=");
			}
			System.out.println("+===+");

			for (EnrolmentRecord record : enrolmentList) {
				System.out.println("| "
						+ String.format("%-" + idlength + "s",
								record.getCourseId())
						+ " | "
						+ String.format("%-" + 10 + "s",
								record.getStudentJMBAG()) + " | "
						+ record.getGrade() + " |");
			}
			System.out.print("+");
			for (int i = 0; i < idlength + 2; i++) {
				System.out.print("=");
			}
			System.out.print("+");
			for (int i = 0; i < 10 + 2; i++) {
				System.out.print("=");
			}
			System.out.println("+===+");
		}

		System.out.println("Records selected: " + enrolmentList.size());
	}
	/**
	 * Method that prints whole database.
	 */
	public void fancyPrintAllDb() {

		List<EnrolmentRecord> records = new ArrayList<EnrolmentRecord>();
		for (Map.Entry<String, EnrolmentRecord> entry : dataBase.entrySet()) {
			records.add(entry.getValue());
		}

		fancyPrintDb(records);
	}

}
