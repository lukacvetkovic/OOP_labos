package hr.fer.oop.lab3.topic1.shell;

public interface ShellCommand {
	public String getCommandName();
	public String getCommandDescription();
	public CommandStatus execute(Environment e,String s);

}
