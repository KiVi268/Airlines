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
            // Замени на логичное название
            Example example = objectMapper.readValue(bufferedInputStream, Example.class);
            // храни в памяти сразу объект, а не список из этого объекта
            this.frequentFlyerNames = new ArrayList<>(example.getForumProfiles());
        }
    }

    // Комменты поставь над методами, у меня же нет задания)
    public List<FrequentFlyer> findByDepartureCity(String city) {
        List<FrequentFlyer> result = new ArrayList<>();
        for (FrequentFlyer flyer : frequentFlyerNames) {
            for (RegisteredFlight flight : flyer.getRegisteredFlights()) {
                if (flight.getDeparture() != null &&
                        // У тебя в этом классе есть поле city используй его
                        // + ко всему этот код не правильно работает
                        flight.getDeparture().toString().equalsIgnoreCase(city)) {
                    result.add(flyer);
                    break;
                }
            }
        }
        return result;
    }

    public List<FrequentFlyer> findByDepartureDateAfter(LocalDate date) {
        List<FrequentFlyer> result = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Укажи правильный формат даты (АЙ ЯЙ ЯЙ заебал пользоваться нейронками)

        for (FrequentFlyer flyer : frequentFlyerNames) {
            for (RegisteredFlight flight : flyer.getRegisteredFlights()) {
                if (flight.getDate() != null && !flight.getDate().isEmpty()) {
                    try {
                        LocalDate flightDate = LocalDate.parse(flight.getDate(), formatter);
                        if (flightDate.isAfter(date)) {
                            result.add(flyer);
                            break;
                        }

                    } // если блок catch пустой, то можно юзать вместо e -> ignored
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
