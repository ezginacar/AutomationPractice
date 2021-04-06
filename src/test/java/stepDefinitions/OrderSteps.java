package stepDefinitions;

import helpers.SeleniumHelpers;
import io.cucumber.java.en.Given;

import org.junit.Assert;
import pages.HomePage;
import pages.OrderPage;
import product.ProductFactory;


import static utils.LogUtil.logger;

public class OrderSteps {
    HomePage homePage = new HomePage();
    OrderPage orderPage = new OrderPage();

    @Given("^Remove the cart if it is not empty$")
    public void removeCart() throws InterruptedException {
        SeleniumHelpers.wait(3);
       // ProductFactory.products.clear();
        if(homePage.cartProductAmount() != 0)
            homePage.clickCartButton();
            orderPage.removeCart();

        Assert.assertEquals(homePage.cartProductAmount(),0);
        logger.info("Cart is empty");
    }
}
