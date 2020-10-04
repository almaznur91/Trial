package ru.inovus.test.service;

import org.springframework.stereotype.Service;
import ru.inovus.test.model.CarNumber;
import ru.inovus.test.repository.CarNumberRepository;

import java.util.Arrays;
import java.util.Random;

@Service
public class CarNumberService {

    private static final String[] LETTERS = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

    private CarNumber carNumber = new CarNumber("А", "А", "А", 0);

    private final CarNumberRepository repository;

    public CarNumberService(CarNumberRepository repository) {
        this.repository = repository;
    }

    public String randomNumber() {

        Random rn = new Random();
        carNumber.setNumber(1 + (int) (Math.random() * 999));

        carNumber.setFirstLetter(LETTERS[rn.nextInt(LETTERS.length)]);
        carNumber.setSecondLetter(LETTERS[rn.nextInt(LETTERS.length)]);
        carNumber.setThirdLetter(LETTERS[rn.nextInt(LETTERS.length)]);

        CarNumber randomCarNumber = new CarNumber(carNumber.getFirstLetter(), carNumber.getSecondLetter(), carNumber.getThirdLetter(), carNumber.getNumber());

        if (repository.contains(randomCarNumber)) {
            randomNumber();
        } else repository.add(randomCarNumber);

        return this.carNumber.toString();
    }

    public String nextNumber() {

        String lastLetter = LETTERS[LETTERS.length - 1];

        if (carNumber.getNumber() < 999) {
            carNumber.setNumber(carNumber.getNumber() + 1);
        } else if (!carNumber.getThirdLetter().equals(lastLetter)) {
            carNumber.setThirdLetter(getNextLetter(carNumber.getThirdLetter()));
            carNumber.setNumber(1);
        } else if (!carNumber.getSecondLetter().equals(lastLetter)) {
            carNumber.setSecondLetter(getNextLetter(carNumber.getSecondLetter()));
            carNumber.setThirdLetter(LETTERS[0]);
            carNumber.setNumber(1);
        } else if (!carNumber.getFirstLetter().equals(lastLetter)) {
            carNumber.setFirstLetter(getNextLetter(carNumber.getFirstLetter()));
            carNumber.setSecondLetter(LETTERS[0]);
            carNumber.setThirdLetter(LETTERS[0]);
            carNumber.setNumber(1);
        } else {
            carNumber.setNumber(1);
            carNumber.setFirstLetter(LETTERS[0]);
            carNumber.setSecondLetter(LETTERS[0]);
            carNumber.setThirdLetter(LETTERS[0]);
        }
        return carNumber.toString();
    }

    private String getNextLetter(String letter) {
        return LETTERS[Arrays.asList(LETTERS).indexOf(letter) + 1];
    }

}
