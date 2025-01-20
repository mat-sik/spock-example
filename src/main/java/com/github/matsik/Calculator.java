package com.github.matsik;

public class Calculator {

    private int count;

    public int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public void acumulate(int number) {
        count += number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
