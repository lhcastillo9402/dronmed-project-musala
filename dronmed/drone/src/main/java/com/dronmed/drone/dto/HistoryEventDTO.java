package com.dronmed.drone.dto;

public class HistoryEventDTO {

    private Long id;
    private int batteryLevel;
    private LocalDateTime timestamp;

    public HistoryEventDTO() {
    }

    public HistoryEventDTO(HistoryEvent historyEvent) {
        this.id = historyEvent.getId();
        this.batteryLevel = historyEvent.getBatteryLevel();
        this.timestamp = historyEvent.getTimestamp();
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
}
