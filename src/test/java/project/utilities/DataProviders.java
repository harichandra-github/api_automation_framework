package project.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="AllData")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//testdata.xlsx";
		XLUtils xl=new XLUtils(path);
		
//		int rownum=xl.getRowCount(path,"sheet1");
//		int colcount=xl.getCellCount(path, "sheet1", 1);
		
		String apidata[][]=new String[5][7];
		for(int i=1;i<=5;i++)
		{
			for(int j=0;j<7;j++)
			{
				apidata[i-1][j]=xl.getCellData(path, "sheet1", i, j);
			}
		}
		
		return apidata;
		
	}
	
	@DataProvider(name="getUserNames")
	public String[] getUsernames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//testdata.xlsx";
		XLUtils xl=new XLUtils(path);
		
//		int rownum=xl.getRowCount(path,"sheet1");

		String apidata[]=new String[5];
		
		for(int i=1;i<=5;i++)
		{
			apidata[i-1]=xl.getCellData(path, "sheet1", i, 1);
		}
		return apidata;
	}
}
