package ru.inovus.test.repository;

import org.springframework.stereotype.Repository;
import ru.inovus.test.model.CarNumber;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarNumberRepository {
    private final List<CarNumber> randomNumberList = new ArrayList<>();

    public void add(CarNumber carNumber) {
        this.randomNumberList.add(carNumber);
    }

    public boolean contains(CarNumber carNumber) {
        return this.randomNumberList.indexOf(carNumber) >= 0;
    }

}
