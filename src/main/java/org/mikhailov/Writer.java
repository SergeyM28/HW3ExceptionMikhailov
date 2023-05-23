package org.mikhailov;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Writer {

    private File file;
    private Parser p;
    public Writer(Parser p) {
        this.p = p;
    }
    // Создает файл с названием равным фамилии, если такого файла еще не существует.
    public void createFile() {
        this.file = new File(p.getSurname() + ".txt");
        try {
            if (checkExistingFile(file) == false) {
                this.file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Записывает данные в файл
    public void writeFile() {
        try(FileWriter fw = new FileWriter(this.file, true)){
        String data = "<" + p.getSurname() + ">" +
                "<" + p.getName() + ">" +
                "<" + p.getPatronymic() + ">" +
                "<" + p.getDate() + ">" +
                "<" + p.getPhoneNumber() + ">" +
                "<" + p.getGender() + ">";
            fw.write(data + "\n");
            fw.flush();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    public boolean checkExistingFile(File file){
        if(file.exists()){
            return true;
        }
        else return false;
    }

}
