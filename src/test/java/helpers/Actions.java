package helpers;

import base.BaseTest;
import org.openqa.selenium.WebElement;

import static helpers.SeleniumHelpers.waitUntillVisibilityOfElement;


public class Actions extends BaseTest {

    static org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);

    public static void mouseHoverAndClick(WebElement hoverElement, WebElement clickElement) throws InterruptedException {

        actions.moveToElement(hoverElement).perform();
        waitUntillVisibilityOfElement(clickElement);
        actions.moveToElement(hoverElement).click(clickElement).build().perform();
    }


    public static void mouseHover(WebElement element){
        actions.moveToElement(element).perform();
    }


}
