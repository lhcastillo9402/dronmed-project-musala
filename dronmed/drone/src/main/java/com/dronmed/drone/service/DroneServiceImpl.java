package com.dronmed.drone.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DroneServiceImpl implements DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    @Autowired
    private HistoryEventRepository historyEventRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DroneDTO registerDrone(DroneDTO droneDTO) {
        // Convert DTO to entity
        Drone drone = modelMapper.map(droneDTO, Drone.class);

        // Save entity in database
        drone = droneRepository.save(drone);

        // Convert entity to DTO and return it
        return modelMapper.map(drone, DroneDTO.class);
    }

    @Override
    public DroneDTO loadDrone(String serialNumber, List<String> medicationCodes) {
        // Find drone by serial number or throw exception if not found
        Drone drone = droneRepository.findById(serialNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Drone not found with serial number: " + serialNumber));

        // Check if drone is in IDLE state or throw exception if not
        if (drone.getState() != DroneState.IDLE) {
            throw new IllegalStateException("Drone is not in IDLE state");
        }

        // Check if drone has enough battery or throw exception if not
        if (drone.getBatteryCapacity() < 25) {
            throw new IllegalStateException("Drone has low battery");
        }

        // Find medications by codes or throw exception if not found
        List<Medication> medications = medicationRepository.findAllById(medicationCodes);
        if (medications.size() != medicationCodes.size()) {
            throw new ResourceNotFoundException("Some medications not found with codes: " + medicationCodes);
        }

        // Calculate the total weight of the medications
        double totalWeight = medications.stream()
                .mapToDouble(Medication::getWeight)
                .sum();

        // Check if drone can carry the total weight or throw exception if not
        if (totalWeight > drone.getWeightLimit()) {
            throw new IllegalStateException("Drone cannot carry more than " + drone.getWeightLimit() + " grams");
        }

        // Set the drone as the owner of the medications
        medications.forEach(medication -> medication.setDrone(drone));

        // Save the medications in database
        medicationRepository.saveAll(medications);

        // Update the state of the drone to LOADING and save it in database
        drone.setState(DroneState.LOADING);
        drone = droneRepository.save(drone);

        // Convert entity to DTO and return it
        return modelMapper.map(drone, DroneDTO.class);
    }

    @Override
    public DroneDTO getDroneBySerialNumber(String serialNumber) {
        // Find drone by serial number or throw exception if not found
        Drone drone = droneRepository.findById(serialNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Drone not found with serial number: " + serialNumber));

        // Convert entity to DTO and return it
        return modelMapper.map(drone, DroneDTO.class);
    }

    @Override
    public List<MedicationDTO> getLoadedMedicationsBySerialNumber(String serialNumber) {
        // Find drone by serial number or throw exception if not found
        Drone drone = droneRepository.findById(serialNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Drone not found with serial number: " + serialNumber));

        // Get the medications of the drone
        List<Medication> medications = drone.getMedications();

        // Convert entities to DTOs and return them
        return medications.stream()
                .map(medication -> modelMapper.map(medication, MedicationDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DroneDTO> getAvailableDrones() {
        // Find all drones that are in IDLE state and have enough battery
        List<Drone> drones = droneRepository.findAll()
                .stream()
                .filter(drone -> drone.getState() == DroneState.IDLE && drone.getBatteryCapacity() >= 25)
                .collect(Collectors.toList());

        // Convert entities to DTOs and return them
        return drones.stream()
                .map(drone -> modelMapper.map(drone, DroneDTO.class))
                .collect(Collectors.toList());
    }
}
