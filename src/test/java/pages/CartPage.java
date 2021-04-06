package pages;

import base.BaseTest;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseTest {

    public CartPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id='layer_cart']/div[@class='clearfix']/div[contains(@class,'layer_cart_product')]/*[@class='cross']")
    public WebElement cartClosePopup;

    @FindBy(xpath = "//div[@id='layer_cart']/div[@class='clearfix']/div[contains(@class,'layer_cart_cart')]/div[@class='button-container']/a")
    private WebElement proceedToCheckoutButton;








}
