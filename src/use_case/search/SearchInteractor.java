package use_case.search;


import entity.Product;
import entity.ProductFactory;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class SearchInteractor implements SearchInputBoundary {

    final SearchOutputBoundary searchOutputBoundary;
    final ProductFactory productFactory;


    public SearchInteractor(SearchOutputBoundary searchOutputBoundary, ProductFactory productFactory) {

        this.searchOutputBoundary = searchOutputBoundary;
        this.productFactory = productFactory;

    }

    @Override
    public void execute(SearchInputData searchInputData) {
        String urlString = "https://api.bluecartapi.com/request?api_key=17E691EE2B274440B026E21B2DE8CE76&type=product&item_id=";
        urlString = urlString + searchInputData;
        try {
            //URL product = new URL(urlString);
            //URLConnection conn = product.openConnection();
            //InputStream stuff = conn.getInputStream();

            //BufferedReader in = new BufferedReader(new InputStreamReader(stuff));
            //String inputLine;
            //StringBuffer response = new StringBuffer();

            //while ((inputLine = in.readLine()) != null) {
                //response.append(inputLine);
            //}
            //in.close();

            String name = "name1";
            float price = 99;
            String brand = "brand1";
            String description = "This is the product description";
            String image = "image.png";
            Product product = productFactory.create(name, price, brand, description, image);

            SearchOutputData searchOutputData = new SearchOutputData(product, false);

        }
        catch (Exception e) {
            // Fail View
        }
    }
}
