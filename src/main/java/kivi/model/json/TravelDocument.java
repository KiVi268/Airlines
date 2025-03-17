package kivi.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TravelDocument {

    @JsonProperty("Passports")
    public Object passports;

    public TravelDocument() {
    }

    public TravelDocument(Object passports) {
        this.passports = passports;
    }

    public Object getPassports() {
        return passports;
    }

    public void setPassports(Object passports) {
        this.passports = passports;
    }

    @Override
    public String toString() {
        return "TravelDocument{" +
                "passports=" + passports +
                '}';
    }
}