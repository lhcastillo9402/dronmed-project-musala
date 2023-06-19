package com.dronmed.drone.unittest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroneServiceUnitTest {

    @MockBean
    private DroneRepository droneRepository;

    @MockBean
    private MedicationRepository medicationRepository;

    @MockBean
    private HistoryEventRepository historyEventRepository;

    @Autowired
    private DroneService droneService;

    @Test
    public void whenRegisterDrone_thenDroneShouldBeSaved() {
        // given
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setSerialNumber("D001");
        droneDTO.setModel(DroneModel.MAVIC);
        droneDTO.setWeightLimit(500);
        droneDTO.setBatteryCapacity(100);

        Drone drone = new Drone();
        drone.setSerialNumber("D001");
        drone.setModel(DroneModel.MAVIC);
        drone.setWeightLimit(500);
        drone.setBatteryCapacity(100);
        drone.setState(DroneState.IDLE);

        when(droneRepository.save(any(Drone.class))).thenReturn(drone);

        // when
        DroneDTO createdDrone = droneService.registerDrone(droneDTO);

        // then
        verify(droneRepository, times(1)).save(any(Drone.class));
        assertEquals(droneDTO.getSerialNumber(), createdDrone.getSerialNumber());
        assertEquals(droneDTO.getModel(), createdDrone.getModel());
        assertEquals(droneDTO.getWeightLimit(), createdDrone.getWeightLimit(), 0.01);
        assertEquals(droneDTO.getBatteryCapacity(), createdDrone.getBatteryCapacity());
        assertEquals(DroneState.IDLE, createdDrone.getState());
    }
}
