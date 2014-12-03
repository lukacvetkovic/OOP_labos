package hr.fer.oop.lab3.topic1.shell;

public class HelpCommand extends AbstractCommand{

	public HelpCommand() {
		super("HELP", "Prints names and description of all commands");
		
	}

	@Override
	public CommandStatus execute(Environment e, String s) {
		AbstractCommand[] listOfCommands= new AbstractCommand[4];
		listOfCommands[0]= new HelpCommand();
		listOfCommands[1]= new CdCommand();
		listOfCommands[2]= new QuitCommand();
		listOfCommands[3]= new TerminalCommand();
		
		for(AbstractCommand ab : listOfCommands){
			System.out.println(ab.getCommandName()+"\t"+ab.getCommandDescription());
		}
		return CommandStatus.CONTINUE;
	}

}
