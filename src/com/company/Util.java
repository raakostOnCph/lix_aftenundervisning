package com.company;

public class Util {


    public static String fixMellemrum(String s) {

        while (true) {

            s = s.replace("  ", " ");

            if (!s.contains("  ")) {
                return s;
            }
        }


    }

    public static String rensOrd(String s) {

        if (Main.slutterPå(s)) {
            return s.substring(0, s.length() - 1);
        }
        return s;
    }

    public static String ordTilTekst(String[] ordliste) {

        return String.join(" ", ordliste);

    }

    public static boolean erSpecialTegn(String s) {

        String specialTegn = "!#%&;:().,";

        return specialTegn.contains(s);


    }

    public static String[] delEfterOrd(String s) { // metode signatur

        String[] strings = s.split(" ");

        return strings;

        //return s.split(" ");
    }

    public static String[] delEfterTegn(String s) {


        String[] strings = s.split("");

        return strings;


    }

    public static void udskriv(String[] strings) { // metode signatur

        for (int i = 0; i < strings.length; i++) {

            System.out.println(strings[i]);

        }


    }
}
