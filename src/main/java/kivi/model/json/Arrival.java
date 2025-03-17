package kivi.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Arrival {

    @JsonProperty("City")
    public String city;
    @JsonProperty("Airport")
    public String airport;
    @JsonProperty("Country")
    public String country;

    public Arrival() {
    }

    public Arrival(String city, String airport, String country) {
        this.city = city;
        this.airport = airport;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Arrival{" +
                "city='" + city + '\'' +
                ", airport='" + airport + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
