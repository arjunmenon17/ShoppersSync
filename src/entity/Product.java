package entity;

import java.math.BigDecimal;

public interface Product {

    float getPrice();

    String getName();

    String getDescription();

    String getBrand();

    float environmentalScore();

    String environmentalDescription();

    String getImage();
}
