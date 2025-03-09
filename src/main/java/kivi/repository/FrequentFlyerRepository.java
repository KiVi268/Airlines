package kivi.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kivi.model.Example;
import kivi.model.FrequentFlyer;
import kivi.model.RegisteredFlight;

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
            Example example = objectMapper.readValue(bufferedInputStream, Example.class);
            this.frequentFlyerNames = new ArrayList<>(example.getForumProfiles());
        }
    }

    public List<FrequentFlyer> findByDepartureCity(String city) {
        List<FrequentFlyer> result = new ArrayList<>();
        for (FrequentFlyer flyer : frequentFlyerNames) {
            for (RegisteredFlight flight : flyer.getRegisteredFlights()) {
                if (flight.getDeparture() != null && flight.getDeparture().toString().equalsIgnoreCase(city)) {
                    result.add(flyer);
                    break;
                }
            }
        }
        return result;
    }

    public List<FrequentFlyer> findByDepartureDateAfter(LocalDate date) {
        List<FrequentFlyer> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Укажи правильный формат даты

        for (FrequentFlyer flyer : frequentFlyerNames) {
            for (RegisteredFlight flight : flyer.getRegisteredFlights()) {
                if (flight.getDate() != null && !flight.getDate().isEmpty()) {
                    try {
                        LocalDate flightDate = LocalDate.parse(flight.getDate(), formatter);
                        if (flightDate.isAfter(date)) {
                            result.add(flyer);
                            break;
                        }
                    } catch (Exception e) {}
                }
            }
        }
        return result;
    }

    public ArrayList<FrequentFlyer> getFrequentFlyerNames() {
        return frequentFlyerNames;
    }
}
