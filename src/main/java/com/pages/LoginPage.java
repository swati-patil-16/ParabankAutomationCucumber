package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  {

    private WebDriver driver;
    private By username = By.name("username");
    private By password = By.name("password");
    private By button = By.className("login");
    private By forgetPassWordLink = By.linkText("Forgot login info?");

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public boolean ifForgetPasswordLinkExists()
    {
        return driver.findElement(forgetPassWordLink).isDisplayed();
    }

    public void enterUserName(String user_name)
    {
        driver.findElement(username).sendKeys(user_name);
    }

    public void enterPassword(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickOnLogin()
    {
        driver.findElement(button).click();
    }

    public AccountPage doLogin(String user_name, String pass)
    {
        driver.findElement(username).sendKeys(user_name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(button).click();
        return new AccountPage(driver);

    }

}
