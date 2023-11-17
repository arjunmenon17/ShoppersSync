package use_case.search;


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
        String urlString = "https://api.bluecartapi.com/request?api_key=17E691EE2B274440B026E21B2DE8CE76&type=product&item_id=782866746";
        try {
            URL fitbit = new URL(urlString);
            URLConnection conn = fitbit.openConnection();
            InputStream stuff = conn.getInputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(stuff));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        }
        catch (Exception e) {
            // ur mom
        }
    }
}
