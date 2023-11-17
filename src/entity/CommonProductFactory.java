package entity;

public class CommonProductFactory implements ProductFactory{

    @Override
    public Product create(String name, float price, String category, String description) {
        return new CommonProduct(name, price, category, description);
    }

}
