package org.mikhailov;

public class WrongDateException extends Exception{
    String message = "дата введена неверно. необходимо вводить дату в формате дд.мм.гггг";

    public WrongDateException() {
    }
    public WrongDateException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
