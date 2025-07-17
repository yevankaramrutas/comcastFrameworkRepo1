package com.comcast.crm.generic.databaseutility;


import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws Throwable{
		FileReader fread=new FileReader("./configAppData/jsonData.json");
		JSONParser parser =new JSONParser();
		
		
		Object obj = parser.parse(new FileReader("fread"));	
		JSONObject map=(JSONObject) obj;
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		String data=(String) map.get(key);
		return data;
	}

}
