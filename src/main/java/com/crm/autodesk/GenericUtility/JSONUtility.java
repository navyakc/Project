package com.crm.autodesk.GenericUtility;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONUtility {
	
	public String readdatafromJason(String key) throws Throwable {
		//read data from jason file
		FileReader file=new FileReader("./commonData.json"); //enter path of jason file
		
		//convert the jason file into object
		JSONParser jsonobj=new JSONParser();
		Object jobj=jsonobj.parse(file);
		
		//type cast java obj to hashmap
		HashMap map=(HashMap)jobj;
		String value=map.get(key).toString();
		
		//return the value
		return value;
		
	}


}
