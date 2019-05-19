package test;

import com.sun.jersey.api.client.ClientHandlerException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import services.OpenWeatherMapApi;

import javax.json.JsonException;
import java.io.IOException;

public class TestOpenWeatherMapApi {


    @Test(expected = ClientHandlerException.class)
    public void test_should_give_exception_when_url_is_wrong() throws JsonMappingException, JsonException, IOException {

        OpenWeatherMapApi apiService = new OpenWeatherMapApi();
        apiService.getAll("openwaether.xx");

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_should_give_exception_when_name_of_city_is_wrong() throws JsonMappingException, JsonException, IOException {

        OpenWeatherMapApi apiService = new OpenWeatherMapApi();
        apiService.getAll("http://api.openweathermap.org/data/2.5/weather?units"
                +"=metric&lang=pl&appid=7b8ae714c290ba2aa42fab1aa9183de8&q=Zakopane");

    }


}
