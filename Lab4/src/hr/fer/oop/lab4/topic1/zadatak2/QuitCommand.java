package hr.fer.oop.lab4.topic1.zadatak2;
/**
 * Command that quits the shell.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class QuitCommand extends AbstractCommand {
	/**
	 * Constructor for command.
	 */
	public QuitCommand() {
		super("QUIT", "Shuts down the current shell");

	}
	/**
	 * Method that executes quitting the shell.
	 * 
	 * @param e
	 *            is environment of the command.
	 * @param s
	 *            is destination folder.
	 * @return CommandStatus enum which tells us if we should continue or exit.
	 */
	@Override
	public CommandStatus execute(Environment e, String s) {

		return CommandStatus.EXIT;

	}

}
