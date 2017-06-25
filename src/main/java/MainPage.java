import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    protected WebDriver driver;

    FilesApp filesApp = new FilesApp();

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='3361']/a")
    private WebElement smartphonesTvAndElectronicsButton;

    public WebElement getSmartphonesTvAndElectronicsButton() {
        return smartphonesTvAndElectronicsButton;
    }

    @FindBy(xpath = ".//*[@id='menu_categories_left']/li[1]/h4/a")
    private WebElement phonesButton;

    public WebElement getPhonesButton() {
        return phonesButton;
    }

    @FindBy(xpath = ".//*[@id='menu_categories_left']/li[1]/div/a[1]")
    private WebElement smartphonesButton;

    public WebElement getSmartphonesButton() {
        return smartphonesButton;
    }

    @FindBy(xpath = ".//*[@class='g-tag g-tag-icon-middle-popularity sprite']")
    private WebElement labelTopSales;

    @FindBy(xpath = ".//*[@class='g-i-tile-i-title clearfix']/a")
    private WebElement nameDevices;

    @FindBy(xpath = ".//*[@class='prices_active_element_original']")
    private WebElement priceDevices;

    @FindBy(xpath = ".//*[@class='g-tag g-tag-icon-middle-popularity sprite']/../../..")
    private List<WebElement> topSaleItems;

    By topSaleItemsBy = By.xpath(".//*[@class='g-tag g-tag-icon-middle-popularity sprite']");

    @FindBy(xpath = ".//*[@id='page2']")
    private WebElement page2;

    @FindBy(xpath = ".//*[@id='page3']")
    private WebElement page3;

    public WebElement getPage2() {
        return page2;
    }

    public WebElement getPage3() {
        return page3;
    }

    public void goToSmartphonesSection() throws InterruptedException {
        waitElement(smartphonesTvAndElectronicsButton, 15);
        smartphonesTvAndElectronicsButton.click();
        waitt(500);
        smartphonesTvAndElectronicsButton.click();
        waitElement(phonesButton, 15);
        phonesButton.click();
        waitElement(smartphonesButton, 15);
        smartphonesButton.click();
    }

    public void getNamesDevices() throws FileNotFoundException {
        waitt(700);
        if (driver.findElements(topSaleItemsBy).size() > 0) {

            List<String> nameDevicesAttribute = new ArrayList<>();
            List<String> priceDevicesAttribute = new ArrayList<>();
            for (int i = 0; i < topSaleItems.size(); i++) {
                nameDevicesAttribute.add(i, topSaleItems.get(i).findElement(By.xpath(".//*[@class='g-i-tile-i-title clearfix']/a")).getText());
                priceDevicesAttribute.add(i, topSaleItems.get(i).findElement(By.xpath(".//*[@class='g-price-uah']")).getText());
            }
            ArrayList<String> listOfTopSalesDevicesAndPrices = new ArrayList<>();
            for (int i = 0; i < nameDevicesAttribute.size(); i++) {
                listOfTopSalesDevicesAndPrices.add(i, nameDevicesAttribute.get(i) + " - " + priceDevicesAttribute.get(i) + "\n");
            }
            filesApp.saveResultInTXT(listOfTopSalesDevicesAndPrices);
            for (int i = 0; i < listOfTopSalesDevicesAndPrices.size(); i++) {
                System.out.println(listOfTopSalesDevicesAndPrices.get(i));
            }

        } else {
            waitt(500);
            System.out.println("Top Sales not found");
            filesApp.saveResultInTXT("Top Sales not found");
        }

    }
}
