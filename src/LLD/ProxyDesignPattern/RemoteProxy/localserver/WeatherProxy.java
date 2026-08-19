package LLD.ProxyDesignPattern.RemoteProxy.localserver;

import LLD.ProxyDesignPattern.RemoteProxy.remoteserver.Weather;
import LLD.ProxyDesignPattern.RemoteProxy.remoteserver.WeatherService;

public class WeatherProxy implements Weather {
     private Weather weather;

    public WeatherProxy() {
        this.weather = new WeatherService();
    }

    @Override
    public String getWeather() {
        authenticate();
        openConnection();
        serializeRequest();
        return sendHttpRequest();
    }

    private void authenticate(){
        System.out.println("Authenticating.....");
    }

    private void openConnection(){
        System.out.println("Opening Connection...");
    }

    private void serializeRequest(){
        System.out.println("Serializing Request...");
    }

    private String sendHttpRequest(){
        System.out.println("Sending HTTP request..");
        return weather.getWeather();
    }

}
