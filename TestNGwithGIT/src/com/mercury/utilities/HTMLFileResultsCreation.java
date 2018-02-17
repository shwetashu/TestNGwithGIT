package com.mercury.utilities;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class HTMLFileResultsCreation {
	static String FileName;
	static String TC;
	static int stepID;
	public static void createHeader(String TestCaseName)
	{
		stepID=0;
		TC=TestCaseName;
		Date d=new Date();
		 FileName=TestCaseName+"_"+(d.getDate()+"_"+(d.getMonth()+1)+"_"+(1900+d.getYear())+"_"+d.getHours()+"_"+d.getMinutes()+"_"+d.getSeconds());
		try{
			File f=new File("D:/workspace/TestNGwithGIT/src/com/mercury/testResults/"+FileName+".html");
			FileWriter fw=new FileWriter(f);
			fw.write("<html>\n");
			fw.write("<title>Automation Infotech</title>\n");
			fw.write("<body>\n");
			fw.write("<table border=1 width=100%>\n");
			fw.write("<tr>\n");
			fw.write("<td> StepId </td>\n");
			fw.write("<td> StepName </td>\n");
			fw.write("<td> Desc </td>\n");
			fw.write("<td> Status </td>\n");
			fw.write("</tr>\n");

			fw.close();
		}
		catch(Exception e)
		{

		}


	}
	public static void insertStep(String StepID,String StepName,String Desc,String Status)
	{
		stepID++;
		try{
			File f=new File("D:/workspace/TestNGwithGIT/src/com/mercury/testResults/"+FileName+".html");
			FileWriter fw=new FileWriter(f,true);
			fw.write("<tr>\n");
			fw.write("<td> "+TC+"."+stepID +"</td>\n");
			fw.write("<td> "+StepName+" </td>\n");
			fw.write("<td> "+Desc +"</td>\n");
			//fw.write("<td> "+Status +"</td>\n");
			if(Status.equalsIgnoreCase("Passed"))
				fw.write("<td><img src=D:/SeleniumTutotial/Day15_20Aug/right-tick.png alt='Passed' width ='50' height='50'> </td>\n");
			else
				fw.write("<td><img src=D:/SeleniumTutotial/Day15_20Aug/Wrong-tick.jpg alt='Failed' width ='50' height='50'> </td>\n");
			fw.write("</tr>\n");
			fw.write("</tr>\n");

			fw.close();
		}
		catch(Exception e)
		{

		}
	}

}
