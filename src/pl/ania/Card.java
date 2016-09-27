package pl.ania;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Card {

    Scanner reading = new Scanner(System.in);

    private String PIN;

    private String id;

    public Card(String PIN, String id) {
        this.PIN = PIN;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPIN() {
        return PIN;
    }

    public boolean checkPIN(String userPIN) {
        return userPIN.equals(PIN);

    }
    public void changePIN() {

        boolean PINcorrect;
        do {
            PINcorrect = true;
            Pattern pattern = Pattern.compile("[0-9]{4}");
            System.out.println("Podaj nowy kod PIN: ");
            String userChoice = reading.nextLine();
            if (pattern.matcher(userChoice).matches()) {
                PIN = userChoice;
            } else {
                System.out.println("Niepoprawny PIN");
                PINcorrect = false;
            }
        }
        while (!PINcorrect);

    }

}
