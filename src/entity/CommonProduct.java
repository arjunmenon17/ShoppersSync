package entity;

public class CommonProduct implements Product {

    private final String name;

    private final float price;

    private final String brand;

    private final String image;

    private final String description;
    private final float esg;


    CommonProduct(String name, float price, String brand, String description, String image, float esg) {

        this.name = name;

        this.price = price;

        this.image = image;

        this.brand = brand;

        this.description = description;

        this.esg = esg;

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
    public float environmentalScore() {return esg;}
    @Override
    public String getImage() {return image;}


}
