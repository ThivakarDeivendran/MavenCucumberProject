package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFileClass {
	
	
	public static String readingPropertyFile(String propertyKeyName) throws IOException {
		File fileName = new File("D:\\User\\Document\\Eclipse_workspace\\myMaven\\Properties\\Facebook.properties");
		FileInputStream fisFile = new FileInputStream(fileName);
		Properties propertyFileData = new Properties();
		propertyFileData.load(fisFile);
		return propertyFileData.getProperty(propertyKeyName);
	}


}