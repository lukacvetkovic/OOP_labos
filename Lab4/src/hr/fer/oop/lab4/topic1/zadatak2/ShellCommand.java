package hr.fer.oop.lab4.topic1.zadatak2;

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
