package hr.fer.oop.topic10.db;

/**
 * Container for enromlent.
 * 
 * @author Luka Cvetkoviæ.
 *
 */
public class EnrolmentRecord {

	private String courseId;
	private String studentJMBAG;
	private String grade;

	/**
	 * Constructor for EnromentRecord.
	 * 
	 * @param courseId
	 * @param studentJMBAG
	 * @param grade
	 */
	public EnrolmentRecord(String courseId, String studentJMBAG, String grade) {
		super();
		this.courseId = courseId;
		this.studentJMBAG = studentJMBAG;
		this.grade = grade;
	}

	/**
	 * Method that returns hashCode of enrmolment.
	 * 
	 * @return int HashCode of enrolment.
	 */
	public int hashCode() {
		return (this.courseId + this.studentJMBAG).hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof EnrolmentRecord) {
			EnrolmentRecord other = (EnrolmentRecord) obj;
			if (other.getCourseId().equals(this.courseId)
					&& other.getStudentJMBAG().equals(this.getStudentJMBAG())) {
				return true;
			}

		}
		return false;
	}

	/**
	 * Getter for courseId.
	 * 
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * Setter for courseId.
	 * 
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * Getter for JMBAG.
	 * 
	 * @return the studentJMBAG
	 */
	public String getStudentJMBAG() {
		return studentJMBAG;
	}

	/**
	 * Setter for JMBAG.
	 * 
	 * @param studentJMBAG
	 *            the studentJMBAG to set
	 */
	public void setStudentJMBAG(String studentJMBAG) {
		this.studentJMBAG = studentJMBAG;
	}

	/**
	 * Getter for grade.
	 * 
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Setter for grade.
	 * 
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
