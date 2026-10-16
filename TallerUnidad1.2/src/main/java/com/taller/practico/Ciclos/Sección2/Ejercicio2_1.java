package JAVA.com.taller.practico.Ciclos.Sección2;

import java.util.Scanner;

public class Ejercicio2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pin;

        System.out.println("=== Ejercicio 2.1: Validación Estricta de PIN (4 dígitos) ===");

        do {
            System.out.print("Ingrese su PIN de seguridad (4 dígitos, 1000-9999): ");
            pin = scanner.nextInt();

            if (pin < 1000 || pin > 9999) {
                System.out.println("Error: La clave debe tener exactamente 4 dígitos positivos");
            }
        } while (pin < 1000 || pin > 9999);

        System.out.println("PIN válido ingresado: " + pin);
        System.out.println("Acceso permitido.");

        scanner.close();
    }
}
