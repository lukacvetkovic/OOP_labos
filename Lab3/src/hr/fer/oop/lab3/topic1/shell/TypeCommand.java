package hr.fer.oop.lab3.topic1.shell;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javafx.scene.image.Image;

public class TypeCommand extends AbstractCommand {

	public TypeCommand() {
		super("TYPE", "Print the contents of files to screen ");

	}

	@Override
	public CommandStatus execute(Environment e, String arg) {
		String filename = arg.split(" ")[0];
		BufferedReader reader;
		String line;
		try {
			reader = new BufferedReader(new FileReader(e.getActiveTerminal().getCurrentPath().resolve(filename).toString()));
		} catch (FileNotFoundException e1) {
			System.out.println("Error, non existing file");
			return CommandStatus.CONTINUE;
		}

		while (true) {
			try {
				line=reader.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				return CommandStatus.CONTINUE;
			}
			
			if(line!=null){
				System.out.println(line);
			}
			else{
				return CommandStatus.CONTINUE;
			}
			
			
			
			
		}
	}

}
