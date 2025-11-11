import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        boolean anotherEntry = true;
        int id = 1;
        String fileName = "";

        System.out.println("Personal Data Record Entry");

        while (anotherEntry) {

            // Name
            String firstName = SafeInput.getNonZeroLenString(in, "Enter Your First Name: ");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Your Last Name: ");

            //ID Number
            String userID = String.format("%06d", id);
            System.out.println("Your ID number is:  " + userID);

            //Email
            String email = SafeInput.getNonZeroLenString(in, "Enter Your Email: ");

            //Year of Birth
            int birthYear;
            do {
                birthYear = SafeInput.getInt(in, "Enter Your Year of Birth (4 digits): ");
                if (birthYear < 1900 || birthYear > 2025) {
                    System.out.println("Invalid Year. Please input between 1900 and 2025.");
                }
            } while (birthYear < 1900 || birthYear > 2025);

            //CSV Record
            String csvRecord = lastName + ", " + firstName + ", " + userID + ", " + email + ", " + birthYear;
            records.add(csvRecord);
            System.out.println("Record added: " + csvRecord);

            id++;

            anotherEntry = SafeInput.getYNConfirm(in, "Do you want to enter another record?");
        }
                try {
                    fileName = SafeInput.getNonZeroLenString(in, "Enter File Name to Save: ");
                    FileWriter writer = new FileWriter("src/" + fileName);

                    for (String record : records) {
                        writer.write(record + "\n");
                    }

                    writer.close();
                    System.out.println("File " + fileName + " has been saved in the SRC");
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                }
    }
}
