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
        AndroidButton menuPageButton = new AndroidButton((AndroidDriver) driver, By.id(BaseTest.bundle.getString("UserProfile")), "UserProfile field");
        return menuPageButton;
    }

    public MobileButton getOrderButton() throws Exception {
        AndroidButton orderButton = new AndroidButton ((AndroidDriver) driver, By.xpath("//android.widget.Button[@text='" + BaseTest.bundle.getString("OrderButton") + "']"), "Order Button");
        return orderButton;
    }

    public MobileButton getFindButton() throws Exception {
        AndroidButton findButton = new AndroidButton ((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='" + BaseTest.bundle.getString("FindButton") + "']"), "Find Button");
        return findButton;
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

    public MobileButton getFindSubWayNearYou() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("FindNearbySubway")+"']"), "FindASubwayNearYou button");
        return button;
    }

    public MobileButton getAllowLocation() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//*[@text='"+BaseTest.bundle.getString("AllowLocation")+"']"), "AllowLocation button");
        return button;
    }
    public MobileButton getStoreView() throws Exception {
        AndroidButton storeViewButton = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/toggle_view"), "StoreView button");
        return storeViewButton;
    }
    public MobileButton getFindAnotherSubway() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("FindAnotherSubway")+"']"), "Find Another Subway button");
        return button;
    }
    public MobileLabel getYourFavoriteOrderName() throws Exception {
        AndroidLabel label = new AndroidLabel((AndroidDriver)driver, By.id(BaseTest.bundle.getString("FavoriteNameInApp")), "FavoriteNameInApp button");
        return label;
    }
    public MobileButton getFavoritesAddIcon() throws Exception {
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.ImageView[@resource-id='"+BaseTest.bundle.getString("FavoriteAddIcon")+"']"), "Favorite Add icon button");
        return button;
    }
    public MobileLabel getTokenValue() throws Exception{
        AndroidLabel token = new AndroidLabel((AndroidDriver) driver,By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TokenValue")+"']"), "Get Token Value from Dashboard");
        return token;
    }
    public MobileLabel getZeroTokenMessage() throws Exception{
        AndroidLabel token = new AndroidLabel((AndroidDriver) driver,  By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("ZeroTokenMessage")+"']"), "Get zero Token Message from Dashboard");
        return token;
    }
    public MobileLabel getTokenMessage() throws Exception{
        AndroidLabel token = new AndroidLabel((AndroidDriver) driver,    By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TokenMessage")+"']"), "Get Token Message from Dashboard");
        return token;
    }
    public MobileButton getTellMeHow() throws Exception{
        AndroidButton token = new AndroidButton((AndroidDriver) driver,   By.xpath("//android.widget.TextView[@resource-id='"+BaseTest.bundle.getString("TellMeHow")+"']"), "Get zero token link");
        return token;
    }
    public MobileButton getStartAnotherOrder() throws Exception{
        AndroidButton token = new AndroidButton((AndroidDriver) driver,  By.id("com.subway.mobile.subwayapp03:id/order_divider_1"), "Get zero token link");
        return token;
    }
    public MobileButton getAnimationSparkle() throws Exception{
        AndroidButton token = new AndroidButton((AndroidDriver) driver,  By.id("com.subway.mobile.subwayapp03:id/animation_sparkle"), "Get zero token link");
        return token;
    }
    public MobileButton getStartAnother() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.id("com.subway.mobile.subwayapp03:id/nested_scroll_padding_fix"), "Add Something Else button");
        return button;
    }
    public MobileButton getRewardsApply() throws Exception{
        AndroidButton button = new AndroidButton((AndroidDriver) driver, By.xpath("//android.widget.TextView[@text='"+BaseTest.bundle.getString("Apply")+"']"), "Apply button");
        return button;
    }


}
