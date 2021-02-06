package Resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import HelperClass.ResourceHelper;

public class ExcelUtilities {

	public static String getData(String ModuleName, String ColName) throws IOException {

		Row rowNum;
		
		String path=ResourceHelper.getResourcePath("//src//main//java//Utilities//AcademyProjectexternalData.xlsx");
		FileInputStream input = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		int totalSheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < totalSheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Test_Data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Identify Coloumn name with "Module"

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				int j = 0;
				int coloumn = 0;
				while (cells.hasNext()) {
					Cell Value = cells.next();
					if (Value.getStringCellValue().equalsIgnoreCase("Module")) {
						coloumn = j;
					}
					j++;
					// Identify Test Case Coloumn "Module"
					int coloumnNumber = getColoumnNumber(ColName, sheet);

					// Identify Module Name present on which Row
					while (rows.hasNext()) {
						rowNum = rows.next();
						
						if (rowNum.getCell(coloumn).getStringCellValue().equalsIgnoreCase(ModuleName)) {
                           //Extract Cell Value based on Coloumn Name Provided.
							Cell cell = rowNum.getCell(coloumnNumber);
							String returnCellValue=String.valueOf(cell);
							return returnCellValue;
							
						}
						input.close();
					}

				}
			}
		}
		return null;
	}
	

	public static int getColoumnNumber(String ColoumnName, XSSFSheet sheet) {
		// Identify Test Case Coloumn "Module"
		Iterator<Row> rows = sheet.iterator();
		Row firstRow = rows.next();
		Iterator<Cell> cells = firstRow.cellIterator();
		int k = 0;
		int coloumn = 0;
		while (cells.hasNext()) {
			Cell Value = cells.next();
			if (Value.getStringCellValue().equalsIgnoreCase(ColoumnName)) {
				coloumn = k;
			}
			k++;
		}
		return coloumn;
	}

	public static void putData(String moduleName, String ColName, String ColValue) throws IOException {
		Row rowNum;
		// ArrayList<String> ad=new ArrayList<String>();
		String path=ResourceHelper.getResourcePath("//src//main//java//Utilities//AcademyProjectexternalData.xlsx");
		FileInputStream input = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		int totalSheetCount = workbook.getNumberOfSheets();
		for (int i = 0; i < totalSheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Test_Data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// Identify Coloumn name with "Module"

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				int j = 0;
				int coloumn = 0;
				while (cells.hasNext()) {
					Cell Value = cells.next();
					if (Value.getStringCellValue().equalsIgnoreCase("Module")) {
						coloumn = j;
					}
					j++;
					// Identify Cell Number with Blank Value in the 1st Row
					int coloumnNumber = putColoumnNumber(null, sheet);
                      //int coloumnNumber=5;
                      //Adding the new Coloumn
                      firstRow.createCell(coloumnNumber).setCellValue(ColName);
					// Identify Module Name present on which Row
					while (rows.hasNext()) {
						rowNum = rows.next();
						if (rowNum.getCell(coloumn).getStringCellValue().equalsIgnoreCase(moduleName)) {
							//Getting access of the blank cell in the specified modulename row
							//Cell cell=rowNum.getCell(coloumnNumber);
							
							//Setting value in the blank cell of the specified row. 
								rowNum.createCell(coloumnNumber).setCellValue(ColValue);
						
						
								input.close();

								System.out.println("done");
								FileOutputStream outFile = new FileOutputStream(
										path);
								workbook.write(outFile);
								outFile.close();
							
						}
					}
				}
			}
		}
	}
	public static int putColoumnNumber(String ColoumnName,XSSFSheet sheet)


	{
		//Identify Test Case Coloumn "Module"
		Iterator<Row> rows1 = sheet.iterator();
		Row firstRow1 = rows1.next();
		Iterator<Cell> cells1 = firstRow1.cellIterator();
		int k1=0;
		int coloumn1=0;
		
		try
		{
		while(cells1.hasNext())
		{
			Cell Value1=cells1.next();
			//short lastcellNum = firstRow.getLastCellNum();
		
			
			if(Value1.getStringCellValue().equalsIgnoreCase(ColoumnName))
			{
				coloumn1=k1;
			}
			k1++;
			
	}
		if(ColoumnName.contains(null))
		{
			short lastcellNum = firstRow1.getLastCellNum();
			coloumn1=lastcellNum+1;
		}
		//return coloumn;
		}
		catch(Exception e)
		{
			e.getStackTrace();
			e.getCause();
			e.getMessage();
		}
		return coloumn1;
	}}