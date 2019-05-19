package services;

import domain.CurrentWeather;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.IOException;

public class ShowWeather {

    public StringBuilder make (OpenWeatherMapApi apiService)
            throws JsonParseException, JsonMappingException, IOException
    {

        String url = "http://api.openweathermap.org/data/2.5/weather?units"
                +"=metric&lang=pl&appid=7b8ae714c290ba2aa42fab1aa9183de8&q="
                +apiService.getCity();


        CurrentWeather currentWeather;
        currentWeather = apiService.getAll(url);

        StringBuilder stringBuilder = new StringBuilder();

        try {
            stringBuilder.append(
                    "<h3>"+currentWeather.getName()+"</h3>"
                            +"<h4>"+currentWeather.getWeather()[6]+"</h4>"
                            +"<table>"
                            + "<tr><td>Temperatura:</td><td>"+currentWeather.getMain().getTemp()+" <sup>o</sup>C</td></tr>"
                            + "<tr><td>Zachmurzenie:</td><td>"+currentWeather.getClouds().getAll()+"%</td></tr>"
                            + "<tr><td>Cisnienie atmosferyczne:</td><td>"+currentWeather.getMain().getPressure()+" hPa</td></tr>"
                            + "<tr><td>Predkosc wiatru:</td><td>"+currentWeather.getWind().getSpeed()+" m/s</td></tr>"
                            + "</table>"

            );
        } catch (NullPointerException e) {

            e.printStackTrace();
            stringBuilder.append("<br><br><br>API error...");
            return stringBuilder;
        }

        return stringBuilder;

    }
}
