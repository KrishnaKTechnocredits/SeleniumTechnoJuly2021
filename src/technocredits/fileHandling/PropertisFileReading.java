package technocredits.fileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertisFileReading {

	public static void main(String[] args) throws IOException {
		File file = new File("./src/technocredits/firstProprty.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		System.out.println(properties.getProperty("dbServer_1"));
		
	}

}
