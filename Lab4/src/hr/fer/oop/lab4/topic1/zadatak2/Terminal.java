package hr.fer.oop.lab4.topic1.zadatak2;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class that mimics terminal.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class Terminal {
	private int id;
	private Path currentPath;

	public Terminal(int id) {
		super();
		this.id = id;
		this.currentPath = Paths.get(".");
	}

	/**
	 * Getter for currentPath.
	 * 
	 * @return currentPath.
	 */
	public Path getCurrentPath() {
		return currentPath;
	}

	/**
	 * Setter for currentPath.
	 * 
	 * @param currentPath
	 *            is path to which we want to set current path to.
	 */
	public void setCurrentPath(Path currentPath) {
		this.currentPath = currentPath;
	}

	/**
	 * Getter for id.
	 * 
	 * @return id.
	 */
	public int getId() {
		return id;
	}

}
