package JAVA.com.taller.practico.Ciclos.Sección2;

import java.util.Scanner;

public class Ejercicio2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        double saldo = 0.0;

        System.out.println("=== Ejercicio 2.2: Menú Interactivo de Consola (Plataforma Bancaria) ===");

        do {
            System.out.println("\n----- MENÚ PRINCIPAL -----");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Retiro");
            System.out.println("4. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Su saldo actual es: $" + String.format("%.2f", saldo));
                    break;
                case 2:
                    System.out.print("Ingrese el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito exitoso. Nuevo saldo: $" + String.format("%.2f", saldo));
                    } else {
                        System.out.println("Monto inválido. Debe ser mayor a cero.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (retiro > 0 && retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + String.format("%.2f", saldo));
                    } else if (retiro > saldo) {
                        System.out.println("Fondos insuficientes.");
                    } else {
                        System.out.println("Monto inválido. Debe ser mayor a cero.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
