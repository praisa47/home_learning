package ExcelSheet;

//import org.apache.poi.hssf.model.Sheet;
//import org.apache.poi.hssf.model.Workbook;
//import org.apache.poi.hssf.record.formula.functions.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BasicExcelReader {
    public static void main(String[] args) throws IOException {
        String fileName = "Data_Ori.xlsx";
        String filePath = System.getProperty("user.dir") +"\\src\\test\\resources";
        File file = new File(filePath + "\\" + fileName);
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        //Workbook workbook = new Workbook(inputStream);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        //workb = new Workbook();
        //Read sheet inside the workbook by its name
        XSSFSheet employeeSheet = workbook.getSheet("Employee"); //sheetname
        //Find number of rows in excel file
        int rowCount = employeeSheet.getLastRowNum() - employeeSheet.getFirstRowNum();
        //Create a loop over all the rows of excel file to read it
        for (int i = 0; i < rowCount + 1; i++) {
            XSSFRow row = employeeSheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.print(row.getCell(j).getStringCellValue() + "|| ");
            }
            System.out.println();
        }
    }
}

