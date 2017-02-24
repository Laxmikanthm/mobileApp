package pages.ContactInformationPage;

        import base.gui.controls.mobile.generic.MobileButton;
        import base.gui.controls.mobile.generic.MobileLabel;
        import base.pages.mobile.MobileBasePage;
        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.ios.IOSDriver;
        import pages.NamePage.NamePage;
        import pages.PhonePage.PhonePage;
        import pages.SubWayPage.SubWayPage;

/**
 * Created by e002243 on 17-02-2017.
 */
public abstract  class ContactInformationPage<T extends AppiumDriver> extends MobileBasePage{

    public ContactInformationPage(AppiumDriver driver){
        super(driver);
    }


    abstract MobileButton getName() throws Exception;
    abstract MobileButton getPassWord() throws Exception;
    abstract MobileButton getPhone() throws Exception;
    abstract MobileButton getBackButton() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static ContactInformationPage get(AppiumDriver driver) throws Exception{

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform){
            case "iOS":
                return new ContactInformationPageIOS((IOSDriver) driver);

            case "Android":
                return new ContactInformationPageAndroid((AndroidDriver) driver);

            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }

    public NamePage getNameField()  throws Exception
    {
        try{
            getName().waitForClickable();
            getName().click();
            return NamePage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public NamePage getPasswordField()  throws Exception
    {
        try{
            this.getPhone().click();
            return NamePage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public PhonePage getPhoneField()  throws Exception
    {
        try{
            this.getPhone().click();
            return PhonePage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public SubWayPage selectBackButton()  throws Exception
    {
        try{
            getBackButton().waitForClickable();
            getBackButton().click();
            //this.getPhone().click();
            return SubWayPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

}


