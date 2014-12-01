package hr.fer.oop.lab3.topic1.shell;

public interface Environment {
	public String readLine();
	public void write();
	public void writeln();
	public Terminal getActiveTerminal();
	public void setActiveTerminal(Terminal t);
	public Terminal getOrCreateTerminal(int i);
	public Terminal[] listTerminals();
	public Iterable commands();

}
