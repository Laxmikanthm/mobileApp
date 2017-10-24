package pages.PayPalPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.generic.PasswordTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import pages.PaymentMethodsPage.PaymentMethodsPage;
import pojos.user.MobileUser;
import java.util.List;

/**
 * Created by e002243 on 08-03-2017.
 */
public abstract class PayPalPage<T extends AppiumDriver> extends MobileBasePage {

    public PayPalPage(AppiumDriver driver)
    {
        super(driver);
    }

    abstract MobileTextBox getPaypalUserName() throws Exception;
    abstract MobileTextBox getPaypalUname() throws Exception;
    abstract PasswordTextBox getPaypalPassword() throws Exception;
    abstract PasswordTextBox getPaypalPwd() throws Exception;
    abstract MobileButton getLogIn() throws Exception;
    abstract MobileButton getAgreeAndContinue() throws Exception;
    abstract MobileButton getBackBtn() throws Exception;
    abstract MobileLabel getPayWith() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }
By agreeandContinue=By.id("confirmButtonTop");
    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static PayPalPage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new PayPalPageIOS((IOSDriver) driver);
            case "Android":
                return new PayPalPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public PaymentMethodsPage addPaypalDetails(MobileUser mobileUser)throws Exception {

        try {
            getPaypalUserName().isReady();
            getPaypalUserName().getControl().clear();
            getPaypalUname().getControl().sendKeys("upadhyaya_s@subway.com");
            getPaypalPassword().getControl().clear();
            getPaypalPwd().getControl().sendKeys("Subway1965");
            getDriver().hideKeyboard();
            getLogIn().click();
           // getPayWith().isReady();
            Thread.sleep(20000);
           //((AppiumDriver) driver).swipeAndClick(200, 700, 200, 100, 4000);
            scrollToElement(agreeandContinue,0.9,0.5);
            getAgreeAndContinue().click();
            getBackBtn().click();
            return PaymentMethodsPage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    public void scrollToElement(By locator, double startpoint, double endpoint) {
        while (getElements(locator).size() == 0) {
            boolean flag = false;
            Dimension dimensions = driver.manage().window().getSize();
            int Startpoint = (int) (dimensions.getHeight() * startpoint);//0.9
            int EndPoint = (int) (dimensions.getHeight() * endpoint);//0.5
          //  ((AppiumDriver) driver).swipeAndClick(200, Startpoint, 200, EndPoint, 4000);
            TouchAction action = new TouchAction((MobileDriver)driver);
            action.longPress(200,Startpoint).moveTo(200,EndPoint).release().perform();
        }
    }

    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = ((AppiumDriver) driver).findElements(locator);

        return elementsList;
    }

    public void goBackButton()  throws Exception
    {
        getBackBtn().isReady();
        getBackBtn().click();
    }
}
