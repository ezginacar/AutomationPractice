package pages;

import base.BaseTest;
import helpers.Actions;
import helpers.JSHelpers;
import helpers.SeleniumHelpers;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.SeleniumHelpers.*;
import static utils.LogUtil.*;
import static helpers.Actions.*;


public class ProductListPage extends BaseTest {
    public ProductListPage(){
        PageFactory.initElements(driver,this);
    }

    private String productContainer = "//div[@class='product-container']";
    private String rightBlock = "/div[@class='right-block']/div[@class='button-container']";
    private String addToCart = "/a[contains(@class,'add_to_cart')]";
    private String name = "/h5/a[@class='product-name']";
    private String price = "/div[@class='content_price']/span[@class = 'price product-price']";



    @FindBy(className = "cat-name")
    private WebElement categoryTitle;



    public void clickAddToCartForNTHRank(int rank ) throws InterruptedException {
       String expression = String.format("(%s)[%d]%s%s", productContainer,rank,rightBlock,addToCart);
       String container = String.format("(%s)[%d]", productContainer,rank);
       WebElement element2 = SeleniumHelpers.getElement(container);
       WebElement element3 = SeleniumHelpers.getElement(expression);

       JSHelpers.scrollThePageUntillElementVisible(element2);
       Actions.mouseHoverAndClick(element2,element3);
       try{
           WebElement element =getElement(expression);
           element.click();
           logger.info(String.format("Clicked on Add to cart button for the %d.ranked product from the product list", rank));
       }
       catch (NotFoundException e) {
           Assert.fail("No web element found with given rank");
       }
    }


    public String getProductNameForNTHRank(int rank){
        String container = String.format("(%s)[%d]", productContainer,rank);
        String expression = String.format("(%s)[%d]%s%s", productContainer,rank,rightBlock,name);

        WebElement element1 = SeleniumHelpers.getElement(expression);
        WebElement element2 = SeleniumHelpers.getElement(container);
        JSHelpers.scrollThePageUntillElementVisible(element2);

        mouseHover(element1);
        logger.info(String.format("Hovered on the %d. product to see product details"));

        return element2.getText();

    }

    public Double getProductPriceeForNTHRank(int rank){
        String container = String.format("(%s)[%d]", productContainer,rank);
        String expression = String.format("(%s)[%d]%s%s", productContainer,rank,rightBlock,price);

        WebElement element1 = SeleniumHelpers.getElement(expression);
        WebElement element2 = SeleniumHelpers.getElement(container);
        JSHelpers.scrollThePageUntillElementVisible(element2);

        mouseHover(element1);
        logger.info(String.format("Hovered on the %d. product to see product details"));

        String str = element2.getText();
        return Double.parseDouble(str);

    }



    public void validateCategoryTitle(String expectedTitle){
        String actual = categoryTitle.getText();
        if(actual.endsWith(" ")){
            actual = actual.substring(0, actual.length() - 1);
        }
        if(!actual.equals(expectedTitle)){
            Assert.fail(String.format( "Expected title (%s) is not equal to actual (%s)", expectedTitle, actual));
        }

    }
}
