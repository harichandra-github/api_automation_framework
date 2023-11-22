package project.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook wb;
	public  XSSFSheet ws;
	public  XSSFRow row;
	public  XSSFCell cell;
	String xlfile;

	public XLUtils(String file) {
		file=xlfile;
		
		// TODO Auto-generated constructor stub
	}

	public  int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public  int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public  String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(column);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}

		catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;

	}

//	public  void setCellData(String xlfile, String xlsheet, int rownum, int column, String data)
//			throws IOException {
//		fi = new FileInputStream(xlfile);
//		wb = new XSSFWorkbook(fi);
//		ws = wb.getSheet(xlsheet);
//		row = ws.getRow(rownum);
//		cell = row.getCell(column);
//		cell.setCellValue(data);
//		fo = new FileOutputStream(xlfile);
//		wb.write(fo);
//		wb.close();
//		fi.close();
//		fo.close();
//
//	}
}
