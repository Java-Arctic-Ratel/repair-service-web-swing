package com.epam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "appearanceName"
})
public class Appearance {

    public String getAppearanceName() {
        return appearanceName;
    }

    public void setAppearanceName(String appearanceName) {
        this.appearanceName = appearanceName;
    }

    @JsonProperty("appearanceName")
    public String appearanceName;

}
