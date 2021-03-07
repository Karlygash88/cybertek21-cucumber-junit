package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class SmartBearBasePage {

    public SmartBearBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Order']")
    public WebElement linkOrder;

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement buttonViewAllOrders;

    @FindBy(xpath = "//table[@class='SampleTable']//tr/td[2]")
    public List<WebElement> listOfNames;


    public boolean verifyOrder(String name){

        for (WebElement each : listOfNames){
            if (each.getText().equals(name))
                return true;
        }
        return false;
    }
}
