package use_case.search.calc_score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class CalcScoreInteractor implements CalcScoreInputBoundary{
    final CalcScoreDataAccessInterface calcScoreDataAccessInterface;

    public CalcScoreInteractor (CalcScoreDataAccessInterface calcScoreDataAccessInterface) {
        this.calcScoreDataAccessInterface = calcScoreDataAccessInterface;
    }
    @Override
    public float execute(CalcScoreInputData calcScoreInputData) {
        String brand = calcScoreInputData.getCompany();
        String company = find_parent_company(brand);
        if (company.equals("Item Not Found.")) {
            return -1.00F;
        }
        return calcScoreDataAccessInterface.get_score_from_file(company, brand);
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

            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + "What is the parent company for " + brand + "? Write " + brand + "'s official company name if " + brand + " is a parent company. Only use ONE OR TWO WORDS in your response." + "\"}]}";
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
            return "Item Not Found.";
        }
    }

    public static String extractMessageFromJSONResponse(String response) {
        int start = response.indexOf("content")+ 11;

        int end = response.indexOf("\"", start);

        return response.substring(start, end);

    }
}
