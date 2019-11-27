package com.epam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "deviceIMEIOrSn",
        "devicePassword",
        "type",
        "model",
        "brand",
        "appearance",
        "complectation",
        "defect"
})
public class Device {

    @JsonProperty("deviceIMEIOrSn")
    public String deviceIMEIOrSn;
    @JsonProperty("devicePassword")
    public String devicePassword;
    @JsonProperty("type")
    public Type type;
    @JsonProperty("model")
    public Model model;
    @JsonProperty("brand")
    public Brand brand;
    @JsonProperty("appearance")
    public Appearance appearance;
    @JsonProperty("complectation")
    public Complectation complectation;
    @JsonProperty("defect")
    public Defect defect;

    public String getDeviceIMEIOrSn() {
        return deviceIMEIOrSn;
    }

    public void setDeviceIMEIOrSn(String deviceIMEIOrSn) {
        this.deviceIMEIOrSn = deviceIMEIOrSn;
    }

    public String getDevicePassword() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Complectation getComplectation() {
        return complectation;
    }

    public void setComplectation(Complectation complectation) {
        this.complectation = complectation;
    }

    public Defect getDefect() {
        return defect;
    }

    public void setDefect(Defect defect) {
        this.defect = defect;
    }
}
