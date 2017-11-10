package pages.UserProfilePage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AddCardPage.AddCardPage;
import pages.CommonElements.CommonElements;
import pages.ContactInformationPage.ContactInformationPage;
import pages.HomePage.HomePage;
import pages.MobileOrderHistoryPage.MobileOrderHistoryPage;
import pages.NamePage.NamePage;
import pages.PhonePage.PhonePage;
import pages.PurchaseHistoryPage.PurchaseHistoryPage;
import pojos.user.MobileUser;
import pojos.user.RemoteOrderCustomer;
import utils.Logz;

import java.util.List;

/**
 * Created by e002243 on 16-02-2017.
 */
public abstract  class UserProfilePage<T extends AppiumDriver> extends MobileBasePage {

    public UserProfilePage(AppiumDriver driver){
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
    abstract By getGeneralTab() throws Exception;
    abstract By getAccountTab() throws Exception;
    abstract By getMenuTab() throws Exception;
    abstract By getPaymentTab() throws Exception;


    //abstract MobileLabel getOrderNumber() throws Exception;


    By logout=By.id("com.subway.mobile.subwayapp03:id/logout");
    //abstract MobileButton getLogOutButton() throws Exception;

    public static UserProfilePage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new UserProfilePageIOS((IOSDriver) driver);
            case "Android":
                return new UserProfilePageAndroid((AndroidDriver) driver);
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
          //  ((AppiumDriver) driver).swipeAndClick(200, Startpoint, 200, EndPoint, 2000);
            TouchAction action = new TouchAction((MobileDriver) driver);
            action.longPress(200, Startpoint).moveTo(200, EndPoint).release().perform();
        }
    }

    public UserProfilePage logout() throws Exception
    {
        try {
            CommonElements commonElements = new CommonElements( (AppiumDriver)driver );
            commonElements.scroll( getHelp().getControl(), "up");
            getLogOut().isReady();
            getLogOut().click();
            logOutInpopupButton();
        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return UserProfilePage.get((AppiumDriver) driver);
    }


    public void logOutInpopupButton() throws Exception

    {
        getLogOutButtonInPopUp().waitForClickable();
        getLogOutButtonInPopUp().click();
    }


    public UserProfilePage updateProfileInfo(MobileUser mobileUser) throws Exception {

        ContactInformationPage contactInformationPage =  getContactInformation();
        NamePage namepage= contactInformationPage.getNameField();
        contactInformationPage=namepage.updateFirstNameLastName(mobileUser);
        PhonePage phonePage= contactInformationPage.getPhoneField();
        contactInformationPage= phonePage.updatePhoneNumber();
        contactInformationPage.selectBackButton();
        return UserProfilePage.get((AppiumDriver) driver);
    }


    public void HideKeyboard()
    {
        AppiumDriver d=(AppiumDriver) driver;
        d.hideKeyboard();
    }


    public AddCardPage gotoAddPaymentMethods() throws  Exception
    {
        try{
            Thread.sleep(10000);
            getPaymentMethods().click();

        }catch(Exception ex){
            Logz.error("not able to click the Add payment method");
        }
        return AddCardPage.get((AppiumDriver) driver);
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
            Logz.step("Validated Appversion Successfully");
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void assertHelpPageTexts() throws Exception {
        try {

            By General=getGeneralTab();
            Thread.sleep(5000);
            Assert.assertEquals(isElementPresent(General),true);
            By MyAccount=getAccountTab();
            Thread.sleep(5000);
            Assert.assertEquals(isElementPresent(MyAccount),true);
            By MenuandOrdering=getMenuTab();
            Thread.sleep(5000);
            Assert.assertEquals(isElementPresent(MenuandOrdering),true);
            By payment=getPaymentTab();
            Thread.sleep(5000);
            Assert.assertEquals(isElementPresent(payment),true);
            Logz.step("Validated help page Successfully");

        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void assertPrivacyPolicyTexts() throws Exception {
        try {
            By privacyPolicyLocator = By.id("android:id/content");
            Assert.assertTrue(isElementPresent(privacyPolicyLocator),"Privacy Statment Text present in the Privacypolicy");
            Logz.step("Validated Privacy Policy Successfully");
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    public void assertTermsAndConditionsTexts() throws Exception {
        try {
            By termsAndConditionsTextLocator = By.id("android:id/content");
            Assert.assertTrue(isElementPresent(termsAndConditionsTextLocator),"Terms and conditions Text present in the Terms and conditions page");
            Logz.step("Validated Terms&Conditions Successfully");
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

    public HomePage assertUserLoggedOut() throws Exception{
        try {
            Logz.step("Asserting user is logged out ");
            String actualUser =  driver.findElementById("signIn").getText();
            String expectedUser = BaseTest.getStringfromBundleFile("SignInWithExistingAccount");
            Assert.assertEquals(actualUser, expectedUser);
            Logz.step("Asserted user is logged out ");
        }catch (Exception ex){
            throw new Exception("Unable to assert user is logged Out\n" +ex.getMessage());
        }

        return HomePage.get((AppiumDriver) driver);
    }

    abstract MobileButton getEmailAddress() throws Exception;
    abstract MobileButton getFullName() throws Exception;
    abstract MobileButton getInitials() throws Exception;
    abstract MobileButton getPurchaseHistory() throws Exception;

    public HomePage assertEmailDisplayName(RemoteOrderCustomer mobileUser) throws Exception{
        try {
            Logz.step("Asserting user email in menu page ");
            String initials = mobileUser.getFirstName().substring(0, 1) +""+ mobileUser.getLastName().substring(0, 1);
            Assert.assertEquals(getEmailAddress().getText(), mobileUser.getEmailAddress());
            Assert.assertEquals(getFullName().getText(), mobileUser.getFirstName() + " " + mobileUser.getLastName());
            Assert.assertEquals(getInitials().getText(), initials);
            Logz.step("Asserted user email in menu page ");
        }catch (Exception ex){
            throw new Exception("Unable to assert user email in menu page\n" +ex.getMessage());
        }

        return HomePage.get((AppiumDriver) driver);
    }
    public PurchaseHistoryPage goToPurchaseHistoryPage() throws Exception{
        Logz.step("##### Navigating to Purchase History Page #####");

        getPurchaseHistory().click();
        Logz.step("##### Navigated to Purchase History Page #####");
        return PurchaseHistoryPage.get((AppiumDriver) driver);
    }
    public UserProfilePage assertUserLoggedIn(RemoteOrderCustomer mobileUser) throws Exception{
        try {
            Logz.step("Asserting user is logged in ");
           /* String actualUser = getOrderButton().getText();
            String expectedUser = BaseTest.getStringfromBundleFile("OrderButton");
            Assert.assertEquals(actualUser, expectedUser);*/
            assertEmailDisplayName(mobileUser);
            Logz.step("Asserted user is logged in ");

        }catch (Exception ex){
            throw new Exception("Unable to assert user is logged in\n" +ex.getMessage());
        }

        return UserProfilePage.get((AppiumDriver) driver);
    }

}
