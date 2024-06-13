package JavaRush.myExeption.FinalWork;

import java.time.DateTimeException;
public class BirthdayException extends DateTimeException {
    BirthdayException(String s){
        super(s);
    }
}
