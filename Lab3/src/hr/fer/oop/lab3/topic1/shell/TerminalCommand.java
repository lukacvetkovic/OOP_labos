package hr.fer.oop.lab3.topic1.shell;

public class TerminalCommand extends AbstractCommand {

	public TerminalCommand() {
		super("TERMINAL",
				"Switches to other terminal, if there is no other terminal makes new one");
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandStatus execute(Environment e, String arg) {
		int num = Integer.valueOf(arg.split(" ")[0]);
		Terminal newTerminal = e.getOrCreateTerminal(num);
		e.setActiveTerminal(newTerminal);
		System.out.println("Changed current terminal to "+ num);
		return CommandStatus.CONTINUE;
	}

}
