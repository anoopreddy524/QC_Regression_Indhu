package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class QCAgeStoreGraceDays extends QCStore {
	

	public static void ageStoreGraceDays(String SSN, String AppURL) {
		int i;
		for (i = 0; i < 3; i++) {
		
		
		
			try {
				
				int lastrow = TestData.getLastRow("New_Loan");
				String sheetName = "New_Loan";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {


						String AgeStore = TestData.getCellData(sheetName, "AgeStore", row);

						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(4000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("Age Store process is
						// initiated", ExtentColor.BLUE));
						test.log(LogStatus.INFO, "Age Store Grace days process is initiated");
						driver.switchTo().frame("bottom");
						String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
								.getText();
						String store_date[] = Str_date.split(":");
						business_date = store_date[1].trim();
						test.log(LogStatus.PASS, "Business date is :" + business_date);

						driver.switchTo().defaultContent();

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						driver.findElement(By.cssSelector("li[id='910000']")).click();

						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						Thread.sleep(1000);
						try {
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
				
							driver.findElement(By.cssSelector("li[id='911101']")).click();
							test.log(LogStatus.PASS, "Clicked on Transactions");
						} catch (Exception e) {
							//driver.get("https://192.168.2.203/cc/demoIndex.do");
							driver.get("https://qclocalauto.qfund.net/cc/demoIndex.do");
							
							  //driver.get(csr_url);
							   //driver.get("https://qclocalreg.qfund.net/cc/demoIndex.do");
							driver.switchTo().defaultContent();

							wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
							driver.switchTo().frame("topFrame");
							wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
							driver.findElement(By.cssSelector("li[id='910000']")).click();

							Thread.sleep(1000);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
				
							driver.findElement(By.cssSelector("li[id='911101']")).click();
							test.log(LogStatus.PASS, "Clicked on Transactions");
						}
						driver.switchTo().frame("main");
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Click on submit Button");
						Thread.sleep(2000);
						
						
						/*for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						String mainwindow = driver.getWindowHandle();
						Thread.sleep(1000);
						driver.findElement(By
								.xpath("/html/body/table/tbody/tr[1]/td[1]/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a"))
								.click();
						test.log(LogStatus.PASS, "Clicked on Customer number link");
						Thread.sleep(3000);
						for (String winHandle : driver.getWindowHandles()) {
							if (!mainwindow.equalsIgnoreCase(winHandle)) {
								driver.switchTo().window(winHandle);
                                
								try {
									driver.findElement(By.id("overridelink")).click();
									Thread.sleep(3000);
									
								} catch (Exception e) {
									// TODO: handle exception
								}
								loan_number = driver.findElement(locator(prop.getProperty("csr_loan_nbr"))).getText();
								test.log(LogStatus.PASS, "Loan Number is" + loan_number);
								Thread.sleep(1000);
								NextDueDate = driver.findElement(locator(prop.getProperty("csr_due_date"))).getText();
								test.log(LogStatus.PASS, "Next due date is " + NextDueDate);
								driver.close();
								Thread.sleep(500);
								break;
							}
						}
						driver.switchTo().window(mainwindow);*/
						
			//============= Taking Due Date From History ====================
						
						for(String winHandle : driver.getWindowHandles()){
						    driver.switchTo().window(winHandle);
							}
						    driver.switchTo().defaultContent();
						    driver.switchTo().frame("mainFrame");
						    driver.switchTo().frame("main");
						    
						    
						  // String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
						  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
						    driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Clicked on GO Button under search results");
							// driver.findElement(By.name("button")).click();
							
						for(String winHandle : driver.getWindowHandles()){
							    driver.switchTo().window(winHandle);
								}				    
							 driver.switchTo().defaultContent();
							    driver.switchTo().frame("mainFrame");
							    driver.switchTo().frame("main");
							   					    
							    Thread.sleep(5000);
							    
							    	 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
									    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
							
							   //  String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
								//   test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
								 driver.findElement(By.name("transactionList")).sendKeys("History");
								 test.log(LogStatus.PASS, "Transaction Type is selected as History");
								 driver.findElement(By.name("button")).click();
								 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");													 													
								 Thread.sleep(3000); 
								 
								 NextDueDate=driver.findElement(locator(Jprop.getProperty("loan_status_inf_due_date"))).getText();
							     test.log(LogStatus.PASS, "Next due date is "+NextDueDate);		
							     Thread.sleep(1000); 
							     loan_number=driver.findElement(By.xpath("//*[@id='revolvingCreditHistTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
							     test.log(LogStatus.PASS, "Loan Number  is "+loan_nbr);	
							     

									
							     
	//==============================================================================
						
						

						Thread.sleep(5000);

						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("topFrame");
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@id='930000']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Cash Management");
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						try {
							driver.findElement(By.xpath("//*[@id='988190657']/a")).click();
							test.log(LogStatus.PASS, "Clicked on Start Scheduler");
						} catch (Exception e) {
							driver.get("https://qclocalauto.qfund.net/cc/demoIndex.do");
							//driver.get("https://192.168.2.203/cc/demoIndex.do");
							  //driver.get("https://qclocalreg.qfund.net/cc/demoIndex.do");
                                  
							driver.switchTo().defaultContent();
							driver.switchTo().frame("topFrame");
							driver.findElement(By.xpath("//*[@id='930000']/a")).click();

							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.findElement(By.xpath("//*[@id='988190657']/a")).click();
							test.log(LogStatus.PASS, "Clicked on Start Scheduler");
						}
						int IAgeStore = Integer.parseInt(AgeStore);

						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						Date DDueDateminus1 = df.parse(business_date);
						Calendar cal = Calendar.getInstance();
						cal.setTime(DDueDateminus1);
						cal.add(Calendar.DATE, IAgeStore);
						Date DDueDate1 = cal.getTime();
						String Gracedays = df.format(DDueDate1);
						System.out.println(Gracedays);

						test.log(LogStatus.PASS, "Age Store Date after increasing is :" + Gracedays);

						Thread.sleep(5000);

						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
				
						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						String Due_Date[] = Gracedays.split("/");
						String Due_Date1 = Due_Date[0];
						String Due_Date2 = Due_Date[1];
						String Due_Date3 = Due_Date[2];
						driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
						test.log(LogStatus.PASS, "Month is entered: " + Due_Date1);
						driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
						test.log(LogStatus.PASS, "Date is entered: " + Due_Date2);
						driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
						test.log(LogStatus.PASS, "Year is entered: " + Due_Date3);
						driver.findElement(By.name("runSchedulerBtn")).click();
						test.log(LogStatus.PASS, "Clicked on Run Scheduler");
						Thread.sleep(8000);
						// String alert1= driver.switchTo().alert().getText();
						// test.log(LogStatus.PASS, "Clicked on Finish Loan:
						// "+alert1);

						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						Thread.sleep(30000);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
						Thread.sleep(8000);
						driver.findElement(By.name("ok")).click();
						// test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
						// test.log(LogStatus.PASS,
						// MarkupHelper.createLabel("Clicked on Scheduler Ok
						// Successfully",ExtentColor.GREEN));
						test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
						test.log(LogStatus.PASS, "************************************************");

						Thread.sleep(5000);
						driver.close();

						break;
					}
				}

				break; // for FOR loop
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower
				// Registration is failed", ExtentColor.RED));
				// test.log(LogStatus.FAIL, "Age store is failed");
				test.log(LogStatus.INFO, " " + e);
				test.log(LogStatus.INFO,
						"Age store Grace days process is initiated again due to Application sync issue");
				driver.get("https://qclocalauto.qfund.net/cc/demoIndex.do");
				//driver.get("https://qclocalreg.qfund.net/cc/demoIndex.do");
				continue;

			}

		}
		if (i == 3) {
			test.log(LogStatus.FAIL, "Age store Grace days is failed");

		}
	}

	public static void ageStoreGraceDays2ndTime(String SSN, String AppURL) throws Exception {
		int i;
		for (i = 0; i < 4; i++) {

			try {

				int lastrow = TestData.getLastRow("New_Loan");
				String sheetName = "New_Loan";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {

						String PIN = TestData.getCellData(sheetName, "PIN", row);
						// System.out.println(Password);
						String StoreId = TestData.getCellData(sheetName, "StoreID", row);
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);

						String AgeStore_2nd_time = TestData.getCellData(sheetName, "AgeStore_2nd_time", row);

						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(4000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("Age Store process is
						// initiated", ExtentColor.BLUE));
						test.log(LogStatus.INFO, "Age Store Grace days process is initiated");
						driver.switchTo().frame("bottom");
						String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]"))
								.getText();
						String store_date[] = Str_date.split(":");
						business_date = store_date[1].trim();
						test.log(LogStatus.PASS, "Business date is :" + business_date);

						driver.switchTo().defaultContent();

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
						driver.switchTo().frame("topFrame");
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
						driver.findElement(By.cssSelector("li[id='910000']")).click();
						
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");
						Thread.sleep(1000);
				
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
		
						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transactions");
						driver.switchTo().frame("main");
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Click on submit Button");
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button under Search results");
						// driver.findElement(By.name("button")).click();

						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// driver.findElement(By.name("button")).click();

						if (ProductID.equals("PDL")) {
							driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						}
						if (ProductID.equals("TLP")) {
							driver.findElement(By
									.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input"))
									.click();
							test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						}

						Thread.sleep(5000);
						if (ProductID.equals("LOC")) {
							/// html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]
							driver.findElement(By
									.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]"))
									.click();
						}

						Thread.sleep(5000);
							int IAgeStore = Integer.parseInt(AgeStore_2nd_time);
							
							DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
							Date DDueDateminus1 = df.parse(business_date);
							Calendar cal = Calendar.getInstance();
							cal.setTime(DDueDateminus1);
							cal.add(Calendar.DATE, IAgeStore);
							Date DDueDate1 = cal.getTime();
							business_date = df.format(DDueDate1);
							System.out.println(business_date);

							test.log(LogStatus.PASS, "Age Store Date after increasing is :" + business_date);
							// String DueDate0[] =NextDueDate.split("/");

						}

						Thread.sleep(5000);

						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("topFrame");
						driver.findElement(By.xpath("//*[@id='930000']/a")).click();
						test.log(LogStatus.PASS, "Clicked on Cash Management");
						try {
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.findElement(By.xpath("//*[@id='988190657']/a")).click();
							test.log(LogStatus.PASS, "Clicked on Start Scheduler");
						} catch (Exception e) {
							driver.get("http://192.168.2.203/cc/demoIndex.do");
							driver.switchTo().defaultContent();
							driver.switchTo().frame("topFrame");
							driver.findElement(By.xpath("//*[@id='930000']/a")).click();
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.findElement(By.xpath("//*[@id='988190657']/a")).click();
							test.log(LogStatus.PASS, "Clicked on Start Scheduler");

						}
						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						String Due_Date[] = business_date.split("/");
						String Due_Date1 = Due_Date[0];
						String Due_Date2 = Due_Date[1];
						String Due_Date3 = Due_Date[2];
						driver.findElement(By.name("endMonth")).sendKeys(Due_Date1);
						test.log(LogStatus.PASS, "Month is entered: " + Due_Date1);
						driver.findElement(By.name("endDay")).sendKeys(Due_Date2);
						test.log(LogStatus.PASS, "Date is entered: " + Due_Date2);
						driver.findElement(By.name("endYear")).sendKeys(Due_Date3);
						test.log(LogStatus.PASS, "Year is entered: " + Due_Date3);
						driver.findElement(By.name("runSchedulerBtn")).click();
						test.log(LogStatus.PASS, "Clicked on Run Scheduler");
						Thread.sleep(500);
						// String alert1= driver.switchTo().alert().getText();
						// test.log(LogStatus.PASS, "Clicked on Finish Loan:
						// "+alert1);

						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (Exception e) {
							// do what you normally would if you didn't have the
							// alert.
						}
						Thread.sleep(30000);

						wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ok")));
						Thread.sleep(8000);
						driver.findElement(By.name("ok")).click();
						// test.log(LogStatus.PASS, "Clicked on Scheduler Ok");
						// test.log(LogStatus.PASS,
						// MarkupHelper.createLabel("Clicked on Scheduler Ok
						// Successfully",ExtentColor.GREEN));
						test.log(LogStatus.PASS, "Clicked on Scheduler Ok Successfully");
						test.log(LogStatus.PASS, "************************************************");

						Thread.sleep(5000);
						driver.close();

						break;

					}
				

				break; // for FOR loop
			} 
			catch (Exception e) {
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "GraceDays");
								test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO,
						"Age store Grace days process is initiated again due to Application sync issue");
				driver.get(prop.getProperty("login_page")); 
				continue;

			}

		}
		if (i == 3) {
			test.log(LogStatus.FAIL, "Age store Grace days is failed");
			Assert.assertTrue(false);

		}
	}
}