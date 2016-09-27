package pl.ania;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ATM {

    Scanner reading = new Scanner(System.in);


    Scanner readingFile = new Scanner(new File("ATM.txt"));
//    {
//        try {
//            System.out.println(Files.readAllLines(Paths.get("ATM.txt")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    Account accountOne = new Account(Integer.parseInt(readingFile.nextLine()),  new Card(readingFile.nextLine(), "1"));

    Map<String, Integer> mapChoiceOption = new HashMap<>();

    public ATM() throws FileNotFoundException  {
        mapChoiceOption.put("1", 50);
        mapChoiceOption.put("2", 100);
        mapChoiceOption.put("3", 200);
        mapChoiceOption.put("4", 500);

    }

    public void writeToFile (){ //nie czaje jat to zrobic z tym wyjatkiem

        try {
            PrintWriter record = new PrintWriter("ATM.txt");
            record.println(accountOne.getMoneyOnAccount());
            record.println(accountOne.getCard().getPIN());
            record.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Niewłaściwa nazwa pliku");
        }

    }

    public void showOptions(){

        boolean isCorrect;

        do {
            isCorrect = false;
            String id = "Proszę podać identyfikator";
            readOption(id, Arrays.asList(accountOne.getCard().getId()));


            String PIN = "Prosze podac PIN";
            readOption(PIN, Arrays.asList(accountOne.getCard().getPIN()));

            boolean returnToMenu;

            do {

                returnToMenu = false;
                String message = "Wybierz opcję: \n 1) Wypłać gotówkę - wybierz 1 \n 2) Wyświetl stan konta - wybierz 2 \n 3) Zmien PIN -wybierz 3 \n 4) Wyjście - wybierz 4";
                String userChoice = readOption(message, Arrays.asList("1", "2", "3", "4"));
                if (userChoice.equals("1")) {
                    withdraw();
                    writeToFile();
                    isCorrect = true;
                } else if (userChoice.equals("2")) {
                    System.out.println("STAN KONTA: " + accountOne.getMoneyOnAccount() + " zl");
                    returnToMenu = true;
                } else if (userChoice.equals("3")) {
                    accountOne.getCard().changePIN();
                    writeToFile();
                    returnToMenu = true;
                } else if (userChoice.equals("4")) {
                    isCorrect = true;
                }
            } while (returnToMenu);

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
