package JavaRush.myExeption.FinalWork;

import java.util.Scanner;

public class Start {
    public String[] startProgram() throws LengthException{
        SortData sortData = new SortData();
        System.out.println("Введите данные через запятую в формате:\nИмя Фамилия Отчество, гендер, номер телефона," +
                " дата рождения ");
        String peopleData = new Scanner(System.in).nextLine();
        String[] arrayPeopleData = peopleData.split(", ");
        if(arrayPeopleData.length != 4){
            throw new LengthException("Не все данные введены");
        }
        return arrayPeopleData;
    }

}
