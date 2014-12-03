package hr.fer.oop.lab3.topic1.shell;

import hr.fer.oop.lab3.topic1.collections.SimpleHashtable.TableEntry;

public class HelpCommand extends AbstractCommand{

	public HelpCommand() {
		super("HELP", "Prints names and description of all commands");
		
	}

	@Override
	public CommandStatus execute(Environment e, String s) {
		
		for(Object command:e.commands()){
			TableEntry entery= (TableEntry)command;
			ShellCommand com= (ShellCommand)entery.getValue();
			System.out.println(com.getCommandName()+"\t"+com.getCommandDescription());
		}
		return CommandStatus.CONTINUE;
	}

}
