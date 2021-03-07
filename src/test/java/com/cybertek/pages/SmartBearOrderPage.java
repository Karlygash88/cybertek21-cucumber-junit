package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearOrderPage extends SmartBearBasePage {

    public SmartBearOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement dropdownProduct;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement inputQuantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    public WebElement inputPricePerUnit;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    public WebElement inputDiscount;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    public WebElement inputTotal;

    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement buttonCalculate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement inputCustomerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement inputStreet;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement inputCity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement inputState;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement inputZip;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement radioVisa;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement radioMasterCard;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement radioAmEx;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement inputCardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement inputExpireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement buttonProcess;


}
