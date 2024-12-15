package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {

    private WebDriver driver;
    private By accountSection = By.xpath("//div[@id='leftPanel']/ul/li");


    public AccountPage(WebDriver driver)
    {
        this.driver=driver;
    }



    public int getAccountSectionCount()
    {
        List<WebElement> li = driver.findElements(accountSection);
        return li.size();
    }

    public List<String> getAccountSectionList()
    {
         List<WebElement> li1 = driver.findElements(accountSection);
         List<String> list = new ArrayList<>();
         for(WebElement e : li1)
         {
             list.add(e.getText());
         }

         return list;
    }
    
}
