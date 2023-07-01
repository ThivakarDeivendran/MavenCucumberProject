package utilities;

import java.io.IOException;

public class ReadingPropertiesFileDataClass extends ReadingPropertiesFileClass{
	public static String mainURL ;
	public static String secondURL;
	
	public static void testReadpropertyFile() throws IOException {
		mainURL= readingPropertyFile("FacebookURL");
	    secondURL= readingPropertyFile("SwaglabsURL");
	  

	}
	public static void main(String[] args) throws IOException {
		 testReadpropertyFile();
	}

}
