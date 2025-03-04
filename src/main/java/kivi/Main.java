package kivi;

import kivi.repository.FrequentFlyerRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FrequentFlyerRepository frequentFlyerRepository = null;
        try {
            frequentFlyerRepository = new FrequentFlyerRepository("FrequentFlyerForum-Profiles.json");
            System.out.println(frequentFlyerRepository.getFrequentFlyerNames());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}