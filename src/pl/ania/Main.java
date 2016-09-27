package pl.ania;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{//czemu tutaj nie moge skasowac wyjatku?
        ATM atm = new ATM();

        atm.showOptions();
    }
}
