package JAVA.com.taller.practico.Ciclos.Sección3;

import java.util.Scanner;

public class Ejercicio3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Ejercicio 3.2: Factorial y Patrón Triangular ===");
        System.out.print("Ingrese un número entero positivo N: ");
        int N = scanner.nextInt();

        if (N < 0) {
            System.out.println("Error: N debe ser un número entero positivo.");
            scanner.close();
            return;
        }

        long factorial = 1;
        for (int i = 1; i <= N; i++) {
            factorial *= i;
        }
        System.out.println("\n--- Parte A: Factorial ---");
        System.out.println(N + "! = " + factorial);

        System.out.println("\n--- Parte B: Patrón Triangular de altura " + N + " ---");
        for (int fila = 1; fila <= N; fila++) {
            for (int col = 1; col <= fila; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
