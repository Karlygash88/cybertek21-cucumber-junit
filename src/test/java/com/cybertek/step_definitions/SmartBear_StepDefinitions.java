package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.pages.SmartBearOrderPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class SmartBear_StepDefinitions {
    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage();
    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();

    @Given("User logs in Smart Bear")
    public void user_logs_in_smart_bear() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearUrl"));
        smartBearLoginPage.loginToSmartBear();
    }

    @When("User goes to Order Page")
    public void user_goes_to_order_page() {
        smartBearOrderPage.linkOrder.click();

    }

    @Then("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String string) {
        Select select = new Select(smartBearOrderPage.dropdownProduct);
        select.selectByVisibleText(string);

    }

    @Then("User enters {string} to quantity")
    public void user_enters_to_quantity(String string) {
        smartBearOrderPage.inputQuantity.sendKeys(Keys.BACK_SPACE + string);
    }

    @Then("User enters {string} to customer name")
    public void user_enters_to_customer_name(String string) {
        smartBearOrderPage.inputCustomerName.sendKeys(string);
    }

    @Then("User enters {string} to street")
    public void user_enters_to_street(String string) {
        smartBearOrderPage.inputStreet.sendKeys(string);
    }

    @Then("User enters {string} to city")
    public void user_enters_to_city(String string) {
        smartBearOrderPage.inputCity.sendKeys(string);
    }

    @Then("User enters {string} to state")
    public void user_enters_to_state(String string) {
        smartBearOrderPage.inputState.sendKeys(string);
    }

    @Then("User enters {string} to zip")
    public void user_enters_to_zip(String string) {
        smartBearOrderPage.inputZip.sendKeys(string);
    }

    @Then("User selects {string} as card type")
    public void user_selects_as_card_type(String string) {
        switch (string.toLowerCase()) {
            case "visa":
                smartBearOrderPage.radioVisa.click();
                break;
            case "master card":
                smartBearOrderPage.radioMasterCard.click();
                break;
            case "american express":
                smartBearOrderPage.radioAmEx.click();
                break;
        }
    }

    @Then("User enters {string} to card number")
    public void user_enters_to_card_number(String string) {
        smartBearOrderPage.inputCardNumber.sendKeys(string);
    }

    @Then("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String string) {
        smartBearOrderPage.inputExpireDate.sendKeys(string);
    }

    @Then("User clicks process button")
    public void user_clicks_process_button() {
        smartBearOrderPage.buttonProcess.click();
    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String string) {
        smartBearOrderPage.buttonViewAllOrders.click();
        Assert.assertTrue(smartBearOrderPage.verifyOrder(string));
    }


    @Then("user enters address information")
    public void user_enters_address_information(Map<String, String> addressInfo) {
        smartBearOrderPage.inputCustomerName.sendKeys(addressInfo.get("customerName"));
        smartBearOrderPage.inputStreet.sendKeys(addressInfo.get("street"));
        smartBearOrderPage.inputCity.sendKeys(addressInfo.get("city"));
        smartBearOrderPage.inputState.sendKeys(addressInfo.get("state"));
        smartBearOrderPage.inputZip.sendKeys(addressInfo.get("zip"));

    }

    @Then("user enters payment information")
    public void user_enters_payment_information(Map<String, String> paymentInfo) {
        user_selects_as_card_type(paymentInfo.get("cardType"));
        smartBearOrderPage.inputCardNumber.sendKeys(paymentInfo.get("cardNumber"));
        smartBearOrderPage.inputExpireDate.sendKeys(paymentInfo.get("expirationDate"));

    }

    @Then("user should see their name in the ViewAllOrders page")
    public void user_should_see_their_name_in_the_view_all_orders_page() {

        smartBearOrderPage.buttonViewAllOrders.click();
        Assert.assertTrue(smartBearOrderPage.verifyOrder("jamal"));
    }


}
