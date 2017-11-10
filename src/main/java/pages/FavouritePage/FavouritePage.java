package pages.FavouritePage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileButton;
import base.pages.mobile.MobileBasePage;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.FavoriteItems;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.FavoriteOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.CustomizePage.CustomizePage;
import pages.CustomizePage.CustomizePageAndroid;
import pages.CustomizePage.CustomizePageIOS;
import pages.HomePage.HomePage;
import pojos.FavouriteDetails;
import pojos.user.MobileUser;
import util.MobileApi;

import java.util.List;

/**
 * Created by E001599 on 09-11-2017.
 */
public abstract class FavouritePage<T extends AppiumDriver> extends MobileBasePage {
    public FavouritePage(AppiumDriver driver) {
        super(driver);
    }

    public static FavouritePage get(AppiumDriver driver) throws Exception {

        String platform = SubwayAppBaseTest.platformName;

        switch (platform) {
            case "iOS":
                return new FavouritePageIOS( (IOSDriver) driver );
            case "Android":
                return new FavouritePageAndroid( (AndroidDriver) driver );
            default:
                throw new Exception( "Unable to get Find A Store page for platform " + platform );
        }
    }
    abstract MobileButton getFavourites() throws Exception;
    abstract MobileButton getPrice() throws Exception;
    abstract MobileButton getIngrediants() throws Exception;
    abstract MobileButton getName() throws Exception;


    public HomePage assertFavourites(MobileUser mobileUser)throws Exception
    {
        getFavourites().click();
        FavouriteDetails actuaFavourites=new FavouriteDetails();
        FavouriteDetails expectedFavourites=new FavouriteDetails();
        actuaFavourites.setFavouriteName(getName().getText());
        actuaFavourites.setIngrediants(getIngrediants().getText());
        actuaFavourites.setPrice(getPrice().getText());
        FavoriteItems expectedApiFavourites= MobileApi.getFavoriteItems(mobileUser);
        String result = "";
        String FavouriteName="";
        Double Price=0.0;
        for(int i=0;i<expectedApiFavourites.getResults().length;i++)
        {

            FavouriteName= expectedApiFavourites.getResults()[i].getFavoriteName();
            Price= expectedApiFavourites.getResults()[i].getPrice();
            List<FavoriteOptions> favoriteOptionsList=expectedApiFavourites.getResults()[i].getOptions().subList(0,expectedApiFavourites.getResults()[i].getOptions().size()-1);
            for(int k=0;k<favoriteOptionsList.size();k++)
            {

                if(k==0) {
                    result=favoriteOptionsList.get(k).getName();
                }
                else
                {
                    result+=","+favoriteOptionsList.get(k).getName();
                }
            }

        }
        expectedFavourites.setIngrediants(result);
        expectedFavourites.setFavouriteName(FavouriteName);
        expectedFavourites.setPrice(Price.toString());
        Assert.assertEquals(actuaFavourites, expectedFavourites);

        return HomePage.get( (AppiumDriver) driver );
    }
}
