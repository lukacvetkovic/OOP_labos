package hr.fer.oop.lab4.topic1.zadatak2.Comparators;

import java.io.File;
import java.util.Comparator;

public class NameComparator implements Comparator<File>{

	private boolean ascDesc;

	public NameComparator(boolean ascDesc) {
		super();
		this.ascDesc = ascDesc;
	}

	@Override
	public int compare(File o1, File o2) {
			int comparison;
		
		
	
		//TRUE je rastuca
		if(ascDesc){
			comparison=o1.getName().compareTo(o2.getName());
			if (comparison != 0) return comparison;			
			
		}
		else{
			comparison=o2.getName().compareTo(o1.getName());
			if (comparison != 0) return comparison;	
		}
		
		return 0;		
		
	}
}
