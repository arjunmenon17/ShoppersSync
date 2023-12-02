package entity;

import java.math.BigDecimal;

public interface ProductFactory {
    Product create(String name, float price, String brand, String description, String image );
}
