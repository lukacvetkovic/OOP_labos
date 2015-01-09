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
	
	public int hashCode(){
		return this.jmbag.hashCode();
	}
	
	
	public boolean equals()
	

}
