package com.epam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sparePartName",
        "sparePartCost"
})
public class SparePart {

    @JsonProperty("sparePartName")
    public String sparePartName;
    @JsonProperty("sparePartCost")
    public BigDecimal sparePartCost;

    public String getSparePartName() {
        return sparePartName;
    }

    public void setSparePartName(String sparePartName) {
        this.sparePartName = sparePartName;
    }

    public BigDecimal getSparePartCost() {
        return sparePartCost;
    }

    public void setSparePartCost(BigDecimal sparePartCost) {
        this.sparePartCost = sparePartCost;
    }
}
