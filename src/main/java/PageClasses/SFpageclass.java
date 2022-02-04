package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HelperClasses.TestBase;

public class SFpageclass extends TestBase {

	public SFpageclass() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Component Reference']")
	public WebElement componentReferenceTab;

	public void clickOncomponentReferenceTab() {
		objsfcommon.waitForElement(20, componentReferenceTab);
		objsfcommon.scrollToElement(componentReferenceTab);
		objsfcommon.clickByJS(componentReferenceTab);
		// componentReferenceTab.click();

	}

	@FindBy(xpath = "//input[@placeholder='Quick Find']")
	public WebElement quickFindBox;

	public void searchAndSelectComponentFromQuickFind(String comp) {
		objsfcommon.waitForElement(20, quickFindBox);
		objsfcommon.scrollToElement(quickFindBox);
		quickFindBox.clear();
		quickFindBox.sendKeys(comp);
		objsfcommon.implicitlyWait(3);

		WebElement compEle = driver.findElement(
				By.xpath("(//*[text()='Lightning Web Components']/following::span[text()='" + comp + "'])[1]"));
		objsfcommon.waitForElement(20, compEle);
		objsfcommon.scrollToElement(compEle);
		compEle.click();
	}

	@FindBy(xpath = "(//label[text()='Example']/following::input[@placeholder='Choose Example'])[1]")
	public WebElement exampleDropDown;

	public void selectFromTheExampleDropDown(String option) throws InterruptedException {
		Thread.sleep(5000);
		objsfcommon.waitTillPageLoad();
		objsfcommon.implicitlyWait(20);
		objsfcommon.waitForElement(20, exampleDropDown);
		objsfcommon.scrollToElement(exampleDropDown);
		exampleDropDown.click();
		WebElement optionEle = driver.findElement(
				By.xpath("(//input[@placeholder='Choose Example']/following::span[@title='" + option + "'])[1]"));
		objsfcommon.implicitlyWait(20);
		objsfcommon.waitForElement(20, optionEle);
		objsfcommon.scrollToElement(optionEle);
		optionEle.click();

	}

	@FindBy(xpath = "(//button[text()='Run'])[1]")
	public WebElement runButton;

	public void clickonRun() {
		objsfcommon.implicitlyWait(20);
		objsfcommon.waitForElement(20, runButton);
		objsfcommon.scrollToElement(runButton);
		runButton.click();
	}

	@FindBy(xpath = "(//label[text()='Label']/following::input)[1]")
	public WebElement labelInput;

	@FindBy(xpath = "(//span[@title='Label'])[1]")
	public WebElement labelcolumnName;

	public void editAndUpdateLabelColumnValue(String labName, String index) {
		WebElement editEle = driver.findElement(
				By.xpath("(//span[@title='Label']/following::th[@data-label='Label']//button)[" + index + "]"));
		objsfcommon.waitForElement(20, editEle);
		objsfcommon.scrollToElement(editEle);
		editEle.click();
		objsfcommon.waitForElement(20, labelInput);
		objsfcommon.scrollToElement(labelInput);
		labelInput.clear();
		labelInput.sendKeys(labName);

		objsfcommon.waitForElement(20, labelcolumnName);
		objsfcommon.scrollToElement(labelcolumnName);
		labelcolumnName.click();

	}

	@FindBy(xpath = "(//label[text()='Website']/following::input)[1]")
	public WebElement websiteInput;

	@FindBy(xpath = "(//span[@title='Website'])[1]")
	public WebElement WebsitecolumnName;

	public void editAndUpdateWebsiteColumnValue(String web, String index) {
		WebElement editEle = driver.findElement(
				By.xpath("(//span[@title='Website']/following::*[@data-label='Website']//button)[" + index + "]"));
		objsfcommon.waitForElement(20, editEle);
		objsfcommon.scrollToElement(editEle);
		editEle.click();
		objsfcommon.waitForElement(20, websiteInput);
		objsfcommon.scrollToElement(websiteInput);
		websiteInput.clear();
		websiteInput.sendKeys(web);
		objsfcommon.waitForElement(20, WebsitecolumnName);
		objsfcommon.scrollToElement(WebsitecolumnName);
		WebsitecolumnName.click();

	}

	@FindBy(xpath = "(//label[text()='Phone']/following::input)[1]")
	public WebElement phoneInput;

	@FindBy(xpath = "(//span[@title='Phone'])[1]")
	public WebElement phonecolumnName;

	public void editAndUpdatePhoneColumnValue(String web, String index) {
		WebElement editEle = driver.findElement(
				By.xpath("(//span[@title='Phone']/following::*[@data-label='Phone']//button)[" + index + "]"));
		objsfcommon.waitForElement(20, editEle);
		objsfcommon.scrollToElement(editEle);
		editEle.click();
		objsfcommon.waitForElement(20, phoneInput);
		objsfcommon.scrollToElement(phoneInput);
		phoneInput.clear();
		phoneInput.sendKeys(web);
		objsfcommon.waitForElement(20, phonecolumnName);
		objsfcommon.scrollToElement(phonecolumnName);
		phonecolumnName.click();

	}

