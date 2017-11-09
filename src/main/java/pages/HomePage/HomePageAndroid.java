package pages.HomePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.test.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 2/2/17.
 */
public class HomePageAndroid extends HomePage {


    public HomePageAndroid(AndroidDriver driver) throws Exception {
        super(driver);
    }
    public MobileButton getMenu() throws Exception {
        AndroidButton menuPageButton = new AndroidButton((AndroidDriver) driver, By.id("profile"), "UserProfilePage field");
        return menuPageButton;
    }

    public MobileButton getOrderButton() throws Exception {
        AndroidButton orderButton = new AndroidButton ((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("OrderButton") + "']"), "Order Button");
        return orderButton;
    }

    public MobileButton getBackButton() throws Exception {
        //AndroidButton backButton = new AndroidButton ((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("FindButton") + "']"), "Find Button");
        AndroidButton backButton = new AndroidButton((AndroidDriver) driver, By.className("android.widget.ImageButton"), "Back button");
        return backButton;
    }

    public MobileButton getFindYourSubWay() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("FindYourSubWay")+"']"), "FindYourSubWay button");
        return button;
    }
    public MobileButton getFindAnotherSubway() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("FindAnotherSubway")+"']"), "Find Another Subway button");
        return button;
    }
    public MobileLabel getYourFavoriteOrderName() throws Exception {
        AndroidLabel label = new AndroidLabel((AndroidDriver)driver, By.id("favorites_1_title"), "FavoriteNameInApp button");
        return label;
    }
    public MobileButton getFavoritesAddIcon() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.ImageView[@resource-id='"+BaseTest.bundle.getString("FavoriteAddIcon")+"']"), "Favorite Add icon button");
        return button;
    }
    public MobileLabel getTokenValue() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver,By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TokenValue")+"']"), "Get Token Value from Dashboard");
        return label;
    }
    public MobileLabel getZeroTokenMessage() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver,  By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("ZeroTokenMessage")+"']"), "Get zero Token Message from Dashboard");
        return label;
    }
    public MobileLabel getTokenMessage() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver,    By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TokenMessage")+"']"), "Get Token Message from Dashboard");
        return label;
    }
    public MobileButton getTellMeHow() throws Exception{
        AndroidButton label = new AndroidButton((AndroidDriver) driver,   By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TellMeHow")+"']"), "Get zero token link");
        return label;
    }
    public MobileButton getStartAnotherOrder() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver,  By.id("order_divider_1"), "Get zero token link");
        return button;
    }
    public MobileButton getAnimationSparkle() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver,  By.id("animation_sparkle"), "Get zero token link");
        return button;
    }
    public MobileButton getStartAnother() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("start_order"), "Add Something Else button");
        return button;
    }
    public MobileButton getRewardsApply() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("Apply")+"']"), "Apply button");
        return button;
    }
    public MobileLabel getCertificatesMessage() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver,  By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("CertificatesCount")+"']"), "Get Certificates Count");
        return label;
    }

    public MobileLabel gethomepagecertificatemessage() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver,  By.id("txt_loyalty_reward_count"), "Rewards certificate count");
        return label;
    }


    public MobileLabel getRedeemText() throws Exception{
        AndroidLabel label = new AndroidLabel((AndroidDriver) driver,  By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("RedeemText")+"']"), "Get zero Token Message from Dashboard");
        return label;
    }
    public MobileButton getRedeemButton() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver,  By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("RedeemText")+"']"), "Get zero Token Message from Dashboard");
        return button;
    }


}
