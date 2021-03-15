package com.company;

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


        String x = FilHaandtering.læsFil("tekst.txt").toLowerCase();

        String s = "hej med dig hej med dig hej    Med   dig hej     med   dig hej med dig ".toLowerCase();
      //  String tekst = FilHaandtering.læsFil("tekst.txt");

//        String res = s.replace("  ", " ");

//        System.out.println(s);
//        System.out.println(normaliser(s));

       // System.out.println(tælForekomster(s, "hej"));



//        StringBuilder stringBuilder = new StringBuilder();
//
//        stringBuilder.append(s + " ");
//        stringBuilder.append(s);
//
//        System.out.println("indholdet af min stringB : " + stringBuilder.toString());
//
//
//        if (stringBuilder.indexOf(" " + Indput.getTekst("skriv det ord du leder : ") + " ") > 0) {
//
//            System.out.println("ordet findes");
//        }
//        else {
//            System.out.println("ordet findes ikke i listen");
//        }
        // String tekst = FilHaandtering.læsFil("tekst.txt");

        etOrdAfHver(s);
               // udskriv(delEfterOrd(x));

          udskriv(  hisogram (etOrdAfHver(s) ) );








    }    // her slutter min main metode


    public static String [] hisogram ( String tekst) {

        String ordliste = etOrdAfHver(tekst);   // alle forskellige ord i teksten

        String [] ord = delEfterOrd(ordliste);  // lavet om til et array

        int [] resultArray = new int[ord.length];

        for (int i = 0; i < ord.length; i++) {

           resultArray[i] = tælForekomster(tekst, ord[i]);

        }

        for (int i = 0; i < ord.length; i++) {

            ord[i] = ord[i] + ": " + resultArray[i];

        }

        return ord;

    }


    public static int tælForekomster(String tekst, String ord) {

        String [] ordArray = delEfterOrd(tekst);

        int antal =0;

        for (int i = 0; i < ordArray.length; i++) {

            if (ordArray[i].equalsIgnoreCase(ord) ) {
                antal++;
            }
        }

        return antal;
    }

    public static String normaliser(String s) {

        while (true) {

            s = s.replace("  ", " ");

            if (!s.contains("  ")) {
                return s;
            }
        }


    }


    public static String etOrdAfHver(String s) {

        String[] ord = delEfterOrd(s);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ord.length; i++) {


                if (stringBuilder.indexOf(  " " + ord[i] + " " ) == -1) {

                    stringBuilder.append(" " + ord[i] + " ");

                }



        }


        return normaliser(stringBuilder.toString()).trim();


    }


    public static String markerOrd(String tekst, String ord) {

        String[] ordliste = tekst.split(" ");

        for (int i = 0; i < ordliste.length; i++) {

            String temp = rensOrd(ordliste[i]);

            if (temp.equalsIgnoreCase(ord)) {

                ordliste[i] = ordliste[i].toUpperCase();
            }

        }

        return String.join(" ", ordliste);

    }


    public static String rensOrd(String s) {

        if (slutterPå(s)) {
            return s.substring(0, s.length() - 1);
        }
        return s;
    }

    public static boolean slutterPå(String s) {

        int i = s.length() - 1;

        String sidste = s.substring(i);

        return tilHører(sidste);

    }

    public static String ordTilTekst(String[] ordliste) {

        return String.join(" ", ordliste);

    }


    public static boolean tilHører(String s) {

        String specialTegn = "!#%&;:().,";

        return specialTegn.contains(s);


    }

    public static String markerOrdVirker(String tekst, String ord) {   // viker ikke helt.

        String[] ordliste = delEfterOrd(tekst);

        for (int i = 0; i < ordliste.length; i++) {

            if (ordliste[i].equalsIgnoreCase(ord)) {


                ordliste[i] = ordliste[i].toUpperCase();
            }

        }

        return ordTilTekst(ordliste);


    }


    // Todo find alle forekomster af et bestemt ord og marker det. Huske det med punktum og komma til sidste i et ord.
    // todo lav en metode der kan fjern alle markeringer.


    // to lave en metode som Kan bytte et ord ud  med et andet i en tekst
    // todo lav en metode som tager en fil, og ord og bytte alle forkomster af ordet ud, og og gemme filen.

    // todo lav metoden kan dele en tekst op i ord.
    // todo lav metoden kan dele en tekst op i bogstaver.
    // todo lav metoden kan dele en tekst op i sætninger.

    // todo lav metoden kan samle bogstaver til en tekst.
    // todo lav metoden kan samle ord til sætninger.
    //todo lave en metode der kan fjern special tegn f.eks. ,".-

    // todo lav metoden der findet et bestemt ord og skriver det med stor.
    // todo lav en metode der lave der laver alle bogstaver store/små
    // todo lav metoden kan som kan fjerne markeringen.

    // todo lav en metode der kan fjerne et ord
    // todo lav en metode der kan erstatte et ord med et andet.
    // todo lav metoden kan lave stor forbogstav.


    public static String findLængsteOrd(String s) {


        String[] ord = s.split(" ");

        String res = "";

        for (int i = 0; i < ord.length; i++) {

            if (ord[i].length() > res.length()) {

                res = ord[i];    // her opdatere jeg res.
            }


        }

        return rensOrd(res);

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


}       // her slutter min main klasse
