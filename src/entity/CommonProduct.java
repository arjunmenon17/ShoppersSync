package entity;

public class CommonProduct implements Product {

    private final String name;

    private final float price;

    private final String brand;

    private final String description;


    CommonProduct(String name, float price, String brand, String description) {

        this.name = name;

        this.price = price;

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



}
