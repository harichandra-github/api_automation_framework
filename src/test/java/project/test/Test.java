package project.test;

import java.io.IOException;

import project.utilities.XLUtils;

public class Test {

	public static void main(String[] args) throws IOException {
		System.out.println("Test");

		String path=System.getProperty("user.dir")+"//testdata//testdata.xlsx";
		XLUtils xl=new XLUtils(path);
		
		int rownum=xl.getRowCount(path,"sheet1");
	
		
		String apidata[]=new String[rownum];
		for(int i=1;i<=6;i++)
		{
			
			
				//apidata[i-1][j]=xl.getCellData(path, "sheet1", i, j);
				System.out.println(xl.getCellData(path, "sheet1", i, 7).toString());
			
		}

	}

}
