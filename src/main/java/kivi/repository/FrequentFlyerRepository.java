package kivi.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kivi.model.json.FrequentFlyerList;
import kivi.model.json.FrequentFlyer;
import kivi.model.json.RegisteredFlight;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FrequentFlyerRepository {
    private ObjectMapper objectMapper;
    private ArrayList<FrequentFlyer> frequentFlyerNames;

    public FrequentFlyerRepository(String fileName) throws IOException {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            FrequentFlyerList frequentFlyerList = objectMapper.readValue(bufferedInputStream, FrequentFlyerList.class);
            this.frequentFlyerNames = new ArrayList<>(frequentFlyerList.getForumProfiles());
        }
    }


    public List<FrequentFlyer> findByDepartureCity(String city) {
        List<FrequentFlyer> result = new ArrayList<>();
        for (FrequentFlyer flyer : frequentFlyerNames) {
            for (RegisteredFlight flight : flyer.getRegisteredFlights()) {
                if (flight.getDeparture() != null &&
                        flight.getDeparture().getCity().equalsIgnoreCase(city)) {
                    result.add(flyer);
                    break;
                }
            }
        }
        return result;
    }

    public List<FrequentFlyer> findByDepartureDateAfter(LocalDate date) {
        List<FrequentFlyer> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (FrequentFlyer flyer : frequentFlyerNames) {
            for (RegisteredFlight flight : flyer.getRegisteredFlights()) {
                if (flight.getDate() != null && !flight.getDate().isEmpty()) {
                    try {
                        LocalDate flightDate = LocalDate.parse(flight.getDate(), formatter);
                        if (flightDate.isAfter(date)) {
                            result.add(flyer);
                            break;
                        }

                    }
                     catch (Exception ignored) {}
                }
            }
        }
        return result;
    }

    public ArrayList<FrequentFlyer> getFrequentFlyerNames() {
        return frequentFlyerNames;
    }
}
