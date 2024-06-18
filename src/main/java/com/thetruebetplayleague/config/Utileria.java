package com.thetruebetplayleague.config;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;



import java.util.regex.Matcher;

public class Utileria {
    // metodo para imprimir informes
    @SuppressWarnings("resource")
    public static void mostrarInforme(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("************* RESULTADO *************");
        System.out.println(mensaje);
        System.out.println("*************************************\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
    // metodo para confirmaar
    public static int confirmacion(String pregunta){
        System.out.println(pregunta + "\n1. SI\n2. NO");
        return Utileria.validarRango(1, 2);
    }

    // recrea el input de python de string
    @SuppressWarnings("resource")
    public static String getStringInput(String mensaje){
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    //recrea el input de int
    @SuppressWarnings("resource")
    public static int getIntInput(String mensaje){
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        return scanner.nextInt();
    }
    // imprime una lista
    public static void imprimirOpciones(String[] opciones){
        for( int i = 0; i < opciones.length; i++){
            System.out.println((i+1) + " " + opciones[i]);
        }
    }

    
/**
 * Método estático para validar y obtener un número dentro de un rango específico.
 * Permite al usuario introducir un número por consola y verifica que esté dentro
 * del rango especificado.
 *
 * @param numMinimo Valor mínimo del rango (inclusive).
 * @param numMaximo Valor máximo del rango (inclusive).
 * @return El número validado que se encuentra dentro del rango especificado.
 */
    public static int validarRango(int numMinimo, int numMaximo) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        int numero;
        do {
            try {
                numero = sc.nextInt();

                if (numero >= numMinimo && numero <= numMaximo) {
                    return numero;
                } else {
                    System.out.println("Error: El número debe estar dentro del rango especificado.\nIngresa un numero: ");
                }
            } catch (Exception e) {
                System.out.println("Error: Debes introducir un número entero.\nIngresa un numero: ");
                sc.next();
            }
        } while (true);
    }

    //  verifica que el equipo local y visitante no sean los mismos 
    public static int verificarEquipo(ArrayList<String> nombreEquipos, int numComparador) {
       
    
        do {
            int num = Utileria.validarRango(1, nombreEquipos.size());
            System.out.println("Ingresa una opcion");
            if (num == numComparador) {
                System.out.println("Error: Esa opcion ya la has escogido antes.");
            } else {
                return num;
            }
        } while (true);

    }

    //verificar fecha
    @SuppressWarnings("resource")
    public static String validarFecha(String fecha){
        Scanner scanner = new Scanner(System.in);
        String regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{2}$";
        while (true){
            Pattern patron  = Pattern.compile(regexp); // compilacion en un patron
            Matcher matcher = patron.matcher(fecha); // crea el matcher
            boolean isMatching = matcher.matches(); // compara el string y el regexp
            if (isMatching == true){
                break;
            } else{
                System.out.println("Formato incorrecto, o fuera de rango. Intente otra vez");
                fecha = scanner.nextLine();
            }
        }
        return fecha;
    }
}
