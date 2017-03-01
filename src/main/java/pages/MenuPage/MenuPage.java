package pages.MenuPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.ContactInformationPage.ContactInformationPage;
import pages.NamePage.NamePage;
import pages.PhonePage.PhonePage;
import pojos.MobileUser;

/**
 * Created by e002243 on 16-02-2017.
 */
public abstract  class MenuPage<T extends AppiumDriver> extends MobileBasePage {

    public MenuPage(AppiumDriver driver){
        super(driver);
    }

    abstract MobileButton getLogOut() throws Exception;
    abstract MobileButton getContactInfo() throws Exception;
    abstract MobileLabel getUserInfo() throws Exception;
    abstract MobileButton getLogOutButtonInPopUp() throws Exception;
    //abstract MobileButton getLogOutButton() throws Exception;

    public static MenuPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new MenuPageIOS((IOSDriver) driver);
            case "Android":
                return new MenuPageAndroid((AndroidDriver) driver);
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
            this.getContactInfo().waitForClickable();
            this.getContactInfo().click();
            return ContactInformationPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }

    }

    public String getUserInformation() throws Exception
    {
        try{
            return getUserInfo().getText();
        }catch(Exception ex){
            throw new Exception(ex);
        }


    }

    public void logout() throws Exception

    {
        getLogOut().waitForClickable();
        getLogOut().click();
        logOutInpopupButton();
    }


    public void logOutInpopupButton() throws Exception

    {
        getLogOutButtonInPopUp().waitForClickable();
        getLogOutButtonInPopUp().click();
    }


    public MenuPage updateProfileInfo(MobileUser mobileUser) throws Exception {

        ContactInformationPage contactInformationPage =  getContactInformation();
        NamePage namepage= contactInformationPage.getNameField();
        contactInformationPage=namepage.updateFirstNameLastName(mobileUser);
        PhonePage phonePage= contactInformationPage.getPhoneField();
        contactInformationPage= phonePage.updatePhoneNumber();
        // menuPage= contactInformationPage.selectBackButton();
//        String AfirstNameLastName=  menuPage.getUserInformation();
//        String EfirstNameLastName= namepage.getFirstNameLastName();

        return MenuPage.get((AppiumDriver) driver);
    }

}

