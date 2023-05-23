package org.mikhailov;

import java.util.Scanner;

public class Reader {
    Scanner sc = new Scanner(System.in);
    String message = "Введите данные в произвольном порядке, разделенные пробелом:\n" +
            " * Фамилия Имя Отчество датарождения номертелефона пол\n" +
            " * Форматы данных:\n" +
            " * фамилия, имя, отчество - строки\n" +
            " * дата_рождения - строка формата dd.mm.yyyy\n" +
            " * номер_телефона - целое беззнаковое число без форматирования\n" +
            " * пол - символ латиницей f или m.";

    public String input (){
        System.out.println(message);
        String temp = sc.nextLine();
        return temp;
    }

    public Reader() {
        }

    public Reader(String message) {
        this.message = message;
    }
}
