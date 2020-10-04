package ru.inovus.test.model;

import java.util.Objects;

public class CarNumber {

    private static final String PAST = "116 RUS";

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

    public CarNumber(String firstLetter, String secondLetter, String thirdLetter, int number) {
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
        CarNumber carNumber = (CarNumber) o;
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
