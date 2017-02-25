package page;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class OpenWeatherPage {
    private static String url = "https://openweathermap.org/city/703448";
    private Document document;
    private static String temperatureLocatorId = "weather-widget-temperature";
    private static String pressureLocatorId = "weather-widget-pressure";

    public OpenWeatherPage(){
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e){
            throw new RuntimeException("Failed to connect open weather page");
        }
    }

    public String getTemperature(){
        Element element = document.getElementById(temperatureLocatorId);
        return element.text();
    }

    public String getPressure(){
        Element element = document.getElementById(pressureLocatorId);
        return element.text();
    }

    public static void main(String[] args) {
        OpenWeatherPage page = new OpenWeatherPage();
        String temp = page.getTemperature();
        String pr = page.getPressure();
    }

}