	@FindBy(xpath = "//button[@title='Select a date']")
	public WebElement selectADateButton;

	@FindBy(xpath = "//button[@name='today']")
	public WebElement todayDatelink;

	@FindBy(xpath = "(//label[text()='Time']/following::input)[1]")
	public WebElement timeTextBox;

	@FindBy(xpath = "(//label[text()='Date']/following::input)[1]")
	public WebElement dateTextBox;

	@FindBy(xpath = "(//span[@title='CloseAt'])[1]")
	public WebElement closeAtcolumnName;

	public void editAndUpdateDatetimeColumnValue(String date, String time, String index) {
		WebElement editEle = driver.findElement(
				By.xpath("(//span[@title='CloseAt']/following::*[@data-label='CloseAt']//button)[" + index + "]"));
		objsfcommon.waitForElement(20, editEle);
		objsfcommon.scrollToElement(editEle);
		editEle.click();
//		objsfcommon.waitForElement(20, selectADateButton);
//		objsfcommon.scrollToElement(selectADateButton);
//		objsfcommon.clickByJS(selectADateButton);

		objsfcommon.waitForElement(20, dateTextBox);
		objsfcommon.scrollToElement(dateTextBox);
		dateTextBox.clear();
		dateTextBox.sendKeys(date);

		objsfcommon.waitForElement(20, timeTextBox);
		objsfcommon.scrollToElement(timeTextBox);
		timeTextBox.clear();
		timeTextBox.sendKeys(time);

		objsfcommon.waitForElement(20, closeAtcolumnName);
		objsfcommon.scrollToElement(closeAtcolumnName);
		closeAtcolumnName.click();

	}

	@FindBy(xpath = "(//label[text()='Balance']/following::input)[1]")
	public WebElement balanceInput;

	@FindBy(xpath = "(//span[@title='Balance'])[1]")
	public WebElement balancecolumnName;

	public void editAndUpdateBalanceColumnValue(String bal, String index) {
		WebElement editEle = driver.findElement(
				By.xpath("(//span[@title='Balance']/following::*[@data-label='Balance']//button)[" + index + "]"));
		objsfcommon.waitForElement(20, editEle);
		objsfcommon.scrollToElement(editEle);
		editEle.click();
		objsfcommon.waitForElement(20, balanceInput);
		objsfcommon.scrollToElement(balanceInput);
		balanceInput.clear();
		balanceInput.sendKeys(bal);

		objsfcommon.waitForElement(20, balancecolumnName);
		objsfcommon.scrollToElement(balancecolumnName);
		balancecolumnName.click();

	}

	public void switchToFrameWithIndex(String index) {
		objsfcommon.implicitlyWait(30);
		WebElement ele = driver.findElement(By.xpath("(//iframe[@name='preview'])[" + index + "]"));
		objsfcommon.waitForElement(30, ele);
		objsfcommon.scrollToElement(ele);
		driver.switchTo().frame(ele);
	}


	public String getLabelValue(String row) {
		WebElement ele = driver
				.findElement(By.xpath("(//*[@data-label='Label']//lightning-base-formatted-text)[" + row + "]"));
		objsfcommon.waitForElement(20, ele);
		objsfcommon.scrollToElement(ele);
		return ele.getText();
	}

	public String getWebsiteValue(String row) {
		WebElement ele = driver
				.findElement(By.xpath("(//*[@data-label='Website']//lightning-formatted-url/a)[" + row + "]"));
		objsfcommon.waitForElement(20, ele);
		objsfcommon.scrollToElement(ele);
		return ele.getText();
	}

	public String getPhoneValue(String row) {
		WebElement ele = driver
				.findElement(By.xpath("(//*[@data-label='Phone']//lightning-formatted-phone/a)[" + row + "]"));
		objsfcommon.waitForElement(20, ele);
		objsfcommon.scrollToElement(ele);
		return ele.getText();
	}

	public String getDateValue(String row) {
		WebElement ele = driver
				.findElement(By.xpath("(//*[@data-label='CloseAt']//lightning-formatted-date-time)[" + row + "]"));
		objsfcommon.waitForElement(20, ele);
		objsfcommon.scrollToElement(ele);
		return ele.getText();
	}

	public String getBalanceValue(String row) {
		WebElement ele = driver
				.findElement(By.xpath("(//*[@data-label='Balance']//lightning-formatted-number)[" + row + "]"));
		objsfcommon.waitForElement(20, ele);
		objsfcommon.scrollToElement(ele);
		return ele.getText();
	}

}
