package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class filHaandtering {
    public static String læsFil(String filnavn) {

        File file = new File(filnavn);
        String indhold = "";

        Scanner scanner = null;
        try {

            scanner = new Scanner(file);

            while (scanner.hasNext()) {

                indhold = indhold + "\n" + scanner.nextLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("filen " + filnavn + " findes ikke");
            // indhold = "filen findes ikke";
        }

        return indhold;
    }

    public static void skrivTilFil(String filnavn, String tekst) {

        File file = new File(filnavn);


        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(tekst);
            fileWriter.flush();

        } catch (IOException e) {
            System.out.println("kunne ikke gemme filen !");
        }


    }
}
