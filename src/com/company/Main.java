package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // ints, Strings, arrays.

//        int [] tal = new int[4];
//
//        tal[0] = 313;
//        tal[1] = 666;
//        tal[2] = 42;
//        tal[3] = 7;


//        String [] ord = new String[5];
//
//        ord[0] = "velkommen ";
//        ord[1] = "til ";
//        ord[2] = "den ";
//        ord[3] = "første ";
//        ord[4] = "undervisningsgang ";
//
//
//
//        for (int i = 0; i < ord.length ; i++) {
//
//        System.out.println( "på plads nr " + i + " : " +  ord[i]);
//
//        }


//        int [] ints = {33,1,34,32,1,3,4,4,3,2,22};
//
//        System.out.println("længden er " + ints.length);
//
//        System.out.println(ints[3]);

        // String [] strings = {"hej " , "med ", "dig "};


        // sådan her deler efter ord.


//        String [] ord = "hej med dig".split( " ");
//
//        String [] bogstaver = "hej med dig".split( "");
//
//
//        udskriv(ord);
//
//        System.out.println("\n\n");
//
//        udskriv(bogstaver);
//


//
//


        // String sætning = læsFil(getTekst("angiv filnavn : "));
        //System.out.println("DET VI LÆSTE AF FILEN : " + sætning);


//       String indhold = FilHaandtering.læsFil("tekst.txt");
//
//
//       String max =     findLængsteOrd(indhold);
//
//        System.out.println(max);
//
//        String maxRens = rensOrd(max);
//
//        System.out.println(maxRens);
//
//        System.out.println(markerOrd(indhold, findLængsteOrd(indhold)));


        String teksten = FilHaandtering.læsFil("tekst.txt").toLowerCase();

        String s = "hej med dig hej med dig hej Med dig hej med dig hej med dig ".toLowerCase();




      Util.udskriv(Statestik.hisogram(teksten) )  ;

        System.out.println(hyppigesteOrd(teksten, hyppistIndex(teksten)));


        System.out.println(findeOgMarkerDetLængste(teksten));


        // todo finde ud af hvad om vi kan slette markerOrdVirker ?
        // todo omdøb tilHører   ->   erSpecialTegn
        // todo omdøb normaliser -> fixMellemrum

        // todo Lav en util klasse og træk følgende metoder ud i den.
        //  fixMellemrum, delefterord , deleftertegn,rensOrd, tilhøre ,etafhvert,
        // udskriv

        // todo Lav en statestik klasse og træk følgende metoder ud i den.
        // tilForekomster, histogram



        // todo lav en metode som kun returnere histoindex'er

        // todo Marker det ord der optræder flest gange

        // todo slet et ord (husk at fixe mellemrum).
        // todo Slet det ord der optræder flest gange
        // todo byt et ord ud med et andet.


        System.out.println("\n\n\n");

        System.out.println(sletOrd(teksten, "men"));

        System.out.println("\n\n\n");

        System.out.println(sletOrd(teksten, udksrivHyppigesteOrd(teksten)));

        System.out.println("\n\n\n");

        System.out.println(erstatOrd(teksten, "men", "Andreas"));


    }    // her slutter min main metode


    public static String erstatOrd(String tekst, String gammelt, String nyt  ) {


        String[] ordliste = tekst.split(" ");

        for (int i = 0; i < ordliste.length; i++) {

            String temp = Util.rensOrd(ordliste[i]);

            if (temp.equalsIgnoreCase(gammelt)) {

                ordliste[i] = nyt;
            }

        }

        return String.join(" ", ordliste);




    }


    public static String sletOrd(String tekst, String ord ) {

        String [] ordListe = Util.delEfterOrd(tekst);

        for (int i = 0; i < ordListe.length; i++) {

            if (ordListe[i].equalsIgnoreCase(ord)) {

                ordListe[i] = "";
            }

        }

        String samletTekst = String.join(" ", ordListe);

        return  Util.fixMellemrum(samletTekst);


    }

    public static String findeOgMarkerDetLængste(String  tekst) {

       return markerOrd(tekst, findLængsteOrd(tekst));

    }

    public static String markHyppigst (String tekst) {

        String ord = udksrivHyppigesteOrd(tekst);
        return  markerOrd(tekst, ord);


    }

    public static String udksrivHyppigesteOrd( String tekst ) {

        return hyppigesteOrd(tekst, hyppistIndex(tekst));

    }

    public static int hyppistIndex(String tekst) {

        int [] hyppighed = Statestik.hisogramIndex(tekst);

        // System.out.println(Arrays.toString(hyppighed));


        int index = -1;
        int antal =0;

        for (int i = 0; i < hyppighed.length; i++) {

            if (antal < hyppighed[i] ) {

                antal = hyppighed[i];
                //System.out.println("opdatere index til : " + i );
                //System.out.println("opdatere variablen antal er : " + antal );
                index = i;
            }
        }
        return index;
    }

    public static String hyppigesteOrd ( String tekst , int i ) {

        String ord = Statestik.etOrdAfHver(tekst);

        String [] ordListe = Util.delEfterOrd(ord);

        return ordListe[i];

    }


    public static String markerOrd(String tekst, String ord) {

         String ANSI_RED = "\u001B[31m";
         String ANSI_RESET = "\u001B[0m";

        String[] ordliste = tekst.split(" ");

        for (int i = 0; i < ordliste.length; i++) {

            String temp = Util.rensOrd(ordliste[i]);

            if (temp.equalsIgnoreCase(ord)) {

                ordliste[i] =   ANSI_RED + ordliste[i] + ANSI_RESET;
            }

        }

        return String.join(" ", ordliste);

    }


    public static boolean slutterPå(String s) {

        int i = s.length() - 1;

        String sidste = s.substring(i);

        return Util.erSpecialTegn(sidste);

    }


    public static String findLængsteOrd(String s) {


        String[] ord = s.split(" ");

        String res = "";

        for (int i = 0; i < ord.length; i++) {

            if (ord[i].length() > res.length()) {

                res = ord[i];    // her opdatere jeg res.
            }


        }

        return Util.rensOrd(res);

    }


}       // her slutter min main klasse
