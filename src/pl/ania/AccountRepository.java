package pl.ania;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class AccountRepository {


    public Account find(String id) {
        try {
            Scanner scanner = new Scanner(new File("accounts/" + id));
            return new Account(Integer.parseInt(scanner.nextLine()),  new Card(scanner.nextLine(), id));
        } catch (FileNotFoundException fnfe) {
            System.out.println("Niepoprawny identyfikator");
        }
        return null;
    }

    public void writeToFile(Account accountOne) {
        try {
            Files.write(Paths.get("accounts/", String.valueOf(accountOne.getCard().getId())),
                Arrays.asList(String.valueOf(accountOne.getMoneyOnAccount()), accountOne.getCard().getPIN()));
        } catch (IOException fnfe) {
            fnfe.printStackTrace();
        }

    }
}