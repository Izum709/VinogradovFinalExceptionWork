package JavaRush.myExeption.FinalWork;

import java.io.IOException;
import java.util.Arrays;

/*Урок 3. Продвинутая работа с исключениями в Java
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:

Фамилия Имя Отчество дата _ рождения номер _ телефона пол

Форматы данных:

фамилия, имя, отчество - строки
дата _ рождения - строка формата dd.mm.yyyy
номер _ телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки,
обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если форматы данных не совпадают,
нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои.
Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны
записаться полученные данные, вида
<Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
пользователь должен увидеть стектрейс ошибки.*/
public class Main {
    public static void main(String[] args) {
        Start start = new Start();
        SortData sortData = new SortData();
        SaveFile saveFile = new SaveFile();
        try {
            String[] a = start.startProgram();
            System.out.println(Arrays.toString(a)+" "+a.length);
            sortData.sortFio(a);
            System.out.println("fio - "+sortData.fullName);
            System.out.println(sortData.getFirstName()+" "+sortData.getLastName()+" "+sortData.getPatronymic());
            sortData.sortGender(a);
            System.out.println("gender - "+sortData.getGender());
            sortData.sortPhoneNumber(a);
            System.out.println("phone number - "+sortData.getPhoneNumber());
            sortData.sortedBirthday(a);
            System.out.println("birthday - "+sortData.getBirthday());
            saveFile.saveFile(sortData.getFirstName(), sortData.getLastName(), sortData.getPatronymic(),
                    sortData.getBirthday(), sortData.getPhoneNumber(), sortData.getGender());
        }catch (LengthException | FioException | GenderException | PhoneNumberException | BirthdayException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
