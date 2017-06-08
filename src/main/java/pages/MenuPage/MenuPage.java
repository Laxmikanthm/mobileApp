package pages.MenuPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.AddCardPage.AddCardPage;
import pages.ContactInformationPage.ContactInformationPage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.NamePage.NamePage;
import pages.PhonePage.PhonePage;
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
    abstract MobileLabel getPrivacyStatement() throws Exception;
    //abstract MobileLabel getOrderNumber() throws Exception;


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

    public void validateMobileOrderHistory(String expectedOrderNum) throws Exception
    {
        try{
           getMobileOrderHistory().click();
           String orderNum= ((AndroidDriver)driver).findElementByXPath("//*[starts-with(@text,'Order ') and @class='android.widget.TextView']").getText();
            String actualOrderNumber[]=orderNum.split(" ");

            Assert.assertEquals(actualOrderNumber[1],expectedOrderNum);
            System.out.println("Hello");


        }catch(Exception ex){
            System.out.println("*************** ----Catch Block ----- *********");
        }
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
        return MenuPage.get((AppiumDriver) driver);
    }


    public void HideKeyboard()
    {
        AppiumDriver d=(AppiumDriver) driver;
        d.hideKeyboard();
    }


    public AddCardPage gotoAddPaymentMethods() throws  Exception
    {
        try{
            getPaymentMethods().click();
            return AddCardPage.get((AppiumDriver) driver);

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
            getEmailPreferences().isReady();
            getEmailPreferences().click();
            getEmail().isReady();
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

    public void getabout() throws Exception
    {
        try{
            this.getAbout().isReady();
            this.getAbout().click();

        }catch (Exception ex){
            throw new Exception(ex);
        }
    }
    public void navigatetoTermsandConditions() throws Exception
    {
        try{
            getTermsandConditions().waitForClickable();
            getTermsandConditions().click();

        }catch (Exception ex){
            throw new Exception(ex);
        }
    }
    public void navigatetoPrivacyPolicy() throws Exception
    {
        try{
            getPrivacyPolicy().waitForClickable();
            getPrivacyPolicy().click();

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

    public boolean checkElemetnPresence()throws Exception
    {
        try{

          boolean displayed= getPrivacyStatement().getControl().isDisplayed();
            if(displayed){
                return true;
            }else{
                return false;
            }

        }catch (Exception ex){
            throw new Exception(ex);
        }

    }

    public void assertAppVersionTexts() throws Exception {
        try {
            By appVersionLocator = By.id("com.subway.mobile.subwayapp03:id/version");
            Assert.assertTrue(isElementPresent(appVersionLocator), "App version is existed in the About page");
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void assertHelpPageTexts() throws Exception {
        try {
            By helopPageLocator= By.id("com.subway.mobile.subwayapp03:id/question");
            Assert.assertTrue(isElementPresent(helopPageLocator),"Help page has the expected Text");
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void assertPrivacyPolicyTexts() throws Exception {
        try {
            By privacyPolicyLocator = By.id("android:id/content");
            Assert.assertTrue(isElementPresent(privacyPolicyLocator),"Privacy Statment Text present in the Privacypolicy");
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void assertTermsAndConditionsTexts() throws Exception {
        try {
            By termsAndConditionsTextLocator = By.id("android:id/content");
            Assert.assertTrue(isElementPresent(termsAndConditionsTextLocator),"Terms and conditions Text present in the Terms and conditions page");
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void assertUpdateProfile(MobileUser mobUser) throws Exception
    {
        try {

            Assert.assertEquals(mobUser.getFirstName()+" "+mobUser.getLastName(), getUserInformation());
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

}
