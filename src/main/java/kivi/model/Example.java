package kivi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Example {

    @JsonProperty("ForumProfiles")
    public List<FrequentFlyer> frequentFlyers;

    public Example() {
    }

    public Example(List<FrequentFlyer> frequentFlyers) {
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
