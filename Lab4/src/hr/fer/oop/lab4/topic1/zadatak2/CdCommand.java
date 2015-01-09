package hr.fer.oop.lab4.topic1.zadatak2;


import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * Command that changes the current directory.
 * 
 * @author Luka Cvetkoviæ
 *
 */
public class CdCommand extends AbstractCommand {
	/**
	 * Constructor for CdCommand.
	 */
	public CdCommand() {
		super("CD", "Changes directory");
	}

	/**
	 * Method that executes changing directory.
	 * 
	 * @param e
	 *            is environment of the command.
	 * @param s
	 *            is destination folder.
	 * @return CommandStatus enum which tells us if we should continue or exit.
	 */
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
			Path path = Paths.get(pathString);
			System.out.println(path);
			Path real_path=null;
			try {
				  real_path = e.getActiveTerminal().getCurrentPath().resolve(path);
			      
			      
			      
			      Path novi=real_path.toRealPath();
			      
			      
			      
			      
			    } catch (IOException e1) {
			    	System.out.println("Error, no such directory");
			    	
					return CommandStatus.CONTINUE;
			    }
			
			e.getActiveTerminal().setCurrentPath(real_path);
			System.out.println("Current directory id now set to: "
					+ real_path.toAbsolutePath().normalize().toString());

		}

		return CommandStatus.CONTINUE;
	}

}
