package domain;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CurrentWeather {

    private String name;
    private String[] weather;
    private Clouds clouds;
    private Main main;
    private Wind wind;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Clouds getClouds() {
        return clouds;
    }
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }
    public Main getMain() {
        return main;
    }
    public void setMain(Main main) {
        this.main = main;
    }
    public Wind getWind() {
        return wind;
    }
    public void setWind(Wind wind) {
        this.wind = wind;
    }
    public String[] getWeather() {
        return weather;
    }
    public void setWeather(String[] weather) {
        this.weather = weather;
    }

}
