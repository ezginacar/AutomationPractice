package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import pages.HomePage;
import pages.MyAccount;

import java.util.Iterator;
import java.util.List;
import static helpers.SeleniumHelpers.*;
import static utils.PropertyUtil.*;
import static utils.LogUtil.logger;

public class LoginSteps {
    MyAccount account = new MyAccount();
    HomePage homePage =new HomePage();

    @When("^Try to login with given infos below:$")
    public void login(DataTable dataTable){
        List<String> data = dataTable.row(1);
        String mail = data.get(0);
        String passwd = data.get(1);

        account.login(mail,passwd);
        Assert.assertTrue(visibilityOfElement(homePage.accountButton));
    }

    @When("^Login with valid user account informations$")
    public void loginWithValidUser(){
        String mail =getProperties("login.mail");
        String password =getProperties("login.password");

        account.login(mail,password);
        Assert.assertTrue(visibilityOfElement(homePage.accountButton));

    }


    @Then("^Should seen account button$")
    public void shouldSeenAccountButton(){
        Boolean visibility = homePage.accountButton.isDisplayed();
        Assert.assertTrue(visibility);
        logger.info("Login success!");
    }
}
