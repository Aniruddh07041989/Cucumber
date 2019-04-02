package com.stepDefination;

import org.openqa.selenium.WebDriver;

import com.pages.Locators;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefination {
 WebDriver driver = Hook.driver;
	
	@Given("^User is on home screen$")
	public void user_is_on_home_screen() throws Throwable {
     System.out.println("Üser is on home scree");
	}

	@Then("^User enter source as \"([^\"]*)\"$")
	public void user_enter_source_as(String arg1) throws Throwable {
        Locators ls = new Locators(driver);
        ls.enterSource(arg1); 
	}

	@Then("^User enter destination as \"([^\"]*)\"$")
	public void user_enter_destination_as(String arg1) throws Throwable {
		Locators ls = new Locators(driver);
		ls.enterDestination(arg1);
	}

	@Then("^User select \"([^\"]*)\" of journey$")
	public void user_select_of_journey(String arg1) throws Throwable {
		Locators ls = new Locators(driver);
		ls.enterDate(arg1);
	}

	@Then("^User click on search bus button$")
	public void user_click_on_search_bus_button() throws Throwable {
		Locators ls = new Locators(driver);
		ls.btn_search.click();
		Thread.sleep(10000);
	}


	@Then("^User select non-ac bus and click on view seat$")
	public void user_select_non_ac_bus() throws Throwable {
		Locators ls = new Locators(driver);
		ls.clickNonACBus();
        Thread.sleep(5000);
	}


	@Then("^User select seat$")
	public void user_select_seat() throws Throwable {
		Locators ls = new Locators(driver);
		ls.selectSeat();
		
	}

	@Then("^User select boarding point$")
	public void user_select_boarding_point() throws Throwable {
		Locators ls = new Locators(driver);
		ls.selectBordingPoint();
	}

	@Then("^User select dropping point$")
	public void user_select_dropping_point() throws Throwable {
		Locators ls = new Locators(driver);
		ls.selectDroppingPoint();
	}

	@Then("^User click on proceed to payment$")
	public void user_click_on_proceed_to_payment() throws Throwable {
		Locators ls = new Locators(driver);
		ls.setPice();
		ls.clickProceedButton();
	}

	@Then("^User unselect insurance option$")
	public void user_unselect_insurance_option() throws Throwable {
		Locators ls = new Locators(driver);
		ls.checkNoInsurance();
	}

	@Then("^User validate amount$")
	public void user_validate_amount() throws Throwable {
		Locators ls = new Locators(driver); 
		ls.validatePrice(); 
	}

	@Then("^User click on hotel option$")
	public void user_click_on_hotel_option() throws Throwable {
		 Locators ls = new Locators(driver);
         ls.selectHotel();
	}

	@Then("^User enter area \"([^\"]*)\"$")
	public void user_enter_area(String arg1) throws Throwable {
		Locators ls = new Locators(driver);
		ls.enterAddress(arg1);
	}

	@Then("^User click on search button$")
	public void user_click_on_search_button() throws Throwable {
		Locators ls = new Locators(driver);
		ls.clickSearch();
		Thread.sleep(10000);
	}

	@Then("^User validate result$")
	public void user_validate_result() throws Throwable {
		Locators ls = new Locators(driver);
		 ls.validateAddress();
	}



}
