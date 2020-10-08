package ru.inovus.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inovus.test.entity.CarNumberEntity;
import ru.inovus.test.repository.CarNumberRepository;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

@Service
public class CarNumberService {

    private static final String[] LETTERS = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

    private CarNumberEntity carNumber = new CarNumberEntity("А", "А", "А", 0);

    private final CarNumberRepository repository;

    @Autowired
    public CarNumberService(CarNumberRepository repository) {
        this.repository = repository;
    }

    public void setCarNumber(CarNumberEntity carNumber) {
        this.carNumber = carNumber;
    }

    public String randomNumber() {

        Random rn = new Random();
        carNumber.setNumber(1 + (int) (Math.random() * 999));

        carNumber.setFirstLetter(LETTERS[rn.nextInt(LETTERS.length)]);
        carNumber.setSecondLetter(LETTERS[rn.nextInt(LETTERS.length)]);
        carNumber.setThirdLetter(LETTERS[rn.nextInt(LETTERS.length)]);

        CarNumberEntity randomCarNumber = new CarNumberEntity(carNumber.getFirstLetter(), carNumber.getSecondLetter(), carNumber.getThirdLetter(), carNumber.getNumber());

        if (repository.equals(randomCarNumber)) {
            randomNumber();
        } else repository.save(randomCarNumber);

        if (!repository.equals(carNumber)) {
            repository.save(randomCarNumber);
        } else {
            randomNumber();
        }

        return this.carNumber.toString();
    }

    public String nextNumber() {

        String lastLetter = LETTERS[LETTERS.length - 1];

        if (carNumber.getNumber() < 999) {
            carNumber.setNumber(carNumber.getNumber() + 1);
        } else if (!carNumber.getThirdLetter().equals(lastLetter)) {
            carNumber.setThirdLetter(getNextLetter(carNumber.getThirdLetter()));
            carNumber.setNumber(0);
        } else if (!carNumber.getSecondLetter().equals(lastLetter)) {
            carNumber.setSecondLetter(getNextLetter(carNumber.getSecondLetter()));
            carNumber.setThirdLetter(LETTERS[0]);
            carNumber.setNumber(0);
        } else if (!carNumber.getFirstLetter().equals(lastLetter)) {
            carNumber.setFirstLetter(getNextLetter(carNumber.getFirstLetter()));
            carNumber.setSecondLetter(LETTERS[0]);
            carNumber.setThirdLetter(LETTERS[0]);
            carNumber.setNumber(0);
        } else {
            carNumber.setNumber(0);
            carNumber.setFirstLetter(LETTERS[0]);
            carNumber.setSecondLetter(LETTERS[0]);
            carNumber.setThirdLetter(LETTERS[0]);
        }
        return carNumber.toString();
    }

    private String getNextLetter(String letter) {
        return LETTERS[Arrays.asList(LETTERS).indexOf(letter) + 1];
    }

    public CarNumberEntity getCarNumberByIdOrEmpty(Integer carNumberId) {
        Optional<CarNumberEntity> optionalCarNumberEntity = Optional.of(repository.findById(carNumberId).orElse(new CarNumberEntity("A","A", "A", 0)));
        return optionalCarNumberEntity.orElseThrow(RuntimeException::new);
    }

    public void saveCarNumber(CarNumberEntity carNumberEntity) {
        CarNumberEntity entity = getCarNumberByIdOrEmpty(carNumberEntity.getId());
        entity.setNumber(carNumberEntity.getNumber());
        entity.setFirstLetter(carNumberEntity.getFirstLetter());
        entity.setSecondLetter(carNumberEntity.getSecondLetter());
        entity.setThirdLetter(carNumberEntity.getThirdLetter());
        entity.setPAST("116 RUS");
        repository.save(entity);
    }

}
