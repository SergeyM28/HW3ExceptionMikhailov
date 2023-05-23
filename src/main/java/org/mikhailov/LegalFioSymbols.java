package org.mikhailov;

import java.util.Arrays;
import java.util.List;

public class LegalFioSymbols {
    //Класс содержит список всех легальных символов для имени, фамилии и отчества
    //Считаем, что если строка состоит из строчных и прописных кириллических символов, а также знака "-", то имя введено верно
    private String legalFioSymbolsArr[] = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н",
            "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю","Я", "а", "б", "в",
            "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц",
            "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю","я","-"};
    private List<String> legalFioSymbolsList = Arrays.asList(legalFioSymbolsArr);

    public String[] getLegalFioSymbolsArr() {
        return legalFioSymbolsArr;
    }

    public List<String> getLegalFioSymbolsList() {
        return legalFioSymbolsList;
    }

    public LegalFioSymbols() {
    }
}
