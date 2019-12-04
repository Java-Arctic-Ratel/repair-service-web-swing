package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class RepairOrderPage {

    @JsonProperty("content")
    public List<RepairOrder> content;
    @JsonProperty("pageable")
    public Pageable pageable;
    @JsonProperty("totalPages")
    public int totalPages;
    @JsonProperty("totalElements")
    public int totalElements;
    @JsonProperty("last")
    public boolean last;
    @JsonProperty("first")
    public boolean first;
    @JsonProperty("number")
    public int number;
    @JsonProperty("sort")
    public Sort_ sort;
    @JsonProperty("numberOfElements")
    public int numberOfElements;
    @JsonProperty("size")
    public int size;
    @JsonProperty("empty")
    public boolean empty;

    public List<RepairOrder> getContent() {
        return content;
    }

    public void setContent(List<RepairOrder> content) {
        this.content = content;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Sort_ getSort() {
        return sort;
    }

    public void setSort(Sort_ sort) {
        this.sort = sort;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

}
