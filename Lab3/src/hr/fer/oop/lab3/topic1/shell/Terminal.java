package hr.fer.oop.lab3.topic1.shell;

import java.nio.file.Path;

public class Terminal {
	private int id;
	private Path currentPath;

	public Terminal(int id) {
		super();
		this.id = id;
	}

	public Path getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(Path currentPath) {
		this.currentPath = currentPath;
	}

	public int getId() {
		return id;
	}

}
