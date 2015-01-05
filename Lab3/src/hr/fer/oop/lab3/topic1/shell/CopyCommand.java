package hr.fer.oop.lab3.topic1.shell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyCommand extends AbstractCommand {

	/**
	 * Construct a new Copy Command
	 */
	public CopyCommand() {
		super("COPY", "Copy Command");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommandStatus execute(Environment e, String s) {
		String[] names = s.split(" ");
		if (!names[0].startsWith("/")) {
			names[0] = "/" + names[0];
		}
		if (!names[1].startsWith("/")) {
			names[1] = "/" + names[1];
		}
		File src = new File(e.getActiveTerminal().getCurrentPath() + names[0]);
		File dest = new File(e.getActiveTerminal().getCurrentPath() + names[1]);
		if (!src.isFile()) {
			try {
				e.writeln("Invalid source file!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return CommandStatus.CONTINUE;
		} else if (dest.isFile()) {
			;
		} else if (dest.isDirectory()) {
			dest = new File(e.getActiveTerminal().getCurrentPath() + names[1]
					+ "/" + src.getName());
		} else if (new File(dest.getParent()).isDirectory()) {
			;
		} else {
			try {
				e.writeln("Invalid destination path!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int noOfBytes = 0;
			while ((noOfBytes = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, noOfBytes);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		return CommandStatus.CONTINUE;
	}

}