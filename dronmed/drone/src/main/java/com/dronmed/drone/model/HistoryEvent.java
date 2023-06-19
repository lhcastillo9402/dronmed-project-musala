package com.dronmed.drone.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history_events")
public class HistoryEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "battery_level", nullable = false)
    private int batteryLevel;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "drone_serial_number")
    private Drone drone;

    public HistoryEvent() {
    }

    public HistoryEvent(int batteryLevel, LocalDateTime timestamp) {
        this.batteryLevel = batteryLevel;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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

       HistoryEvent historyEvent = (HistoryEvent) o;

       return id.equals(historyEvent.id);
   }

   @Override
   public int hashCode() {
       return id.hashCode();
   }

   @Override
   public String toString() {
       return "HistoryEvent{" +
               "id=" + id +
               ", batteryLevel=" + batteryLevel +
               ", timestamp=" + timestamp +
               '}';
   }
}