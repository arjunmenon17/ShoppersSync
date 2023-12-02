package entity;

import java.math.BigDecimal;

public class CommonProduct implements Product {

    private final String name;

    private final float price;

    private final String brand;

    private final String image;

    private final String description;


    CommonProduct(String name, float price, String brand, String description, String image) {

        this.name = name;

        this.price = price;

        this.image = image;

        this.brand = brand;

        this.description = description;

    }

    @Override
    public float getPrice() {return price;}


    @Override
    public String getName() {return name;}

    @Override
    public String getDescription() {return description;}

    @Override
    public String getBrand() {return brand;}

    @Override
    public float environmentalScore() {
        float score = 0.0F;
        // Implement here

        return score;
    }
    @Override
    public String environmentalDescription() {
        String eParagraph = "";
        // Implement here

        return eParagraph;
    }

    @Override
    public String getImage() {return image;}


}
