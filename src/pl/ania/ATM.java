package pl.ania;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ATM {

    Scanner reading = new Scanner(System.in);

    AccountRepository accountRepository = new AccountRepository();

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
            isCorrect = false;
            String idMessage = "Proszę podać identyfikator";

            Account account = readAccount(idMessage);//czyli = account

            String PIN = "Prosze podac PIN";

            readOption(PIN, Arrays.asList(account.getCard().getPIN()));//czemu to jest lista?

            boolean returnToMenu;

            do {
                returnToMenu = false;
                String message = "Wybierz opcję: \n 1) Wypłać gotówkę - wybierz 1 \n 2) Wyświetl stan konta - wybierz 2 \n " +
                    "3) Zmien PIN -wybierz 3 \n 4) Wyjście - wybierz 4";
                String userChoice = readOption(message, Arrays.asList("1", "2", "3", "4"));
                if (userChoice.equals("1")) {
                    withdraw(account);
                    accountRepository.writeToFile(account);
                    isCorrect = true;
                } else if (userChoice.equals("2")) {
                    System.out.println("STAN KONTA: " + account.getMoneyOnAccount() + " zl");
                    returnToMenu = true;
                } else if (userChoice.equals("3")) {
                    account.getCard().changePIN();
                    accountRepository.writeToFile(account);
                    returnToMenu = true;
                } else if (userChoice.equals("4")) {
                    isCorrect = true;
                }
            } while (returnToMenu);
        }

        while (!isCorrect);

    }

    private void withdraw(Account accountOne) {
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

    private Account readAccount(String message) {
        while (true) {
            System.out.println(message);
            String id = reading.nextLine();
            Account account = accountRepository.find(id);
            if (account != null) {
                return account;
            }
            System.out.println("Podano niewłaściwą wartość");
        }
    }

}
