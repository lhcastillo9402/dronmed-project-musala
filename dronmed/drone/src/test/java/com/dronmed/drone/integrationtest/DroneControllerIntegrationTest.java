package com.dronmed.drone.integrationtest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class DroneControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    @Before
    public void setUp() {
        // insert some test data into H2 database
    }

    @Test
    public void givenDrones_whenGetAvailableDrones_thenReturnJsonArray() throws Exception {
        // given
        Drone drone1 = new Drone("D001", DroneModel.MAVIC, 500, 100, DroneState.IDLE);
        Drone drone2 = new Drone("D002", DroneModel.PHANTOM, 1000, 80, DroneState.IDLE);
        droneRepository.saveAll(Arrays.asList(drone1, drone2));

        // when
        mvc.perform(get("/drones/available")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(2)))
          .andExpect(jsonPath("$[0].serialNumber", is("D001")))
          .andExpect(jsonPath("$[0].model", is("MAVIC")))
          .andExpect(jsonPath("$[0].weightLimit", is(500.0)))
          .andExpect(jsonPath("$[0].batteryCapacity", is(100)))
          .andExpect(jsonPath("$[0].state", is("IDLE")))
          .andExpect(jsonPath("$[1].serialNumber", is("D002")))
          .andExpect(jsonPath("$[1].model", is("PHANTOM")))
          .andExpect(jsonPath("$[1].weightLimit", is(1000.0)))
          .andExpect(jsonPath("$[1].batteryCapacity", is(80)))
          .andExpect(jsonPath("$[1].state", is("IDLE")));
    }
}
