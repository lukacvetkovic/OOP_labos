package hr.fer.oop.lab4.topic1.zadatak2;

/**
 * Abstract class that has methods and atributes that every command need to
 * have.
 * 
 * @author Luka Cvtkoviæ
 *
 */
public abstract class AbstractCommand implements ShellCommand {

	private String commandName;
	private String commandDescription;

	/**
	 * Constructor for Command.
	 * 
	 * @param commandName
	 *            is name of the command.
	 * @param commandDescription
	 *            is description of the command.
	 */
	public AbstractCommand(String commandName, String commandDescription) {
		super();
		this.commandName = commandName;
		this.commandDescription = commandDescription;
	}

	/**
	 * Getter for commandName.
	 */
	@Override
	public String getCommandName() {
		return this.commandName;
	}

	/**
	 * Getter for commandDescription.
	 */
	@Override
	public String getCommandDescription() {
		return this.commandDescription;
	}

}
