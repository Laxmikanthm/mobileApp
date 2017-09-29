package util;

import cardantApiFramework.pojos.StringUtils;
import cardantApiFramework.serviceUtilities.cardantClientV2.dto.storeDTO.FavoriteItems;
import pojos.RemoteOrder;
import pojos.user.MobileUser;
import pojos.user.RemoteOrderCustomer;
import utils.Logz;

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
}
