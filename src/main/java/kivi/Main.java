package kivi;

import com.fasterxml.jackson.databind.ObjectMapper;
import kivi.model.BoardingData;
import kivi.model.FrequentFlyer;
import kivi.model.csv.BoardingDataCSV;
import kivi.repository.BoardingDataRepository;
import kivi.repository.FrequentFlyerRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

//todoАЙ ЯЙ ЯЙ заебал пользоваться нейронками + перепиши вручную
public class Main {
    public static void main(String[] args) throws IOException {
        //FrequentFlyerRepository frequentFlyerRepository = new FrequentFlyerRepository("FrequentFlyerForum-Profiles.json");
        BoardingDataRepository boardingDataRepository = new BoardingDataRepository("BoardingData.csv");


//        /**
//         * @FrequentFlyersRepository
//         */
//
//        System.out.println("Loading data from file...");
//        try {
//            List<FrequentFlyer> flyers = frequentFlyerRepository.getFrequentFlyerNames();
//
//            if (flyers != null && !flyers.isEmpty()) {
//                System.out.println("Found " + flyers.size() + " Frequent Flyers");
//                System.out.println("Example Frequent Flyer: " + flyers.get(0));
//            }
//            else {
//                System.out.println("No Frequent Flyers found");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Eror loading data from file", e);
//        }
//
//        System.out.println("\nFind Depature City...");
//        try{
//            String city = "Boston MA";
//            List<FrequentFlyer> results = frequentFlyerRepository.findByDepartureCity(city);
//
//            if (results != null && !results.isEmpty()) {
//                System.out.println("Found " + results.size() + " Frequent Flyers");
//                System.out.println("Example Frequent Flyer: " + results.get(0));
//            } else {
//                System.out.println("No Frequent Flyers found");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Error finding Depature City", e);
//        }
//
//        System.out.println("\nFind by Depature date after...");
//        try {
//            LocalDate depatureDate = LocalDate.parse("2020-01-01");
//            List<FrequentFlyer> resultDate = frequentFlyerRepository.findByDepartureDateAfter(depatureDate);
//
//            if (resultDate != null && !resultDate.isEmpty()) {
//                System.out.println("Found " + resultDate.size() + " Frequent Flyers");
//                System.out.println("Example Frequent Flyer: " + resultDate.get(0));
//            } else {
//                System.out.println("No Frequent Flyers found");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Error finding Depature date after", e);
//        }

        /**
         * @BoardingDataRepository
         */

        System.out.println("\nGetting Boarding Data List...");
        String cvs = "BoardingData.csv";

        //boardingDataRepository.loadFromCSV(cvs);
        List<BoardingDataCSV> boardingDataList = boardingDataRepository.getBoardingDataList();
        System.out.println("Data from csv:" + boardingDataList);
        boardingDataRepository.saveToJSON("BoardingData.json");
        System.out.println("All files saved!");


        }
    }