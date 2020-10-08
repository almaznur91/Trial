package ru.inovus.test.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car_number")

public class CarNumberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPAST() {
        return PAST;
    }

    public void setPAST(String PAST) {
        this.PAST = PAST;
    }

    private String PAST = "116 RUS";

    private String firstLetter;
    private String secondLetter;
    private String thirdLetter;

    private int number;

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getSecondLetter() {
        return secondLetter;
    }

    public void setSecondLetter(String secondLetter) {
        this.secondLetter = secondLetter;
    }

    public String getThirdLetter() {
        return thirdLetter;
    }

    public void setThirdLetter(String thirdLetter) {
        this.thirdLetter = thirdLetter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return firstLetter + addZero(number) + secondLetter + thirdLetter + " " + PAST;
    }

    public CarNumberEntity(String firstLetter, String secondLetter, String thirdLetter, int number) {
        this.firstLetter = firstLetter;
        this.secondLetter = secondLetter;
        this.thirdLetter = thirdLetter;
        this.number = number;

    }

    private String addZero(int num) {
        if (num > 99) {
            return String.valueOf(num);
        } else if (num > 9) {
            return "0" + num;
        } else return "00" + num;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNumberEntity carNumber = (CarNumberEntity) o;
        return number == carNumber.number &&
                firstLetter.equals(carNumber.firstLetter) &&
                secondLetter.equals(carNumber.secondLetter) &&
                thirdLetter.equals(carNumber.thirdLetter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstLetter, secondLetter, thirdLetter, number);
    }

}
