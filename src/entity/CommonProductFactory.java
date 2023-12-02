package entity;

public class CommonProductFactory implements ProductFactory {

    @Override
    public Product create(String name, float price, String brand, String description, String image) {
        return new CommonProduct(name, price, brand, description, image);
    }

}
