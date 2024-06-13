package JavaRush.myExeption.FinalWork;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class SortData {
    public String fullName;
    private String firstName;
    private String lastName;
    private  String patronymic;
    private long phoneNumber;
    private char gender = ' ';
    private LocalDate birthday;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void sortFio(String[] array) throws FioException{
        String[] fio = new String[3];
        for (String s : array){
            if(s.trim().matches("[ А-я ]+")){
                fio = s.split(" ");
                if(fio.length != 3){
                    throw new FioException("ФИО введено не полностью");
                }
                firstName = fio[0];
                lastName = fio[1];
                patronymic = fio[2];
            }
        }
        fullName = Arrays.toString(fio);
        System.out.println("Данные ФИО заполнены полностью");
    }
    public void sortGender(String[] array) throws GenderException{
        for (String s : array){
            if (s.trim().length() == 1 ) {
                if(s.trim().equals("m") || s.trim().equals("f")){
                    gender = s.trim().charAt(0);
                }else {
                    throw new GenderException("Введен неверный символ гендера ");
                }
            }
        }
        System.out.println("Данные о гендоре введены успешно");
    }
    public void sortPhoneNumber(String[] array) throws  PhoneNumberException{
       for (String s : array){
           if(s.trim().matches("[0-9]+")){
               if(s.trim().length() != 11){
                   throw new PhoneNumberException("введен не верный формат номера телeфона");
               }else {
                   try {
                       phoneNumber = Long.parseLong(s);
                   }catch (NumberFormatException e){
                       throw new PhoneNumberException("ошибочка закралась");
                   }
               }
           }
       }
        System.out.println("Номер телефона записан");
    }
    public void sortedBirthday(String[] array)throws BirthdayException{
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateNow = LocalDate.now();
        for (String s : array){
            if(s.trim().length() == 10){
                try {
                    birthday = LocalDate.parse(s,dateTimeFormatter);


                }catch (DateTimeException e){
                    throw  new BirthdayException("Введен неверный формат даты");
                }
                Period period = birthday.until(dateNow);
                if (birthday.isAfter(dateNow) || period.getYears() > 150){
                    throw new BirthdayException("Ошибка возраста");
                }
            }
        }
        System.out.println("Дата дня рождения введена успешно");
    }
}
