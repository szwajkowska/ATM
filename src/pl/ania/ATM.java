package pl.ania;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ATM {

    Scanner reading = new Scanner(System.in);

    Account accountOne = new Account(300,  new Card("1111"));

    Map<String, Integer> mapChoiceOption = new HashMap<>();

    public ATM() {
        mapChoiceOption.put("1", 50);
        mapChoiceOption.put("2", 100);
        mapChoiceOption.put("3", 200);
        mapChoiceOption.put("4", 500);
    }

    public void showOptions() {
        boolean isCorrect;
        do {
            String PIN = "Prosze podac PIN";
            readOption(PIN, Arrays.asList(accountOne.getCard().getPIN()));
            String message = "Wybierz opcję: \n 1) Wypłać gotówkę - wybierz 1 \n 2) Wyświetl stan konta - wybierz 2 \n 3) Zmien PIN -wybierz 3";
            String userChoice = readOption(message, Arrays.asList("1", "2", "3"));
            if (userChoice.equals("1")) {
                withdraw();
            } else if (userChoice.equals("2")) {
                System.out.println("STAN KONTA: " + accountOne.getMoneyOnAccount() + " zl");
            } else if (userChoice.equals("3")){
                accountOne.getCard().changePIN();
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
            Integer userChoiceInt = Integer.parseInt(userChoice);
            accountOne.withdrawMoney(userChoiceInt);
        } else {
            accountOne.withdrawMoney(mapChoiceOption.get(userChoice));
            System.out.println("WYPLATA KWOTY: " + mapChoiceOption.get(userChoice) + " zl");
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
