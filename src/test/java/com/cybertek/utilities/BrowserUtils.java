package com.cybertek.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {


    public static void titleVerification(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            System.out.println("Can't handle sleep method");
        }
    }

    public static void hoover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement each : list)
            elemTexts.add(each.getText());
        return elemTexts;
    }
}
