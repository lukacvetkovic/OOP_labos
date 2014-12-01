package hr.fer.oop.lab3.topic1.shell;

public abstract class AbstractCommand implements ShellCommand {

	private String commandName;
	private String commandDescription;

	public AbstractCommand(String commandName, String commandDescription) {
		super();
		this.commandName = commandName;
		this.commandDescription = commandDescription;
	}

	@Override
	public String getCommandName() {
		return this.commandName;
	}

	@Override
	public String getCommandDescription() {
		return this.commandDescription;
	}

}
