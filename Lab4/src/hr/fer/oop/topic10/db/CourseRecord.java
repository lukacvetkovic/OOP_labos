package hr.fer.oop.topic10.db;



public class CourseRecord {
	private String courseId;
	private String courseName;
	/**
	 * @param courseId
	 * @param courseName
	 */
	public CourseRecord(String courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}
	
	
	public int hashCode() {
		return this.courseId.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof CourseRecord) {
			boolean bool = ((CourseRecord) obj).getCourseId().equals(this.courseId);
			return bool;

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
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	

}
