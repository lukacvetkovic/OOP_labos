package hr.fer.oop.week9.db;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LastNameFilter implements IFilter {

	private String filter;

	public LastNameFilter(String filter) {
		this.filter = filter;
	}

	@Override
	public boolean accepts(StudentRecord record) {

		String name = record.getLastName();
		if (filter.contains("*")) {
			if (filter.startsWith("*")) {
				String ending = filter.split("\\*")[1];
				if (ending.length() <= name.length()) {
					String last = name.substring(name.length()
							- ending.length());
					if (last.equalsIgnoreCase(ending)) {
						return true;
					}
				}
			} else if (filter.endsWith("*")) {
				String beggining = filter.split("\\*")[0];
				if (beggining.length() <= name.length()) {
					String first = name.substring(0, beggining.length());
					if (first.equalsIgnoreCase(beggining)) {
						return true;
					}
				}
			} else {
				String beggining = filter.split("\\*")[0];
				String ending = filter.split("\\*")[1];
				if (beggining.length() <= name.length()
						&& ending.length() <= name.length()) {
					String first = name.substring(0, beggining.length());
					String last = name.substring(name.length()
							- ending.length());
					if (first.equalsIgnoreCase(beggining)
							&& last.equalsIgnoreCase(ending)) {
						return true;
					}
				}
			}
		} else {
			if (name.equalsIgnoreCase(filter)) {

				return true;
			}
		}

		return false;
	}

}
