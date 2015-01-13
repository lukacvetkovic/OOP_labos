package hr.fer.oop.topic10.db;

/**
 * Container for Courses.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class CourseRecord {
	private String courseId;
	private String courseName;

	/**
	 * Constructor for CourseRecord
	 * 
	 * @param courseId
	 * @param courseName
	 */
	public CourseRecord(String courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}

	/**
	 * Method that returns hashCode of courseId.
	 * 
	 * @return int HashCode of courseId.
	 */
	public int hashCode() {
		return this.courseId.hashCode();
	}

	/**
	 * Method returns boolean value if two CourseRecords are equal.
	 * 
	 * @return true if are equal, false if are not.
	 */
	public boolean equals(Object obj) {
		if (obj instanceof CourseRecord) {
			boolean bool = ((CourseRecord) obj).getCourseId().equals(
					this.courseId);
			return bool;

		}
		return false;
	}

	/**
	 * Getter for courseId.
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * Setter for courseId.
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * Getter for courseName
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Setter for courseName.
	 * @param courseName
	 *            the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
