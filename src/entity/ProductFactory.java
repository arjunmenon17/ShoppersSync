package entity;

public interface ProductFactory {
    Product create(String name, float price, String brand, String description );
}
