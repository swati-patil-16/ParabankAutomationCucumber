package stepdefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    String loginPageTitle;
    String accountPageTitle;



    @Given("user is on login page")
    public void user_is_on_login_page() {
      DriverFactory.getDriver().get("https://parabank.parasoft.com/");
    }

    @When("user gets the title of the {string} page")
    public void user_gets_the_title_of_the_page(String pageName) {
        if(pageName.equals("login")){
        loginPageTitle= loginPage.getPageTitle();
        }

        else if(pageName.equals("Account"))
        {
            accountPageTitle=loginPage.getPageTitle();
            System.out.println(accountPageTitle);
        }
    }

    @Then("{string} page title should be {string}")
    public void page_title_should_be(String pageName, String expectedTitle) {
        if(pageName.equals("login")) {
            Assert.assertTrue(loginPageTitle.equals(expectedTitle));
        }
        else if(pageName.equals("Account"))
        {
            Assert.assertTrue(accountPageTitle.equals(expectedTitle));
        }

    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.ifForgetPasswordLinkExists());
    }

    @When("user enters username {string}")
    public void user_enters_username(String uname) {
           loginPage.enterUserName(uname);
    }

    @When("user enters password {string}")
    public void user_enters_password(String pass) {
      loginPage.enterPassword(pass);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
      loginPage.clickOnLogin();
    }


}
