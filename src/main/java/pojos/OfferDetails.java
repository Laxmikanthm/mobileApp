package pojos;

public class OfferDetails {
    String menuName;
    String productName;
    String breadSize;
    String itemCount;


    public OfferDetails() {
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public String getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(String breadSize) {
        this.breadSize = breadSize;
    }
    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfferDetails that = (OfferDetails) o;

        if (menuName != null ? !menuName.equals(that.menuName) : that.menuName != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        return breadSize != null ? breadSize.equals(that.breadSize) : that.breadSize == null;
    }

    @Override
    public int hashCode() {
        int result = menuName != null ? menuName.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (breadSize != null ? breadSize.hashCode() : 0);
        return result;
    }


}
