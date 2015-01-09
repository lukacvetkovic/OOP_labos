package hr.fer.oop.lab4.topic1.zadatak2;

import java.io.IOException;

/**
 * Interface with methods that environment should have.
 * 
 * @author Luka Cvetkoviæ
 *
 */
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
