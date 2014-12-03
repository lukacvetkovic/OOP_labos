package hr.fer.oop.lab3.topic1.shell;

import java.io.IOException;

public interface Environment {
	public String readLine() throws IOException;
	public void write(String s) throws IOException;
	public void writeln(String s) throws IOException;
	public Terminal getActiveTerminal();
	public void setActiveTerminal(Terminal t);
	public Terminal getOrCreateTerminal(int i);
	public Terminal[] listTerminals();
	public Iterable commands();

}
