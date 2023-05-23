package org.mikhailov;

public class WrongDataAmmountException extends Exception{
    private int dataAmmount;
    String message = "введен неверный объем данных";

    public WrongDataAmmountException() {
    }
    public WrongDataAmmountException(int dataAmpunt) {
    }
}
