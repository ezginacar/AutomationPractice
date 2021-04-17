package pages;

import base.BaseTest;
import helpers.SeleniumHelpers;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.LogUtil.logger;

public class CartPage extends BaseTest {

    public CartPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='layer_cart']/div[@class='clearfix']/div[contains(@class,'layer_cart_product')]/*[@class='cross']")
    private WebElement cartClosePopup;

    @FindBy(xpath = "//div[@id='layer_cart']/div[@class='clearfix']/div[contains(@class,'layer_cart_cart')]/div[@class='button-container']/a")
    private WebElement proceedToCheckoutButton;



    public void closePopup(){
        try{
            cartClosePopup.click();
        }
        catch (NoSuchElementException e){
            SeleniumHelpers.waitUntillVisibilityOfElement(cartClosePopup);
            Assert.assertTrue("Close button for the cart popup is not visible",cartClosePopup.isDisplayed());
            cartClosePopup.click();
        }
        logger.info("Cart popup is closed");
    }








}
