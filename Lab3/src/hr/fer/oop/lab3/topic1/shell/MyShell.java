package hr.fer.oop.lab3.topic1.shell;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

import hr.fer.oop.lab3.topic1.collections.SimpleHashtable;

public class MyShell {

	private static SimpleHashtable commands;
	static {
		commands = new SimpleHashtable();
		ShellCommand[] cc = { new HelpCommand(), new QuitCommand(),
				new CdCommand(), new TerminalCommand() };
		for (ShellCommand c : cc) {
			commands.put(c.getCommandName(), c);
		}
	}

	public static class EnvironmentImpl implements Environment {

		private SimpleHashtable terminals;
		private Terminal activeTerminal;
		private BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		private BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(System.out));

		public EnvironmentImpl() {
			this.activeTerminal = new Terminal(1);
			this.terminals = new SimpleHashtable();
			terminals.put(1, activeTerminal);
		}

		@Override
		public String readLine() throws IOException {
			return reader.readLine();
		}

		@Override
		public void write(String s) throws IOException {

			writer.write(s);
			writer.flush();
		}

		@Override
		public void writeln(String s) throws IOException {
			writer.write(s + "\n");
			writer.flush();

		}

		@Override
		public Terminal getActiveTerminal() {

			return activeTerminal;
		}

		@Override
		public void setActiveTerminal(Terminal t) {
			this.activeTerminal = t;

		}

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

		@Override
		public Iterable commands() {
			return commands;
		}

	}

	private static Environment environment = new EnvironmentImpl();

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
			String arg = null;
			for (int i = 1, n = tempArray.length; i < n; i++) {
				arg = tempArray[i] + " ";
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
