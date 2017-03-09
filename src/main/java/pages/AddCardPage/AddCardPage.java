package pages.AddCardPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.MenuPage.MenuPage;
import pages.MenuPage.MenuPageAndroid;
import pages.MenuPage.MenuPageIOS;
import pojos.user.MobileUser;

/**
 * Created by e002243 on 01-03-2017.
 */
public abstract class AddCardPage <T extends AppiumDriver> extends MobileBasePage {

    public AddCardPage(AppiumDriver driver){ super(driver);}

    abstract MobileTextBox getCardNumber() throws Exception;
    abstract MobileTextBox getExpiresOn() throws Exception;
    abstract MobileTextBox getCCV() throws Exception;
    abstract MobileTextBox getPin() throws Exception;
    abstract MobileTextBox getNameOnCard() throws Exception;
    abstract MobileButton getNextButton() throws  Exception;
    abstract MobileButton getSavePaymentMethod() throws  Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    public static AddCardPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new AddCardPageIOS((IOSDriver) driver);
            case "Android":
                return new AddCardPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public void addCardDetails(MobileUser mobileUser) throws Exception
    {
        try{
            getCardNumber().setText("");
            getNameOnCard().setText(mobileUser.getFirstName()+mobileUser.getLastName());
            getNextButton().click();
            getExpiresOn().setText("");
            getCCV().setText("");
            getNextButton().click();
        }catch(Exception ex)
        {
            throw new Exception(ex);
        }
    }

    public void addSubwayCardDetails() throws Exception
    {
        try{
            getCardNumber().isReady();
            getCardNumber().setText("");
            getPin().setText("");
            getSavePaymentMethod().click();
        }catch(Exception ex)
        {
            throw new Exception(ex);
        }
    }

    public void HideKeyboard()
    {
        AppiumDriver d = (AppiumDriver)driver;
        d.hideKeyboard();
    }
}


