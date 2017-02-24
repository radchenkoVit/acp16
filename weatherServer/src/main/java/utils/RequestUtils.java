package utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import static utils.Configuration.weatherKey;

public class RequestUtils {
    private static String weatherEndPoint = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    public static String getWeather(String city) throws UnirestException {
        String url = String.format(weatherEndPoint, city, weatherKey);
        HttpResponse<JsonNode> response = sendGet(url);
        return response.getBody().toString();
    }

    private static HttpResponse<JsonNode> sendGet(String url) throws UnirestException {
        return Unirest.get(url).asJson();
    }
}
