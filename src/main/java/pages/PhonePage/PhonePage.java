package pages.PhonePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import enums.Country;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.ContactInformationPage.ContactInformationPage;
import pages.ContactInformationPage.ContactInformationPageAndroid;
import pages.ContactInformationPage.ContactInformationPageIOS;
import pojos.MobileUser;

/**
 * Created by e002243 on 17-02-2017.
 */
public abstract class PhonePage <T extends AppiumDriver> extends MobileBasePage {

    public String phoneNumber;

    public PhonePage(AppiumDriver driver){
        super(driver);
    }
    abstract MobileTextBox getPhoneNumber() throws Exception;
    abstract MobileButton getSave() throws Exception;


    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static PhonePage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new PhonePageIOS((IOSDriver) driver);

            case "Android":
                return new PhonePageAndroid((AndroidDriver) driver);

            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public ContactInformationPage updatePhoneNumber() throws Exception
    {
        try{
            MobileUser mobileUser = new MobileUser(false, Country.UnitedStates);
            getPhoneNumber().getControl().clear();
            getPhoneNumber().setText(mobileUser.getPhoneNumber());
           // phoneNumber  =  this.getPhoneNumber().getControl().getAttribute("value");

            getSave().click();

            return ContactInformationPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

}
