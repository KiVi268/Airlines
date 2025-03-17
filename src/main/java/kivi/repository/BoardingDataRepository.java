package kivi.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kivi.model.csv.BoardingDataCSV;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Для обработки файла BoardingData.csv создать отдельную модель данных и репозиторий.
 * Реализовать метод, который производит выгрузку коллекции из репозитория
 * в формате JSON в указанный файл
 */

public class BoardingDataRepository {
    private List<BoardingDataCSV> boardingDataRepositoryList;
    private ObjectMapper objectMapper;

    public BoardingDataRepository() {
    }

    public BoardingDataRepository(String fileName) throws IOException {
        this.objectMapper = new ObjectMapper();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter standartDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        objectMapper.registerModule(new JavaTimeModule());
        this.boardingDataRepositoryList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.isEmpty()) {
                    String[] data = line.split(";");
                    BoardingDataCSV boardingDataCSV = new BoardingDataCSV(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            LocalDate.parse(data[4], dateFormat),
                            data[5],
                            data[6],
                            data[7],
                            data[8],
                            LocalDate.parse(data[9], standartDateFormat),
                            LocalTime.parse(data[10], dateTimeFormatter),
                            data[11],
                            data[12],
                            data[13]
                    );
                    boardingDataRepositoryList.add(boardingDataCSV);
                }
            }
        }
    }

    public List<BoardingDataCSV> getBoardingDataList() {
        return boardingDataRepositoryList;
    }

    public void setBoardingDataList(List<BoardingDataCSV> boardingDataRepositoryList) {
        this.boardingDataRepositoryList = boardingDataRepositoryList;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<BoardingDataCSV> saveToJSON(String jsonFile) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jsonFile));
        objectMapper.writeValue(bufferedWriter, boardingDataRepositoryList);
        return null;
    }

    @Override
    public String toString() {
        return "BoardingData{" +
                "boardingDataList=" + boardingDataRepositoryList +
                ", objectMapper=" + objectMapper +
                '}';
    }
}
