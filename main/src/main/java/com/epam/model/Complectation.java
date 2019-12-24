package com.epam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

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
