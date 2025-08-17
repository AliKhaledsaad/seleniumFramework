package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream stream=null;
	
	public FileInputStream getExcelFile()
	{
		String filePath=System.getProperty("user.dir")+"/src/test/java/data/userData.xlsx";
		File srcFile = new File(filePath);
		try {
			stream = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Excel File Not Found , check file path : "+e.getMessage());
		}
		return stream;
	}
	
	public Object [][] getExcelData() throws IOException
	{
		stream = getExcelFile();
		XSSFWorkbook wb = new XSSFWorkbook(stream);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int totalRows = (sheet.getLastRowNum()+1);
		int totalCols = 5;
		
		String [][]arrayExcelData = new String[totalRows][totalCols];
		
		for(int i=0;i<totalRows;i++)
		{
			for(int j=0;j<totalCols;j++)
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
	}
}
