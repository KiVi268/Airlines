package kivi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RealName {

    @JsonProperty("LastName")
    public Object lastName;
    @JsonProperty("FirstName")
    public Object firstName;

    public RealName() {
    }

    public RealName(Object lastName, Object firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Object getLastName() {
        return lastName;
    }

    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    public Object getFirstName() {
        return firstName;
    }

    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "RealName{" +
                "lastName=" + lastName +
                ", firstName=" + firstName +
                '}';
    }
}
