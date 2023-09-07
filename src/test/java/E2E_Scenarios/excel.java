package E2E_Scenarios;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class excel {
    @DataProvider(name="testdata")
    public Object[][] excel() throws IOException, InvalidFormatException {

        File myFile = new File("C://Users//Asus//Downloads//testing.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(myFile);
        XSSFSheet mysheet = workbook.getSheet("sheet1");
        int num_of_rows=mysheet.getPhysicalNumberOfRows();
        int num_of_clms=mysheet.getRow(0).getLastCellNum();
        String [][] myarray= new String[num_of_rows-1][num_of_clms];
        for (int i=1;i<num_of_rows;i++){
            for (int j=0;j<num_of_clms;j++){
                XSSFRow row=mysheet.getRow(i);
                myarray[i-1][j]=row.getCell(j).getStringCellValue();
            }
        }
        return myarray;
    }
}
