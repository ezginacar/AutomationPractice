package pages;

import base.BaseTest;
import jdk.internal.instrumentation.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import static utils.LogUtil.logger;

import java.util.List;

public class OrderPage extends BaseTest {

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


    @FindBy(xpath = "(//table[@id='cart_summary']/tfoot/tr[@class='cart_total_price'])[3]/td[@id='total_price_container']/span[@id= 'total_price']")
    private WebElement totalPriceAmount;

    @FindBy(css ="a[class='cart_quantity_delete']")
    private List<WebElement> deleteButtonList;










    public void getTotalPrice(double taxPrice, double shippingPrice) {

        shippingPrice = 2.00;
        taxPrice = 0;




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
