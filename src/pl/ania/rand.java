package pl.ania;

import java.io.PrintWriter;
import java.util.Random;

public class rand {

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            System.out.println(random.nextInt(10000));

        }
    }

}





