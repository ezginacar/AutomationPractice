package pages;

import base.BaseTest;
import helpers.JSHelpers;
import helpers.SeleniumHelpers;
import jdk.internal.instrumentation.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import product.Product;
import product.ProductFactory;

import static org.junit.Assert.assertEquals;
import static utils.LogUtil.logger;

import java.beans.Expression;
import java.rmi.server.ExportException;
import java.util.Iterator;
import java.util.List;

public class OrderPage extends BaseTest {

    ProductFactory productFactory = ProductFactory.getProductInstance();

    public OrderPage() {
        PageFactory.initElements(driver, this);
    }
/*
    private String productList = "//table[@id='cart_summary']/tbody/tr[contains(@id, 'product')]";
    private String cartQuantityInput = "td[contains(@class,'cart_quantity')]";
    private String  totalPriceSingleProduct = ("/td[@class='cart_total']";
*/
    private String productRow ="//tbody/tr[contains(@class,'cart_item')]";
    private String productName = "/td[@class='cart_description']/p[@class='product-name']";
    private String productUnitPrice = "/td[@class='cart_unit']/span[@class='price']";
    private String productCartTotal = "/td[@class='cart_total']/span[@class='price']";
    private String value = "/a";


    @FindBy(xpath = "(//table[@id='cart_summary']/tfoot/tr[@class='cart_total_price'])[3]/td[@id='total_price_container']/span[@id= 'total_price']")
    private WebElement totalPriceAmount;

    @FindBy(css ="a[class='cart_quantity_delete']")
    private List<WebElement> deleteButtonList;

    @FindBy(id ="cart_title")
    public WebElement orderTitle;


    public void validateOrdersWithProductList(){
        for (Product product : productFactory.getProducts()) {
           String name =  product.getName();
           Double price = product.getPrice();
           String prodNames = productRow + productName + value;
           String prodPrices = productRow + productUnitPrice ;

           try {
               List<WebElement> productNames = SeleniumHelpers.getElementList(prodNames);
               JSHelpers.scrollThePageUntillElementVisible(productNames.get(0));

               List<WebElement> productPrices = SeleniumHelpers.getElementList(prodPrices);

               try {
                   int i = SeleniumHelpers.getIndexOnList(productNames, name);
                   String p = productPrices.get(i).getText().replace("$","");
                   Double act = Double.parseDouble(p);

                   Assert.assertEquals(price, act);

               }catch (Exception e) {
                   Assert.fail(String.format("Expected product '%s' not found on the cart", name));
               }

           }catch (Exception e){

           }


        }
    }





    public void removeCart(){
        int i = deleteButtonList.size();
        while (i >0) {
            deleteButtonList.get(0);
            i = i -1 ;
        }
        logger.info("Removed all products from the cart");
    }

}
