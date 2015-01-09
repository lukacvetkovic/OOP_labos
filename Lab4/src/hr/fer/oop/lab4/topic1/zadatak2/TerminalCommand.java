package hr.fer.oop.lab4.topic1.zadatak2;

/**
 * Command that switches to other terminal.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class TerminalCommand extends AbstractCommand {
	/**
	 * Constructor for TerminalCommand.
	 */
	public TerminalCommand() {
		super("TERMINAL",
				"Switches to other terminal, if there is no other terminal makes new one");
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method that executes changing the terminal.
	 * 
	 * @param e
	 *            is environment of the command.
	 * @param s
	 *            is destination folder.
	 * @return CommandStatus enum which tells us if we should continue or exit.
	 */
	@Override
	public CommandStatus execute(Environment e, String arg) {
		int num = Integer.valueOf(arg.split(" ")[0]);
		Terminal newTerminal = e.getOrCreateTerminal(num);
		e.setActiveTerminal(newTerminal);
		System.out.println("Changed current terminal to " + num);
		return CommandStatus.CONTINUE;
	}

}
