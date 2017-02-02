package pages.HomePage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import pages.MenuPage.MenuPage;

/**
 * Created by test-user on 2/2/17.
 */
public abstract class SubwayAppHomePage<T extends AppiumDriver> extends MobileBasePage{

    public SubwayAppHomePage(AppiumDriver driver) {
        super(driver);
    }

    abstract MobileButton getMenuButton() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public MenuPage openMenu() throws Exception {
        try{
            this.getMenuButton().tap();
            return MenuPage.get((AppiumDriver) driver);
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
}
