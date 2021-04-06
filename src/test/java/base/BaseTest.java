package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import static utils.PropertyUtil.getProperties;
import static utils.LogUtil.logger;


public class BaseTest {

    public static WebDriver driver = null;

    public void init(){

        String browser = getProperties("browser").toLowerCase();
        switch (browser){
            case "chrome":
              WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
              break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        logger.info("Driver initialized");

    }

    @Before
    public void startTest(){init();}

    @After
    public void finishTest(){ driver.quit();}




}
