package helpers;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import java.util.concurrent.TimeUnit;

import static utils.PropertyUtil.getProperties;
import static utils.LogUtil.logger;

public class SeleniumHelpers extends BaseTest {

    public static void navigateURL() throws InterruptedException {
        String url = getProperties("mainurl");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait(5);
        driver.manage().window().maximize();
        logger.info("Navigated to-> "+url);
    }

    public static void click(WebElement element) {
        element.click();
        logger.info(String.format("Clicked on '%s'\n", element));
    }
    public static void sendKeys(WebElement element, String text){

        element.sendKeys(text);
        logger.info(String.format("Typed '%s' \n", text));
    }

    public static String getText(WebElement element ){return element.getText();}

    public static Boolean visibilityOfElement(WebElement element){
        Boolean visibility = false;
        if(element.isDisplayed())
            visibility = true;

        return visibility;
    }

    public static void waitUntillVisibilityOfElement(WebElement element){
        WebDriverWait wait =new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void wait(int seconds) throws InterruptedException {
        logger.info(String.format("Waiting for %d seconds...",seconds));
        Thread.sleep(seconds * 1000);

    }


    public static Integer getIndexOnList(List<WebElement> elements, String text) {
        int value = -1;
        for(int i =0; i<elements.size(); i++){
            WebElement element = elements.get(i);

            String actual = getText(element);
            if(actual.equals(text)) {
                value =i;
                break;

            }

        }
        return value;
    }

    public static List<WebElement> getElementList(String expression){
        return driver.findElements(By.xpath(expression));
    }

    public static WebElement getElement(String expression){
        return driver.findElement(By.xpath(expression));
    }


    public static void mouseHover(WebElement hoverElement) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();

    }






}
