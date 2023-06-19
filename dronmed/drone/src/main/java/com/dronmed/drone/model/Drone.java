package com.dronmed.drone.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drones")
public class Drone {

    @Id
    @Column(name = "serial_number", length = 100)
    private String serialNumber;

    @Column(name = "model", nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneModel model;

    @Column(name = "weight_limit", nullable = false)
    private double weightLimit;

    @Column(name = "battery_capacity", nullable = false)
    private int batteryCapacity;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneState state;

    @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medication> medications;

    @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoryEvent> historyEvents;

    public Drone() {
    }

    public Drone(String serialNumber, DroneModel model, double weightLimit, int batteryCapacity, DroneState state) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public DroneModel getModel() {
        return model;
    }

    public void setModel(DroneModel model) {
        this.model = model;
    }

    public double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public DroneState getState() {
        return state;
    }

    public void setState(DroneState state) {
        this.state = state;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public List<HistoryEvent> getHistoryEvents() {
        return historyEvents;
    }

    public void setHistoryEvents(List<HistoryEvent> historyEvents) {
        this.historyEvents = historyEvents;
    }

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;

       Drone drone = (Drone) o;

       return serialNumber.equals(drone.serialNumber);
   }

   @Override
   public int hashCode() {
       return serialNumber.hashCode();
   }

   @Override
   public String toString() {
       return "Drone{" +
               "serialNumber='" + serialNumber + '\'' +
               ", model=" + model +
               ", weightLimit=" + weightLimit +
               ", batteryCapacity=" + batteryCapacity +
               ", state=" + state +
               '}';
   }
}
