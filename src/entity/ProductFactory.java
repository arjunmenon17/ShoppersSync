package entity;

public interface ProductFactory {
    Product create(String name, String description, float price);
}
