package pages.OrdersPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import java.util.List;

/**
 * Created by e002243 on 10-03-2017.
 */
public abstract class OrdersPage<T extends AppiumDriver> extends MobileBasePage {

    public OrdersPage(AppiumDriver driver) { super(driver); }

    abstract MobileButton getSearchButton() throws Exception;
    abstract MobileTextBox getSearchByZipCode() throws Exception;
    abstract MobileLabel getStoreNames() throws Exception;
    abstract MobileButton getSelectRestaurantButton() throws Exception;
    abstract MobileButton getStartOrderButton() throws Exception;
    abstract MobileButton getDenyButton() throws Exception;
    abstract MobileButton getCatagoryItem() throws Exception;
    abstract MobileButton getOkPopupButton() throws Exception;
    abstract MobileButton getAddToBag() throws Exception;
    abstract MobileButton getPlaceOrder() throws Exception;

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }

    public static OrdersPage get(AppiumDriver driver) throws Exception {

        String platform = driver.getCapabilities().getCapability("platformName").toString();

        switch (platform) {
            case "iOS":
                return new OrdersPageIOS((IOSDriver) driver);
            case "Android":
                return new OrdersPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }


    public void placeRandomOrder( MobileUser mobileUser, String storeName ) throws Exception
    {
        try{
            findYourStore(mobileUser);
            searchStore(storeName);
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
//            orderCategoryItem(order);
//            orderSubCategoryItem(order);
//            getAddToBag().click();
            }
            catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void searchStoreByZipCode(MobileUser mobileUser) throws Exception
    {
        try{
            getSearchButton().click();
            getSearchByZipCode().setText(mobileUser.getPostalCode());
            getSearchByZipCode().getControl().sendKeys(Keys.ENTER);
            }
            catch(Exception ex){
            throw new Exception(ex);
        }
    }


    public List<WebElement> getStores(String xpathAddressValue) throws Exception
    {
        try{
            AppiumDriver dr=(AppiumDriver) driver;
           List<WebElement> allAddress= dr.findElements(By.xpath(xpathAddressValue));

           return allAddress;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
    public List<WebElement> getCategoryItems() throws Exception
    {
        try{
            AppiumDriver dr=(AppiumDriver) driver;
            List<WebElement> allAddress= dr.findElements(By.name(""));

            return allAddress;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void searchStore(String storeName) throws Exception
    {
        try{
            List<WebElement> allStores= getStores("");
            for(int i=0; i<allStores.size(); i++)
            {
                if(allStores.get(i).getText().equals(storeName))
                {
                    allStores.get(i).click();
                }
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
    public void denyPopUp() throws Exception
    {
        try{
            int d=((AndroidDriver)driver).findElements(By.xpath("//*[@text='Deny']")).size();
            if(d>0)
            {
                //getDenyButton().click();

                ((AndroidDriver)driver).findElement(By.xpath("//*[@text='Deny']")).click();
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
               // getOkPopupButton().click();
                ((AndroidDriver)driver).findElement(By.xpath("//*[@text='OK']")).click();
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }


    public void orderCategoryItem(Order order) throws Exception
    {
        try{
            List<WebElement> allCategoryItems= getCategoryItems();
            for(int i=0; i<allCategoryItems.size(); i++)
            {
                if(allCategoryItems.get(i).getText().equals(order.getCart().getProductDetail().getProductGroup().getName()))
                {
                    allCategoryItems.get(i).click();
                }
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void orderSubCategoryItem(Order order) throws Exception
    {
        try{
            List<WebElement> allSubCategoryItems= getCategoryItems();
            for(int i=0; i<allSubCategoryItems.size(); i++)
            {
                if(allSubCategoryItems.get(i).getText().equals(order.getCart().getProductDetail().getProductClass().getName()))
                {
                    allSubCategoryItems.get(i).click();
                }
            }
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void findYourStore(MobileUser mobileUser) throws Exception
    {
        try{
            okPopUp();
            denyPopUp();
            searchStoreByZipCode(mobileUser);

        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

}

