package pages.ForgotPasswordPage;

import base.gui.controls.mobile.android.AndroidPasswordTextBox;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.gui.controls.mobile.generic.PasswordTextBox;
import base.gui.controls.mobile.ios.IOSPasswordTextBox;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.LoginPage.LoginPage;
import pojos.user.MobileUser;


import java.util.List;

import static cardantApiFramework.serviceUtilities.mailinatorClient.MailinatorClient.getVerificationCode;

/**
 * Created by E003705 on 28-02-2017.
 */
public abstract class ForgotYourPasswordPage<T extends AppiumDriver> extends MobileBasePage {
    public ForgotYourPasswordPage(AppiumDriver driver) {
        super(driver);
    }


    abstract MobileTextBox getEmailAddress() throws Exception;
    abstract MobileButton getNextButton() throws Exception;
    abstract MobileButton getResetButton() throws Exception;
    abstract PasswordTextBox getPassword() throws Exception;
    abstract PasswordTextBox getConfirmPassword() throws Exception;
    abstract MobileButton getSetPassword() throws Exception;
    abstract MobileButton getLoginAgainPopUp() throws Exception;

    public LoginPage setNewPassword(MobileUser mobileUser) throws Exception {
        try {
            getEmailAddress().isReady();
            getEmailAddress().getControl().clear();
            getEmailAddress().setText(mobileUser.getEmailAddress());
            getNextButton().click();
            enterCode(getVerificationCode(mobileUser.getEmailAddress()));
            getResetButton().click();
            getPassword().isReady();
            getPassword().getControl().clear();
            getPassword().setText(mobileUser.getPassword());
            getConfirmPassword().getControl().clear();
            getConfirmPassword().setText(mobileUser.getPassword());
            getDriver().hideKeyboard();
            getSetPassword().isReady();
            getSetPassword().click();
            getOKButton();
            return LoginPage.get((AppiumDriver)driver);
        } catch (Exception ex) {
            throw new Exception(ex);

        }
    }
    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static ForgotYourPasswordPage get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform) {
            case "iOS":
                return new ForgotYourPasswordPageIOS((IOSDriver) driver);
            case "Android":
                return new ForgotYourPasswordPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public void getOKButton() throws Exception

    {
        getLoginAgainPopUp().waitForClickable();
        getLoginAgainPopUp().click();
    }

    public void enterCode(String code) {

        List<MobileElement> codes = ((AppiumDriver) driver).findElements(By.xpath("//*[@resource-id='" + BaseTest.bundle.getString("VerificaitonCode") + "']/android.widget.EditText"));
        {
            codes.get(0).sendKeys(code);
        }
    }
}