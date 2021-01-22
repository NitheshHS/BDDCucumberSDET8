package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\CommonData\\VtigerAppData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
