package org.mikhailov;

public class WrongDataAmountException extends Exception{
    private int dataAmount;
    String message = "введен неверный объем данных";

    public WrongDataAmountException() {
    }
    public WrongDataAmountException(int dataAmount) {
        this.dataAmount = dataAmount;
    }

    public int getDataAmount() {
        return dataAmount;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
