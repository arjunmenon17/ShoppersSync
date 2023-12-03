package use_case.search;


import entity.Product;
import entity.ProductFactory;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchInteractor implements SearchInputBoundary {

    final SearchOutputBoundary searchPresenter;
    final ProductFactory productFactory;
    final CalcScoreDataAccessInterface calcScoreDataAccessInterface;


    public SearchInteractor(SearchOutputBoundary searchOutputBoundary, ProductFactory productFactory, CalcScoreDataAccessInterface calcScoreDataAccessInterface) {

        this.searchPresenter = searchOutputBoundary;
        this.productFactory = productFactory;
        this.calcScoreDataAccessInterface = calcScoreDataAccessInterface;

    }

    @Override
    public void execute(SearchInputData searchInputData) {
        String urlString = "https://api.bluecartapi.com/request?api_key=17E691EE2B274440B026E21B2DE8CE76&type=product&item_id=";
        urlString = urlString + searchInputData.getId();

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString)).build();

            JSONObject x = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(JSONObject::new)
                    .join();

            JSONObject pass = x.getJSONObject("request_info");
            boolean success = pass.getBoolean("success");

            if (success) {
                JSONObject iproduct = x.getJSONObject("product");
                String name = iproduct.getString("title");
                String brand = iproduct.getString("brand");
                String description = iproduct.getString("description");

                JSONObject main_image = iproduct.getJSONObject("main_image");
                String image = main_image.getString("link");

                JSONArray variants = iproduct.getJSONArray("variants");
                JSONObject base_item = variants.getJSONObject(0);
                BigDecimal price = base_item.getBigDecimal("price");
                float f_price = price.floatValue();

                CalcScoreInputData calcScoreInputData = new CalcScoreInputData(brand);

                calcScoreInputBoundary calcScoreInteractor = new CalcScoreInteractor(calcScoreDataAccessInterface);
                float esg = calcScoreInteractor.execute(calcScoreInputData);

                Product product = productFactory.create(name, f_price, brand, description, image, esg);

                SearchOutputData searchOutputData = new SearchOutputData(product, false);
                searchPresenter.prepareSuccessView(searchOutputData);

            }

            else {searchPresenter.prepareFailView("Product does not exist, please enter a valid Product ID.");}

        }
        catch (Exception e) {
            searchPresenter.prepareFailView("Search failed please try again.");
        }
    }
}
