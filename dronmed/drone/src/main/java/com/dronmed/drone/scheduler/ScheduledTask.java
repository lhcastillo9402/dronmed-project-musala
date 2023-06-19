package com.dronmed.drone.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Autowired
    private DroneService droneService;

    @Scheduled(fixedRate = 60000) // Run every minute
    public void updateDroneStates() {
        // Call service method to update the states of all drones based on their battery levels and history events
        droneService.updateDroneStates();
    }
}
