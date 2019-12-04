package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Sort_ {

    @JsonProperty("sorted")
    public boolean sorted;
    @JsonProperty("unsorted")
    public boolean unsorted;
    @JsonProperty("empty")
    public boolean empty;

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    public boolean isUnsorted() {
        return unsorted;
    }

    public void setUnsorted(boolean unsorted) {
        this.unsorted = unsorted;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
