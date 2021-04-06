package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static helpers.SeleniumHelpers.*;

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
        sendKeys(loginEmailInput,mail);
        visibilityOfElement(loginEmailInput);
        sendKeys(loginPasswordInput,password);
        loginSubmitButton.click();

    }

}
