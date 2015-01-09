package hr.fer.oop.lab4.topic1.zadatak2.Comparators;

import java.io.File;
import java.util.Comparator;

public class TypeComparator implements Comparator<File>{
	

	private boolean ascDesc;

	public TypeComparator(boolean ascDesc) {
		super();
		this.ascDesc = ascDesc;
	}
	

	@Override
	public int compare(File o1, File o2) {
		
		if(ascDesc){
			if(o1.isFile() && o2.isDirectory()){
				return 1;
			}
		}
		else{
			if(o2.isFile() && o1.isDirectory()){
				return 1;
			}
		}
		
		
		return 0;
	}

}
