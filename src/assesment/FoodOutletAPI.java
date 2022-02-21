package assesment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FoodOutletAPI {


    public static List<String> getRelevantFood(String city, int mincost) throws IOException {
        String endpoint = "https://jsonmock.hackerank.com/api/food_outlets?city=<city>&page=<pageno>";
        List<String> output = new ArrayList<>();
        int totalPages = -1;
        sendGET(endpoint.replace("<city>", city).replace("<pageno>", String.valueOf(1)));


        return output;

    }
    private static void sendGET(String GET_URL) throws IOException {
        URL obj = new URL(GET_URL);
        final String USER_AGENT = "Mozilla/5.0";

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setConnectTimeout(5000);
        con.addRequestProperty("Content-type", "application/json");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }

    }


    public static void main(String[] args) throws IOException {
        getRelevantFood("Denver", 5);
    }
}
