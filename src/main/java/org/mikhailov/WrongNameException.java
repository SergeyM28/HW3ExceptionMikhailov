package org.mikhailov;

public class WrongNameException extends Exception{
    String message = "неверный ввод ФИО";

    public WrongNameException() {
    }

    @Override
    public String getMessage() {
        return message;
    }
}
