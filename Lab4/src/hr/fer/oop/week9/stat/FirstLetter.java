package hr.fer.oop.week9.stat;

/**
 * Class which contains first letter, size and count of files.
 * 
 * @author Cveki
 *
 */
public class FirstLetter {

	public int count;
	public long size;
	public String letter;

	public FirstLetter(String letter, long size) {
		super();
		this.letter = letter;
		this.count = 1;
		this.size = size;
	}

}
