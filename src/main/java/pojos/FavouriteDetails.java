package pojos;

import util.Utils;
import utils.Logz;

/**
 * Created by E001599 on 06-11-2017.
 */
public class FavouriteDetails {
    String favouriteName;
    String ItemName;
    String Ingrediants;
    String Price;

    public String getFavouriteName() {
        return favouriteName;
    }

    public void setFavouriteName(String favouriteName) {
        this.favouriteName = favouriteName;
    }


    public String getIngrediants() {
        return Ingrediants;
    }

    public void setIngrediants(String ingrediants) {
        Ingrediants = ingrediants;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavouriteDetails)) return false;

        FavouriteDetails favouriteDetails = (FavouriteDetails) o;

        if (getFavouriteName() != null ? !getFavouriteName().equalsIgnoreCase(favouriteDetails.getFavouriteName()) : favouriteDetails.getFavouriteName() != null) {
            Logz.step("FavouriteDetails name actual " + getFavouriteName() + "But expected " + favouriteDetails.getFavouriteName());
            return false;
        }

        if (getPrice() != null ? !Utils.removeTrailingZero(getPrice().replaceAll("[+$]", "")).equals(Utils.removeTrailingZero(favouriteDetails.getPrice().replaceAll("[+$]", ""))) : favouriteDetails.getPrice() != null) {
            Logz.step("FavouriteDetails Price actual " + getPrice() + "But expected " + favouriteDetails.getPrice());
            return false;
        }


        if (getIngrediants() != null ? !getIngrediants().equals(favouriteDetails.getIngrediants()) : favouriteDetails.getIngrediants() != null) {
            Logz.step("FavouriteDetails Ingrediants  actual " + getIngrediants() + "But expected " + favouriteDetails.getIngrediants());
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = getFavouriteName() != null ? getFavouriteName().hashCode() : 0;
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getIngrediants() != null ? getIngrediants().hashCode() : 0);
        return result;
    }
}
