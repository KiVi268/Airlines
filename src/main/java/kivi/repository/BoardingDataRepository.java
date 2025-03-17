package kivi.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import kivi.model.csv.BoardingDataCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//todo Почему класс не используется и почему не протестирован

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
        objectMapper.registerModule(new JavaTimeModule());
        this.boardingDataRepositoryList = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.isEmpty()){
                    String[] data = line.split(";");
                    BoardingDataCSV boardingDataCSV = new BoardingDataCSV(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4],
                            data[5],
                            data[6],
                            data[7],
                            data[8],
                            data[9],
                            data[10],
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

    //todo также пропиши задание к методу
    //сделано
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
