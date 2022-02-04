package BussinesFunctionClasses;

import java.util.ArrayList;

import org.testng.Assert;

import DataClasses.SFDataclass;
import HelperClasses.TestBase;
import PageClasses.SFpageclass;

public class SFbusinessclass extends TestBase {

	SFpageclass objPage;

	public SFbusinessclass() {
		objPage = new SFpageclass();
	}

	public void setTestData(SFDataclass objdata, String methodname) {
		try {
			ArrayList<String> exceldata = new ArrayList();
			String filepath = System.getProperty("user.dir") + objConfig.getProperty("testfilepath");
			String sheet = objConfig.getProperty("sheetname");
			exceldata = objsfcommon.getRowData(filepath, sheet, methodname, "Test Case Name");
			objdata.setLabel(exceldata.get(0));
			objdata.setWebsite(exceldata.get(1));
			objdata.setPhone(exceldata.get(2));
			objdata.setDate(exceldata.get(3));
			objdata.setTime(exceldata.get(4));
			objdata.setBalance(exceldata.get(5));
			objdata.setRow(exceldata.get(6));
			objdata.setComponent(exceldata.get(7));
			objdata.setExampleDropDownOption(exceldata.get(8));
		} catch (Exception e) {
			System.out.println("Not able to read, due to :" + e);
		}

	}

	public void clickOncomponentReferenceTab() {
		try {
			objPage.clickOncomponentReferenceTab();
		} catch (Exception e) {
			System.out.println("Not able to clickOncomponentReferenceTab, due to :" + e);
		}

	}

	public void searchAndSelectComponentFromQuickFind(String comp) {
		try {
			objPage.searchAndSelectComponentFromQuickFind(comp);
		} catch (Exception e) {
			System.out.println("Not able to searchAndSelectComponentFromQuickFind, due to :" + e);
		}

	}

	public void selectFromTheExampleDropDown(String option) {
		try {
			objPage.selectFromTheExampleDropDown(option);
		} catch (Exception e) {
			System.out.println("Not able to selectFromTheExampleDropDown, due to :" + e);
		}

	}

	public void editAndUpdateTheTableRowData(SFDataclass objdata) {
		try {
			objPage.selectFromTheExampleDropDown(objdata.getExampleDropDownOption());
			objPage.clickonRun();
			objPage.switchToFrameWithIndex("1");
			objPage.switchToFrameWithIndex("1");
			objPage.editAndUpdateLabelColumnValue(objdata.getLabel(), objdata.getRow());
			objPage.editAndUpdateWebsiteColumnValue(objdata.getWebsite(), objdata.getRow());
			objPage.editAndUpdatePhoneColumnValue(objdata.getPhone(), objdata.getRow());
			objPage.editAndUpdateDatetimeColumnValue(objdata.getDate(), objdata.getTime(), objdata.getRow());
			objPage.editAndUpdateBalanceColumnValue(objdata.getBalance(), objdata.getRow());
		} catch (Exception e) {
			System.out.println("Not able to editAndUpdateTheTableRowData, due to :" + e);
		}

	}

	public void verifyLabelName(String expectedValue, String row) {
		try {
			String actualValue = objPage.getLabelValue(row);
			Assert.assertEquals(actualValue, expectedValue, "Label Name Mis-Match");

		} catch (Exception e) {
			System.out.println("Not able to verifyLabelName, due to :" + e);
		}

	}

	public void verifyWebsite(String expectedValue, String row) {
		try {
			String actualValue = objPage.getWebsiteValue(row);
			Assert.assertEquals(actualValue, expectedValue, "WebSite Value Mis-Match");

		} catch (Exception e) {
			System.out.println("Not able to verify Website, due to :" + e);
		}

	}

	public void verifyPhone(String expectedValue, String row) {
		try {
			boolean status = false;
			String actualValue = objPage.getPhoneValue(row);
			if (actualValue.equals(expectedValue)) {
				status = true;
			}
			Assert.assertTrue(status, "Phone Value Mis-Match");

		} catch (Exception e) {
			System.out.println("Not able to verify Phone, due to :" + e);
		}

	}

	public void verifyDate(String expectedValue, String row) {
		try {
			String actualValue = objPage.getDateValue(row);
			Assert.assertEquals(actualValue, expectedValue, "Date Value Mis-Match");

		} catch (Exception e) {
			System.out.println("Not able to verify Date, due to :" + e);
		}

	}

	public void verifyBalance(String expectedValue, String row) {
		try {
			boolean status = false;
			String actualValue = objPage.getBalanceValue(row);
			if (actualValue.contains(expectedValue)) {
				status = true;
			}
			Assert.assertTrue(status, "Balance Value Mis-Match");

		} catch (Exception e) {
			System.out.println("Not able to verify Balance, due to :" + e);
		}

	}

	public void verifyUpdatedValues(SFDataclass objdata) {
		try {
			this.verifyLabelName(objdata.getLabel(), objdata.getRow());
			this.verifyWebsite(objdata.getWebsite(), objdata.getRow());
			this.verifyPhone(objdata.getPhone(), objdata.getRow());
			this.verifyDate(objdata.getDate(), objdata.getRow());
			this.verifyBalance(objdata.getBalance(), objdata.getRow());
		} catch (Exception e) {
			System.out.println("Not able to verify Updated Values, due to :" + e);
		}

	}

}
