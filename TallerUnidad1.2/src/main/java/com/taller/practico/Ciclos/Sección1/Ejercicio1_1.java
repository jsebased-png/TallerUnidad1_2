package JAVA.com.taller.practico.Ciclos.Sección1;

import java.util.Scanner;

public class Ejercicio1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int acumulador = 0;
        int contador = 0;
        int numero;

        System.out.println("=== Ejercicio 1.1: Contador y Acumulador con Valor Centinela ===");
        System.out.println("Ingrese números enteros. Para finalizar escriba -99.");

        System.out.print("Ingrese un número: ");
        numero = scanner.nextInt();

        while (numero != -99) {
            acumulador += numero;
            contador++;

            System.out.print("Ingrese un número: ");
            numero = scanner.nextInt();
        }

        System.out.println("\n--- Resultados ---");
        System.out.println("Total acumulado de los números ingresados: " + acumulador);
        System.out.println("Cantidad exacta de entradas procesadas: " + contador);

        scanner.close();
    }
}
