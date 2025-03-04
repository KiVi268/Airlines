package kivi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kivi.model.FrequentFlyer;

import java.io.*;
import java.util.ArrayList;

public class FrequentFlyerRepository {
    private ObjectMapper objectMapper = new ObjectMapper();
    private ArrayList<FrequentFlyer> frequentFlyerNames;

    public FrequentFlyerRepository() {
    }

    public FrequentFlyerRepository(String fileName) throws IOException {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))){
            this.frequentFlyerNames = objectMapper.readValue(bufferedInputStream, new TypeReference<>() {});
        }
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ArrayList<FrequentFlyer> getFrequentFlyerNames() {
        return frequentFlyerNames;
    }

    public void setFrequentFlyerNames(ArrayList<FrequentFlyer> frequentFlyerNames) {
        this.frequentFlyerNames = frequentFlyerNames;
    }

    @Override
    public String toString() {
        return "FrequentFlyerRepository{" +
                "objectMapper=" + objectMapper +
                ", frequentFlyerNames=" + frequentFlyerNames +
                '}';
    }
}
