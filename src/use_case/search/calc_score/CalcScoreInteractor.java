package use_case.search.calc_score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class CalcScoreInteractor implements CalcScoreInputBoundary{
    final CalcScoreOutputBoundary calcScoreOutputBoundary;
    final CalcScoreDataAccessInterface calcScoreDataAccessInterface;

    public CalcScoreInteractor (CalcScoreOutputBoundary calcScoreOutputBoundary, CalcScoreDataAccessInterface calcScoreDataAccessInterface) {
        this.calcScoreOutputBoundary = calcScoreOutputBoundary;
        this.calcScoreDataAccessInterface = calcScoreDataAccessInterface;
    }
    @Override
    public void execute(CalcScoreInputData calcScoreInputData) {
        String brand = calcScoreInputData.getCompany();
        String company = find_parent_company(brand);
        float score = calcScoreDataAccessInterface.get_score_from_file(company, brand);
    }

    public String find_parent_company(String brand) {
        String apiKey = "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";
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        String model = "gpt-3.5-turbo";

        try {
            URL obj = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + "What is the parent company for " + brand + " in one word?" + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // calls the method to extract the message.
            return extractMessageFromJSONResponse(response.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String extractMessageFromJSONResponse(String response) {
        int start = response.indexOf("content")+ 11;

        int end = response.indexOf("\"", start);

        return response.substring(start, end);

    }
}
