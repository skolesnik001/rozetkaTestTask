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
}
