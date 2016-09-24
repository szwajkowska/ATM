package pl.ania;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lukasz on 2016-09-24.
 */
public class ATM {

    Scanner reading = new Scanner(System.in);


    public void showOptions() {
        boolean isCorrect;
        do {
            String message = "Wybierz opcję: \n 1) Wypłać gotówkę - wybierz 1 \n 2) Wyświetl stan konta - wybierz 2";
            String userChoice = readOption(message, Arrays.asList("1", "2"));
            if (userChoice.equals("1")) {
                withdraw();
            } else if (userChoice.equals("2")) {
                System.out.println("STAN KONTA");
            }
            isCorrect = false;
        }

        while (!isCorrect);


    }

    private void withdraw() {
        String message = "Wybierz kwotę: \n 1) 50 zl -wybierz 1 \n 2) 100 zl - wybierz 2 \n 3) 200 zl - wybierz 3 \n 4) 500zl - wybierz 4 \n 5) inna kwota - wybierz 5";
        String userChoice = readOption(message, Arrays.asList("1", "2", "3", "4", "5"));
        if (userChoice.equals("5")) {
            System.out.println("Podaj kwotę: ");
            userChoice = reading.nextLine();
        } else {
            System.out.println("WYPLATA GOTÓWKI");
        }
    }


    private String readOption(String message, List<String> options) {
        while (true) {
            System.out.println(message);
            String userChoice = reading.nextLine();
            if (options.contains(userChoice)) {
                return userChoice;
            }
            System.out.println("Podano niewłaściwą wartość");

        }

    }
}
