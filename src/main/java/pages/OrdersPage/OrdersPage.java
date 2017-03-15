package pages.OrdersPage;

import base.gui.controls.mobile.generic.MobileButton;
import base.gui.controls.mobile.generic.MobileLabel;
import base.gui.controls.mobile.generic.MobileTextBox;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pojos.Orders.Order;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import java.util.List;
import org.openqa.selenium.Dimension;

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
    abstract MobileButton getGotIt() throws Exception;
    abstract MobileButton getCategory(String Category) throws Exception;
    abstract MobileButton getSubCategory(String Category) throws Exception;

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


    public void placeRandomOrder( Order order, MobileUser mobileUser, String storeName) throws Exception
    {
        try{
            findYourStore(mobileUser);
            searchStore(storeName);
            getSelectRestaurantButton().click();
            getStartOrderButton().click();
            selectCategory(order.getCart().getProductDetail().getProductGroup().getName());
            selectSubCategory(order.getCart().getProductDetail().getProductClass().getName());
//            orderCategoryItem(order);
//            orderSubCategoryItem(order);
            getAddToBag().click();
            getPlaceOrder().click();
            getGotIt().click();
            }
            catch(Exception ex){
            throw new Exception(ex);
        }
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

    public void searchStore(String storeName) throws Exception
    {
        try{
            //Get the size of screen.
            Dimension  size = ((AndroidDriver)driver).manage().window().getSize();
            System.out.println(size);

            //Find swipe start and end point from screen's with and height.
            //Find starty point which is at bottom side of screen.
            int starty = (int) (size.height * 0.80);
            //Find endy point which is at top side of screen.
            int endy = (int) (size.height * 0.20);
            //Find horizontal point where you wants to swipe. It is in middle of screen width.
            int startx = size.width / 2;
            System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

            //Swipe from Top to Bottom.
           ((AndroidDriver)driver).swipe(startx, 2300, startx, 1725, 3000);


            ((AndroidDriver)driver).findElement(By.xpath("//*[@text='"+storeName+"']")).click(); ;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }

    public void selectCategory(String categoryName ) throws Exception
    {
        try{
            getCategory(categoryName).click(); ;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
    public void selectSubCategory(String subCategoryName ) throws Exception
    {
        try{

            ((AndroidDriver)driver).findElement(By.xpath("//*[@text='"+subCategoryName+"']")).click(); ;
        }catch(Exception ex){
            throw new Exception(ex);
        }
    }
    public void placeOrder(String subCategoryName ) throws Exception
    {
        try{

            getPlaceOrder().click();
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
                getOkPopupButton().click();
               // ((AndroidDriver)driver).findElement(By.xpath("//*[@text='OK']")).click();
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

