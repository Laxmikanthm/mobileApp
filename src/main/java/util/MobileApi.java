package util;

import Enums.BreadSize;
import base.gui.controls.mobile.generic.MobileButton;
import cardantApiFramework.pojos.StringUtils;
import cardantApiFramework.serviceUtilities.cardantClientV2.data.ProductData;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.*;
import enums.PaymentMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import kobieApi.serviceUtils.KobieClient;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import pages.HomePage.HomePage;
import pojos.CustomizedItem.CustomizedItem;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RemoteOrderCustomer;
import snaplogicApi.serviceUtils.SnaplogicClient;
import utils.Logz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MobileApi {

    public static void removeFavoriteItems(RemoteOrderCustomer user) throws Exception {
        try {
            Logz.step("******* Started to remove favorite items *******");
            RemoteOrder remoteOrder = new RemoteOrder(user);
            remoteOrder.removeFavoriteItemList(user);
            Logz.step("******* Ended to remove favorite items *******");
        } catch (Exception ex) {
            Logz.step("******* Unable to remove favorite items *******" + ex.getMessage());
        }
    }
    public static FavoriteItems getFavoriteItems(RemoteOrderCustomer user) throws Exception {
        try {
            Logz.step("******* Started to retrieving favorite items *******");
            RemoteOrder remoteOrder = new RemoteOrder(user);
            return  remoteOrder.getFavoriteItems(user);
        } catch (Exception ex) {
            Logz.step("******* Unable to retrieving favorite items *******" + ex.getMessage());
        }
        return null;
    }
    public static void addFavorite(MobileUser user) throws Exception {
        try {
            RemoteOrder remoteOrder = user.getCart().getRemoteOrder();
            remoteOrder.addFavoriteItems(user, 1, StringUtils.getRandomString(14));
            //   remoteOrder.removeFavoriteItems(user);
        } catch (Exception ex) {
            Logz.step("Unable to add favorite item" + ex.getMessage());
        }
    }
    public static void addFavoriteItem(MobileUser user, int NoOfFavoriteItem) throws Exception {
        Logz.step("####### Started adding Favorite Items: " +NoOfFavoriteItem + " #######");
        for (int i = 0; i < NoOfFavoriteItem; i++) {
            addFavorite(user);
        }
        Logz.step("####### Ended adding Favorite Items: " +NoOfFavoriteItem + " #######");
    }
    public static void removeAddFavorite(MobileUser user, int favoriteItemCount) throws Exception{
        //first remove if any
        removeFavoriteItems(user);
        //then add
        addFavoriteItem(user,favoriteItemCount);
        FavoriteItems favoriteItems =  getFavoriteItems(user);
        int count = 0;
        while(count<3) {
            if (favoriteItems.getTotalResults().isEmpty()) {
                addFavoriteItem(user, favoriteItemCount);
            }
            count++;
        }
    }
    public static void addCreditCard(RemoteOrderCustomer user) throws Exception{
        Logz.step("##### Adding credit card to user through API ##### ");
        pojos.tenders.CreditCard creditCard = new pojos.tenders.CreditCard();
        creditCard.addGuestCreditPayment(user);
        Logz.step("##### Added credit card to user through API ##### ");
    }
    public static RemoteOrderCustomer getLoyaltyLookUp(RemoteOrderCustomer user) throws Exception {
        SnaplogicClient client = new SnaplogicClient();
        user = client.getProfileByGuestId(user);
        return KobieClient.getLoyalty(user);
    }
    public static RemoteOrderCustomer placeOrderWithNoOfToken(RemoteOrderCustomer user, int tokenCount) throws Exception {
        RemoteOrder ex = user.getCart().getRemoteOrder();
        ex.customer = user;
        ex.placeRandomOrderForGivenNumberOfTokens(tokenCount, PaymentMethod.CREDITCARD);
        SnaplogicClient client = new SnaplogicClient();
        user = client.getProfileByGuestId(user);
        return KobieClient.getLoyalty(user);
    }
    public static int getBreadOptionCount(CustomizedItem customizedItem, MobileUser mobileUser) throws Exception{
       String groupId =  customizedItem.getProductDetail().getPromoEndDate();
        String classId = customizedItem.getProductDetail().getAvailableDate();
        List<Product>  products = ProductData.getClassProducts(mobileUser, mobileUser.getStoreID(), groupId, classId);
       return products.size();

    }
    public static String getExpectedDefaultIngredients(ProductDetail productDetail) throws Exception {
        String ingredients;
        List<String> ingredientList = new ArrayList<>();
        Defaults[] defaults = productDetail.getDefaults();
        List<Option> options = defaults[0].getOptions();
        Attribute[] a;
        //ingredientList.add(a[0].getName());
        // int counter = 0;
        for (Defaults d : defaults) {
            // if (counter > 0) {
            if (d.getName().contains("Cheese") || d.getName().contains("Egg") || d.getName().contains("Bread")) {
                a = d.getOptions().get(0).getAttributes();
                ingredientList.add(a[0].getName());
            } else {
                options = d.getOptions();
                ingredientList.addAll(options.stream().map(Option::getName).collect(Collectors.toList()));
                //ingredientList.addAll(options.stream().map(Option::getOptionGroupCode).collect(Collectors.toList()));
            }

            // }
            // counter++;
        }
        Proteins[] proteins = productDetail.getProteinss();
        for (Proteins protein : proteins) {
            ingredientList.add(protein.getName());
        }
        ingredients = ingredientList.toString();
        return ingredients.substring(1, ingredients.length() - 1);
    }

public static CustomizedItem getCustomizedItemDetails(MobileUser mobileUser, String menuName, BreadSize breadSize) throws Exception {
    RemoteOrder remoteOrder = new RemoteOrder(mobileUser);
    Logz.step("##### getting Customized Item Details #####");
    return remoteOrder.getCustomizedItemDetail(menuName, breadSize.toString());
}

    public static void placeOrder(int numberOfOrder, int numberOfItem, MobileUser mobileUser) throws Exception {
        try {
            RemoteOrder remoteOrder = mobileUser.getCart().getRemoteOrder();
            //   RemoteOrder remoteOrder = new RemoteOrder(mobileUser);
            for (int i = 0; i < numberOfOrder; i++) {
                remoteOrder.placeRandomOrder(numberOfItem, enums.PaymentMethod.CREDITCARD);
            }

        } catch (Exception ex) {
            throw new Exception(("Failed to place order throw api.\n" + ex.getMessage()));

        }

    }
    public static CustomizedItem getSidesDrinksCustomizedItemDetails(MobileUser mobileUser, String menuName) throws Exception{
        RemoteOrder remoteOrder = new RemoteOrder(mobileUser);
        Logz.step( "##### getting Sides Drinks Customized Item Details #####" );
        return  remoteOrder.getCustomizedSidesDrinksDetail(menuName);


}


}
