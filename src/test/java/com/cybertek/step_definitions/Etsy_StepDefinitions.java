package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Etsy_StepDefinitions {
    EtsySearchPage etsySearchPage = new EtsySearchPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsyUrl"));
    }

    @Then("user should see title as expected")
    public void user_should_see_title_as_expected() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("user searches for {string}")
    public void userSearchesFor(String string) {
        etsySearchPage.searchBox.sendKeys(string+ Keys.ENTER);
    }

    @Then("user should see {string} in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String expected) {
        String actualTitle = Driver.getDriver().getTitle();
        wait.until(ExpectedConditions.titleContains(expected));
        Assert.assertTrue(actualTitle.contains(expected));
    }
}
