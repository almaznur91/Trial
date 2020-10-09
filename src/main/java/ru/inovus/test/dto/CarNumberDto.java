package ru.inovus.test.dto;

import ru.inovus.test.entity.CarNumberEntity;

public class CarNumberDto {

    private String firstLetter;
    private String secondLetter;
    private String thirdLetter;
    private int number;

    public CarNumberDto() {
    }

    public CarNumberDto(String firstLetter, String secondLetter, String thirdLetter, int number) {
        this.firstLetter = firstLetter;
        this.secondLetter = secondLetter;
        this.thirdLetter = thirdLetter;
        this.number = number;
    }

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

    private String addZero(int num) {
        if (num > 99) {
            return String.valueOf(num);
        } else if (num > 9) {
            return "0" + num;
        } else return "00" + num;

    }

    @Override
    public String toString() {
        return firstLetter + addZero(number) + secondLetter + thirdLetter + " " + "116RUS";
    }

}
