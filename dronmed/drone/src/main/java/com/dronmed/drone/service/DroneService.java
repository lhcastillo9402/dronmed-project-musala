package com.dronmed.drone.service;

import java.util.List;

public interface DroneService {

    DroneDTO registerDrone(DroneDTO droneDTO);

    DroneDTO loadDrone(String serialNumber, List<String> medicationCodes);

    DroneDTO getDroneBySerialNumber(String serialNumber);

    List<MedicationDTO> getLoadedMedicationsBySerialNumber(String serialNumber);

    List<DroneDTO> getAvailableDrones();
}
