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
import product.ProductFactory;

import static helpers.SeleniumHelpers.*;

import static utils.LogUtil.*;
import static helpers.Actions.*;


public class ProductListPage extends BaseTest {
    public ProductListPage(){
        PageFactory.initElements(driver,this);
    }

    ProductFactory productFactory =  ProductFactory.getProductInstance();

    private String productContainer = "//div[@class='product-container']";
    private String rightBlock = "/div[@class='right-block']";
    private String butonContainer ="/div[@class='button-container']";
    private String addToCart = "/a[contains(@class,'add_to_cart')]";
    private String name = "/h5/a[@class='product-name']";
    private String price = "/div[@class='content_price']/span[contains(@class,'product-price')]";



    @FindBy(className = "cat-name")
    private WebElement categoryTitle;



    public void clickAddToCartForNTHRank(int rank ) throws InterruptedException {
       String expression = String.format("(%s)[%d]%s%s%s", productContainer,rank,rightBlock,butonContainer,addToCart);
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

        //mouseHover(element1);
        logger.info(String.format("Hovered on the %d. product to see product details", rank));

        String productName = element1.getText();
        logger.info("Product name -> "+ productName);

        return productName;

    }

    public Double getProductPriceeForNTHRank(int rank) throws InterruptedException {
        String container = String.format("(%s)[%d]", productContainer,rank);
        String expression = String.format("(%s)[%d]%s%s", productContainer,rank,rightBlock,price);

        WebElement element1 = SeleniumHelpers.getElement(expression);
        WebElement element2 = SeleniumHelpers.getElement(container);
        JSHelpers.scrollThePageUntillElementVisible(element2);
        //mouseHover(element2);
        logger.info(String.format("Hovered on the %d. product to see product details", rank));

        String str = element1.getText();
        logger.info("Product price -> " + str);
        String str2 = str.replace("$", "");
        return Double.parseDouble(str2);

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
