package services;

import java.io.IOException;

import domain.CurrentWeather;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class OpenWeatherMapApi {

    private String city;

    public CurrentWeather getAll(String url) throws JsonParseException, JsonMappingException, IOException {

        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);

        WebResource webResource;
        webResource = client.resource(url);


        String response = webResource.get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CurrentWeather res;
        res = mapper.readValue(response, CurrentWeather.class);

        return res;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}