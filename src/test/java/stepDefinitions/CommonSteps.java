package stepDefinitions;

import cucumber.api.cli.*;
import helpers.SeleniumHelpers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import pages.HomePage;

import static utils.LogUtil.*;
import static helpers.SeleniumHelpers.*;

public class CommonSteps {
    HomePage homePage = new HomePage();

    @Given("^Navigate to the homepage$")
    public void navigateURL() throws InterruptedException {
        SeleniumHelpers.navigateURL();
    }

    @Then("^Should be at \"(.*?)\" page$")
    public void validateURLPath(String path){
        homePage.validatePath(path);
    }

    @When("^Click on the Sign in button$")
    public void clickSignInOutButton() throws InterruptedException {
        SeleniumHelpers.wait(2);
        homePage.clickSignInButton();
    }

    @Then("^Should seen Sign out button$")
    public void shouldSeenSignInOutButton(){
        String text = homePage.signInButton.getText();
        Assert.assertEquals("Sign in", text);

    }


    @Then("^Should see product quantity as Cart (\\d+) on the order button$")
    public void validateCartQuantity(int quantity) throws InterruptedException {
       int i =  homePage.cartProductAmount();
       Assert.assertEquals(i ,quantity);
    }


}
