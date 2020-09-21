package tests;

import static org.testng.Assert.assertFalse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCTXCSRNewLoan extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static String ESign_CheckNbr;
	public static String ESign_Password;
	public static String ESign_Checks;
	public static String CouponNbr;
	// public static String ChkgAcctNbr;
	public static String AllowPromotion;
	public static String AllowCoupons;
	public static String CSO_Fee;
	
	 
	public static String ESign_Preference;
	public static String ESign_CourtesyCallConsent;
	public static String ESign_DisbType;
	public static String ESign_LoanAmt;
	public static String ESign_CollateralType;
	public static String stateProductType;
	public static String stateProduct;
	public static String StoreID;
	public static String NewVIN;
	public static String VehicleType;
	public static String NewLoan_Term;
	public static String NewLoan_ProductName;
	public static String ProductType;
	public static String Password;
	public static String UserName;
	public static String ProductID;
	public static String last4cheknum;
	public static String InsuranceExpiryDate0[] = null;
	public static String InsuranceExpiryDate3;
	public static String InsuranceExpiryDate2;
	public static String InsuranceExpiryDate1;
	public static String PolicyNumber;

	public static String InsuranceCompany;
	public static String PhoneNbr3;
	public static String PhoneNbr2;
	public static String PhoneNbr1;
	public static String PhoneNbr;
	public static String InsuranceCoverage;
	public static String LicensePlateExp;
	public static String LicensePlateNumber;
	public static String ExteriorColor;
	public static String AppraisalValue;
	public static String InsuranceExpiryDate;
	public static String TitleNumber;
	public static int rnum;
	public static int cnum;
	public static String product_name;
	public static int count;
	public static List<WebElement> rows;
	public static String No_of_checks;
	public static String cardType;
	public static String cardNumber;
	public static String cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;
	public static String CheckNbr1;
	public static String CheckNbr2;
	public static String CheckNbr3;
	public static String CheckNbr4;
	public static String CheckNbr5;
	public static String CheckNbr6;

	public static String VIN;
	public static String Miles;
	public static String VehicleGrade;
	public static String relamount;
	public static String  CC_Issuer_Name;
	public static String Loanamount;
	public static String Coupon_nbr;
	//public static String CSOFeeNewLoan;

	public static void newLoan(String SSN, String AppURL) throws Exception {
		int i;
		for (i = 0; i < 3; i++) {

			try {
				int lastrow = TestData.getLastRow("New_loan");
				String sheetName = "New_Loan";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);
						ProductID = TestData.getCellData(sheetName, "ProductID", row);
						System.out.println(ProductID);
						UserName = TestData.getCellData(sheetName, "UserName", row);
						Password = TestData.getCellData(sheetName, "Password", row);
						ProductType = TestData.getCellData(sheetName, "ProductType", row);
						NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
						NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
						NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
						VIN = TestData.getCellData(sheetName, "VIN", row);
						Miles = TestData.getCellData(sheetName, "Miles", row);
						StoreID = TestData.getCellData(sheetName, "StoreID", row);
						stateProduct = State + " " + ProductID;
						stateProductType = State + " " + NewLoan_ProductName;
						ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						System.out.println(ESign_CollateralType);
						ESign_LoanAmt = TestData.getCellData(sheetName, "ESign_LoanAmt", row);
						// ChkgAcctNbr =
						// TestData.getCellData(sheetName,"ChkgAcctNbr",row);
						ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
						AllowPromotion = TestData.getCellData(sheetName, "AllowPromotion", row);
						Coupon_Code = TestData.getCellData(sheetName, "Coupon_Code", row);
						CouponNbr = TestData.getCellData(sheetName, CouponNbr, row);

						AllowCoupons = TestData.getCellData(sheetName, "AllowCoupons", row);
						CSO_Fee=TestData.getCellData(sheetName, "CSOFee", row);
						CouponNbr = TestData.getCellData(sheetName, "CouponNbr", row);
						ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						ESign_Checks = TestData.getCellData(sheetName, "ESign_Checks", row);
						ESign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						//ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						ESign_CheckNbr=SSN.substring(SSN.length() - 6);
						// last4cheknum=
						// ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						//last4cheknum = TestData.getCellData(sheetName, "ChkgAcctNbr_lastfour", row);
						last4cheknum= SSN.substring(SSN.length() - 4);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);
						TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
						AppraisalValue = TestData.getCellData(sheetName, "Appraisal Value", row);
						ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
						LicensePlateNumber = TestData.getCellData(sheetName, "License Plate Number", row);

						VehicleGrade = TestData.getCellData(sheetName, "Vehicle Grade", row);
						LicensePlateExp = TestData.getCellData(sheetName, "License Plate Expiry", row);
						InsuranceCoverage = TestData.getCellData(sheetName, "Insurance Coverage", row);
						PhoneNbr = TestData.getCellData(sheetName, "Phone Nbr", row);
						PhoneNbr1 = PhoneNbr.substring(0, 3);
						PhoneNbr2 = PhoneNbr.substring(3, 6);
						PhoneNbr3 = PhoneNbr.substring(6, 10);
						InsuranceCompany = TestData.getCellData(sheetName, "Insurance Company", row);
						InsuranceExpiryDate = TestData.getCellData(sheetName, "Insurance Expiry Date", row);
						PolicyNumber = TestData.getCellData(sheetName, "Policy Number", row);
						InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
						InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
						InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
						InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
						No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
						CC_Issuer_Name=TestData.getCellData(sheetName, "CC_Issuer_Name", row);

						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
						Loanamount = TestData.getCellData(sheetName,"Loanamount",row);
						System.out.println(Loanamount);
						
						  driver.switchTo().frame("bottom");
							String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
							String store_date[]=Str_date.split(":");
							business_date=store_date[1].trim();
							test.log(LogStatus.PASS, "Business date is :"+business_date);

							driver.switchTo().defaultContent();	   
						
						
						Thread.sleep(3000);
						
						test.log(LogStatus.INFO, "New Loan initiation has started");

						driver.switchTo().frame("topFrame");
						driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();
						
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(locator(Rprop.getProperty("csr_new_loan_link"))).click();
						test.log(LogStatus.PASS, "Clicked on New Loan");
						driver.switchTo().frame("main");
						Thread.sleep(4000);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(locator(Rprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(locator(Rprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						driver.findElement(locator(Rprop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
							test.log(LogStatus.PASS, "Clicked on GO Button");

							for (String winHandle1 : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle1);
							}
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							// Selection of Product based on the Name provided
							// in Test Data
							//==================================================================================
							
							/*driver.findElement(By.xpath("//*[@id='veh1']")).click();
							test.log(LogStatus.PASS, "Clicked on yes button");
*/
							driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "colletral type is collected as:" +ESign_CollateralType);
							
							Thread.sleep(20000);
							if (ESign_CollateralType.equalsIgnoreCase("Debit Card")) {
								
							
							driver.findElement(By.xpath("//*[@name='cardNmbr']")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");
							
							driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);

							test.log(LogStatus.PASS, "Card number is :" + cardNumber);

							driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);

							test.log(LogStatus.PASS, "Enterd card Type : " + cardType);

							driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);

							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);

							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

							driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);

							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							
							driver.findElement(By.xpath("//*[@value='Add Card']")).click();
							test.log(LogStatus.PASS, "clicked on Add Card Button");
							//========================================================================
							}
							Thread.sleep(30000);
							if (driver.findElement(By.id("LoanButtonId")).isEnabled()) {

								WebElement htmltable = driver.findElement(By.xpath(
										"//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
								
								rows = htmltable.findElements(By.tagName("tr"));

								count = 0;
								count = driver
										.findElements(By
												.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"))
										.size();
								
								if (ProductID.equals("PDL")) {
									PDL(SSN,AppURL);
									break;
								}
								if (ProductID.equals("ILP")) {
									ILP();
									break;
								}

								if (ProductID.equals("TLP")) {
									TLP();
									break;
								}
								if (ProductID.equals("LOC")) {
									LOC();
									break;
								}
							}

						}

						break;
					}

				}
				break;
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("New Loan
				// is failed", ExtentColor.RED));
				// test.log(LogStatus.FAIL, "New Loan is failed");
				test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
				String screenshotPath = getScreenhot(driver, "Exception");
								test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "New Loan process is initiated again due to Application sync issue");
				driver.get(Rprop.getProperty("login_page")); 
				continue;

			}

		}
		if (i == 3) {
			test.log(LogStatus.FAIL, "New Loan is failed");
			Assert.assertTrue(false);
			// throw new ArithmeticException("sample");

		}
	}

	public static void PDL(String SSN, String AppURL) throws Exception 

	{

		// if(ProductID.equals("PDL"))
		{
			rnum = rnum + 1;
			if (State.equalsIgnoreCase("TX")) {
				//*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[3]/td[2]/input
				                              //*[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[4]/td[2]/input
				//*[@id="termSel1"]
				driver.findElement(By.xpath("//*[@id='termSel1']")).click();
			} else if (State.equalsIgnoreCase("NV")) {
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_nv_product"))).click();
			}
		}
		test.log(LogStatus.PASS, "Product selected as " + stateProduct);

		driver.findElement(By.id("LoanButtonId")).click();
		test.log(LogStatus.PASS, "Clicked on New Loan button ");
		
		
		Thread.sleep(3000);
		
		
		
//====================  Script For Negotiate Loan Amount  ========================================================
	/*	driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");

		Thread.sleep(5000);
		driver.findElement(By.name("negLoanAmt")).click();
		
		test.log(LogStatus.PASS, "Clicked on Negotiate Loan amt Tab");
		
		String mainwindow=driver.getWindowHandle();
	    for(String winHandle : driver.getWindowHandles()){
			if(!mainwindow.equalsIgnoreCase(winHandle))
			{
		    driver.switchTo().window(winHandle);
		    
		    Thread.sleep(1000);
		    driver.findElement(By.name("requestBean.siilBean.advAmt")).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+Loanamount);
		    
		    System.out.println(Loanamount);
		    
		    Thread.sleep(1000);
			driver.findElement(By.name("reCalculate")).click();
			test.log(LogStatus.PASS, "Clicked on ReCalculate Tab");
			Thread.sleep(2000);
			//driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/table/tbody/tr/td[3]/table/tbody/tr[12]/td/input")).click();
			  driver.findElement(By.name("negSel")).click();                           
			test.log(LogStatus.PASS, "Clicked on Option1 Select Tab");
			Thread.sleep(5000);
		   
			break;
			}
	    }
			driver.switchTo().window(mainwindow);
			Thread.sleep(2000);
			//--------------------------------------------------------------------------------------------------------------	
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
		
			Thread.sleep(2000);*/
//================================================================================================================
		//driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[14]/td[2]/div[1]/select")).sendKeys(ESign_CollateralType);
		///*[@id="errorMessage"]/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[14]/td[2]/div[1]/select
		//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[3]/td[3]/select")).sendKeys(ESign_CollateralType);
		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);
		Thread.sleep(3000);

		if (ESign_CourtesyCallConsent.equals("Yes")) {
			Thread.sleep(7000);
			if (ESign_Preference.equals("Call")) {
				//html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[21]/td[3]/select
				driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[30]/td[2]/select")).sendKeys(ESign_CourtesyCallConsent);
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr[21]/td[3]/select")).sendKeys(ESign_CourtesyCallConsent);			                          
				                          
				driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
				                        
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);
			}
			if (ESign_Preference.equals("Mail")) {
				driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				
				driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);
			}
			if (ESign_Preference.equals("SMS")) {
				driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				try {
					Alert alert = driver.switchTo().alert();
					// alert.dismiss();
					alert.accept();

					// if alert present, accept and move on.

				} catch (NoAlertPresentException e) {
					// do what you normally would if you didn't have the alert.
				}
			}

		} else {
			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
		}

		if (AllowPromotion.equals("Yes")) {

			String main_window = driver.getWindowHandle();
			driver.findElement(By.xpath("//*[@id='allowPromotion']")).sendKeys(Keys.ENTER);
			test.log(LogStatus.PASS, "Promotion button is clicked ");
			Thread.sleep(10000);

			for (String winHandle1 : driver.getWindowHandles()) {
				if (!main_window.equalsIgnoreCase(winHandle1)) {
					Thread.sleep(5000);
					driver.switchTo().window(winHandle1);
					Thread.sleep(5000);
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
					test.log(LogStatus.PASS, "Promotion radio button is selected ");
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
					test.log(LogStatus.PASS, "OK button is clicked ");

					driver.switchTo().window(main_window);
					try {
						Alert alert = driver.switchTo().alert();
						String almsg = alert.getText();

						alert.accept();
						test.log(LogStatus.PASS, "Alert handled " + almsg);
						test.log(LogStatus.PASS, "Alert accepted");
						Thread.sleep(5000);
						driver.switchTo().window(main_window);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						// if alert present, accept and move on.

					} catch (Exception e) {

					}
					break;
				}

			}


			// driver.findElement(By.xpath("//*[@id='coupon']/td[3]/div[1]/input")).sendKeys(CouponNbr);
			// test.log(LogStatus.PASS, "CouponNbr is selected as "+CouponNbr);
		}
		
		if (AllowCoupons.equals("Yes")) {

			driver.findElement(By.xpath("//*[@id='allowPromotion']")).click();
			test.log(LogStatus.PASS, "Allow Coupons check box is clicked ");
			Thread.sleep(1000);
			//html/body/form[1]/table/tbody/tr[6]/td/table/tbody/tr/td/table/tbody/tr[2]/td[4]/input
			CSOFeeNewLoan= driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[2]/tbody/tr[2]/td[3]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Getting CSO Fee is " + CSOFeeNewLoan);
			
			CSOFeeInt=Float.valueOf(CSOFeeNewLoan);
			test.log(LogStatus.PASS, "Getting float CSO Fee is " + CSOFeeInt);
			
			String mainwindow=driver.getWindowHandle();

			QCAdminCoupon.getCouponCode(driver,SSN, AppURL); 

			Thread.sleep(2000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			
			test.log(LogStatus.PASS, "Control switched to CSR page to enter Coupon_Code");
			
			//*[@id="coupon"]/td[2]/div[1]/input
			driver.findElement(By.xpath("//*[@id='coupon']/td[2]/div[1]/input")).sendKeys(CouponNbr);
			test.log(LogStatus.PASS, "Coupon_Code Entered as "+CouponNbr);
			try{
			Alert alert = driver.switchTo().alert();
			String almsg=alert.getText();
			test.log(LogStatus.PASS,"alert with message"+almsg);
			if (almsg.contains(" not ")){
				
				alert.accept();
				test.log(LogStatus.PASS,"Coupon not valid alert handled" );
				
				
			}else{
				alert.accept();
				test.log(LogStatus.FAIL, "alert handled");
			}
			}catch(Exception e){
				
			}
		}


		// '''''''''''''''''''''''''''''''''''''''''''''''//'''''''''''''''''''''''''''''''''''''''''''''//

		if (ESign_CollateralType.equals("CHECK")) {

			//driver.findElement(By.xpath("//*[@id='chkgAcctNbr']")).sendKeys(last4cheknum);
			//test.log(LogStatus.PASS, "	Chkg Acct Nbr(Last 4 Digits Only) is enterted as " + last4cheknum);
			driver.findElement(By.xpath("//*[@id='requestBean.siilBean.disbType']")).sendKeys(ESign_DisbType);
			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);			
			Thread.sleep(500);
			String TotalDisbamount = driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[11]/td[2]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Total Disb Amount is  " + TotalDisbamount);
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='disbAmt1']/td[2]/input")).sendKeys(TotalDisbamount);
			test.log(LogStatus.PASS, "Disb Amount Entered is  " + TotalDisbamount);
			
			Thread.sleep(500);
			
			
			int last4=Integer.parseInt(last4cheknum);
			String s = String.valueOf(last4cheknum);
			for (int j=last4,i=0; j<=last4+5; j++,i++)
			{
			 String last4str=String.valueOf(j);  
			driver.findElement(By.xpath("//*[@id='checkNbrs"+i+"']")).sendKeys(last4str);
			test.log(LogStatus.PASS, "Check Number Entered is  " + last4str);
			
			  System.out.println(last4str);
	
			 
			   
			}

			Thread.sleep(500);

			

		

			Thread.sleep(3000);
			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

			test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);
			// for(int i=1;i<=3;i++){
			// driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.TAB);;
			// }
			// driver.findElement(By.name("advanceRequestBean.loggedUserPassword")).sendKeys(Keys.ENTER);
			// driver.findElement(By.name("finishadvance")).click();

			driver.findElement(By.name("finishLoan")).click();
			test.log(LogStatus.PASS, "Clicked on Finish Loan button ");
		}

		// '''''''''''''''''''''''''''''''''''''''''''''//'''''''''''''''''''''''''''''''''''''''''''''''//
		if (ESign_CollateralType.equals("DEBIT CARD")) {

			//driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);
			//test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);
			
			
			driver.findElement(By.xpath("//*[@id='requestBean.siilBean.disbType']")).sendKeys(ESign_DisbType);
			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);			
			Thread.sleep(500);
			String TotalDisbamount = driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[11]/td[2]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Total Disb Amount is  " + TotalDisbamount);
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='disbAmt1']/td[2]/input")).sendKeys(TotalDisbamount);
			test.log(LogStatus.PASS, "Disb Amount Entered is  " + TotalDisbamount);
			
			Thread.sleep(500);
			
			
			

			/*driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");			
			test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

			driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
		
			test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);

			driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
			test.log(LogStatus.PASS, "Card number is :" + cardNumber);

			driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
			test.log(LogStatus.PASS, "Enterd Expiry month as" + cardEx_month);

			driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
			test.log(LogStatus.PASS, "Entered Expiry year as" + cardEx_month);

			driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
			test.log(LogStatus.PASS, "Enterd CVV as " + cvv);
			driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
			test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

			driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[24]/td[2]/div/input[3]")).click();
										//*[@id="errorMessage"]/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[24]/td[2]/div/input[3]
			test.log(LogStatus.PASS, "Clicked on add card button ");
			Thread.sleep(30000);*/
			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
			test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);
			driver.findElement(By.name("finishLoan")).click();
			test.log(LogStatus.PASS, "clicked on Finish Loan button ");

		}

		if (ESign_CollateralType.equals("ACH")) {
			

			driver.findElement(By.xpath("//*[@id='requestBean.siilBean.disbType']")).sendKeys(ESign_DisbType);
			
			//driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys(ESign_DisbType);                                   
			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);
			Thread.sleep(1000);
			////*[@id="errorMessage"]/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[11]/td[2]/input
			String TotalDisbamount = driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[11]/td[2]/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Total Disb Amount is  " + TotalDisbamount);
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='disbAmt1']/td[2]/input")).sendKeys(TotalDisbamount);
			test.log(LogStatus.PASS, "Disb Amount Entered is  " + TotalDisbamount);

			//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
			//html/body/form[1]/table/tbody/tr[10]/td/input
			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
			test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
			driver.findElement(By.name("finishLoan")).sendKeys(Keys.ENTER);
			test.log(LogStatus.PASS, "Clicked on Finish Loan button ");
		}

		Thread.sleep(3000);
		try {
			Alert alert = driver.switchTo().alert();
			String almsg = alert.getText();

			alert.accept();
			test.log(LogStatus.PASS, "Alert handled " + almsg);

			// if alert present, accept and move on.

		} catch (NoAlertPresentException e) {
			// do what you normally would if you didn't have the alert.
		}

		for (String winHandle1 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle1);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		Thread.sleep(10000);

		if (ESign_CollateralType.equals("ACH")) {
			//String confirm_text1 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[2]/td")).getText();
			String confirm_text1 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]")).getText();
			//String confirm_text2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[3]/td")).getText();
			String confirm_text2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
			
		    //String confirm_text3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[4]/td")).getText();
			String confirm_text3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/b")).getText();
			test.log(LogStatus.PASS, "confirm text is  " + confirm_text1 + confirm_text2 + confirm_text3);
		}
		if (ESign_CollateralType.equals("CHECK")) {
			//String confirm_text1 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[2]/td")).getText();
			String confirm_text1 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]")).getText();                              
			                         
			//String confirm_text2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[3]/td")).getText();
			String confirm_text2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
			
			//String confirm_text3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[4]/td")).getText();
			String confirm_text3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/b")).getText();
			test.log(LogStatus.PASS, "confirm text is  " + confirm_text1 + confirm_text2 + confirm_text3);
		}

		if (ESign_CollateralType.equals("DEBIT CARD")) {
			//String confirm_text4 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[1]/td")).getText();
			String confirm_text1 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]")).getText();                              
            
			//String confirm_text2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[3]/td")).getText();
			String confirm_text2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
			
			//String confirm_text3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[4]/td")).getText();
			String confirm_text3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/b")).getText();
			test.log(LogStatus.PASS, "confirm text is  " + confirm_text1 + confirm_text2 + confirm_text3);
			
			// String
			// confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[1]/td")).getText();
			// String
			// confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[2]/table/tbody/tr[4]/td")).getText();

			//test.log(LogStatus.PASS, "confirm text is  " + confirm_text4);
		}

		// test.log(LogStatus.PASS, "confirm text is "+confirm_text);
		Thread.sleep(15000);

		driver.findElement(By.name("OKBut")).click();
		test.log(LogStatus.PASS, "Clicked on Yes button ");
		//driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
		driver.findElement(By.xpath("//*[@id='docEditor']/table/tbody/tr[4]/td/input[1]")).click();
		test.log(LogStatus.PASS, "Clicked on Yes button ");
		Thread.sleep(5000);
		for (String winHandle1 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle1);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("bdyLoad");
		if (driver.findElement(By.name("ok")).isDisplayed()) {
			                            
			// String msg="</td><td width='10%' bgcolor=339933
			// align=center><font color=white size=1.8 style=Arial>";
			// test.log(LogStatus.PASS, MarkupHelper.createLabel("New Loan is
			// Completed Successfully",ExtentColor.GREEN));
			//test.log(LogStatus.PASS, "New Loan is Completed Successfully");
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Completed Successfully ");
			
			test.log(LogStatus.PASS, "*************************************");

		} else {
			test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
		}

	}

	public static void ILP() throws InterruptedException

	{

		test.log(LogStatus.PASS, "getting product name ");

		List<WebElement> rows = driver.findElements(
				By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));

		int n = rows.size();

		for (int i = 2; i <= n; i++) {

			String Pname = driver.findElement(
					By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[" + i
							+ "]/td[2]"))
					.getText();
			//*[@id="termSel1"]
			test.log(LogStatus.PASS, "getting product name " + Pname);

			if (Pname.equals(stateProductType))

			{

				if (NewLoan_Term.equals("Term1"))

				{

					driver.findElement(By
							.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ i + "]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input"))
							.click();

					test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);

				}

				else if (NewLoan_Term.equals("Term2"))

				{

					driver.findElement(By
							.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ rnum + "]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input"))
							.click();

					test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);

				}

			}

			else {

				continue;

			}

			driver.findElement(By.id("LoanButtonId")).click();

			test.log(LogStatus.PASS, "Clicked on new loan button ");

			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			driver.switchTo().frame("main");

			String relamount = driver.findElement(By.name("requestBean.siilBean.advAmt")).getAttribute("value");

			test.log(LogStatus.PASS, "getting request loan amount " + relamount);

			// --------------------------------------------------------------------------------------------------------------

			if (ESign_CollateralType.equalsIgnoreCase("ACH")) {

				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

				test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);

				if (ESign_DisbType.equalsIgnoreCase("Cash")) {

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

					test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

					test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag"))
							.sendKeys(ESign_CourtesyCallConsent);

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

					if (ESign_CourtesyCallConsent.equals("Yes"))

					{
						Thread.sleep(7000);
						if (ESign_Preference.equals("Call"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						if (ESign_Preference.equals("Mail"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						if (ESign_Preference.equals("SMS"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

							try {

								Alert alert = driver.switchTo().alert();

								alert.dismiss();

								// if alert present, accept and move on.

							}

							catch (NoAlertPresentException e) {

								// do what you normally would if you didn't have
								// the alert.

							}

						}

					}

					if (AllowPromotion.equals("Yes"))

					{

						driver.findElement(By.name("allowPromotion")).click();

						test.log(LogStatus.PASS, "AllowPromotion is selected ");

						driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);

						test.log(LogStatus.PASS, "CouponNbr is selected as " + CouponNbr);

					}

				}

				else if (ESign_DisbType.equalsIgnoreCase("Check")) {

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

					test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

					test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag"))
							.sendKeys(ESign_CourtesyCallConsent);

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

					if (ESign_CourtesyCallConsent.equals("Yes"))

					{
						Thread.sleep(7000);
						if (ESign_Preference.equals("Call"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						if (ESign_Preference.equals("Mail"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						if (ESign_Preference.equals("SMS"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

					}

					if (AllowPromotion.equals("Yes"))

					{

						driver.findElement(By.name("allowPromotion")).click();

						test.log(LogStatus.PASS, "AllowPromotion is selected ");

						driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);

						test.log(LogStatus.PASS, "CouponNbr is selected as " + CouponNbr);

					}

					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);

					test.log(LogStatus.PASS, "Number of checks selected as " + No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();

					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);

					test.log(LogStatus.PASS, "Enterd amount is " + relamount);

				}

				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

				// driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);

				test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);

				driver.findElement(By.name("finishLoan")).click();

				// driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();

				test.log(LogStatus.PASS, "click on Finish Loan button ");

			}

			// --------------------------------------------------------------------------------------------------------

			if (ESign_CollateralType.equalsIgnoreCase("Debit Card")) {

				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

				test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);

				if (ESign_DisbType.equalsIgnoreCase("Cash")) {

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

					test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

					test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

					driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");

					test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

					driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);

					test.log(LogStatus.PASS, "Card number is :" + cardNumber);

					driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);

					test.log(LogStatus.PASS, "Enterd card Type : " + cardType);

					driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);

					test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);

					test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);

					test.log(LogStatus.PASS, "Enterd CVV " + cvv);

					driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

					test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

					driver.findElement(By
							.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"))
							.click();

					test.log(LogStatus.PASS, "Clicked on add card button ");

					Thread.sleep(30000);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag"))
							.sendKeys(ESign_CourtesyCallConsent);

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

					if (ESign_CourtesyCallConsent.equals("Yes"))

					{
						Thread.sleep(7000);
						if (ESign_Preference.equals("Call"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						if (ESign_Preference.equals("Mail"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						if (ESign_Preference.equals("SMS"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

							try {

								Alert alert = driver.switchTo().alert();

								alert.dismiss();

								// if alert present, accept and move on.

							}

							catch (NoAlertPresentException e) {

								// do what you normally would if you didn't have
								// the alert.

							}

						}

					}

					if (AllowPromotion.equals("Yes"))

					{

						driver.findElement(By.name("allowPromotion")).click();

						test.log(LogStatus.PASS, "AllowPromotion is selected ");

						// String mwh=driver.getWindowHandle();

						driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);

						test.log(LogStatus.PASS, "CouponNbr is selected as " + CouponNbr);

						// String winHandle = driver.getWindowHandle(); //Get
						// current window handle.

					}

				}

				else if (ESign_DisbType.equalsIgnoreCase("Check")) {

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

					test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

					test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

					driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");

					test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

					driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);

					test.log(LogStatus.PASS, "Card number is :" + cardNumber);

					driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);

					test.log(LogStatus.PASS, "Enterd card Type : " + cardType);

					driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);

					test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);

					test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);

					test.log(LogStatus.PASS, "Enterd CVV " + cvv);

					driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

					test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

					driver.findElement(By
							.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"))
							.click();

					test.log(LogStatus.PASS, "Clicked on add card button ");

					Thread.sleep(30000);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag"))
							.sendKeys(ESign_CourtesyCallConsent);

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

					if (ESign_CourtesyCallConsent.equals("Yes"))

					{
						Thread.sleep(7000);
						if (ESign_Preference.equals("Call"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						if (ESign_Preference.equals("Mail"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						if (ESign_Preference.equals("SMS"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

					}

					if (AllowPromotion.equals("Yes"))

					{

						driver.findElement(By.name("allowPromotion")).click();

						test.log(LogStatus.PASS, "AllowPromotion is selected ");

						driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);

						test.log(LogStatus.PASS, "CouponNbr is selected as " + CouponNbr);

					}

					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);

					test.log(LogStatus.PASS, "Number of checks selected as " + No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();

					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);

					test.log(LogStatus.PASS, "Enterd amount is " + relamount);

				}

				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

				test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);

				driver.findElement(By.name("finishLoan")).click();

				test.log(LogStatus.PASS, "click on Finish Loan button ");

			}

			// -----------------------------------------------------------------------------------------------------------------------------------

			if (ESign_CollateralType.equalsIgnoreCase("Check")) {

				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

				test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);

				if (ESign_DisbType.equalsIgnoreCase("Cash") || ESign_DisbType.equalsIgnoreCase("Cash")) {

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

					test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

					test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag"))
							.sendKeys(ESign_CourtesyCallConsent);

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

					if (ESign_CourtesyCallConsent.equals("Yes"))

					{
						Thread.sleep(7000);
						if (ESign_Preference.equals("Call"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						else if (ESign_Preference.equals("Mail"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

						}

						else if (ESign_Preference.equals("SMS"))

						{

							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

							try {

								Alert alert = driver.switchTo().alert();

								alert.dismiss();

								// if alert present, accept and move on.

							}

							catch (NoAlertPresentException e) {

								// do what you normally would if you didn't have
								// the alert.

							}

						}

					}

					else {

						test.log(LogStatus.PASS, "Esign preference selected as NO ");

					}

					if (AllowPromotion.equals("Yes"))

					{

						driver.findElement(By.name("allowPromotion")).click();

						test.log(LogStatus.PASS, "AllowPromotion is selected ");

						driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);

						test.log(LogStatus.PASS, "CouponNbr is selected as " + CouponNbr);

					} else

					{

						test.log(LogStatus.PASS, "Allow promotions not selected");

					}

				}

				test.log(LogStatus.INFO, "Performing check transactions");

				int chkno = 987654;

				String instamnts = driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");

				int instamntsno = Integer.parseInt(instamnts) + 1;

				for (int j = 2; j <= instamntsno; j++) {

					chkno = chkno + 1;

					String str1 = Integer.toString(chkno);

					driver.findElement(By.xpath("//*[@id='checkNbrs" + (j - 2) + "']")).sendKeys(str1);

					test.log(LogStatus.PASS, "Check number enterd as " + chkno);

				}

				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

				test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);

				driver.findElement(By.name("finishLoan")).click();

				test.log(LogStatus.PASS, "click on Finish Loan button ");

			}

			// ------------------------------------------------------------------------------------------------------------

			try {

				Alert alert = driver.switchTo().alert();

				alert.accept();

				// if alert present, accept and move on.

			}

			catch (NoAlertPresentException e) {

				// do what you normally would if you didn't have the alert.

			}

			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			driver.switchTo().frame("main");

			driver.findElement(By.name("OKBut")).click();

			test.log(LogStatus.PASS, "click on Yes button ");

			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			driver.switchTo().frame("main");

			if (driver.findElement(By.name("ok")).isDisplayed())

			{

				test.log(LogStatus.PASS, "New Loan is Completed Successfully ");

				test.log(LogStatus.INFO,
						"**********************************************************************************");

				// driver.findElement(By.name("ok")).click();

			}

			else

			{

				test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");

			}

			break;

		}

	}

	public static void TLP() throws InterruptedException {

		

		driver.findElement(By.name("vehicleType_dd")).sendKeys(VehicleType);
		test.log(LogStatus.PASS, "Vehicle Type is selected as " + VehicleType);

		driver.findElement(By.name("existingVin")).sendKeys(VIN);
		test.log(LogStatus.PASS, "VIN selected as " + VIN);
		driver.findElement(By.name("newVinNbr")).sendKeys(NewVIN);
		test.log(LogStatus.PASS, "New VIN entered as " + NewVIN);
		driver.findElement(By.name("miles")).sendKeys(Miles);
		test.log(LogStatus.PASS, "New VIN entered as " + Miles);
		driver.findElement(By.name("bbHit_Button")).click();
		test.log(LogStatus.PASS, "Clicked on Black Book button ");

		test.log(LogStatus.PASS, "getting product name ");

		List<WebElement> rows = driver.findElements(
				By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));

		int n = rows.size();

		for (int i = 2; i <= n; i++) {

			String Pname = driver.findElement(
					By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[" + i
							+ "]/td[2]"))
					.getText();

			test.log(LogStatus.PASS, "getting product name " + Pname);

			if (Pname.equals(stateProductType))

			{

				if (NewLoan_Term.equals("Term1"))

				{

					driver.findElement(By
							.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ i + "]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input"))
							.click();

					test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);

				}

				else if (NewLoan_Term.equals("Term2"))

				{

					driver.findElement(By
							.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ rnum + "]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input"))
							.click();

					test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);

				}

			}

			else {

				continue;

			}

			driver.findElement(By.id("LoanButtonId")).click();
			Thread.sleep(4000);

			test.log(LogStatus.PASS, "Clicked on new loan button ");

			driver.findElement(By.name("requestBean.titleNumber")).sendKeys(TitleNumber);
			test.log(LogStatus.PASS, "Entered the Title number as " + TitleNumber);
			driver.findElement(By.name("button1")).click();
			test.log(LogStatus.PASS, "click on Update button ");
			Thread.sleep(4000);
			driver.findElement(By.name("requestBean.licensePltNbr")).sendKeys(LicensePlateNumber);
			test.log(LogStatus.PASS, "Entered License Plate number as " + LicensePlateNumber);
			driver.findElement(By.name("requestBean.extClr")).sendKeys(ExteriorColor);
			test.log(LogStatus.PASS, "Entered Extirior Color as " + ExteriorColor);
			driver.findElement(By.name("requestBean.vehicleGrade")).sendKeys(VehicleGrade);
			test.log(LogStatus.PASS, "Selected Vehicle Grade as " + VehicleGrade);
			Thread.sleep(2000);
			driver.findElement(By.name("requestBean.coverageType")).sendKeys(InsuranceCoverage);
			test.log(LogStatus.PASS, "Selected Insurance coverage as " + InsuranceCoverage);
			driver.findElement(By.name("iPhoneNbr1")).sendKeys(PhoneNbr1);
			test.log(LogStatus.PASS, "Entereted phone number field 1 as  " + PhoneNbr1);
			driver.findElement(By.name("iPhoneNbr2")).sendKeys(PhoneNbr2);
			test.log(LogStatus.PASS, "Entereted phone number field 2 as  " + PhoneNbr2);
			driver.findElement(By.name("iPhoneNbr3")).sendKeys(PhoneNbr3);
			test.log(LogStatus.PASS, "Entereted phone number field 3 as  " + PhoneNbr3);
			driver.findElement(By.name("requestBean.companyName")).clear();
			driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
			test.log(LogStatus.PASS, "Entered Insurance company as " + InsuranceCompany);
			driver.findElement(By.name("iexpiry1")).sendKeys(InsuranceExpiryDate1);
			test.log(LogStatus.PASS, "Entereted Insurance expiry date field 1 as  " + InsuranceExpiryDate1);
			driver.findElement(By.name("iexpiry2")).sendKeys(InsuranceExpiryDate2);
			test.log(LogStatus.PASS, "Entereted Insurance expiry date field 2 as  " + InsuranceExpiryDate2);
			driver.findElement(By.name("iexpiry3")).sendKeys(InsuranceExpiryDate3);
			test.log(LogStatus.PASS, "Entereted Insurance expiry date field 3 as  " + InsuranceExpiryDate3);
			driver.findElement(By.name("requestBean.polocyNbr")).clear();
			driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
			test.log(LogStatus.PASS, "Entered policy number as " + PolicyNumber);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button2")));
			driver.findElement(By.name("button2")).click();
			test.log(LogStatus.PASS, "Clicked on update button ");
			Thread.sleep(2000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("process")));
			driver.findElement(By.name("process")).click();
			
			test.log(LogStatus.PASS, "click on process Loan button ");
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			
			} catch (NoAlertPresentException e) {
			
			}
			Thread.sleep(5000);
			relamount = driver.findElement(By.name("cashToCust")).getAttribute("value");
			test.log(LogStatus.PASS, " Cash to Customer value is " + relamount);
			if (ESign_CollateralType.equalsIgnoreCase("ACH")) {

				TLP_ACH_Collateral();

			}

			// --------------------------------------------------------------------------------------------------------

			if (ESign_CollateralType.equalsIgnoreCase("Debit Card")) {
				TLP_DEBITCARD_Collateral();
			}

			// -----------------------------------------------------------------------------------------------------------------------------------

			if (ESign_CollateralType.equalsIgnoreCase("NO COLLATERAL")) {
				TLP_NO_Collateral();

			}

			// ------------------------------------------------------------------------------------------------------------

			try {

				Alert alert = driver.switchTo().alert();

				alert.accept();

				// if alert present, accept and move on.

			}

			catch (NoAlertPresentException e) {

				// do what you normally would if you didn't have the alert.

			}

			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			driver.switchTo().frame("main");

			driver.findElement(By.name("OKBut")).click();

			test.log(LogStatus.PASS, "click on Yes button ");

			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			driver.switchTo().frame("main");

			if (driver.findElement(By.name("ok")).isDisplayed())

			{

				test.log(LogStatus.PASS, "New Loan is Completed Successfully ");

				test.log(LogStatus.INFO,
						"**********************************************************************************");

			}

			else

			{

				test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");

			}

			break;

		}

	}

	public static void LOC() {
		try {

			driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
			test.log(LogStatus.PASS, "CollateralType is selected as " + ESign_CollateralType);
			Thread.sleep(5000);
			driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
			test.log(LogStatus.PASS, "Payment Reminder Consent is selected as " + ESign_CourtesyCallConsent);
			driver.findElement(By.name("advanceRequestBean.emailConsentFlag")).sendKeys(ESign_CourtesyCallConsent);
			test.log(LogStatus.PASS, "Payment Reminder Consent is selected as " + ESign_CourtesyCallConsent);
			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
			driver.findElement(By.name("finishadvance")).click();
			test.log(LogStatus.PASS, "Click on Finish LOC Button");
			for (String winHandle1 : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle1);
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			driver.findElement(By.xpath("//*[@id='OKBut']")).click();
			// driver.findElement(By.name("OKBut")).click();
			// driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/input[1]")).click();
			test.log(LogStatus.PASS, "click on Yes button ");
			for (String winHandle1 : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle1);
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");

			if (driver
					.findElement(By
							.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td[2]/input"))
					.isDisplayed()) {
				test.log(LogStatus.PASS, "New Loan is Completed Successfully ");
				driver.findElement(By
						.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td/table[2]/tbody/tr/td[2]/input"))
						.click();
			} else {
				test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void TLP_ACH_Collateral() throws InterruptedException

	{

		driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);

		if (ESign_DisbType.equalsIgnoreCase("Cash")) {

			driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

			driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

			driver.findElement(By.name("vehicleKey")).sendKeys("NO");

			test.log(LogStatus.PASS, "Vehicle Key selected as NO ");
			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

			test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

			if (ESign_CourtesyCallConsent.equals("Yes"))

			{
				Thread.sleep(7000);
				if (ESign_Preference.equals("Call"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("Mail"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("SMS"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

					try {

						Alert alert = driver.switchTo().alert();

						alert.dismiss();

						// if alert present, accept and move on.

					}

					catch (NoAlertPresentException e) {

						// do what you normally would if you didn't have
						// the alert.

					}

				}

			}

			if (AllowPromotion.equals("Yes"))

			{

				driver.findElement(By.name("allowPromotion")).click();

				test.log(LogStatus.PASS, "AllowPromotion is selected ");

				driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);

				test.log(LogStatus.PASS, "CouponNbr is selected as " + CouponNbr);

			}

		}

		else if (ESign_DisbType.equalsIgnoreCase("Check")) {

			driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

			driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);
			driver.findElement(By.name("vehicleKey")).sendKeys("NO");

			test.log(LogStatus.PASS, "Vehicle Key selected as NO ");
			Thread.sleep(2000);

			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

			test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

			if (ESign_CourtesyCallConsent.equals("Yes"))

			{
				Thread.sleep(7000);
				if (ESign_Preference.equals("Call"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("Mail"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("SMS"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

			}

			if (AllowPromotion.equals("Yes"))

			{

				String main_window = driver.getWindowHandle();
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(Rprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(Rprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						try {
							Alert alert = driver.switchTo().alert();
							String almsg = alert.getText();

							alert.accept();
							test.log(LogStatus.PASS, "Alert handled " + almsg);
							test.log(LogStatus.PASS, "Alert accepted");
							Thread.sleep(5000);
							driver.switchTo().window(main_window);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							// if alert present, accept and move on.

						} catch (Exception e) {

						}
						break;
					}

				}


			}

			driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);

			test.log(LogStatus.PASS, "Number of checks selected as " + No_of_checks);

			driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();

			test.log(LogStatus.PASS, "check box selected ");

			driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Enterd amount is " + relamount);

		}

		driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

		// driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);

		test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);

		driver.findElement(By.name("finishLoan")).click();

		// driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();

		test.log(LogStatus.PASS, "click on Finish Loan button ");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			// if alert present, accept and move on.

		} catch (NoAlertPresentException e) {
			// do what you normally would if you didn't have the alert.
		}

	}

	public static void TLP_DEBITCARD_Collateral() throws InterruptedException {

		driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);

		if (ESign_DisbType.equalsIgnoreCase("Cash")) {

			driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

			driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);
			driver.findElement(By.name("vehicleKey")).sendKeys("NO");

			test.log(LogStatus.PASS, "Vehicle Key selected as NO ");
			driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");

			test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

			driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);

			test.log(LogStatus.PASS, "Card number is :" + cardNumber);

			driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);

			test.log(LogStatus.PASS, "Enterd card Type : " + cardType);

			driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);

			test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

			driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);

			test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

			driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);

			test.log(LogStatus.PASS, "Enterd CVV " + cvv);

			driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

			test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

		/*	driver.findElement(By
					.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"))
					.click();*/
			driver.findElement(By.xpath("//input[@class='sortbuttons' and @onclick='this.disabled=true;addCard(this);']")).click();

			test.log(LogStatus.PASS, "Clicked on add card button ");

			Thread.sleep(30000);

			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

			test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

			if (ESign_CourtesyCallConsent.equals("Yes"))

			{
				Thread.sleep(7000);
				if (ESign_Preference.equals("Call"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("Mail"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("SMS"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

					try {

						Alert alert = driver.switchTo().alert();

						alert.dismiss();

						// if alert present, accept and move on.

					}

					catch (NoAlertPresentException e) {

						// do what you normally would if you didn't have
						// the alert.

					}

				}

			}

			if (AllowPromotion.equals("Yes"))

			{
				String main_window = driver.getWindowHandle();
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(Rprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(Rprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						try {
							Alert alert = driver.switchTo().alert();
							String almsg = alert.getText();

							alert.accept();
							test.log(LogStatus.PASS, "Alert handled " + almsg);
							test.log(LogStatus.PASS, "Alert accepted");
							Thread.sleep(5000);
							driver.switchTo().window(main_window);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							// if alert present, accept and move on.

						} catch (Exception e) {

						}
						break;
					}

				}


			}

		}

		else if (ESign_DisbType.equalsIgnoreCase("Check")) {

			driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

			driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

			driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");

			test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

			driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);

			test.log(LogStatus.PASS, "Card number is :" + cardNumber);

			driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);

			test.log(LogStatus.PASS, "Enterd card Type : " + cardType);

			driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);

			test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

			driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);

			test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

			driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);

			test.log(LogStatus.PASS, "Enterd CVV " + cvv);

			driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

			test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

			driver.findElement(By
					.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"))
					.click();

			test.log(LogStatus.PASS, "Clicked on add card button ");

			Thread.sleep(30000);

			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

			test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

			if (ESign_CourtesyCallConsent.equals("Yes"))

			{
				Thread.sleep(7000);
				if (ESign_Preference.equals("Call"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("Mail"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("SMS"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

			}

			if (AllowPromotion.equals("Yes"))

			{

				driver.findElement(By.name("allowPromotion")).click();

				test.log(LogStatus.PASS, "AllowPromotion is selected ");

				driver.findElement(By.name("requestBean.siilBean.couponNbr")).sendKeys(CouponNbr);

				test.log(LogStatus.PASS, "CouponNbr is selected as " + CouponNbr);

			}

			driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);

			test.log(LogStatus.PASS, "Number of checks selected as " + No_of_checks);

			driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();

			test.log(LogStatus.PASS, "check box selected ");

			driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Enterd amount is " + relamount);

		}

		driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

		test.log(LogStatus.PASS, "Password entered as " + ESign_Password);

		driver.findElement(By.name("finishLoan")).click();

		test.log(LogStatus.PASS, "Clicked on Finish Loan button ");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			// if alert present, accept and move on.

		} catch (NoAlertPresentException e) {
			// do what you normally would if you didn't have the alert.
		}

	}

	public static void TLP_NO_Collateral() throws InterruptedException {

		driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);

		if (ESign_DisbType.equalsIgnoreCase("Cash") || ESign_DisbType.equalsIgnoreCase("Check")) {

			driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);
			driver.findElement(By.name("vehicleKey")).sendKeys("NO");

			test.log(LogStatus.PASS, "Vehicle Key selected as NO ");

			driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

			test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

			if (ESign_CourtesyCallConsent.equals("Yes"))

			{
				Thread.sleep(7000);
				if (ESign_Preference.equals("Call"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				else if (ESign_Preference.equals("Mail"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				else if (ESign_Preference.equals("SMS"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

					try {

						Alert alert = driver.switchTo().alert();

						alert.dismiss();


					}

					catch (NoAlertPresentException e) {

					}

				}

			}

			else {

				test.log(LogStatus.PASS, "Esign preference selected as NO ");

			}

			if (AllowPromotion.equals("Yes"))

			{

				String main_window = driver.getWindowHandle();
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(Rprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(Rprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						try {
							Alert alert = driver.switchTo().alert();
							String almsg = alert.getText();

							alert.accept();
							test.log(LogStatus.PASS, "Alert handled " + almsg);
							test.log(LogStatus.PASS, "Alert accepted");
							Thread.sleep(5000);
							driver.switchTo().window(main_window);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							// if alert present, accept and move on.

						} catch (Exception e) {

						}
						break;
					}

				}


		}
		driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);

		test.log(LogStatus.PASS, "Number of checks selected as " + No_of_checks);

		driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();

		test.log(LogStatus.PASS, "check box selected ");

		driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);

		test.log(LogStatus.PASS, "Enterd amount is " + relamount);
		/*driver.findElement(By.name("requestBean.siilBean.checkopt")).sendKeys(No_of_checks);
		test.log(LogStatus.PASS, "Entered number of checks as " + No_of_checks);
		
		driver.findElement(By.name("requestBean.siilBean.payeeName1")).sendKeys(CC_Issuer_Name);
		test.log(LogStatus.PASS, "Entered payee Name as " + CC_Issuer_Name);
		driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(CC_Issuer_Name);
		test.log(LogStatus.PASS, "Entered payee Name as " + CC_Issuer_Name);*/

		driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

		test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);

		driver.findElement(By.name("finishLoan")).click();

		test.log(LogStatus.PASS, "click on Finish Loan button ");
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			// if alert present, accept and move on.

		} catch (NoAlertPresentException e) {
			// do what you normally would if you didn't have the alert.
		}
	}
}
}