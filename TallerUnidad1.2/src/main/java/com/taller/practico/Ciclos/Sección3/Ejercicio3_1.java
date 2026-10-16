package JAVA.com.taller.practico.Ciclos.Sección3;

import java.util.Scanner;

public class Ejercicio3_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Ejercicio 3.1: Tabla de Multiplicar y Conteo Regresivo ===");
        System.out.print("Ingrese un número entero N: ");
        int N = scanner.nextInt();

        System.out.println("\n--- Tabla de multiplicar de " + N + " ---");
        for (int i = 1; i <= 12; i++) {
            System.out.println(N + " x " + i + " = " + (N * i));
        }

        System.out.println("\n--- Conteo regresivo desde " + N + " hasta 0 ---");
        for (int i = N; i >= 0; i--) {
            System.out.println(i);
        }

        scanner.close();
    }
}
