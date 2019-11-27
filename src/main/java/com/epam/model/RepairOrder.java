package com.epam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonInclude
@JsonPropertyOrder({
        "repairOrderId",
        "repairOrderStartDate",
        "repairOrderEndDate",
        "repairOrderIssueDate",
        "repairOrderCostEstimated",
        "repairOrderCostTotal",
        "client",
        "device",
        "status",
        "employee",
        "sparePart"
})
public class RepairOrder {

    @JsonProperty("repairOrderId")
    private int repairOrderId;
    @JsonProperty("repairOrderStartDate")
    private String repairOrderStartDate;
    @JsonProperty("repairOrderEndDate")
    private String repairOrderEndDate;
    @JsonProperty("repairOrderIssueDate")
    private String repairOrderIssueDate;
    @JsonProperty("repairOrderCostEstimated")
    private BigDecimal repairOrderCostEstimated;
    @JsonProperty("repairOrderCostTotal")
    private BigDecimal repairOrderCostTotal;
    @JsonProperty("client")
    private Client client;
    @JsonProperty("device")
    private Device device;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("employee")
    private Employee employee;
    @JsonProperty("sparePart")
    private SparePart sparePart;

    public int getRepairOrderId() {
        return repairOrderId;
    }

    public void setRepairOrderId(int repairOrderId) {
        this.repairOrderId = repairOrderId;
    }

    public String getRepairOrderStartDate() {
        return repairOrderStartDate;
    }

    public void setRepairOrderStartDate(String repairOrderStartDate) {
        this.repairOrderStartDate = repairOrderStartDate;
    }

    public String getRepairOrderEndDate() {
        return repairOrderEndDate;
    }

    public void setRepairOrderEndDate(String repairOrderEndDate) {
        this.repairOrderEndDate = repairOrderEndDate;
    }

    public String getRepairOrderIssueDate() {
        return repairOrderIssueDate;
    }

    public void setRepairOrderIssueDate(String repairOrderIssueDate) {
        this.repairOrderIssueDate = repairOrderIssueDate;
    }

    public BigDecimal getRepairOrderCostEstimated() {
        return repairOrderCostEstimated;
    }

    public BigDecimal getRepairOrderCostTotal() {
        return repairOrderCostTotal;
    }

    public void setRepairOrderCostTotal(BigDecimal repairOrderCostTotal) {
        this.repairOrderCostTotal = repairOrderCostTotal;
    }

    public void setRepairOrderCostEstimated(BigDecimal repairOrderCostEstimated) {
        this.repairOrderCostEstimated = repairOrderCostEstimated;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SparePart getSparePart() {
        return sparePart;
    }

    public void setSparePart(SparePart sparePart) {
        this.sparePart = sparePart;
    }
}
