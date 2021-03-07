package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage {

    public SmartBearLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement inputUsername;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement inputPassword;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement buttonLogin;

    //login method without parameters
    public void loginToSmartBear(){
        inputUsername.sendKeys(ConfigurationReader.getProperty("smartBearUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("smartBearPassword"));
        buttonLogin.click();

    }

    // overloaded version
    public void loginToSmartBear(String userName, String password){
        inputUsername.sendKeys(userName);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }



}
