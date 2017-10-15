package WeatherAPI;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Weather {
    private String city;
    private String country;
    private String units;
    private final String API_KEY = "1738341ff963f8d39bf3ba958d602cfc";
    private double currentTemp;
    private JSONObject forecast;

    Weather(String city, String country, String units){
        this.city = city;
        this.country = country;
        this.units = units;
        try {
            this.extractWeatherJSON(this.getWeatherJSON());
            this.extractForecastJSON(this.getForecastJSON());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void extractForecastJSON(JSONObject jsonObject) {
        this.forecast = jsonObject.getJSONArray("list").getJSONObject(0);
    }

    private void extractWeatherJSON(JSONObject jsonObject){
        this.currentTemp =
                jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("main").getDouble("temp");
    }

    private String generateLink(){
        return "https://api.openweathermap.org/data/2.5/find?q=" + this.city
                + "," + this.country + "&units=metric"+ this.units + "&APPID=" + API_KEY;
    }

    private String generateForecastLink(){
        return "https://api.openweathermap.org/data/2.5/forecast?q=" + this.city
                + "," + this.country + "&APPID=" + API_KEY;
    }

    JSONObject getForecastJSON() throws IOException {

        URL url = new URL(this.generateForecastLink());
        URLConnection con = url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        con.connect();
        InputStream input = con.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            stringBuilder.append(line);
        }

        return new JSONObject(stringBuilder.toString());

    }

    JSONObject getWeatherJSON() throws IOException {

        URL url = new URL(this.generateLink());
        URLConnection con = url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        con.connect();
        InputStream input = con.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            stringBuilder.append(line);
        }

        return new JSONObject(stringBuilder.toString());
    }
}
