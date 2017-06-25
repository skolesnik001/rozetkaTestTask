import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by siava on 23.06.2017.
 */
public class BasePage {

    Actions action;



    protected WebDriver driver;


    public BasePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;

        action = new Actions(driver);

    }

    public void waitElement(WebElement element, int period) {
        new WebDriverWait(driver, period).until((ExpectedConditions.visibilityOf(element)));
    }

    public void waitt(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
