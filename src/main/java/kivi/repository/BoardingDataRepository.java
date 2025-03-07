package kivi.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import kivi.model.BoardingData;

import java.io.*;
import java.util.List;

public class BoardingDataRepository {
    private List<BoardingData> boardingDataRepositoryList;
    private ObjectMapper objectMapper;

    public BoardingDataRepository() {
    }

    public BoardingDataRepository(List<BoardingData> boardingDataRepositoryList, ObjectMapper objectMapper) {
        this.boardingDataRepositoryList = boardingDataRepositoryList;
        this.objectMapper = objectMapper;
    }

    public List<BoardingData> getBoardingDataList() {
        return boardingDataRepositoryList;
    }

    public void setBoardingDataList(List<BoardingData> boardingDataRepositoryList) {
        this.boardingDataRepositoryList = boardingDataRepositoryList;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void loadFromCSV(String csvFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 5) {
                BoardingData boardingData = new BoardingData(
                        data[0], //passengerId
                        data[1], //flightId
                        data[2], //seat
                        data[3], //boardingTime
                        data[4] //departureCity
                );
                boardingDataRepositoryList.add(boardingData);
            }
        }
    }

    public void saveToJSON(String jsonFile) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jsonFile));
        objectMapper.writeValue(bufferedWriter, boardingDataRepositoryList);
    }

    @Override
    public String toString() {
        return "BoardingData{" +
                "boardingDataList=" + boardingDataRepositoryList +
                ", objectMapper=" + objectMapper +
                '}';
    }
}
