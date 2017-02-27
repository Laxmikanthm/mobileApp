package pages.NamePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import enums.Country;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.ContactInformationPage.ContactInformationPage;
import pages.LoginPage.LoginPage;
import pages.SubWayPage.SubWayPage;
import pages.SubWayPage.SubWayPageAndroid;
import pages.SubWayPage.SubWayPageIOS;
import pojos.MobileUser;

import java.util.Random;

/**
 * Created by e002243 on 17-02-2017.
 */
public abstract class NamePage<T extends AppiumDriver> extends MobileBasePage {

    public NamePage(AppiumDriver driver){
        super(driver);
    }

    public String firstName;
    public String lastName;


    abstract MobileTextBox getFirstName() throws Exception;
    abstract MobileTextBox getLastName() throws Exception;

    abstract MobileButton getSave() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static NamePage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new NamePageIOS((IOSDriver) driver);
            case "Android":
                return new NamePageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public ContactInformationPage updateFirstNameLastName() throws Exception
    {
        try{
            MobileUser mobileUser = new MobileUser(false, Country.UnitedStates);
            getFirstName().isReady();
            getFirstName().getControl().clear();
            getFirstName().isReady();
            firstName=mobileUser.getFirstName();
           getFirstName().setText(firstName);
            getFirstName().isReady();
           //firstName=getFirstName().getControl().getAttribute("value");

           Thread.sleep(10000);
            getLastName().isReady();
           getLastName().getControl().clear();
            getLastName().isReady();
            lastName=mobileUser.getLastName();
           getLastName().setText(lastName);
            getLastName().isReady();

           getSave().waitForClickable();
           getSave().click();

            return ContactInformationPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }


    public String getFirstNameLastName(){

        return firstName+lastName;
    }


}
