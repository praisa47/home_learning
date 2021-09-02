package NaveenAutomationLabs;

//import com.excel.lib.util.Xls_Reader;

import com.excel.lib.util.Xls_Reader;

public class ExcelUtilTest {


    public static void main(String[] args) {
        //Xls_Reader coming from the jar file
        //or we can just download the class file and put it under and use it too

        Xls_Reader reader = new Xls_Reader("./src/test/java/NaveenAutomationLabs/SampleExcel.xlsx");


       // ("user.dir") +"\\src\\test\\java\\FileHandling\\project.properties
        String sheetName = "login";

        System.out.println(reader.getCellData(sheetName, "username", 3));
        String data = reader.getCellData(sheetName, 0, 2);
        System.out.println(data);

        int rowCount = reader.getRowCount(sheetName);
        System.out.println("total rows: "+ rowCount);

        //reader.addColumn(sheetName, "status");

        if(! reader.isSheetExist("Regsitration")){
            reader.addSheet("Regsitration");
        }
        reader.setCellData(sheetName, "status", 2, "PASS");

        System.out.println(reader.getColumnCount(sheetName));

        //reader.removeColumn("Regsitration", 0);

        System.out.println(reader.getCellData("Regsitration", "phonenumber", 2));
        System.out.println(reader.getCellData("Regsitration", "age", 2));


    }
}
