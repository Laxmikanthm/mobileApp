package pages.HomePage;

import base.gui.controls.mobile.android.AndroidButton;
import base.gui.controls.mobile.android.AndroidLabel;
import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.ios.IOSButton;
import base.gui.controls.mobile.ios.IOSLabel;
import base.test.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

/**
 * Created by test-user on 2/2/17.
 */
public class HomePageIOS extends HomePage {

    public HomePageIOS(AppiumDriver driver) throws Exception {
        super(driver);
    }

    public MobileButton getMenu() throws Exception {
        IOSButton menuPageButton = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId("icProfile"), "Menu button");
        return menuPageButton;
    }

    public MobileButton getOrderButton() throws Exception {
        IOSButton orderButton = new IOSButton ((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("OrderButton")), "Order Button");
        return orderButton;
    }

    public MobileButton getFindYourSubWay() throws Exception {
        IOSButton button = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("FindYourSubwayiOS")), "FindYourSubWay button");
        return button;
    }

    public MobileButton getBackButton() throws Exception {
        IOSButton backButton = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId("icProfile"), "Back button button");
        return backButton;
    }
    public MobileButton getFindAnotherSubway() throws Exception {
        IOSButton backButton = new IOSButton((IOSDriver) driver, MobileBy.AccessibilityId(BaseTest.bundle.getString("FindAnotherSubwayiOS")), "Finding another subway button");
        return backButton;
    }
    public MobileLabel getYourFavoriteOrderName() throws Exception {

        IOSLabel button = new IOSLabel((IOSDriver) driver, By.xpath("//*[@content-desc='"+ BaseTest.bundle.getString("Login")+"']"), "Login button");

        return button;
    }
    public MobileButton getFavoritesAddIcon() throws Exception {
        IOSButton backButton = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toggle_view"), "StoreView button");
        return backButton;
    }
    public MobileLabel getTokenValue() throws Exception{
        IOSLabel token = new IOSLabel((IOSDriver) driver,By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TokenValue")+"']"), "Get Token Value from Dashboard");
        return token;
    }
    public MobileLabel getZeroTokenMessage() throws Exception{
        IOSLabel token = new IOSLabel((IOSDriver) driver,  By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("ZeroTokenMessage")+"']"), "Get zero Token Message from Dashboard");
        return token;
    }
    public MobileLabel getTokenMessage() throws Exception{
        IOSLabel token = new IOSLabel((IOSDriver) driver,    By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TokenMessage")+"']"), "Get Token Message from Dashboard");
        return token;
    }
    public MobileButton getTellMeHow() throws Exception{
        IOSButton token = new IOSButton((IOSDriver) driver,   By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TellMeHow")+"']"), "Get zero token link");
        return token;
    }
    public MobileButton getStartAnotherOrder() throws Exception{
        IOSButton token = new IOSButton((IOSDriver) driver,  By.id("com.subway.mobile.subwayapp03:id/order_divider_1"), "Get zero token link");
        return token;
    }
    public MobileButton getAnimationSparkle() throws Exception{
        IOSButton token = new IOSButton((IOSDriver) driver,  By.id("com.subway.mobile.subwayapp03:id/animation_sparkle"), "Get zero token link");
        return token;
    }
    public MobileButton getRewardsApply() throws Exception{
        IOSButton token = new IOSButton((IOSDriver) driver,  By.id(" com.subway.mobile.subwayapp03:id/txt_loyalty_reward_apply"), "Apply button");
        return token;
    }
    public MobileButton getStartAnother() throws Exception{
        IOSButton button = new IOSButton((IOSDriver) driver, By.id("com.subway.mobile.subwayapp03:id/nested_scroll_padding_fix"), "Add Something Else button");
        return button;
    }
    public MobileLabel getCertificatesMessage() throws Exception{
        IOSLabel token = new IOSLabel((IOSDriver) driver,  By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("CertificatesCount")+"']"), "Get zero Token Message from Dashboard");
        return token;
    }
    public MobileLabel getRedeemText() throws Exception{
        IOSLabel token = new IOSLabel((IOSDriver) driver,  By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("RedeemText")+"']"), "Get zero Token Message from Dashboard");
        return token;
    }
    public MobileButton getRedeemButton() throws Exception{
        IOSButton token = new IOSButton((IOSDriver) driver,  By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("RedeemText")+"']"), "Get zero Token Message from Dashboard");
        return token;
    }



}
