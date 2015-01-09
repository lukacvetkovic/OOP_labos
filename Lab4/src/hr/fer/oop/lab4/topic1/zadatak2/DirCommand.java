package hr.fer.oop.lab4.topic1.zadatak2;

import hr.fer.oop.lab4.topic1.zadatak2.Comparators.ChainedComparator;
import hr.fer.oop.lab4.topic1.zadatak2.Comparators.DateComparator;
import hr.fer.oop.lab4.topic1.zadatak2.Comparators.ExtensionComparator;
import hr.fer.oop.lab4.topic1.zadatak2.Comparators.NameComparator;
import hr.fer.oop.lab4.topic1.zadatak2.Comparators.SizeComparator;
import hr.fer.oop.lab4.topic1.zadatak2.Comparators.TypeComparator;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DirCommand extends AbstractCommand {

	public DirCommand() {
		super("DIR", "Prints the file names");
		// TODO Auto-generated constructor stub
	}

	@Override
	public CommandStatus execute(Environment e, String arg) {

		String argArray[] = arg.split("/");

		String sort = null;
		String filter = null;
		String type = null;
		Path pathReal = null;
		Path real_path = null;
		String[] inf = null;

		for (String argument : argArray) {

			String sub = argument.trim().substring(0, 4);

			switch (sub) {

			case "sort":
				inf = argument.trim().split("=");
				sort = inf[1];
				break;

			case "filt":
				inf = argument.trim().split("=");
				filter = inf[1];
				break;

			case "type":
				inf = argument.trim().split("=");
				type = inf[1];
				break;

			default:
				Path path = null;
				try {
					path = Paths.get(argument.trim());
				} catch (InvalidPathException p) {
					System.out.println("Command error");
					break;
				}

				try {
					real_path = e.getActiveTerminal().getCurrentPath()
							.resolve(path);

					Path novi = real_path.toRealPath();

				} catch (IOException e1) {
					System.out.println("Error, no such directory" + argument);
					return CommandStatus.CONTINUE;

				}

			}
		}

		if (real_path == null) {
			real_path = e.getActiveTerminal().getCurrentPath();
		}
		/**
		 * Reading file
		 */

		File currentDir = real_path.toFile();
		File[] currentDirFiles = currentDir.listFiles();

		List<Comparator> sortList = new ArrayList();

		if (sort != null) {
			String[] sortArray = sort.split("");

			for (String label : sortArray) {
				switch (label) {
				case "E":
					sortList.add(new ExtensionComparator(false));
					break;
				case "e":
					sortList.add(new ExtensionComparator(true));
					break;
				case "S":
					sortList.add(new SizeComparator(false));
					break;
				case "s":
					sortList.add(new SizeComparator(true));
					break;
				case "D":
					sortList.add(new DateComparator(false));
					break;
				case "d":
					sortList.add(new DateComparator(true));
					break;
				case "N":
					sortList.add(new NameComparator(false));
					break;
				case "n":
					sortList.add(new NameComparator(true));
					break;
				case "T":
					sortList.add(new TypeComparator(false));
					break;
				case "t":
					sortList.add(new TypeComparator(true));
					break;

				}
			}

		}

		PriorityQueue<File> priorityQueue = new PriorityQueue<File>(
				currentDirFiles.length, new ChainedComparator(sortList));

		List<File> ret = new ArrayList<File>();
		if (filter != null) {
			ret = validFiles(currentDir, filter);
		}
		else{
			ret = validFiles(currentDir, "");
		}

		for (File file : currentDirFiles) {

			if (type.equals("f")) {
				if (file.isFile() && ret.contains(file)) {
					System.out.println("Dodajem : " + file.getName());
					priorityQueue.add(file);

				} else {
					continue;
				}
			} else if (type.equals("d") && ret.contains(file)) {
				if (file.isDirectory()) {
					System.out.println("Dodajem : " + file.getName());
					priorityQueue.add(file);

				} else {
					continue;
				}
			} else {
				if (ret.contains(file.getName())) {
					System.out.println("Dodajem : " + file.getName());
					priorityQueue.add(file);
				}

			}

		}

		while (priorityQueue.size() != 0) {
			System.out.println(priorityQueue.remove());
		}

		return CommandStatus.CONTINUE;
	}

	private List<File> validFiles(File root, String s) {
		List<File> ret = new ArrayList<File>();
		if (root.listFiles() != null) {
			for (File ff : root.listFiles()) {

				String name = ff.getName();
				if (s.contains("*")) {
					if (s.startsWith("*")) {
						String ending = s.split("\\*")[1];
						if (ending.length() <= name.length()) {
							String last = name.substring(name.length()
									- ending.length());
							if (last.equalsIgnoreCase(ending)) {
								System.out.println("Dodajem : "
										+ ff.getName());
								ret.add(ff);
							}
						}
					} else if (s.endsWith("*")) {
						String beggining = s.split("\\*")[0];
						if (beggining.length() <= name.length()) {
							String first = name
									.substring(0, beggining.length());
							if (first.equalsIgnoreCase(beggining)) {
								System.out.println("Dodajem : "
										+ ff.getName());
								ret.add(ff);
							}
						}
					} else {
						String beggining = s.split("\\*")[0];
						String ending = s.split("\\*")[1];
						if (beggining.length() <= name.length()
								&& ending.length() <= name.length()) {
							String first = name
									.substring(0, beggining.length());
							String last = name.substring(name.length()
									- ending.length());
							if (first.equalsIgnoreCase(beggining)
									&& last.equalsIgnoreCase(ending)) {
								System.out.println("Dodajem : "
										+ ff.getName());
								ret.add(ff);
							}
						}
					}
				} else {
					if (name.equalsIgnoreCase(s)) {
						System.out.println("Dodajem : "
								+ ff.getName());
						ret.add(ff);
					}
				}

			}
		}

		return ret;
	}

}
