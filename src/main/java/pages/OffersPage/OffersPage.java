package pages.OffersPage;

import Base.SubwayAppBaseTest;
import base.gui.controls.mobile.generic.MobileLabel;
import base.pages.mobile.MobileBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import pages.Enums.BreadSize;
import pages.NamePage.NamePage;
import pages.NamePage.NamePageAndroid;
import pages.NamePage.NamePageIOS;
import pojos.OfferDetails;
import pojos.user.RemoteOrderCustomer;
import util.Utils;

public class OffersPage  <T extends AppiumDriver> extends MobileBasePage {
    public OffersPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public MobileLabel getPageLabel() throws Exception {
        return null;
    }

    @Override
    protected void waitForPageToLoad() throws Exception {

    }
    public static OffersPage get(AppiumDriver driver) throws Exception{

        String platform = SubwayAppBaseTest.platformName;

        switch (platform){
            case "iOS":
                return new OffersPageIOS((IOSDriver) driver);
            case "Android":
                return new OffersPageAndroid((AndroidDriver) driver);
            default:
                throw new Exception("Unable to get Find A Store page for platform " + platform);
        }
    }
    public BreadSize getOfferedBreadSize(OfferDetails itemDetails) throws Exception{
        switch(itemDetails.getBreadSize()){
            case "FootLong":
                return BreadSize.FOOTLONG;
            case "SixInch":
                return BreadSize.SIXINCH;
            default: return BreadSize.NONE;
        }
    }
    public OfferDetails getOfferItemDetails(RemoteOrderCustomer user) throws Exception{
        OfferDetails offerDetails  = new OfferDetails();
        String offerTitle = user.getLoyaltyLookup().getOffers().getOffersList().get(0).getOfferTitle();
        String offerMenuName= Utils.getConnectionString(offerTitle, "", "");
        String offerProductName = Utils.getConnectionString(offerTitle, "", "");;
        String breadSize = Utils.getConnectionString(offerTitle, "", "");;
        String itemCount = Utils.getConnectionString(offerTitle, "", "");;
        if(offerTitle.contains("Cookies")){
            offerDetails.setMenuName(offerMenuName);
            offerDetails.setProductName(offerProductName);
            offerDetails.setBreadSize(breadSize);
            offerDetails.setItemCount(itemCount);
        }
        return offerDetails;
    }

}
