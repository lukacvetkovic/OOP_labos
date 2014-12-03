package hr.fer.oop.lab3.topic1.shell;

public class QuitCommand extends AbstractCommand {

	public QuitCommand() {
		super("QUIT", "Shuts down the current shell");

	}

	@Override
	public CommandStatus execute(Environment e, String s) {

		return CommandStatus.EXIT;

	}

}
