package interface_adapter.Search;

public class SearchState {
    private String productName = "";
    private float productPrice;
    private String productDescription = "";
    private String searchError = null;

    private String productImage = "";

    public SearchState(SearchState copy) {
        productName = copy.productName;
        productPrice = copy.productPrice;
        productDescription = copy.productDescription;
        searchError = copy.searchError;
        productImage = copy.productImage;
    }

    public SearchState() {
    }

    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getSearchError() {
        return searchError;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductImage(String image_url) {
        this.productImage = productImage;
    }

    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }

    @Override
    public String toString() {
        return "SearchState{" +
                "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}