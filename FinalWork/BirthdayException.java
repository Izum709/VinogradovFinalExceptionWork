package JavaRush.myExeption.FinalWork;

import java.time.DateTimeException;
import java.time.format.DateTimeParseException;

public class BirthdayException extends DateTimeException {
    BirthdayException(String s){
        super(s);
    }
}
