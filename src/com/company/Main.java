package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
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



        String sætning = læsFil("tekst.txt");

        udskriv( delEfterOrd(sætning));

        udskriv(delEfterTegn(sætning));

        System.out.println( findLængsteOrd(sætning).length()   );


    }    // her slutter min main metode


    public static String findLængsteOrd(String s ) {


        String [] ord = s.split(" ");

        String res ="";

        for (int i = 0; i < ord.length; i++) {

            if (ord[i].length()  > res.length() ) {

                res = ord[i];    // her opdatere jeg res.
            }


        }

        return res;

    }


    public static String læsFil(String filnavn) throws FileNotFoundException {

        File file = new File(filnavn);

        Scanner scanner = new Scanner(file);

        String indhold = scanner.nextLine();

        return indhold;
    }


    public static String [] delEfterOrd(String s) { // metode signatur

        String [] strings = s.split(" ");

        return strings;

        //return s.split(" ");
    }

    public static String [] delEfterTegn (String s) {


        String [] strings = s.split("");

        return strings;


    }


    public static void udskriv(String [] strings ) { // metode signatur

        for (int i = 0; i < strings.length; i++) {

            System.out.println(strings[i]);

        }


    }



}       // her slutter min main klasse
