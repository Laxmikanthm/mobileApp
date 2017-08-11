package pages.NamePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.ContactInformationPage.ContactInformationPage;
import pojos.user.MobileUser;

/**
 * Created by e002243 on 17-02-2017.
 */
public abstract class NamePage<T extends AppiumDriver> extends MobileBasePage {

    public NamePage(AppiumDriver driver){
        super(driver);
    }
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

    public ContactInformationPage updateFirstNameLastName(MobileUser mobileUser) throws Exception
    {
        try{
            getFirstName().isReady();
            getFirstName().getControl().clear();
            getFirstName().setText(mobileUser.getFirstName()+"subway");
            getLastName().getControl().clear();
            getLastName().setText(mobileUser.getLastName()+"subway");
            getSave().waitForClickable();
            getSave().click();
            return ContactInformationPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

}
