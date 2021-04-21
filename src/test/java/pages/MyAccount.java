package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static helpers.SeleniumHelpers.*;
import static utils.LogUtil.logger;

public class MyAccount extends BaseTest {

    public MyAccount() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement loginEmailInput;

    @FindBy(id="passwd")
    private WebElement loginPasswordInput;


    @FindBy(id ="SubmitLogin")
    private WebElement loginSubmitButton;


    public void login(String mail, String password) {
        visibilityOfElement(loginEmailInput);
        loginEmailInput.sendKeys(mail);
        logger.info(String.format("Typed '%s' on email field ",mail));
        visibilityOfElement(loginEmailInput);
        loginPasswordInput.sendKeys(password);
        logger.info(String.format("Typed '%s' on password field ", password));
        loginSubmitButton.click();
        logger.info("Clicked on login submit button");

    }

}
