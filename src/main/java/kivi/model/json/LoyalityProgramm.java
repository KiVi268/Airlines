package kivi.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoyalityProgramm {

    @JsonProperty("Status")
    public String status;
    @JsonProperty("programm")
    public String programm;
    @JsonProperty("Number")
    public String number;

    public LoyalityProgramm() {
    }

    public LoyalityProgramm(String status, String programm, String number) {
        this.status = status;
        this.programm = programm;
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgramm() {
        return programm;
    }

    public void setProgramm(String programm) {
        this.programm = programm;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "LoyalityProgramm{" +
                "status='" + status + '\'' +
                ", programm='" + programm + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
