package pages.OrderConfirmationPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.CommonElements.CommonElements;
import pages.HomePage.HomePage;
import pages.NamePage.NamePage;
import pages.NamePage.NamePageAndroid;
import pages.NamePage.NamePageIOS;
import pojos.CustomizedItem.CustomizedItem;
import utils.Logz;

public abstract class OrderConfirmationPage<T extends AppiumDriver> extends MobileBasePage {
    public OrderConfirmationPage(AppiumDriver driver) {
        super(driver);
    }
    public static OrderConfirmationPage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new OrderConfirmationPageIOS((IOSDriver) driver) {
                };
            case "Android":
                return new OrderConfirmationPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    By totalAmount = By.id("ordertotal_amount");
    CommonElements commonElements = new CommonElements((AppiumDriver)driver);
    abstract MobileButton getGotIt() throws Exception;


    public HomePage assertOrderDetailsInOrderConfirmationPage(CustomizedItem customizedItem) throws Exception{
        Logz.step("Started asserting total amount In Your Order Page");
        /*String aTotalAmount =  commonElements.getElement(totalAmount, totalAmount, (AppiumDriver)driver).getText();
        String eTotalAmount = "";
        Assert.assertEquals(aTotalAmount, eTotalAmount);*/
        Logz.step("Started asserting total amount In Your Order Page");
        getGotIt().click();
        return HomePage.get((AppiumDriver)driver);
    }
    public HomePage assertLoyaltyDisplay() throws Exception{
        getGotIt().click();
        return HomePage.get((AppiumDriver)driver);
    }
    public HomePage assertOrderSummaryInOrderConfirmationPage() throws Exception{
        return HomePage.get((AppiumDriver)driver);
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
}
