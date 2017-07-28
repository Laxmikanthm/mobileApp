package pages.RegistrationPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import enums.Country;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.HomePage.HomePage;
import pojos.user.MobileUser;
import utils.Logz;
import java.util.List;
import java.util.Map;
import static cardantApiFramework.serviceUtilities.mailinatorClient.MailinatorClient.getVerificationCode;

/**
 * Created by test-user on 2/9/17.
 */
public abstract class RegistrationPage<T extends AppiumDriver> extends MobileBasePage {
    protected Map<String, By> bys;


    public RegistrationPage(AppiumDriver driver) {
        super(driver);
    }

    public static RegistrationPage get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform) {
            case "iOS":
                return new RegistrationPageIOS((IOSDriver) driver);
            case "Android":
                return new RegistrationPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    By nextLocator=By.xpath("//android.widget.Button[@content-desc='"+BaseTest.bundle.getString("NextButton")+"']");

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    abstract MobileTextBox getFirstName() throws Exception;

    abstract MobileTextBox getLastName() throws Exception;

    abstract MobileTextBox getPhone() throws Exception;

    abstract MobileButton getNextButton() throws Exception;

    abstract MobileTextBox getEmail() throws Exception;

    abstract MobileTextBox getPassword() throws Exception;

    abstract MobileTextBox getConfirmPasswrod() throws Exception;

    abstract MobileButton getSignUpButton() throws Exception;

    abstract MobileButton getCheckboxOffers() throws Exception;

    public HomePage signUp() throws Exception {
        try {
            MobileUser user  = new MobileUser(false, Country.UnitedStates, 54588);
            try {
                Thread.sleep(20000);
                driver.findElementByXPath("//android.widget.EditText[@resource-id='custom-givenName']");
            }
            catch (org.openqa.selenium.NoSuchElementException ex) {
                driver.findElementById("com.android.chrome:id/terms_accept").click();
                driver.findElementById("com.android.chrome:id/negative_button").click();
            }
            getFirstName().setText(user.getFirstName());
            getDriver().hideKeyboard();
            getLastName().isReady();
            getLastName().setText(user.getLastName());
            getDriver().hideKeyboard();
            getPhone().setText(user.getPhoneTenDigits());
            getDriver().hideKeyboard();
            getNextButton().click();
            getEmail().isReady();
            getEmail().setText(user.getEmailAddress());
            getPassword().setText(user.getPassword());
            getDriver().hideKeyboard();
            getConfirmPasswrod().setText(user.getPassword());
            getDriver().hideKeyboard();
            getCheckboxOffers().click();
            getSignUpButton().click();
            return HomePage.get((AppiumDriver) driver);
        } catch (Exception ex) {
            Logz.step("");
            throw new Exception(ex);

        }
    }


    public void enterCode(String code) {

        List<MobileElement> codes = ((AppiumDriver) driver).findElements(By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("VerificaitonCode") + "']/android.widget.EditText"));
         {
             codes.get(0).sendKeys(code);
        }
    }


}


