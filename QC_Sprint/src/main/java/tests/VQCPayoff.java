package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class VQCPayoff extends QCStore
{

	public static void payoffcck(String SSN,String AppURL)
	{
		int i;
		for(i=0;i<3;i++)
		{
		
	try{
			int lastrow=TestData.getLastRow("PayOff");
			String sheetName="PayOff";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
					String PIN = TestData.getCellData(sheetName,"Password",row);
					String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
					String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
					String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO,"PayOff started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Vprop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(Vprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(Vprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(Vprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");		
								
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(Vprop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Thread.sleep(5000);					  
						
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					Thread.sleep(5000);
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
					Thread.sleep(2000);	
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button ");
					Thread.sleep(5000);	
				
					/*String paymentamount=driver.findElement(By.xpath("//input[@name='payOffAmount']")).getAttribute("value");
					test.log(LogStatus.PASS, "PaymentAmount captured is :"+paymentamount);
					Thread.sleep(2000);	
					driver.findElement(By.name("tenderType")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					Thread.sleep(2000);	
					
					driver.findElement(By.name("tenderAmount")).sendKeys(paymentamount.trim());
					test.log(LogStatus.PASS, "Payoff amount entered as :"+paymentamount);	
					
					
					driver.findElement(By.name("password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "Pin is entered as "+ PIN);*/
					
					//String paymentamount = driver.findElement(By.name("requestBean.paymentAmt")).getAttribute("value");
					String paymentamount = driver.findElement(By.name("payOffAmount")).getAttribute("value");					
					test.log(LogStatus.PASS, "Paymentamt is :" + paymentamount);
					//driver.findElement(By.name("requestBean.tenderAmt")).clear();
					//driver.findElement(By.name("requestBean.tenderAmt")).sendKeys(Paymentamt);
					//test.log(LogStatus.PASS, "Payment amount entered :" + Paymentamt);
					Thread.sleep(500);
					//driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);
					driver.findElement(By.name("tenderType")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type entered :" + TenderType);
					Thread.sleep(500);
					//driver.findElement(By.name("requestBean.transactionDataBean.ccmoNbrFirst")).sendKeys(CC_MO_Nbr);
					driver.findElement(By.name("ccmoNbrFirst")).sendKeys(CC_MO_Nbr);					
					test.log(LogStatus.PASS, "CC_MO_Nbr entered :" + CC_MO_Nbr);
					Thread.sleep(500);
					//driver.findElement(By.name("requestBean.tenderAmt")).sendKeys(paymentamount);
					driver.findElement(By.name("tenderAmount")).sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Tender amount entered :" + paymentamount);
					driver.findElement(By.name("password")).sendKeys(PIN);
					
					test.log(LogStatus.PASS, "Pin is entered :" + PIN);
					Thread.sleep(500);
					
					driver.findElement(By.name("Submit22")).click();
					Thread.sleep(3000);
					test.log(LogStatus.PASS, "Clicked on Finish Payment");
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>PayOff Return Completed Successfully");
					Thread.sleep(5000);

					
					try { 
						Alert alert = driver.switchTo().alert();

						alert.accept();
						test.log(LogStatus.PASS, "Alert Handled successfully");
																				
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(40000);
					//if(driver.findElement(By.name("ok")).isDisplayed())
					{
					test.log(LogStatus.PASS, "PayOff transaction is successfully");
					}
					test.log(LogStatus.PASS,"****************************************");
					break;
					
				}
					}
		
break;

}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
					test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
					test.log(LogStatus.INFO, "Patial Payment process is initiated again due to Application sync issue");
					driver.get(Vprop.getProperty("login_page"));
					continue;


				}

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, " Partail Payment setup is failed");
			Assert.assertTrue(false);
	
		}
	}


public static void payoffck(String SSN,String AppURL)
{
	int i;
	for(i=0;i<3;i++)
	{
	
try{
		int lastrow=TestData.getLastRow("PayOff");
		String sheetName="PayOff";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
				String PIN = TestData.getCellData(sheetName,"Password",row);
				String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3,5);
				String SSN3 = SSN.substring(5,9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO,"PayOff started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Vprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(Vprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(Vprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Vprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
							
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");					    					   					     
				driver.findElement(locator(Vprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);					  
					
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
				Thread.sleep(5000);
				driver.findElement(By.name("transactionList")).sendKeys(TxnType);
				test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
				Thread.sleep(2000);	
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button ");
				Thread.sleep(5000);	
			
			
				String paymentamount = driver.findElement(By.name("payOffAmount")).getAttribute("value");					
				test.log(LogStatus.PASS, "Paymentamt is :" + paymentamount);
				
				Thread.sleep(500);
				//driver.findElement(By.name("requestBean.tenderType")).sendKeys(TenderType);
				driver.findElement(By.name("tenderType")).sendKeys(TenderType);
				test.log(LogStatus.PASS, "Tender Type entered :" + TenderType);
				Thread.sleep(500);
				//driver.findElement(By.name("requestBean.transactionDataBean.ccmoNbrFirst")).sendKeys(CC_MO_Nbr);
				driver.findElement(By.name("ccmoNbrFirst")).sendKeys(CC_MO_Nbr);					
				test.log(LogStatus.PASS, "CC_MO_Nbr entered :" + CC_MO_Nbr);
				Thread.sleep(500);
				//driver.findElement(By.name("requestBean.tenderAmt")).sendKeys(paymentamount);
				driver.findElement(By.name("tenderAmount")).sendKeys(paymentamount);
				test.log(LogStatus.PASS, "Tender amount entered :" + paymentamount);
				driver.findElement(By.name("password")).sendKeys(PIN);
				
				test.log(LogStatus.PASS, "Pin is entered :" + PIN);
				Thread.sleep(500);
				
				driver.findElement(By.name("Submit22")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Clicked on Finish Payment");
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>PayOff Return Completed Successfully");
				Thread.sleep(5000);

				
				try { 
					Alert alert = driver.switchTo().alert();

					alert.accept();
					test.log(LogStatus.PASS, "Alert Handled successfully");
																			
				}
				catch (NoAlertPresentException e) {
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(40000);
				//if(driver.findElement(By.name("ok")).isDisplayed())
				{
				test.log(LogStatus.PASS, "PayOff transaction is successfully");
				}
				test.log(LogStatus.PASS,"****************************************");
				break;
				
			}
				}
	
break;

}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				test.log(LogStatus.INFO, "Patial Payment process is initiated again due to Application sync issue");
				driver.get(Vprop.getProperty("login_page"));
				continue;


			}

}
	if(i==3)
	{
		test.log(LogStatus.FAIL, " Partail Payment setup is failed");
		Assert.assertTrue(false);

	}
}
}

	