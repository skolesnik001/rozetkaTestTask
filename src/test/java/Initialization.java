import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by siava on 23.06.2017.
 */
public class Initialization {
    public static final String URL_ROZETKA = "http://rozetka.com.ua/";

    WebDriver driver = new ChromeDriver();



    @BeforeMethod
    public void before() {
        driver.get(URL_ROZETKA);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(25, TimeUnit.SECONDS);

    }

    @AfterClass
    public void after(){
        driver.close();
        driver.quit();
    }
}
