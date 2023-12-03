package interface_adapter.Search;

import entity.Product;

public class SearchState {
    private String productName = "";
    private float productPrice;
    private String productDescription = "";
    private String searchError = null;

    private String productImage = "";

    private String productBrand = "";

    private Product product;

    public SearchState(SearchState copy) {
        productName = copy.productName;
        productPrice = copy.productPrice;
        productDescription = copy.productDescription;
        searchError = copy.searchError;
        productImage = copy.productImage;
        productBrand = copy.productBrand;
        product = copy.product;
    }

    public SearchState() {
    }

    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public String getProductBrand() {return  productBrand;}

    public String getProductImage() {return productImage;}

    public String getProductDescription() {
        return productDescription;
    }

    public Product getProduct() {return product;}

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
        this.productImage = image_url;
    }

    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }

    public void setProductBrand(String productBrand) {this.productBrand = productBrand;}

    public void setProduct(Product product) {this.product = product;}

    @Override
    public String toString() {
        return "SearchState{" +
                "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}