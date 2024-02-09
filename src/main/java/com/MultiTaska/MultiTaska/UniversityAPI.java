package com.MultiTaska.MultiTaska;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class UniversityAPI {
    String country = getInput("Enter the country name: ");

    String apiUrl = "http://universities.hipolabs.com/search?country=" + country;
    URL url = null;

    public void getJsonUni(String apiUrl) throws MalformedURLException {

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }


                    JsonArray universitiesArray = JsonParser.parseString(response.toString()).getAsJsonArray();

                    // Обработка каждого элемента
                    for (JsonElement element : universitiesArray) {
                        System.out.println("University Name: " + element.getAsJsonObject().get("name"));
                        System.out.println("Website: " + element.getAsJsonObject().get("web_pages").getAsJsonArray().get(0));
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Error: Unable to get universities data. HTTP response code " + responseCode);
            }
        } catch (
                IOException e) {
            System.err.println("Error: Failed to fetch universities data. " + e.getMessage());
        }
    }

        public static String getInput (String prompt){
            System.out.print(prompt);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                return reader.readLine();
            } catch (IOException e) {
                System.err.println("Error: Failed to read input. " + e.getMessage());
                return "";
            }
        }
    }
