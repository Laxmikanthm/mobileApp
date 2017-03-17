package pages.SearchStore;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pojos.user.MobileUser;

/**
 * Created by E003705 on 17-03-2017.
 */
public abstract class SearchStore<T extends AppiumDriver> extends MobileBasePage {

    public SearchStore(AppiumDriver driver) { super(driver); }

    abstract MobileButton getSearchButton() throws Exception;
    abstract MobileTextBox getSearchByZipCode() throws Exception;
    abstract MobileButton getAllowButton() throws Exception;
    abstract MobileButton getOkPopupButton() throws Exception;
    abstract MobileButton getToggleView() throws Exception;
    abstract MobileButton getMobileOrdering() throws Exception;
    abstract MobileButton getOpenNow() throws Exception;
    abstract MobileButton getDriveThru() throws Exception;
    abstract MobileButton getServesBreakfast() throws Exception;
    abstract MobileButton getOpenHours() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public void searchStoreByZipCode(MobileUser mobileUser) throws Exception
    {
        try{
            getSearchButton().click();
            //getSearchByZipCode().setText(mobileUser.getPostalCode());

            getSearchByZipCode().isReady();
            getSearchByZipCode().getControl().clear();
            //   getSearchByZipCode().setText("06460");
            ((AndroidDriver)driver).findElement(By.xpath("//*[@text='Search by Zip Code']")).sendKeys("06460");
        }
        catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void allowPopUp() throws Exception
    {
        try{
            int d=((AndroidDriver)driver).findElements(By.xpath("//*[@text='Allow']")).size();
            if(d>0)
            {
                getAllowButton().click();
                ((AndroidDriver)driver).findElement(By.xpath("//*[@text='Allow']")).click();
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void okPopUp() throws Exception
    {
        try{
            int d=((AndroidDriver)driver).findElements(By.xpath("//*[@text='OK']")).size();
            if(d>0)
            {
                getOkPopupButton().click();
                // ((AndroidDriver)driver).findElement(By.xpath("//*[@text='OK']")).click();
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void toggleView() throws Exception
    {
        try{
            getToggleView().click();
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void findYourStore(MobileUser mobileUser) throws Exception
    {
        try{
            okPopUp();
            allowPopUp();
            toggleView();
            searchStoreByZipCode(mobileUser);

        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

}
