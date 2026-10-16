package JAVA.com.taller.practico.Ciclos.Sección1;

import java.util.Scanner;

public class Ejercicio1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean procesando = true;
        double acumulador = 0.0;
        final double LIMITE_MAXIMO = 1000000.0;
        String causaFinalizacion = "";

        System.out.println("=== Ejercicio 1.2: Control de Proceso con Bandera de Parada ===");
        System.out.println("Módulo de caja - Ingrese montos de transacciones.");
        System.out.println("El proceso se detiene con monto negativo o al superar $1.000.000");

        while (procesando) {
            System.out.print("Ingrese el monto de la transacción: ");
            double monto = scanner.nextDouble();

            if (monto < 0) {
                procesando = false;
                causaFinalizacion = "Monto negativo (monto no válido)";
            } else if (acumulador + monto > LIMITE_MAXIMO) {
                procesando = false;
                causaFinalizacion = "Superación del límite máximo permitido ($1.000.000)";
            } else {
                acumulador += monto;
                System.out.println("Transacción registrada. Saldo actual: $" + String.format("%.2f", acumulador));
            }
        }

        System.out.println("\n--- Informe Final ---");
        System.out.println("Saldo final acumulado: $" + String.format("%.2f", acumulador));
        System.out.println("Causa de finalización: " + causaFinalizacion);

        scanner.close();
    }
}
