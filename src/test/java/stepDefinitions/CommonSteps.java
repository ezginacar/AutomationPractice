package stepDefinitions;

import cucumber.api.cli.*;
import helpers.SeleniumHelpers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import pages.HomePage;
import pages.OrderPage;

import static utils.LogUtil.*;
import static helpers.SeleniumHelpers.*;

public class CommonSteps {
    HomePage homePage = new HomePage();
    OrderPage orderPage = new OrderPage();

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
    public void shouldSeenSignOutButton(){
        String text = homePage.signOutButton.getText();
        try {
            Assert.assertEquals("Sign out", text);
            logger.info("Signout button seemed");
        }catch (Exception e){
            Assert.fail("Expected button, Sign out not seemed ");
        }

    }


    @Then("^Should see product quantity as Cart (\\d+) on the order button$")
    public void validateCartQuantity(int quantity) throws InterruptedException {
       int i =  homePage.cartProductAmount();
       Assert.assertEquals(i ,quantity);
    }


    @When("Click on the Cart button")
    public void click_on_the_cart_button() {
        homePage.cartButton.click();
        logger.info("Clicked on Cart to see order details..");

        SeleniumHelpers.waitUntillVisibilityOfElement(orderPage.orderTitle);

    }


}
