package com.dronmed.drone.dto;

public class MedicationDTO {

    private String code;
    private String name;
    private double weight;
    private byte[] image;

    public MedicationDTO() {
    }

    public MedicationDTO(Medication medication) {
        this.code = medication.getCode();
        this.name = medication.getName();
        this.weight = medication.getWeight();
        this.image = medication.getImage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
