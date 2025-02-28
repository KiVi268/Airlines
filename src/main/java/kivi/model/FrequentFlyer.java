package kivi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FrequentFlyer {

    @JsonProperty("RegisteredFlights")
    public List<RegisteredFlight> registeredFlights;
    @JsonProperty("NickName")
    public String nickName;
    @JsonProperty("TravelDocuments")
    public List<TravelDocument> travelDocuments;
    @JsonProperty("Sex")
    public String sex;
    @JsonProperty("LoyalityProgramm")
    public List<LoyalityProgramm> loyalityProgramm;
    @JsonProperty("RealName")
    public RealName realName;

    public FrequentFlyer() {
    }

    public FrequentFlyer(List<RegisteredFlight> registeredFlights, String nickName,
                         List<TravelDocument> travelDocuments, String sex, List<LoyalityProgramm> loyalityProgramm,
                         RealName realName) {
        this.registeredFlights = registeredFlights;
        this.nickName = nickName;
        this.travelDocuments = travelDocuments;
        this.sex = sex;
        this.loyalityProgramm = loyalityProgramm;
        this.realName = realName;
    }

    public List<RegisteredFlight> getRegisteredFlights() {
        return registeredFlights;
    }

    public void setRegisteredFlights(List<RegisteredFlight> registeredFlights) {
        this.registeredFlights = registeredFlights;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<TravelDocument> getTravelDocuments() {
        return travelDocuments;
    }

    public void setTravelDocuments(List<TravelDocument> travelDocuments) {
        this.travelDocuments = travelDocuments;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<LoyalityProgramm> getLoyalityProgramm() {
        return loyalityProgramm;
    }

    public void setLoyalityProgramm(List<LoyalityProgramm> loyalityProgramm) {
        this.loyalityProgramm = loyalityProgramm;
    }

    public RealName getRealName() {
        return realName;
    }

    public void setRealName(RealName realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "ForumProfile{" +
                "registeredFlights=" + registeredFlights +
                ", nickName='" + nickName + '\'' +
                ", travelDocuments=" + travelDocuments +
                ", sex='" + sex + '\'' +
                ", loyalityProgramm=" + loyalityProgramm +
                ", realName=" + realName +
                '}';
    }
}
