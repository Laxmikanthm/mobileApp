package pages.PayPalPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPageAndroid;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPageIOS;
import pages.PaymentMethodsPage.PaymentMethodsPage;
import pojos.user.MobileUser;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
    abstract MobileTextBox getPaypalPassword() throws Exception;
    abstract MobileTextBox getPaypalPwd() throws Exception;
    abstract MobileButton getLogIn() throws Exception;
    abstract MobileButton getAgreeAndContinue() throws Exception;
    abstract MobileLabel getPayWith() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static PayPalPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

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
        {
            By AgreeAndContinue  = By.id("confirmButtonTop");
            getPaypalUserName().getControl().clear();
            getPaypalUname().setText("upadhyaya_s@subway.com");
            //getPaypalUserName().setText("upadhyaya_s@subway.com");
            getPaypalPassword().getControl().clear();
            getPaypalPwd().setText("Subway1965");
            getDriver().hideKeyboard();
            /*getPaypalUserName().setText(mobileUser.getPayPalEmailAddress());
            getPaypalPassword().setText(mobileUser.getPayPalPassword());*/
            getLogIn().click();
            getPayWith().isReady();
            scrollToElement(AgreeAndContinue,0.9,0.5);
            getAgreeAndContinue().click();
            return PaymentMethodsPage.get((AppiumDriver) driver);
                }
            }

    public void scrollToElement(By locator, double startpoint, double endpoint) {
        while (getElements(locator).size() == 0) {
            boolean flag = false;
            Dimension dimensions = driver.manage().window().getSize();
            int Startpoint = (int) (dimensions.getHeight() * startpoint);//0.9
            int EndPoint = (int) (dimensions.getHeight() * endpoint);//0.5
            ((AppiumDriver) driver).swipe(200, Startpoint, 200, EndPoint, 2000);
        }
    }

    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = ((AndroidDriver) driver).findElements(locator);

        return elementsList;
    }
}
