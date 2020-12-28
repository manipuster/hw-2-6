package ru.surova.java.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {

    public static void main(String[] args) throws IOException {

        int locationKey = 295212;
        String apiKey = "6qFSSAWK1DsVtZtbAsiRKH02G9SzCT4l";
        URL url = new URL (
            "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" +
            locationKey + "?apikey=" + apiKey
        );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String json = "";
        String line;
        while ((line = reader.readLine()) != null){
            json += line;
        }
        System.out.println(json);
    }
}
