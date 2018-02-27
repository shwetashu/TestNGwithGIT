package com.mercury.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	Properties pro;
	FileInputStream fis;
	public ConfigReader(){
		try{
			File f=new File("src/com/mercury/environment/configurations");
			fis=new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is:" + e.getMessage());
		}
	}

	public  String getPath()
	{
		String path=pro.getProperty("URL");

		return path;
	}

}
