package pages.RegistrationPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import cardantApiFramework.serviceUtilities.mailinatorClient.MailinatorClient;
import cardantApiFramework.serviceUtilities.mailinatorClient.dto.Message;
import cardantApiFramework.serviceUtilities.mailinatorClient.dto.Messages;
import enums.Country;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pojos.MobileUser;

import java.util.Iterator;
import java.util.List;

/**
 * Created by test-user on 2/9/17.
 */
public abstract class RegistrationPage<T extends AppiumDriver> extends MobileBasePage {

    public RegistrationPage(AppiumDriver driver) {
        super(driver);
    }

    public static RegistrationPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new RegistrationPageIOS((IOSDriver) driver);
            case "Android":
                return new RegistrationPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

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


    public void signUp() throws Exception {
        try{
            MobileUser mobileUser = new MobileUser(false, Country.UnitedStates);
            getFirstName().isReady();
            getFirstName().setText(mobileUser.getFirstName());
            getLastName().setText(mobileUser.getLastName());
            getPhone().setText(mobileUser.getPhoneTenDigits());
            getNextButton().click();
            getEmail().isReady();
            getEmail().setText(mobileUser.getEmailAddress());
            getPassword().setText(mobileUser.getPassword());
            getConfirmPasswrod().setText(mobileUser.getPassword());
            getNextButton().click();
            getSignUpButton().isReady();
            enterCode(getVerificationCode(mobileUser));
            getSignUpButton().click();
        }catch (Exception ex){
            throw new Exception(ex);

        }
    }

    public String getVerificationCode(MobileUser mobileUser) throws Exception {
        //Logic for fetching the code from Email.
        String jsonBody =MailinatorClient.getEmailBySecondsAgoAndSubject(5000, "Subway", mobileUser.getEmailAddress());
        String ind[] = jsonBody.split("Your code is: ");
        return ind[1].substring(0,6);
    }

    public void enterCode(String code){
        List<MobileElement> codes = ((AppiumDriver)driver).findElements(By.xpath("//*[@resource-id='"+ BaseTest.bundle.getString("VerificaitonCode")+"']/android.widget.EditText"));
        char[] number = code.toCharArray();
        for(int i =0; i<codes.size(); i++){
            codes.get(0).sendKeys(String.valueOf(number[i]));
        }
    }
}
