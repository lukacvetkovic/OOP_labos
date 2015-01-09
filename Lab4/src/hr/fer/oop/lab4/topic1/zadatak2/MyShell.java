package hr.fer.oop.lab4.topic1.zadatak2;

import hr.fer.oop.lab4.topic1.zadatak1.SimpleHashtable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;



/**
 * Class that makes shell.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class MyShell {

	private static SimpleHashtable commands;
	static {
		commands = new SimpleHashtable();
		ShellCommand[] cc = { new HelpCommand(), new QuitCommand(),
				new CdCommand(), new TerminalCommand(), new TypeCommand(),
				new FilterCommand(), new CopyCommand(), new XcopyCommand(),new DirCommand() };
		for (ShellCommand c : cc) {
			commands.put(c.getCommandName(), c);
		}
	}

	/**
	 * Class that implements current environment.
	 * 
	 * @author Cveki
	 *
	 */
	public static class EnvironmentImpl implements Environment {

		private SimpleHashtable terminals;
		private Terminal activeTerminal;
		private BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		private BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(System.out));

		/**
		 * Constructor for EnvironmentImpl.
		 */
		public EnvironmentImpl() {
			this.activeTerminal = new Terminal(1);
			this.terminals = new SimpleHashtable();
			terminals.put(1, activeTerminal);
		}

		/**
		 * Reads line from shell.
		 */
		@Override
		public String readLine() throws IOException {
			return reader.readLine();
		}

		/**
		 * Writes to shell.
		 */
		@Override
		public void write(String s) throws IOException {

			writer.write(s);
			writer.flush();
		}

		/**
		 * Writes line to shell.
		 */
		@Override
		public void writeln(String s) throws IOException {
			writer.write(s + "\n");
			writer.flush();

		}

		/**
		 * Getter for activeTerminal.
		 * 
		 * @return activeTerminal which is terminal that is currently set.
		 */
		@Override
		public Terminal getActiveTerminal() {

			return activeTerminal;
		}

		/**
		 * Setter for activeTerminal
		 * 
		 * @param Terminal
		 *            t is terminal to which we want to set terminal to.
		 */
		@Override
		public void setActiveTerminal(Terminal t) {
			this.activeTerminal = t;

		}

		/**
		 * Get terminal from parameter i, if there is no terminal i than makes
		 * new terminal with parameter i.
		 * 
		 * @param int i is number of the terminal.
		 */
		@Override
		public Terminal getOrCreateTerminal(int i) {
			if (terminals.containsKey(i)) {
				this.activeTerminal = (Terminal) terminals.get(i);
				return this.activeTerminal;
			} else {
				Terminal newOne = new Terminal(i);
				terminals.put(i, newOne);
				this.activeTerminal = newOne;
				return this.activeTerminal;
			}

		}

		/**
		 * Returns list of all active terminals.
		 * 
		 * @return Terminal[] list of all active terminals.
		 */
		@Override
		public Terminal[] listTerminals() {
			Terminal[] list = new Terminal[terminals.size];
			for (Object terminal : terminals) {
				int i = 0;
				list[i] = (Terminal) terminal;
				i++;

			}

			return list;
		}

		/**
		 * Iterator for commands.
		 */
		@Override
		public Iterable commands() {
			return commands;
		}

	}

	/**
	 * Static class that runs the shell. Class where pogram starts.
	 */
	private static Environment environment = new EnvironmentImpl();

	/**
	 * Method that starts running shell.
	 * 
	 * @param args
	 *            is no used.
	 * @throws IOException
	 *             in input of parameters.
	 */
	public static void main(String[] args) throws IOException {
		environment.writeln("Welcome to MyShell! You may enter commands.");

		while (true) {

			environment.write(environment.getActiveTerminal().getId()
					+ "$"
					+ environment.getActiveTerminal().getCurrentPath()
							.toAbsolutePath().normalize().toString() + "> ");
			String line = environment.readLine();
			String[] tempArray = line.split(" ");
			String cmd = tempArray[0].toUpperCase();
			String arg = "";
			for (int i = 1, n = tempArray.length; i < n; i++) {
				arg += tempArray[i] + " ";
			}
			ShellCommand shellCommand = null;
			if (commands.containsKey(cmd)) {
				shellCommand = (ShellCommand) commands.get(cmd);
			}

			if (shellCommand == null) {
				environment.writeln("Unknown command!");
				continue;
			}

			if (shellCommand.execute(environment, arg) == CommandStatus.EXIT) {

				break;
			}

		}
		environment.writeln("Thank you for using this shell. Goodbye!");

	}
}
