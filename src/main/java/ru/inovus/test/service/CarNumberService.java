package ru.inovus.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inovus.test.dto.CarNumberDto;
import ru.inovus.test.entity.CarNumberEntity;
import ru.inovus.test.mapper.CarNumberMapper;
import ru.inovus.test.repository.CarNumberRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CarNumberService {

    private static final String[] LETTERS = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

    private final CarNumberRepository repository;

    @Autowired
    public CarNumberService(CarNumberRepository repository) {
        this.repository = repository;
    }

    public CarNumberDto randomNumber() {

        Random rn = new Random();

        CarNumberDto carNumber = new CarNumberDto();
        carNumber.setNumber(1 + (int) (Math.random() * 999));

        carNumber.setFirstLetter(LETTERS[rn.nextInt(LETTERS.length)]);
        carNumber.setSecondLetter(LETTERS[rn.nextInt(LETTERS.length)]);
        carNumber.setThirdLetter(LETTERS[rn.nextInt(LETTERS.length)]);

        return carNumber;
    }

    public String nextRandom() {
        CarNumberDto carNumberDto = randomNumber();
        while (isPresent(carNumberDto)) {
            carNumberDto = randomNumber();
        }
        saveCarNumber(carNumberDto);
        return carNumberDto.toString();

    }

    public String nextNumber() {

        String lastLetter = LETTERS[LETTERS.length - 1];
        CarNumberDto carNumber = new CarNumberDto(carNumber.getFirstLetter(), carNumber.getSecondLetter(), carNumber.getThirdLetter(), carNumber.getNumber());


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

    public void saveCarNumber(CarNumberDto carNumberDto) {

        CarNumberEntity carNumber = CarNumberMapper.dtoToEntity(carNumberDto);
        repository.save(carNumber);

    }

    public boolean isPresent(CarNumberDto carNumberDto) {
        List<CarNumberEntity> carNumbers = repository.findAllCarNumber(carNumberDto.getFirstLetter(), carNumberDto.getSecondLetter(), carNumberDto.getThirdLetter(), carNumberDto.getNumber());
        if (carNumbers.isEmpty()) {
            return false;
        } else
            return true;
    }

}
