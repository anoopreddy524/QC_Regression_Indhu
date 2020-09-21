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

public class JQCTLPCSRNewLoan extends QCStore {
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
	public static String VIN;
	public static String Miles;
	public static String VehicleGrade;
	public static String relamount;
	public static String CC_Issuer_Name;

	public static void newLoan(String SSN, String AppURL) {
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
						
						ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
						NewVIN=NewVIN+""+ESign_CheckNbr;
						System.out.println(NewVIN);
						VIN = TestData.getCellData(sheetName, "VIN", row);
						Miles = TestData.getCellData(sheetName, "Miles", row);
						// System.out.println(Term);
						// String StoreId =
						// TestData.getCellData(sheetName,"StoreID",row);
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
						CouponNbr = TestData.getCellData(sheetName, "CouponNbr", row);
						ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						ESign_Checks = TestData.getCellData(sheetName, "ESign_Checks", row);
						ESign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						
						// last4cheknum=
						// ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						last4cheknum = TestData.getCellData(sheetName, "ChkgAcctNbr_lastfour", row);

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
						CC_Issuer_Name = TestData.getCellData(sheetName, "CC_Issuer_Name", row);

						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);

						Thread.sleep(3000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("New Loan initiation has
						// started", ExtentColor.BLUE));
						test.log(LogStatus.INFO, "New Loan initiation has started");

						driver.switchTo().frame("topFrame");
						driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(locator(Jprop.getProperty("csr_new_loan_link"))).click();
						test.log(LogStatus.PASS, "Clicked on New Loan");
						driver.switchTo().frame("main");
						Thread.sleep(4000);
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(locator(Jprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(locator(Jprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
							test.log(LogStatus.PASS, "Clicked on GO Button");

							for (String winHandle1 : driver.getWindowHandles()) {
								driver.switchTo().window(winHandle1);
							}
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							// Selection of Product based on the Name provided
							// in Test Data
							/*driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "colletral type is collected as:" +ESign_CollateralType);*/
							/*if (ESign_CollateralType.equalsIgnoreCase("ACH")) {

								TLP_ACH_Collateral();

							}

							// --------------------------------------------------------------------------------------------------------

							if (ESign_CollateralType.equalsIgnoreCase("Debit Card")) {
								TLP_DEBITCARD_Collateral();
							}

							// -----------------------------------------------------------------------------------------------------------------------------------

							if (ESign_CollateralType.equalsIgnoreCase("NO COLLATERAL")) {
								TLP_NO_Collateral();

							}*/
							driver.findElement(By.xpath("//*[@id='veh1']")).click();
							test.log(LogStatus.PASS, "Clicked on yes button");

							Thread.sleep(10000);
							driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "colletral type is collected as:" +ESign_CollateralType);
							Thread.sleep(30000);
							
							/*driver.findElement(By.xpath("//*[@name='cardNmbr']")).sendKeys("NEW CARD");
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
*/
							Thread.sleep(6000);
							if (driver.findElement(By.id("LoanButtonId")).isEnabled()) {

								WebElement htmltable = driver.findElement(By.xpath(
										"//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table

								rows = htmltable.findElements(By.tagName("tr"));

								count = 0;
								count = driver
										.findElements(By
												.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"))
										.size();
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[1]
								// System.out.println("current row num "+count);
								// System.out.println(" rows num "+
								// rows.size());

								if (ProductID.equals("TLP")) {
									TLP();

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
				test.log(LogStatus.INFO, "Exception occured " + e.toString().substring(0, 250));
				test.log(LogStatus.INFO, "New Loan process is initiated again due to Application sync issue");
				//driver.get("http://192.168.2.203/cc/login/index.jsp");
				continue;

			}

		}
		if (i == 3) {
			test.log(LogStatus.FAIL, "New Loan is failed");
			Assert.assertTrue(false);
			// throw new ArithmeticException("sample");

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

		Thread.sleep(30000);
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

					try{
					driver.findElement(By
							.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
									+ i + "]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input"))
							.click();

					test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);
					}
					catch(Exception ex)
					{
						driver.findElement(By.xpath("//*[@id='termSel1']")).click();
					}

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
			
			String loanAmt=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[2]/td")).getText();
			test.log(LogStatus.PASS, "ILP loan amount is : "+loanAmt);
			String term=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[3]/td")).getText();
			test.log(LogStatus.PASS, "Term is : "+term);
			String inst=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[4]/td")).getText();
			test.log(LogStatus.PASS, "Number of installments is : "+inst);
			String rate=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[5]/td")).getText();
			test.log(LogStatus.PASS, "Interest rate is : "+rate);
			String apr=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[6]/td/input")).getAttribute("value");
			test.log(LogStatus.PASS, "APR is : "+apr);
			String payAmt=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[7]/td/input")).getAttribute("value");
			test.log(LogStatus.PASS, "Payment Amount is : "+payAmt);
			String payDate=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[8]/td")).getText();
			test.log(LogStatus.PASS, "Payment Date is : "+payDate);
			String freq=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[9]/td")).getText();
			test.log(LogStatus.PASS,  "Frequence is : "+freq);
			String minLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[10]/td")).getText();
			test.log(LogStatus.PASS, "Minimum loan amount is : "+minLoanAmt);
			String maxLoanAmt=driver.findElement(By.xpath("//*[@id='tableWid11']/tbody/tr[11]/td")).getText();
			test.log(LogStatus.PASS, "Maximum loan amount is : "+maxLoanAmt);

			driver.findElement(By.id("LoanButtonId")).click();
			Thread.sleep(4000);

			test.log(LogStatus.PASS, "Clicked on new loan button ");

			driver.findElement(By.name("requestBean.titleNumber")).sendKeys(TitleNumber);
			test.log(LogStatus.PASS, "Entered the Title number as " + TitleNumber);
			driver.findElement(By.name("button1")).click();
			test.log(LogStatus.PASS, "click on Update button ");
			Thread.sleep(5000);
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
			Thread.sleep(5000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button2")));
			driver.findElement(By.name("button2")).click();
			test.log(LogStatus.PASS, "Clicked on update button ");
			Thread.sleep(5000);

			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("process")));
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
			Thread.sleep(30000);
			//driver.findElement(By.name("OKBut")).click();
			driver.findElement(By.xpath("//*[@id='confirmGrid']/tbody/tr/td/table/tbody/tr[8]/td[1]/input")).click();
			test.log(LogStatus.PASS, "click on Yes button ");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id='docEditor']/table/tbody/tr[4]/td/input[1]")).click();
			//driver.findElement(By.xpath("//*[@id='docEditor']/form/table/tbody/tr[4]/td/input[1]")).click();
			test.log(LogStatus.PASS, "Clicked on Yes button ");
			Thread.sleep(5000);

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

	public static void TLP_ACH_Collateral() throws InterruptedException

	{

		/*driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
		test.log(LogStatus.PASS, "colletral type is collected as:" +ESign_CollateralType);
		*//*driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);*/

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

				String main_window = driver.getWindowHandle();
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
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
				driver.findElement(By.name("vehicleKey")).sendKeys("NO");

				test.log(LogStatus.PASS, "Vehicle Key selected as NO ");
				Thread.sleep(2000);

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

					String main_window = driver.getWindowHandle();
					driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
					test.log(LogStatus.PASS, "Promotion button is clicked ");
					Thread.sleep(10000);

					for (String winHandle1 : driver.getWindowHandles()) {
						if (!main_window.equalsIgnoreCase(winHandle1)) {
							Thread.sleep(5000);
							driver.switchTo().window(winHandle1);
							Thread.sleep(5000);
							driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
							test.log(LogStatus.PASS, "Promotion radio button is selected ");
							driver.findElement(locator(Jprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
							test.log(LogStatus.PASS, "OK button is clicked ");

							driver.switchTo().window(main_window);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
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
				
				try {
					driver.findElement(By.name("requestBean.siilBean.checkopt")).sendKeys(No_of_checks);

					test.log(LogStatus.PASS, "Number of checks selected as " + No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();

					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);

					test.log(LogStatus.PASS, "Enterd amount is " + relamount);

				} catch (NoAlertPresentException e) {
					// do what you normally would if you didn't have the alert.
				}

			
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

		/*driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);*/
		//=================================================================================================
				
				
		/*driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
		test.log(LogStatus.PASS, "colletral type is collected as:" +ESign_CollateralType);
		
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
		test.log(LogStatus.PASS, "clicked on Add Card Button");*/

		//=================================================================================================
		

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

			/*
			 * driver.findElement(By .xpath(
			 * "//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"
			 * )) .click();
			 */
			driver.findElement(
					By.xpath("//input[@class='sortbuttons' and @onclick='this.disabled=true;addCard(this);']")).click();

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
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
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
			driver.findElement(By.name("vehicleKey")).sendKeys("NO");

			test.log(LogStatus.PASS, "Vehicle Key selected as NO ");

			/*driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");

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
*/
			/*
			 * driver.findElement(By .xpath(
			 * "//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"
			 * )) .click();
			 */
			/*driver.findElement(
					By.xpath("//input[@class='sortbuttons' and @onclick='this.disabled=true;addCard(this);']")).click();

			test.log(LogStatus.PASS, "Clicked on add card button ");

			Thread.sleep(30000);
*/
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
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
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
				Thread.sleep(5000);
				driver.findElement(By.name("requestBean.siilBean.checkopt")).sendKeys(No_of_checks);

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

		/*driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);
*/
		driver.findElement(By.xpath("//*[@name='requestBean.collateralType']")).sendKeys(ESign_CollateralType);
		test.log(LogStatus.PASS, "colletral type is collected as:" +ESign_CollateralType);
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
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(Jprop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
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
			/*
			 * driver.findElement(By.name("requestBean.siilBean.checkopt")).
			 * sendKeys(No_of_checks); test.log(LogStatus.PASS,
			 * "Entered number of checks as " + No_of_checks);
			 * 
			 * driver.findElement(By.name("requestBean.siilBean.payeeName1")).
			 * sendKeys(CC_Issuer_Name); test.log(LogStatus.PASS,
			 * "Entered payee Name as " + CC_Issuer_Name);
			 * driver.findElement(By.name("requestBean.siilBean.checkAmt1")).
			 * sendKeys(CC_Issuer_Name); test.log(LogStatus.PASS,
			 * "Entered payee Name as " + CC_Issuer_Name);
			 */

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