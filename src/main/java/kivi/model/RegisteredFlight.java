package kivi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisteredFlight {

    @JsonProperty("Date")
    public String date;
    @JsonProperty("Codeshare")
    public boolean codeshare;
    @JsonProperty("Arrival")
    public Arrival arrival;
    @JsonProperty("Flight")
    public String flight;
    @JsonProperty("Departure")
    public Departure departure;

    public RegisteredFlight() {
    }

    public RegisteredFlight(String date, boolean codeshare, Arrival arrival, String flight, Departure departure) {
        this.date = date;
        this.codeshare = codeshare;
        this.arrival = arrival;
        this.flight = flight;
        this.departure = departure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCodeshare() {
        return codeshare;
    }

    public void setCodeshare(boolean codeshare) {
        this.codeshare = codeshare;
    }

    public Arrival getArrival() {
        return arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public Departure getDeparture() {
        return departure;
    }

    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "RegisteredFlight{" +
                "date='" + date + '\'' +
                ", codeshare=" + codeshare +
                ", arrival=" + arrival +
                ", flight='" + flight + '\'' +
                ", departure=" + departure +
                '}';
    }
}
