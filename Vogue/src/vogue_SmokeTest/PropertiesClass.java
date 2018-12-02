package vogue_SmokeTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass
{
	static Properties prop=new Properties();
	 public static void loadData() throws IOException
	 {
		 File file=new File(System.getProperty("user.dir")+"\\src\\properties\\ConfigFile.properties");
		 FileReader fobj=new FileReader(file);
		 prop.load(fobj);
	 }
	 public static String getObject(String Data) throws IOException
	 {
		 loadData();
		String data= prop.getProperty(Data);
		return data;
	 }
}
