package hr.fer.oop.lab4.topic1.zadatak2.Comparators;

import java.io.File;
import java.util.Comparator;

public class DateComparator implements Comparator<File>{

	private boolean ascDesc;
	
	public DateComparator(boolean ascDesc) {
		super();
		this.ascDesc = ascDesc;
	}
	
	@Override
	public int compare(File o1, File o2) {
		
		int comparison;
		
		if(ascDesc){
			
			comparison=(int) (o1.lastModified()-o2.lastModified());
			if (comparison != 0) return comparison;					
		}
		else{
			comparison=(int) (o2.lastModified()-o1.lastModified());
			if (comparison != 0) return comparison;		
		}		
		
		return 0;
	}

}
