package hr.fer.oop.week9.stat;

/**
 * Class has name of the extenstion, size and counter of the files with same
 * extension.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Extension {

	public int count;
	public long size;
	public String name;

	public Extension(String name, long size) {
		super();
		this.name = name;
		this.count = 1;
		this.size = size;

	}
}
