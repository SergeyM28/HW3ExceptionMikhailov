package org.mikhailov;

public class Parser {
    private String surname;
    private String name;
    private String patronymic;
    private String phoneNumber;
    private String gender;
    private String date;
    String[] splitedData;

    public Parser() {
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    public void parse(String data){
        splitString(data);
        try {
            processList();
        }catch (WrongDataAmountException e){
            System.out.println(e.getMessage() + " должно быть введено 6 значений, разделенных пробелами. введено значений:");
            System.out.println(e.getDataAmount());
        }
    }

    public void splitString(String data) {
        this.splitedData = data.split(" ");
    }

    public void processList() throws WrongDataAmountException {
        //Должно быть введено 6 значений, иначе кидает ошибку
        if(splitedData.length != 6){
            throw new WrongDataAmountException(splitedData.length);
        }

        for (String elem : splitedData) {
            processString(elem);
        }
        //Итоговая проверка. Если в результате работы функции processList заполенены не все поля класса - кидает RuntimeException
        if (checkAllData() == false){
            throw new RuntimeException("данные введены неверно");
        }
    }
    //Функция processString последовательно проводит ряд проверок, распределяя введенные данные по соответствующим полям
    private void processString (String data){
        //Строки из одного символа "m" или "f" записываются в поле Gender
        if (data.equalsIgnoreCase("f") || data.equalsIgnoreCase("m")){
            this.gender = data;
        }
        //Числа записываются в поле phoneNumber. Программа воспринимает любые введенные числа, как телефон
        else if (numberCheck(data) == true){
            this.phoneNumber = data;
        }
        //Строки, содержащие точки, проверяются на соответствие дате дд.мм.гггг
        else if (data.contains(".")){
            try{
                if (dateCheck(data)){
                    this.date = data;
                }
            }catch (WrongDateException e){
                System.out.println(e.getMessage());
            }
        }
        //Все строки, которые не прошли предыдущие три проверки, проверяются на корректность символов и записываются в поля:
        //surname, name, patronymic
        else {
            try {
                if (nameSymbolCheck(data) == true) {
                    if (this.surname == null) {
                        this.surname = data;
                    } else if (this.name == null) {
                        this.name = data;
                    } else if (this.patronymic == null) {
                        this.patronymic = data;
                    }
                    else throw new WrongNameException();
                }
            }catch (WrongNameException e){
                System.out.println(e.getMessage());
            }
        }
    }
    //Проверка, являются ли данные числом
    private boolean numberCheck(String data){
        try {
            Double.parseDouble(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //Проверка, являются ли данные датой. Дата режется по символу точки, проверяется, что каждый элемент является числом.
    //В случае успеха, проверяется каждый компонент даты. Минимальный допустимый год 1990.
    private boolean dateCheck (String data) throws WrongDateException{
        String[] tempArr = data.split("\\.");
        for (String elem : tempArr){
            if (numberCheck(elem) == false){
                throw new WrongDateException();
            }
        }
        if (Integer.valueOf(tempArr[0]) < 1 || Integer.valueOf(tempArr[0]) > 31){
            throw new WrongDateException("неверно указан день в дате рождения. Допустимы знвчения от 1 до 31");
        }
        if (Integer.valueOf(tempArr[1]) < 1 || Integer.valueOf(tempArr[1]) > 12){
            throw new WrongDateException("неверно указан месяц в дате рождения. Допустимы знвчения от 1 до 12");
        }
        if (Integer.valueOf(tempArr[2]) < 1900 || Integer.valueOf(tempArr[2]) > 2023){
            throw new WrongDateException("неверно указан год в дате рождения. Допустимы знвчения от 1 до 2023");
        }
        return true;
    }
    //Проверка ФИО на корректность ввода. Если строка содержит только легальные символы. Кидает соответствующее исключение.
    //Список легальных символов вынесен в отдельный класс LegalFioSymbols.
    private boolean nameSymbolCheck (String data) throws WrongNameException {
        char tempArr[] = data.toCharArray();
        LegalFioSymbols lfs = new LegalFioSymbols();
        for (char symbol : tempArr){
            if (!lfs.getLegalFioSymbolsList().contains(String.valueOf(symbol))){
                throw new WrongNameException();
            }
        }
        return true;
    }

    public boolean checkAllData(){
        if (this.surname != null && this.name != null && this.patronymic != null &&
                this.gender != null && this.date != null){
            return true;
        } else return false;
    }


    @Override
    public String toString() {
        return "Parser{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}


