package com.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Locators {
WebDriver driver;
String workingDir = System.getProperty("user.dir");
public static String Price;
	
	public Locators(WebDriver driver) 
	{           
	   this.driver = driver; 
	   PageFactory.initElements(driver, this);
	}
	
	
///////////////////////////////////////// Locators ///////////////////////////////////////////////	
	@FindBy(xpath="//*[@id='src']") public WebElement tf_Source;
	@FindBy(xpath="//*[@id='dest']") public WebElement tf_Destination;
	@FindBy(xpath="//*[@id='search_btn']") public WebElement btn_search;
	@FindBy(xpath="//*[@id='search']/div/div[3]/div/label") public WebElement tf_Date;
	@FindBy(xpath="(//*[text()='Non A/C Seater (2+2)']/following::div[text()='View Seats'])[1]") public WebElement btn_ViewSeat;
	@FindBy(xpath="//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[1]/ul/li[1]/div[3]/preceding-sibling::div[@class='radio-css ']") public WebElement rb_BoardingPoint;
	@FindBy(xpath="//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/ul/li[1]/div[3]/preceding-sibling::div[@class='radio-css ']") public WebElement rb_DroppingPoint;
	@FindBy(xpath="//div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[1]/div[2]/div[4]/span[2]/span[2]") public WebElement txt_Price;
	@FindBy(xpath="//*[text()='Proceed to book']") public WebElement btn_ProceedToPay;
	@FindBy(xpath="//*[@id='root']/div/div[5]/div[2]/div/div[5]/div/div[2]/div/label[2]/span") public WebElement rb_NoInsurance;
	@FindBy(xpath="//*[@id='root']/div/div[5]/div[3]/div/div[1]/div[2]/span") public WebElement txt_FinalPrice;
	@FindBy(xpath="//*[@id='search']/div/div[1]/div/ul/li[1]") public WebElement click_Option;
	@FindBy(xpath="//*[@id='search']/div/div[2]/div/ul/li[1]") public WebElement click_Doption;
	@FindBy(xpath="//*[@id='page_main_header']/nav/ul/li[2]/a") public WebElement tab_Hotel;
	@FindBy(xpath="//*[@id='search_key']") public WebElement tf_Hotel;
	@FindBy(xpath="//*[@id='search_wrapper']/div[2]/div/div[1]/div[1]/span[1]") public WebElement select_Address;
	@FindBy(xpath="//*[@id='search_hotel']") public WebElement btn_Search;
	@FindBy(xpath="//*[@id='root']/div/div[3]/div[1]") public WebElement pop_Up;
	@FindBy(xpath="//*[@id='root']/div/div[3]/div[2]/div[2]/span") public WebElement byn_Ok;
	

///////////////////////////////////////// Action Methods ///////////////////////////////////////////////		
	public void enterSource(String name) {
		tf_Source.sendKeys(name);
		click_Option.click();
	}
	
	public void enterDestination(String name) {
		tf_Destination.sendKeys(name);
		click_Doption.click();
	}
	
	public void enterDate(String date) {
		tf_Date.click();
		String D = "//*[@id='rb-calendar_onward_cal']/table/tbody/tr[7]/td[text()='"+date+"']";
		driver.findElement(By.xpath(D)).click();
	}
	
	public void clickNonACBus() {
		if(pop_Up.isDisplayed()) {
			byn_Ok.click();
		}
		btn_ViewSeat.click();
		btn_ViewSeat.click();
	}
	
	public void selectBordingPoint() {
		rb_BoardingPoint.click();
	}
	
	public void selectDroppingPoint() {
		rb_DroppingPoint.click();
	}
	
	public String getPice() { 
        return Price; 
    }
	
	public void setPice() { 
       this.Price =txt_Price.getText();
    }
	
	public void clickProceedButton() { 
		btn_ProceedToPay.click();
	    }
	
	public void checkNoInsurance() { 
		rb_NoInsurance.click();
	    }
	
	public void validatePrice() {
		String finalPrice = txt_FinalPrice.getText();
		if(Locators.Price.equalsIgnoreCase(finalPrice)) {
			System.out.println("Price value is same as Boarding Page");
		}else {
			System.out.println("Validation fail, Price is not same");
		}
	    }
	
	public void selectSeat() throws FindFailed { 
		Screen s = new Screen();
		s.click(workingDir + "/pic/seat.png",0);
		s.click(workingDir + "/pic/seat.png",1);
	    }
	
	public void selectHotel() {
		tab_Hotel.click();
	}
	
	public void enterAddress(String name) {
		tf_Hotel.sendKeys(name);
		select_Address.click();
	}
	
	public void clickSearch() {
		btn_Search.click();
	}
	
	public void validateAddress() {
		List<WebElement> ls = driver.findElements(By.xpath("//*[@class='hotel-location truncate']"));
		for(int i=0; i<=ls.size()-1;i++) {
			if(ls.get(i).getText().contains("Andheri, Mumbai")) {
				System.out.println("Correct Result Is Displayed");
			}else {
				System.out.println("Validation fail for element in : "+i );
			}
		}
	}
}
