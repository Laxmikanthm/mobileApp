package pojos;

import util.Utils;
import utils.Logz;

public class MakeItMeal {
    private String name;
    private String price;
    private String calorie;
    private String imagePath;

    public MakeItMeal(String name, String price, String calorie, String imagePath) {
        this.name = name;
        this.price = price;
        this.calorie = calorie;
        this.imagePath = imagePath;
    }

    public MakeItMeal() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MakeItMeal)) return false;

        MakeItMeal makeItMeal = (MakeItMeal) o;

        if (getName() != null ? !getName().equalsIgnoreCase(makeItMeal.getName()) : makeItMeal.getName() != null){
            Logz.step("MakeItMeal name actual "+getName()+"But expected "+ makeItMeal.getName());
            return false;
        }

        if (getPrice() != null ? !Utils.removeTrailingZero(getPrice().replaceAll("[+$]","")).equals(Utils.removeTrailingZero(makeItMeal.getPrice().replaceAll("[+$]",""))) : makeItMeal.getPrice() != null){
            Logz.step("MakeItMeal Price actual "+getPrice()+"But expected "+ makeItMeal.getPrice());
            return false;
        }


        if (getImagePath() != null ? !getImagePath().equals(makeItMeal.getImagePath()) : makeItMeal.getImagePath() != null){
            Logz.step("MakeItMeal image pathe actual "+getImagePath()+"But expected "+ makeItMeal.getImagePath());
            return false;
        }
        return getCalorie() != null ? getCalorie().replaceAll(" ","").equals(makeItMeal.getCalorie().replaceAll(" ","")) : makeItMeal.getCalorie() == null;
    }

    @Override
    public int hashCode() {
        int result = getPrice() != null ? getPrice().hashCode() : 0;
        result = 31 * result + (getCalorie() != null ? getCalorie().hashCode() : 0);
        return result;
    }
}
