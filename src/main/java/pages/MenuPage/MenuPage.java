package pages.MenuPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import enums.Country;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import pages.AddCardPage.AddCardPage;
import pages.ChoosePaymentMethodPage.ChoosePaymentMethodPage;
import pages.ContactInformationPage.ContactInformationPage;
import pages.ForgotPasswordPage.ForgotYourPasswordPage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.NamePage.NamePage;
import pages.PhonePage.PhonePage;
import pages.SubwayPage.SubwayPage;
import pojos.user.MobileUser;

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
    abstract MobileButton getPaymentMethods() throws Exception;
    abstract MobileButton getGoHome() throws Exception;
    abstract MobileButton getEmailPreferences() throws Exception;
    abstract MobileButton getMobileOrderHistory() throws Exception;
    abstract MobileButton getHelp() throws Exception;
    abstract MobileButton getAbout() throws Exception;
    abstract MobileButton getEmail() throws Exception;
    abstract MobileButton getPrivacyPolicy() throws Exception;
    abstract MobileButton getPrivacyPolicyShare() throws Exception;
    abstract MobileButton getTermsandConditions() throws Exception;


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
        try {
            getLogOut().isReady();
            getLogOut().click();
            logOutInpopupButton();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
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
        contactInformationPage.selectBackButton();
//        String AfirstNameLastName=  menuPage.getUserInformation();
//        String EfirstNameLastName= namepage.getFirstNameLastName();

        return MenuPage.get((AppiumDriver) driver);
    }


    public void HideKeyboard()
    {

        AppiumDriver d=(AppiumDriver) driver;
        d.hideKeyboard();
    }

    public void addCreditCard() throws  Exception
    {
        try{
            MobileUser mobileUser = new MobileUser(false, Country.UnitedStates, 54588);
            SubwayPage subwayPage=  addPaymentMethods();
            ChoosePaymentMethodPage choosePaymentMethodPage= subwayPage.addPaymentMethod();
            AddCardPage addCardPage= choosePaymentMethodPage.ChoosePaymentMethodCreditCard();
            addCardPage.addCardDetails(mobileUser);

        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public SubwayPage addPaymentMethods() throws  Exception
    {
        try{
            getPaymentMethods().click();
            return SubwayPage.get((AppiumDriver) driver);

        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void goHome() throws Exception

    {
        getGoHome().waitForClickable();
        getGoHome().click();
    }

    public void verifyEmailPreference() throws Exception
    {
        try{
            getEmailPreferences().waitForClickable();;
            getEmailPreferences().click();
            getEmail().click();
        }catch(Exception ex){
            throw new Exception(ex);
        }

    }

    public MobileOrderHistoryPage getOrderHistory() throws Exception
    {
        try{
             getMobileOrderHistory().waitForClickable();
             getMobileOrderHistory().click();
            return MobileOrderHistoryPage.get((AppiumDriver) driver);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public void verifyHelp() throws Exception
    {
        try{
            this.getHelp().waitForClickable();
            this.getHelp().click();

        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public ContactInformationPage getabout() throws Exception
    {
        try{
            this.getAbout().waitForClickable();
            this.getHelp().click();
            return ContactInformationPage.get((AppiumDriver) driver);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    public boolean isElementPresent(By locator)throws Exception
    {
        try{

            int x= ((AppiumDriver)driver).findElements(locator).size();
            if(x>0){
                return true;
            }else{
                return false;
            }

        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

}
