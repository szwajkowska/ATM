package pl.ania;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class rand {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            System.out.println(random.nextInt(10000));
            try{
                PrintWriter printWriter = new PrintWriter("accounts/"+String.valueOf(random.nextInt(10000)));
                printWriter.println(String.valueOf(random.nextInt(10000000)));
                printWriter.println(String.valueOf(random.nextInt(9000) + 1000));
                printWriter.close();

            } catch (FileNotFoundException fnfe){

            }
//            try {
//                System.out.println(Files.write(Paths.get("accounts", String.valueOf(random.nextInt(10000))), Arrays.asList( "500", "1234")));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

}





