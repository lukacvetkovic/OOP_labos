package hr.fer.oop.topic10.db;


public class EnrolmentRecord {

	private String courseId;
	private String studentJMBAG;
	private String grade;

	/**
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
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the studentJMBAG
	 */
	public String getStudentJMBAG() {
		return studentJMBAG;
	}

	/**
	 * @param studentJMBAG
	 *            the studentJMBAG to set
	 */
	public void setStudentJMBAG(String studentJMBAG) {
		this.studentJMBAG = studentJMBAG;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
