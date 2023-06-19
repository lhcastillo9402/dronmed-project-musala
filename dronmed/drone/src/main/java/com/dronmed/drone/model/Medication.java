package com.dronmed.drone.model;

import javax.persistence.*;

@Entity
@Table(name = "medications")
public class Medication {

    @Id
    @Column(name = "code", length = 10)
    private String code;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "image", nullable = false)
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "drone_serial_number")
    private Drone drone;

    public Medication() {
    }

    public Medication(String code, String name, double weight, byte[] image) {
        this.code = code;
        this.name = name;
        this.weight = weight;
        this.image = image;
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

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (o == null || getClass() != o.getClass()) return false;

       Medication medication = (Medication) o;

       return code.equals(medication.code);
   }

   @Override
   public int hashCode() {
       return code.hashCode();
   }

   @Override
   public String toString() {
       return "Medication{" +
               "code='" + code + '\'' +
               ", name='" + name + '\'' +
               ", weight=" + weight +
               '}';
   }
}
