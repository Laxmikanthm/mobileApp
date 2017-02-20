package pages.FindYourSubWayPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.HomePage.HomePageAndroid;
import pages.HomePage.HomePageIOS;
import pages.LoginPage.LoginPage;
import pages.LoginPage.LoginPageAndroid;
import pages.LoginPage.LoginPageIOS;
import pages.SubWayPage.SubWayPage;
import pages.ContactInformationPage.ContactInformationPage;

/**
 * Created by e002243 on 16-02-2017.
 */
public abstract  class FindYourSubWayPage<T extends AppiumDriver> extends MobileBasePage {


    public FindYourSubWayPage(AppiumDriver driver) {
        super(driver);
    }

    abstract MobileButton getUserProfile() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static LoginPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new LoginPageIOS((IOSDriver) driver);
            case "Android":
                return new LoginPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public SubWayPage getUserDetails() throws Exception
    {
        try{
            this.getUserProfile().click();
            return SubWayPage.get((AppiumDriver)driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }

    }

    public static Class getHomepageClass(){

        String mobilePlatform = "Android";

        if(mobilePlatform.equalsIgnoreCase("IOS")) {
            return HomePageIOS.class;
        }else
            return HomePageAndroid.class;
    }

    public SubWayPage navigateToUserProfile()  throws Exception
    {
        try{
            this.getUserProfile().click();
            return SubWayPage.get((AppiumDriver)driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
}
