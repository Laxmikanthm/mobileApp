package pages.SubWayPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.ContactInformationPage.ContactInformationPage;

/**
 * Created by e002243 on 16-02-2017.
 */
public abstract  class SubWayPage<T extends AppiumDriver> extends MobileBasePage {

    public SubWayPage(AppiumDriver driver){
        super(driver);
    }

    abstract MobileButton getContactInfo() throws Exception;
    abstract MobileButton getUserInfo() throws Exception;

    public static SubWayPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new SubWayPageIOS((IOSDriver) driver);
            case "Android":
                return new SubWayPageAndroid((AndroidDriver) driver);
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

    public ContactInformationPage getContactInformation() throws Exception
    {
        try{
            this.getContactInfo().click();
            return ContactInformationPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }

    }

    public String getUserInformation() throws Exception
    {
        try{
            String userFirstNameLastName=  this.getUserInfo().getControl().getText();
            return userFirstNameLastName;
        }catch(Exception ex){
            throw new Exception(ex);
        }


    }
}
