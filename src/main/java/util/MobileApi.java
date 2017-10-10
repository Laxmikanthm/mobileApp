package util;

import base.gui.controls.mobile.generic.MobileButton;
import cardantApiFramework.pojos.StringUtils;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.FavoriteItems;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage.HomePage;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RemoteOrderCustomer;
import utils.Logz;

import java.util.List;

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
    public static void addFavorite(RemoteOrderCustomer user) throws Exception {
        try {
            RemoteOrder remoteOrder = user.getCart().getRemoteOrder();
            remoteOrder.addFavoriteItems(user, 1, StringUtils.getRandomString(14));
            //   remoteOrder.removeFavoriteItems(user);
        } catch (Exception ex) {
            Logz.step("Unable to add favorite item" + ex.getMessage());
        }
    }
    public static void addFavoriteItem(RemoteOrderCustomer user, int NoOfFavoriteItem) throws Exception {
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

}
