package hr.fer.oop.lab4.topic1.zadatak2;

import hr.fer.oop.lab4.topic1.zadatak1.SimpleHashtable.TableEntry;





/**
 * Command that lists all the commands that are implemented.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class HelpCommand extends AbstractCommand {
	/**
	 * Constructor for HelpCommand.
	 */
	public HelpCommand() {
		super("HELP", "Prints names and description of all commands");

	}

	/**
	 * Method that prints all the commands with their description.
	 * 
	 * @param e
	 *            is environment of the command.
	 * @param s
	 *            is destination folder.
	 * @return CommandStatus enum which tells us if we should continue or exit.
	 */
	@Override
	public CommandStatus execute(Environment e, String s) {

		for (Object command : e.commands()) {
			TableEntry entery = (TableEntry) command;
			ShellCommand com = (ShellCommand) entery.getValue();
			System.out.println(com.getCommandName() + "\t"
					+ com.getCommandDescription());
		}
		return CommandStatus.CONTINUE;
	}

}
