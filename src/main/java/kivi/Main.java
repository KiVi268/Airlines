package kivi;

import kivi.model.FrequentFlyer;
import kivi.repository.FrequentFlyerRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testFrequentFlyerRepository();
    }

    private static void testFrequentFlyerRepository() {
        testLoadData();
        testFindByDepartureCity();
        testFindByDepartureDateAfter();
    }

    private static void testLoadData() {
        System.out.println("\nТест 1: Загрузка данных из файла");
        try {
            FrequentFlyerRepository repository = new FrequentFlyerRepository("FrequentFlyerForum-Profiles.json");
            List<FrequentFlyer> flyers = repository.getFrequentFlyerNames();
            
            if (flyers != null && !flyers.isEmpty()) {
                System.out.println("Успешно: Данные загружены, количество записей: " + flyers.size());
                System.out.println("Пример данных: " + flyers.get(0));
            } else {
                System.out.println("Ошибка: Данные не загружены или список пуст");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }
    }

    private static void testFindByDepartureCity() {
        System.out.println("\nТест 2: Поиск по городу отправления");
        try {
            FrequentFlyerRepository repository = new FrequentFlyerRepository("FrequentFlyerForum-Profiles.json");
            String testCity = "Boston MA";
            List<FrequentFlyer> results = repository.findByDepartureCity(testCity);
            
            if (results != null && !results.isEmpty()) {
                System.out.println("Успешно: Найдены полеты из города " + testCity);
                System.out.println("Количество найденных записей: " + results.size());
                System.out.println("Пример найденной записи: " + results.get(0));
            } else {
                System.out.println("Результат: Полеты из города " + testCity + " не найдены");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при поиске по городу: " + e.getMessage());
        }
    }

    private static void testFindByDepartureDateAfter() {
        System.out.println("\nТест 3: Поиск по дате вылета");
        try {
            FrequentFlyerRepository repository = new FrequentFlyerRepository("FrequentFlyerForum-Profiles.json");
            LocalDate testDate = LocalDate.parse("2017-05-01");
            List<FrequentFlyer> results = repository.findByDepartureDateAfter(testDate);
            
            if (results != null && !results.isEmpty()) {
                System.out.println("Успешно: Найдены полеты после даты " + testDate);
                System.out.println("Количество найденных записей: " + results.size());
                System.out.println("Пример найденной записи: " + results.get(0));
            } else {
                System.out.println("Результат: Полеты после даты " + testDate + " не найдены");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при поиске по дате: " + e.getMessage());
        }
    }
}