package hr.fer.oop.lab3.topic1.shell;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.sun.org.apache.regexp.internal.recompile;

public class CdCommand extends AbstractCommand {

	public CdCommand() {
		super("CD", "Changes directory");
	}

	@Override
	public CommandStatus execute(Environment e, String s) {
		String pathString = s.split(" ")[0];
		if (pathString.equals("..")) {
			Path path = e.getActiveTerminal().getCurrentPath();
			path = path.toAbsolutePath().normalize().getParent();
			if (path.toAbsolutePath().normalize().getParent() == null) {
				System.out.println("Error");
				return CommandStatus.CONTINUE;
			} else {
				e.getActiveTerminal().setCurrentPath(path);
				System.out.println("Current directory id now set to: "
						+ path.toAbsolutePath().normalize().toString());
			}
		} else {
			Path path= Paths.get(pathString);
			e.getActiveTerminal().setCurrentPath(path);
			System.out.println("Current directory id now set to: "
					+ path.toAbsolutePath().normalize().toString());

		}

		return CommandStatus.CONTINUE;
	}

}
