package utility;
         import java.io.FileInputStream;
         import java.io.FileOutputStream;
         import org.apache.poi.xssf.usermodel.XSSFCell;
         import org.apache.poi.xssf.usermodel.XSSFRow;
         import org.apache.poi.xssf.usermodel.XSSFSheet;
         import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
    public class ExcelUtils {
			private static XSSFWorkbook ExcelWBook;
			private static XSSFSheet ExcelWSheet;
     		private static XSSFRow Row;
    		private static XSSFCell Cell;
    		 
		public static void setExcelFile(String Path,String SheetName) throws Exception {
   			try {
				FileInputStream ExcelFile = new FileInputStream(Path);
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				ExcelWSheet = ExcelWBook.getSheet(SheetName);
				} catch (Exception e){
					throw (e);
				}
		}
	    public static String getCellData(int RowNum, int ColNum) throws Exception{
   			try{
       			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
       			String CellData = Cell.getStringCellValue();
       			return CellData;
       			}catch (Exception e){
					return"";
           			}
 		    }
 
	    @SuppressWarnings("static-access")
		public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
   			try{
       			Row  = ExcelWSheet.getRow(RowNum);
				Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
				if (Cell == null) {
					Cell = Row.createCell(ColNum);
					Cell.setCellValue(Result);
					} else {
						Cell.setCellValue(Result);
					}
      				FileOutputStream fileOut = new FileOutputStream(Constants.TESTDATA_PATH + Constants.TESTDATA_FILENAME);
       				ExcelWBook.write(fileOut);
       				fileOut.flush();
					fileOut.close();
					}catch(Exception e){
						throw (e);
				}
 			}
	}