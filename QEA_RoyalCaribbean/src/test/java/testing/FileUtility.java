package testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUtility {
	public static String[] readExcel(String fileName) throws IOException {
		FileInputStream fi=new FileInputStream(fileName);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sheet=wb.getSheetAt(0);
		XSSFRow row=sheet.getRow(0);
		int c=row.getLastCellNum();
		String[] arr=new String[c];
		for(int i=0;i<c;i++) {
			XSSFCell cell=row.getCell(i);
			DataFormatter d=new DataFormatter();
			arr[i]=d.formatCellValue(cell);
		}
		
		return arr;
	}
}
