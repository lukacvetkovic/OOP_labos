package hr.fer.oop.week9.stat;

import java.io.File;
import java.util.Comparator;

public class ExtensionNameComparator implements Comparator<Extension>{
	
	private boolean ascDesc;

	public ExtensionNameComparator(boolean ascDesc) {
		super();
		this.ascDesc = ascDesc;
	}

	@Override
	public int compare(Extension arg0, Extension arg1) {
		
		String extension1="";
		String extension2="";
		int comparison;
		
		
		int i = arg0.name.lastIndexOf('.');
		if (i > 0) {
		    extension1 = arg0.name.substring(i+1).toLowerCase();
		}
		
		i = arg1.name.lastIndexOf('.');
		if (i > 0) {
		    extension2 = arg1.name.substring(i+1).toLowerCase();
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
