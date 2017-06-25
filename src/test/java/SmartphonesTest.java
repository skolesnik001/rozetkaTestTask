import org.testng.annotations.Test;

import java.io.FileNotFoundException;

/**
 * Created by siava on 23.06.2017.
 */
public class SmartphonesTest extends Initialization{

    MainPage mainPage = new MainPage(driver);

    @Test
    public void chooseNameAndPriceFirstPage() throws InterruptedException, FileNotFoundException {
        mainPage.goToSmartphonesSection();
        mainPage.getNamesDevices();

    }

    @Test
    public void chooseNameAndPriceSecondPage() throws InterruptedException, FileNotFoundException {
        mainPage.goToSmartphonesSection();
        mainPage.waitElement(mainPage.getPage2(),15);
        mainPage.getPage2().click();
        mainPage.getNamesDevices();
    }

    @Test
    public void chooseNameAndPriceThirdPage() throws InterruptedException, FileNotFoundException {
        mainPage.goToSmartphonesSection();
        mainPage.waitElement(mainPage.getPage3(),15);
        mainPage.getPage3().click();
        mainPage.getNamesDevices();
    }
}
