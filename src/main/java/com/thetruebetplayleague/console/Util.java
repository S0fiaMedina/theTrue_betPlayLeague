package com.thetruebetplayleague.console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



@SuppressWarnings("resource")

public class Util {

    public static int getIntInput(String message){
        Scanner sc = new Scanner(System.in);
        System.out.println(message);

        while (true) {
            try{
                String input = sc.nextLine().trim();  // toma el input (RECORTADO  )
                int num = Integer.parseInt(input); // usa el metodo de parse int de integer
                if (num >= 0){
                    return num;
                } else {
                    System.out.println(">> !ERROR: Debes ingresar un numero positivo. Intenta de nuevo:");
                }
            } catch (NumberFormatException e){
                System.out.println(">> !ERROR: Debes ingresar un numero entero\n>> Intenta de nuevo");
            }
        }
    }


    public static String getStringInput(String message){
        // validar que la cadena no esta vacia
        Scanner sc = new Scanner(System.in);
        System.out.println(message);

        while (true) {
            String input = sc.nextLine().trim();

            if (input.equals("")){
                System.out.println(">> !ERROR: No puedes ingresar una cadena vacia. Intenta de nuevo");
            } else {
                return input;
            }
        }
    }

    public static void printOptions(String[] options){
        for (String option : options ){
            System.out.println(option);
        }
    }

    public static int rangeValidator(int minNumber, int maxNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println(">> Escoja la opcion de su preferencia");
        
        while(true){
            try {
                String input = sc.nextLine().trim();
                int num = Integer.parseInt(input);

                if (num >= minNumber || num<= maxNumber){
                    return num;
                } else{
                    System.out.println(">> !ERROR: Debe ingresar un numero que se encuentre dentro del rango. Intente de nuevo");
                }
            } catch (NumberFormatException e) {
                System.out.println(">> !ERROR: Debes ingresar un numero: ");
            }
        }
    }



    public boolean checkDateFormat(String date, String format){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate.parse(date, dateTimeFormatter);
            return true;
        } catch (Exception e) {
            return false;
        }
        

    }


    public static void showASign(String category, String message){
        System.out.println("***************" + category + "******************");
        System.out.println(message);
        System.out.println("***********************************************");
    }

    public static List<Integer> listOfInteger(int start, int end){
        return IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

    }
}
