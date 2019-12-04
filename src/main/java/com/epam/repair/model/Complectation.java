package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "complectationName"
})
public class Complectation {

    public String getComplectationName() {
        return complectationName;
    }

    public void setComplectationName(String complectationName) {
        this.complectationName = complectationName;
    }

    @JsonProperty("complectationName")
    public String complectationName;

}
