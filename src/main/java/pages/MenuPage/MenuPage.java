package pages.MenuPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AddCardPage.AddCardPage;
import pages.ContactInformationPage.ContactInformationPage;
import pages.HomePage.HomePage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.NamePage.NamePage;
import pages.OrdersPage.OrdersPage;
import pages.PhonePage.PhonePage;
import pojos.user.MobileUser;
import utils.Logz;

import java.util.List;

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


    By logout=By.id("com.subway.mobile.subwayapp03:id/logout");
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

    public HomePage assertMobileOrderHistory(String expectedOrderNum) throws Exception
    {
        try{
           getMobileOrderHistory().click();
            //need to change
           String orderNum= ((AndroidDriver)driver).findElementByXPath("//*[starts-with(@text,'Order ') and @class='android.widget.TextView']").getText();
            String actualOrderNumber[]=orderNum.split(" ");

            Assert.assertEquals(actualOrderNumber[1],expectedOrderNum);
            return HomePage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
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
    public List<WebElement> getElements(By locator) {
        List<WebElement> elementsList = ((AndroidDriver) driver).findElements(locator);

        return elementsList;
    }
    public void scrollToElement(By locator, double startpoint, double endpoint) {
        while (getElements(locator).size() == 0) {
            boolean flag = false;
            Dimension dimensions = driver.manage().window().getSize();
            int Startpoint = (int) (dimensions.getHeight() * startpoint);//0.9
            int EndPoint = (int) (dimensions.getHeight() * endpoint);//0.5
          //  ((AppiumDriver) driver).swipe(200, Startpoint, 200, EndPoint, 2000);
        }
    }
    public void logout() throws Exception
    {
        try {
            scrollToElement(logout,0.9,0.5);
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
            Logz.step("Not able to see help icon");
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

            By General=By.id("General");
            Assert.assertEquals(isElementPresent(General),true);
            By MyAccount=By.id("My Account");
            Assert.assertEquals(isElementPresent(MyAccount),true);
            By MenuandOrdering=By.id("Menu & Ordering");
            Assert.assertEquals(isElementPresent(MenuandOrdering),true);
            By payment=By.id("Payment");
            Assert.assertEquals(isElementPresent(payment),true);
            By subwaycardDetails=By.id("SUBWAY® Card");
            Assert.assertEquals(isElementPresent(subwaycardDetails),true);

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
