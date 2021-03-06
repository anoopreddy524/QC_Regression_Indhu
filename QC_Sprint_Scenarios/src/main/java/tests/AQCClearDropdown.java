package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class AQCClearDropdown extends QCStore {
	public static void clearDropDown(String SSN, String AppURL) throws InterruptedException {
		
		
			int lastrow = TestData.getLastRow("ReturnPosting");
			String sheetName = "ReturnPosting";
	

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				System.out.println("...." + RegSSN);
				if (SSN.equals(RegSSN)) {

					String PIN = TestData.getCellData(sheetName, "Password", row);

					String ESign_CollateralType = TestData.getCellData(sheetName, "Esign_CollateralType", row);

					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
					test.log(LogStatus.INFO, "Clear through from CSR has initiated");
					driver.switchTo().frame("bottom");
					String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
					test.log(LogStatus.PASS, ""+Str_date);

					driver.switchTo().defaultContent();	

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
driver.switchTo().frame("topFrame");
					
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
						
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("li[id='911101']")).click();			
					test.log(LogStatus.PASS, "Clicked on Transactions");
					
					
					driver.switchTo().frame("main");		
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");
					Thread.sleep(2000);
								
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[8]")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Thread.sleep(5000);					  
						
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					Thread.sleep(5000);
				/*	driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");*/
		
						
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(By.xpath("//*[@id='CustGrid']/tbody/tr[2]/td[13]/table/tbody/tr/td[1]/select")).sendKeys("Clear");
						test.log(LogStatus.PASS, "Transaction type is selected Clear");
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
						Thread.sleep(2000);
						driver.findElement(By.name("requestBean.chkName")).click();
						test.log(LogStatus.PASS, "Clicked on the check box ");
						driver.findElement(By.id("CmdReturnPosting")).click();
						test.log(LogStatus.PASS, "Clicked on Finish ACH clear ");
						Thread.sleep(20000);
						if (driver.findElement(By.name("ok")).isDisplayed()) {
							test.log(LogStatus.PASS, ESign_CollateralType + "Clear dropdown from CSR is successfull");
							test.log(LogStatus.PASS, "********************************************** ");
						}
					}
					break;
				}

			}

}

