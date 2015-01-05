package hr.fer.oop.lab3.topic1.shell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XcopyCommand extends AbstractCommand {

	/**
	 * Construct a new Xcopy Command.
	 */
	public XcopyCommand() {
		super("XCOPY", "Xcopy Command");
		// TODO Auto-generated constructor stub
	}

	/**
	 * Performs copying of whole file tree.
	 * 
	 * @param src
	 *            root of tree to copy.
	 * @param dest
	 *            where to copy.
	 */
	private void copy(File src, File dest) {
		if (src.isDirectory()) {
			File[] ff = src.listFiles();
			if (ff != null)
				for (File f : ff) {
					File dst = new File(dest.getAbsolutePath() + "/"
							+ f.getName());
					if (f.isDirectory()) {
						dst.mkdir();
					} else {
						try {
							dst.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					copy(f, dst);
				}
		} else {
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
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CommandStatus execute(Environment e, String s) {

		String srcName = s.split(" ")[0];
		String destName = s.split(" ")[1];
		if (!srcName.startsWith("/"))
			srcName = "/" + srcName;
		if (!destName.startsWith("/"))
			destName = "/" + destName;
		File src = new File(e.getActiveTerminal().getCurrentPath() + srcName);
		File dest = new File(e.getActiveTerminal().getCurrentPath() + destName);

		if (!src.isDirectory()) {
			try {
				e.writeln("Invalid source!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (dest.isDirectory()) {
			File nw = new File(dest.getAbsolutePath() + srcName);
			nw.mkdir();
			copy(src, nw);
		} else if (new File(dest.getParent()).isDirectory()) {
			dest.mkdir();
			copy(src, dest);
		} else {
			try {
				e.write("Invalid destination!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return CommandStatus.CONTINUE;
	}

}
