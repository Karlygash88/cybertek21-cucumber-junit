package com.cybertek.step_definitions;

import com.cybertek.pages.DropdownsPage;
import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DataTables_StepDefinitions {
    SmartBearLoginPage smartBearLoginPage =new SmartBearLoginPage();
    DropdownsPage dropdownsPage = new DropdownsPage();

    @Then("User should see something")
    public void user_should_see_something(List<String> fruitList) {
        System.out.println("fruitList.size() = " + fruitList.size());
    }

    @Given("User is on the login page of SmartBear")
    public void user_is_on_the_login_page_of_smart_bear() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearUrl"));
    }


    @When("User enters below info")
    public void user_enters_below_info(Map<String, String> loginInfo) {
        String userName = loginInfo.get("username");
        String password = loginInfo.get("password");

        smartBearLoginPage.loginToSmartBear(userName, password);

    }
    @Then("User should see title changed to Web Orders")
    public void user_should_see_title_changed_to_web_orders() {
        BrowserUtils.titleVerification("Web Orders");

    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {

        Driver.getDriver().get(ConfigurationReader.getProperty("cybertekPracticeUrl"));

    }


    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {
        Select select = new Select(dropdownsPage.monthDropdown);
        List<WebElement> monthsAsWebElement = select.getOptions();

        List<String> monthsAsString = new ArrayList<>();

        monthsAsString = BrowserUtils.getElementsText(monthsAsWebElement);

        Assert.assertTrue(expectedList.equals(monthsAsString));



    }
}
