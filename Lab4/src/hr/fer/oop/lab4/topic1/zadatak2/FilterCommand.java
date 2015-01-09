package hr.fer.oop.lab4.topic1.zadatak2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilterCommand extends AbstractCommand{

	public FilterCommand() {
		super("FILTER", "Searches the current dir for name or extension, can use * for universal word");
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandStatus execute(Environment e, String s) {
		List<String> ret = validFiles(new File(e.getActiveTerminal()
				.getCurrentPath().toString()), s);
		for (String name : ret) {
			try {
				e.writeln(name);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return CommandStatus.CONTINUE;
	}

	private List<String> validFiles(File root, String s) {
		List<String> ret = new ArrayList<String>();
		if (root.isDirectory()) {
			if (root.listFiles() != null) {
				for (File ff : root.listFiles()) {
					ret.addAll(validFiles(ff, s));
				}
			}
		} else {
			String name = root.getName();
			if (s.contains("*")) {
				if (s.startsWith("*")) {
					String ending = s.split("\\*")[1];
					if (ending.length() <= name.length()) {
						String last = name.substring(name.length()
								- ending.length());
						if (last.equalsIgnoreCase(ending)) {
							ret.add(root.getAbsolutePath());
						}
					}
				} else if (s.endsWith("*")) {
					String beggining = s.split("\\*")[0];
					if (beggining.length() <= name.length()) {
						String first = name.substring(0, beggining.length());
						if (first.equalsIgnoreCase(beggining)) {
							ret.add(root.getAbsolutePath());
						}
					}
				} else {
					String beggining = s.split("\\*")[0];
					String ending = s.split("\\*")[1];
					if (beggining.length() <= name.length()
							&& ending.length() <= name.length()) {
						String first = name.substring(0, beggining.length());
						String last = name.substring(name.length()
								- ending.length());
						if (first.equalsIgnoreCase(beggining)
								&& last.equalsIgnoreCase(ending)) {
							ret.add(root.getAbsolutePath());
						}
					}
				}
			} else {
				if (name.equalsIgnoreCase(s)){
					ret.add(root.getAbsolutePath());
				}
			}
		}

		return ret;
	}

}
