package kivi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Example {

    @JsonProperty("ForumProfiles")
    public List<ForumProfile> forumProfiles;

    public Example() {
    }

    public Example(List<ForumProfile> forumProfiles) {
        this.forumProfiles = forumProfiles;
    }

    public List<ForumProfile> getForumProfiles() {
        return forumProfiles;
    }

    public void setForumProfiles(List<ForumProfile> forumProfiles) {
        this.forumProfiles = forumProfiles;
    }

    @Override
    public String toString() {
        return "Example{" +
                "forumProfiles=" + forumProfiles +
                '}';
    }
}
