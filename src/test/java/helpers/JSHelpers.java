package helpers;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static utils.LogUtil.logger;



public class JSHelpers extends BaseTest {

    public static  void scrollThePageUntillElementVisible(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
        logger.info("page scrolled..");
    }
}
