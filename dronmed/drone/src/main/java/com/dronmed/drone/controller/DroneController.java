package com.dronmed.drone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping
    public ResponseEntity<DroneDTO> registerDrone(@RequestBody DroneDTO droneDTO) {
        // Call service method to register a new drone
        DroneDTO createdDrone = droneService.registerDrone(droneDTO);

        // Return response entity with status 201 (Created) and the created drone DTO
        return new ResponseEntity<>(createdDrone, HttpStatus.CREATED);
    }

    @PutMapping("/{serialNumber}/load")
    public ResponseEntity<DroneDTO> loadDrone(@PathVariable String serialNumber, @RequestBody List<String> medicationCodes) {
        // Call service method to load a drone with medications
        DroneDTO loadedDrone = droneService.loadDrone(serialNumber, medicationCodes);

        // Return response entity with status 200 (OK) and the loaded drone DTO
        return new ResponseEntity<>(loadedDrone, HttpStatus.OK);
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<DroneDTO> getDroneBySerialNumber(@PathVariable String serialNumber) {
        // Call service method to get a drone by serial number
        DroneDTO foundDrone = droneService.getDroneBySerialNumber(serialNumber);

        // Return response entity with status 200 (OK) and the found drone DTO
        return new ResponseEntity<>(foundDrone, HttpStatus.OK);
    }

    @GetMapping("/{serialNumber}/medications")
    public ResponseEntity<List<MedicationDTO>> getLoadedMedicationsBySerialNumber(@PathVariable String serialNumber) {
        // Call service method to get the medications loaded in a drone by serial number
        List<MedicationDTO> foundMedications = droneService.getLoadedMedicationsBySerialNumber(serialNumber);

        // Return response entity with status 200 (OK) and the found medications DTOs
        return new ResponseEntity<>(foundMedications, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<DroneDTO>> getAvailableDrones() {
        // Call service method to get all available drones
        List<DroneDTO> availableDrones = droneService.getAvailableDrones();

        // Return response entity with status 200 (OK) and the available drones DTOs
        return new ResponseEntity<>(availableDrones, HttpStatus.OK);
    }
}
