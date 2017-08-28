Test
import jxl.*;
import jxl.write.*;
import jxl.read.*;
import java.util.*;
import java.lang.*;
 
def inputfile="D:\\SOAP UI\\Input.xls";
Workbook wb=Workbook.getWorkbook(new File(inputfile));
Sheet sh=wb.getSheet("Sheet1");
//def r=ws.getRows();
Cell c1=sh.getCell(0,1);
Cell c2=sh.getCell(1,1);
log.info(c1.getContents());
log.info(c2.getContents());
testRunner.testCase.testSuite.setPropertyValue("return_time",c1.getContents());
testRunner.testCase.testSuite.setPropertyValue("pickup_time",c2.getContents());



--------------
project = testRunner.getTestCase().getTestSuite().getProject().getWorkspace().getProjectByName(""Project1);
testSuite = project.getTestSuiteByName("TestSuite1");
testCase = testSuite.getTestCaseByName("TestCase1");
Thread.sleep(3000)
runner = testCase.run(new com.eviware.soapui.support.types.StringToObjectMap(), false);
