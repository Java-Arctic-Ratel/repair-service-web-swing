package com.epam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "clientPhoneNumber",
        "firstName",
        "lastName",
        "address"
})
public class Client {
    @JsonProperty("clientPhoneNumber")
    public String clientPhoneNumber;
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("address")
    public Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
