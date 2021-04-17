package pages;

import base.BaseTest;
import helpers.JSHelpers;
import helpers.SeleniumHelpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static helpers.SeleniumHelpers.*;
import static utils.LogUtil.*;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);

    }

    private String categories = "//div[@id='block_top_menu']/ul[contains(@class, 'menu-content')]/li";
    private String name = "/a";
    private String subCategory = "/ul[contains(@class, 'submenu-container')]/li/a";

    @FindBys({
            @FindBy(css =".header_user_info>.login"),
    })
    public WebElement signInButton;

    @FindBy(css = ".header_user_info>a.account")
    public WebElement accountButton;


    @FindBy(css = "div.shopping_cart>a>span[class^='ajax_cart_quantity']")
    private WebElement cartQuantity;

    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    private WebElement shoppingCartButton;

    @FindBy(css = "div.shopping_cart>a")
    public WebElement cartButton;




    public void clickSignInButton(){
        visibilityOfElement(signInButton);
        String text = signInButton.getText();
        signInButton.click();
        logger.info(String.format("Clicked on '%s' button",text));

    }

    public void validatePath(String path){
        String actualURL =driver.getCurrentUrl();
        if(actualURL.contains(path)){
            logger.info(String.format("User at ' %s ' path",path));
        }else{
            Assert.fail(String.format("User is not at ' %s ' as expected. Actual url is : ' %s ' ", path,actualURL));
        }
    }


    //find and click the related category
    public void clickCategory(String catName){
        String text = categories + name;
        List<WebElement> elements = getElementList(text);
        int i = getIndexOnList(elements, catName);
        elements.get(i).click();
        logger.info(String.format("Clicked on ' %s ' category on the top menu", catName));
    }

    public void hoverAndClickSubcategory(String category, String subCtgry) throws InterruptedException {
        String text = categories + name;
        List<WebElement> categoryList = getElementList(text);
        JSHelpers.scrollThePageUntillElementVisible(categoryList.get(0));

        int i = getIndexOnList(categoryList, category);
        WebElement categoryElement = categoryList.get(i);
        SeleniumHelpers.mouseHover(categoryElement);
        String subcategories = String.format("(%s)[%d]%s",categories,i+1, subCategory);

        List<WebElement> subCategoryList = getElementList(subcategories);
        int j = getIndexOnList(subCategoryList, subCtgry);
        WebElement subCategoryElement = subCategoryList.get(j);
        subCategoryElement.click();
        logger.info(String.format("Clicked on ' %s ' subcategory under ' %s ' category",subCategory,category));
    }

    public int cartProductAmount() throws InterruptedException {

        int i = -1;
        String quantity = cartQuantity.getText();
        if(quantity.equals("")){
            i =0;
        } else {
            i = Integer.parseInt(quantity);
        }
        return i;
    }

    public void clickCartButton(){
        shoppingCartButton.click();
        logger.info("Clicked on the Cart button");
    }




}
