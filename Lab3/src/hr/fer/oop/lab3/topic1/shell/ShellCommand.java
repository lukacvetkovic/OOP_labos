package hr.fer.oop.lab3.topic1.shell;

/**
 * Interface for every command.
 * 
 * @author Luka Cvetkoviæ.
 *
 */
public interface ShellCommand {
	public String getCommandName();

	public String getCommandDescription();

	public CommandStatus execute(Environment e, String arg);

}
