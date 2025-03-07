package kivi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kivi.model.FrequentFlyer;
import kivi.model.RegisteredFlight;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FrequentFlyerRepository {
    private ObjectMapper objectMapper = new ObjectMapper();
    private ArrayList<FrequentFlyer> frequentFlyerNames;

    public FrequentFlyerRepository(String fileName) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
            this.frequentFlyerNames = objectMapper.readValue(bufferedInputStream, new TypeReference<>() {});
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
