package kivi.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FrequentFlyerList {

    @JsonProperty("Forum Profiles")
    private List<FrequentFlyer> frequentFlyers;

    public FrequentFlyerList() {
    }

    public FrequentFlyerList(List<FrequentFlyer> frequentFlyers) {
        this.frequentFlyers = frequentFlyers;
    }

    public List<FrequentFlyer> getForumProfiles() {
        return frequentFlyers;
    }

    public void setForumProfiles(List<FrequentFlyer> frequentFlyers) {
        this.frequentFlyers = frequentFlyers;
    }

    @Override
    public String toString() {
        return "Example{" +
                "forumProfiles=" + frequentFlyers +
                '}';
    }
}
