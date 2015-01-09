package hr.fer.oop.week9.db;

import hr.fer.oop.week9.stat.Extension;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.xml.internal.bind.v2.model.core.ID;


public class StudentDatabase {
	
	private Map<String, StudentRecord> dataBase=new LinkedHashMap<>();
	
	public StudentDatabase(List<String> rows){
		
		for(String row:rows){
			String[] rowSplit=row.split("\t");
			addToDatabase(rowSplit);
		}
		
	}

	private void addToDatabase(String[] rowSplit) {
		dataBase.put(rowSplit[0], new StudentRecord(rowSplit[0], rowSplit[1], rowSplit[2], rowSplit[3]));
		
	}
	
	public StudentRecord forJMBAG(String jmbag){
		for (Map.Entry<String, StudentRecord> entry : dataBase.entrySet()) {
		    String key = entry.getKey();
		    if(key.equals(jmbag)){
		    	return dataBase.get(key);
		    }
		}
		return null;
	}

	
	public List<StudentRecord> filter(IFilter filter){
		List<StudentRecord> studentList= new ArrayList<>();
		for (Map.Entry<String, StudentRecord> entry : dataBase.entrySet()) {
		    String key = entry.getKey();
		    if(filter.accepts(entry.getValue())){
		    	studentList.add(entry.getValue());		    	
		    }
		}
		
		return studentList;
	}
	
	

}
