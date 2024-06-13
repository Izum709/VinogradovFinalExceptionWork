package JavaRush.myExeption.FinalWork;

public class PhoneNumberException extends NumberFormatException{
    public PhoneNumberException(String massage){
        super(massage);
    }
}
