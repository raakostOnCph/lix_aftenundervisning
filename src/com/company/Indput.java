package com.company;

import java.util.Scanner;

public class Indput {


    public static int getTal(String s) {


        int i = 0;


        while (true) {

            try {
                String res =  getTekst(s);
                i = Integer.parseInt(res);
               break;                        // her kommer jeg kun hvis konvateringen lykkedes


            } catch (NumberFormatException e) {     // her kommer jeg hvis konvateringen ikke lykkedes.
                System.out.println("husk det skal være et tal");
            }
        }

        return i;
    }

    public static String getTekst(String s) {

        System.out.print(s);

        Scanner scanner = new Scanner(System.in);

        String indlæst = scanner.nextLine();

        return indlæst;


    }
}
