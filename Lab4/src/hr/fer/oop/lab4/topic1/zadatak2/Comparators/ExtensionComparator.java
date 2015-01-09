package hr.fer.oop.lab4.topic1.zadatak2.Comparators;

import java.io.File;
import java.util.Comparator;

public class ExtensionComparator implements Comparator<File>{
	
	private boolean ascDesc;

	public ExtensionComparator(boolean ascDesc) {
		super();
		this.ascDesc = ascDesc;
	}

	@Override
	public int compare(File o1, File o2) {
		String extension1="";
		String extension2="";
		int comparison;
		
		
		int i = o1.getName().lastIndexOf('.');
		if (i > 0) {
		    extension1 = o1.getName().substring(i+1).toLowerCase();
		}
		
		i = o2.getName().lastIndexOf('.');
		if (i > 0) {
		    extension2 = o2.getName().substring(i+1).toLowerCase();
		}
		
		
		//TRUE je rastuca
		if(ascDesc){
			comparison=extension1.compareTo(extension2);
			if (comparison != 0) return comparison;			
			
		}
		else{
			comparison=extension2.compareTo(extension1);
			if (comparison != 0) return comparison;	
		}
		
		return 0;		
		
	}

}
