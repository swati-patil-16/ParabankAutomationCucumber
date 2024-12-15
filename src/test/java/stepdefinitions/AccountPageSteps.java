package stepdefinitions;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountPageSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    AccountPage accountPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable)
    {
        List<Map<String,String>> credList = dataTable.asMaps();
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");
        accountPage = loginPage.doLogin(username,password);


    }

    @And("accounts section count should be {string}")
    public void accountsSectionCountShouldBe(String c) {
        int n = accountPage.getAccountSectionCount();
        int a = Integer.getInteger(c);
        Assert.assertEquals(n,a);
    }

    @Then("user gets accounts services")
    public void userGetsAccountsServices(DataTable dataTable) {
        List<String> expectedList= dataTable.asList();
        List<String> list = accountPage.getAccountSectionList();
        Assert.assertTrue(expectedList.contains(list));

    }
}
