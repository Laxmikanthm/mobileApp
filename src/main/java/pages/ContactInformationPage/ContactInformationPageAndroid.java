
package pages.ContactInformationPage;

        import base.gui.controls.mobile.android.AndroidButton;
        import base.test.BaseTest;
        import io.appium.java_client.android.AndroidDriver;
        import org.openqa.selenium.By;

/**
 * Created by e002243 on 17-02-2017.
 */
public class ContactInformationPageAndroid extends ContactInformationPage
{

    public ContactInformationPageAndroid(AndroidDriver driver){
        super(driver);
    }


    public AndroidButton getName() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("Name")+"']"), "Name button");

        return button;
    }
    public AndroidButton getPassWord() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("PASSWORD")+"']"), "Password button");

        return button;
    }
    public AndroidButton getPhone() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@resource-id='"+BaseTest.bundle.getString("PHONE")+"']"), "Phone button");

        return button;
    }
    public AndroidButton getBackButton() throws Exception {

        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@class='"+BaseTest.bundle.getString("BackButton")+"']"), "Back button");

        return button;
    }



}
