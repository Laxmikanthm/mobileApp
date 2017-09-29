package pages.UserProfilePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import io.appium.java_client.AppiumDriver;

public class UserProfileIOS  extends  UserProfile{
    public UserProfileIOS(AppiumDriver driver) {
        super(driver);
    }

    @Override
    MobileButton getEmailAddress() throws Exception {
        return null;
    }

    @Override
    MobileButton getFullName() throws Exception {
        return null;
    }

    @Override
    MobileButton getInitials() throws Exception {
        return null;
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
     /*
     By.id(BaseTest.bundle.getString("ToggleView")),
      By.xpath("//android.widget.TextView[@resource-id='"+ BaseTest.bundle.getString("Search")+"']")
    <android.widget.RelativeLayout resource-id="com.subway.mobile.subwayapp03:id/user_name_email_layout">
<android.widget.TextView resource-id="com.subway.mobile.subwayapp03:id/user_name">
<android.widget.FrameLayout resource-id="com.subway.mobile.subwayapp03:id/user_initial_layout">
<android.widget.ImageView>
<android.widget.TextView resource-id="com.subway.mobile.subwayapp03:id/user_initials">
<android.widget.TextView resource-id="com.subway.mobile.subwayapp03:id/user_email">*/
}
