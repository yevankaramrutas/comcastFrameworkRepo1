package gulframework.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
		//mainn method is not used bcoz utility contain reusable methods run the program without testscript
     public String getDataFromPropertiesFile(String key)throws Throwable {
    	 
    	FileInputStream fis=new FileInputStream("./configAppData/commondata1.properties");
    	Properties pobj=new Properties();
    	pobj.load(fis);
    	String data=pobj.getProperty(key);
    	
    	
    	 return data;
    	 
    	 
     }

	
	
	}


