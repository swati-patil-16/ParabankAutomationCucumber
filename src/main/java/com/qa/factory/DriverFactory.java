package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver webDriver;
    public static  ThreadLocal<WebDriver> tldriver= new ThreadLocal<>();

    public  WebDriver init_driver(String browserName){
        if(browserName.equals("chrome"))
        {

            tldriver.set(new ChromeDriver());
        }
        else if(browserName.equals("edge"))
        {
            tldriver.set(new EdgeDriver());
        }
        else if (browserName.equals("Firefox"))
        {
            tldriver.set(new FirefoxDriver());
        }
        else
        {
            System.out.println("please pass correct browser value" + browserName);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {
        return tldriver.get();
    }
}
