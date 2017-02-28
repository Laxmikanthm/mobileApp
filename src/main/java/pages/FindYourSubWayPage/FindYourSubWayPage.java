package pages.FindYourSubWayPage;

import base.gui.controls.browser.Button;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.HomePage.HomePageAndroid;
import pages.HomePage.HomePageIOS;
import pages.LoginPage.LoginPage;
import pages.LoginPage.LoginPageAndroid;
import pages.LoginPage.LoginPageIOS;
import pages.SubWayPage.SubWayPage;
import pages.ContactInformationPage.ContactInformationPage;

import java.util.Map;

/**
 * Created by e002243 on 16-02-2017.
 */
public abstract  class FindYourSubWayPage<T extends AppiumDriver> extends MobileBasePage {


    public FindYourSubWayPage(AppiumDriver driver) {
        super(driver);
    }

    abstract MobileButton getUserProfile() throws Exception;
    abstract  MobileButton getFindYourSubWay()throws Exception;
    Button searchButton;
    Button selectRestButton;
    protected Map<String, By> bys;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static FindYourSubWayPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new FindYourSubWayPageIOS((IOSDriver) driver);
            case "Android":
                return new FindYourSubWayPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public SubWayPage getUserDetails() throws Exception
    {
        try{
            this.getUserProfile().waitForClickable();
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

    public Button getSearchButton() throws Exception {
        if (searchButton == null) {
            searchButton = new Button(driver, bys.get("SearchBtnBy"), "Search button");
        }
        return searchButton;
    }

    public Button getSelectRestButton() throws Exception {
        if (selectRestButton == null) {
            selectRestButton = new Button (driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("SelectRestButton") + "']"), "");
        }
        return selectRestButton;
    }

    public boolean findYourSubWayButton() throws Exception
    {
        try{
           return getFindYourSubWay().getControl().isDisplayed();
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
}
