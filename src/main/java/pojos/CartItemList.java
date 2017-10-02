package pojos;

import utils.Logz;

public class CartItemList {
    private String itemName;
    private String ingredients;
    private String itemPrice;
    private boolean isFavourite;

    private String makeItMealItem;

    private MakeItMeal makeItMealCta;

    public CartItemList() {

    }

    public CartItemList(String itemName, String ingredients, boolean isFavourite) {
        this.itemName = itemName;
        this.ingredients = ingredients;
        this.isFavourite = isFavourite;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public MakeItMeal getMakeItMealCta() {
        return makeItMealCta;
    }

    public void setMakeItMealCta(MakeItMeal makeItMealCta) {
        this.makeItMealCta = makeItMealCta;
    }

    public String getMakeItMealItem() {
        return makeItMealItem;
    }

    public void setMakeItMealItem(String makeItMealItem) {
        this.makeItMealItem = makeItMealItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItemList)) return false;

        CartItemList that = (CartItemList) o;

        if (getItemName() != null ? !getItemName().equals(that.getItemName()) : that.getItemName() != null){
            Logz.step("Item name expected: "+getItemName()+"But act: "+that.getItemName());
            return false;
        }


        if (getItemPrice() != null ? !getItemPrice().equals(that.getItemPrice()) : that.getItemPrice() != null){
            Logz.step("Item price expected: "+getItemPrice()+"But act: "+that.getItemPrice());
            return false;
        }

        if (isFavourite() != that.isFavourite()){
            Logz.step("Favourite is expected: "+isFavourite()+"But act: "+that.isFavourite());
            return false;
        }


        if (getMakeItMealItem() != null ? !getMakeItMealItem().equals(that.getMakeItMealItem()) : that.getMakeItMealItem() != null){
            Logz.step("MIAM Item expected: "+getMakeItMealItem()+"But act: "+that.getMakeItMealItem());
            return false;
        }


        if (getMakeItMealCta() != null ? !getMakeItMealCta().equals(that.getMakeItMealCta()) : that.getMakeItMealCta() != null){
            Logz.step("MIAM CTA expected: "+getMakeItMealCta()+"But act: "+that.getMakeItMealCta());
            return false;
        }

        return getIngredients() != null ? getIngredients().equals(that.getIngredients()) : that.getIngredients() == null;
    }

    @Override
    public int hashCode() {
        int result = getItemName() != null ? getItemName().hashCode() : 0;
        result = 31 * result + (getIngredients() != null ? getIngredients().hashCode() : 0);
        return result;
    }
}
