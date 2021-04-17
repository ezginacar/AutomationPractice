package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.CartPage;

import static utils.LogUtil.logger;

public class CartSteps {
    CartPage cart  = new CartPage();


    @Then("^Close the popup$")
    public void closeThePopup(){
        cart.closePopup();

    }


}
