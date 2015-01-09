package hr.fer.oop.lab4.topic1.zadatak2.Comparators;

import java.io.File;
import java.util.Comparator;

public class SizeComparator implements Comparator<File>{
	
	private boolean ascDesc;
	
	

	public SizeComparator(boolean ascDesc) {
		super();
		this.ascDesc = ascDesc;
	}



	@Override
	public int compare(File o1, File o2) {
		long size1=o1.length();
		
		long size2=o2.length();
		
		int comparison;
		
		if(ascDesc){
			comparison=(int) (size1-size2);
			if (comparison != 0) return comparison;		
						
		}
		else{
			comparison=(int) (size2-size1);
			if (comparison != 0) return comparison;	
		}
		
		return 0;
	}

}
