package JavaRush.myExeption.FinalWork;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class SaveFile {

    public void saveFile(String firstName, String lastName, String patronymic, LocalDate birthday, Long phoneNumber,
    char gender) throws IOException {

        String dataToSave ="<"+firstName+">"+"<"+lastName+">"+"<"+patronymic+
                "<"+birthday+">"+"<"+phoneNumber+">"+"<"+gender+">";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(firstName + ".txt", true))) {
            writer.write(dataToSave);
            writer.newLine();
        } catch (IOException e) {
            throw new IOException("Ошибка при записи в файл.");
        }
    }
}
