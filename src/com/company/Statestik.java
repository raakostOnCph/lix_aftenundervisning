package com.company;

public class Statestik {



    public static int [] hisogramIndex ( String tekst) {

        String ordliste = etOrdAfHver(tekst);   // alle forskellige ord i teksten

        String [] ord = Util.delEfterOrd(ordliste);  // lavet om til et array

        int [] resultArray = new int[ord.length];

        for (int i = 0; i < ord.length; i++) {

            resultArray[i] = tælForekomster(tekst, ord[i]);

        }

        return resultArray;

    }




    public static String [] hisogram ( String tekst) {

        String ordliste = etOrdAfHver(tekst);   // alle forskellige ord i teksten

        String [] ord = Util.delEfterOrd(ordliste);  // lavet om til et array

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

        String [] ordArray = Util.delEfterOrd(tekst);

        int antal =0;

        for (int i = 0; i < ordArray.length; i++) {

            if (ordArray[i].equalsIgnoreCase(ord) ) {
                antal++;
            }
        }

        return antal;
    }

    public static String etOrdAfHver(String s) {

        String[] ord = Util.delEfterOrd(s);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ord.length; i++) {


                if (stringBuilder.indexOf(  " " + ord[i] + " " ) == -1) {

                    stringBuilder.append(" " + ord[i] + " ");

                }



        }


        return Util.fixMellemrum(stringBuilder.toString()).trim();


    }
}
