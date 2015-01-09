package hr.fer.oop.week9.db;

public class StudentRecord {

	private String jmbag;
	private String lastName;
	private String firstName;
	private String finalGrade;

	public StudentRecord(String jmbag, String lastName, String firstName,
			String finalGrade) {
		super();
		this.jmbag = jmbag;
		this.lastName = lastName;
		this.firstName = firstName;
		this.finalGrade = finalGrade;
	}

	public int hashCode() {
		return this.jmbag.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof StudentRecord) {
			boolean bool = ((StudentRecord) obj).getJmbag().equals(this.jmbag);
			return bool;

		}
		return false;
	}

	public String getJmbag() {
		return jmbag;
	}

	public void setJmbag(String jmbag) {
		this.jmbag = jmbag;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}

}
