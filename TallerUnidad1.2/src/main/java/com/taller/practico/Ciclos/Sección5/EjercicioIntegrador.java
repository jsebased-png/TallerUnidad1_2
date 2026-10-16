package JAVA.com.taller.practico.Ciclos.Sección5;

import java.util.Scanner;

public class EjercicioIntegrador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalProductosRegistrados = 0;
        int totalUnidades = 0;
        double valorTotalInventario = 0.0;
        final int CAPACIDAD_MAXIMA = 500;

        int opcion;

        System.out.println("=== RETO INTEGRADOR: Simulador de Control de Inventario ===");

        do {
            System.out.println("\n----- MENÚ PRINCIPAL -----");
            System.out.println("1. Registrar Lote de Productos");
            System.out.println("2. Ver Estado del Almacén");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántos productos componen el lote? ");
                    int N = scanner.nextInt();

                    if (N <= 0) {
                        System.out.println("La cantidad de productos debe ser mayor a cero.");
                        break;
                    }

                    for (int i = 1; i <= N; i++) {
                        System.out.println("\n--- Producto " + i + " de " + N + " ---");

                        System.out.print("¿El producto está descontinuado? (s/n): ");
                        String descontinuado = scanner.next();

                        if (descontinuado.equalsIgnoreCase("s")) {
                            System.out.println("Producto descontinuado. Se omite del inventario.");
                            continue;
                        }

                        double precio;
                        do {
                            System.out.print("Ingrese el precio del producto (mayor a 0): ");
                            precio = scanner.nextDouble();
                            if (precio <= 0) {
                                System.out.println("Error: El precio debe ser estrictamente mayor a cero.");
                            }
                        } while (precio <= 0);

                        int cantidad;
                        do {
                            System.out.print("Ingrese la cantidad en stock (mayor a 0): ");
                            cantidad = scanner.nextInt();
                            if (cantidad <= 0) {
                                System.out.println("Error: La cantidad debe ser estrictamente mayor a cero.");
                            }
                        } while (cantidad <= 0);

                        if (totalUnidades + cantidad > CAPACIDAD_MAXIMA) {
                            System.out.println("¡ALERTA DE SOBRECUPO!");
                            System.out.println("La capacidad máxima del almacén (" + CAPACIDAD_MAXIMA +
                                    " unidades) sería superada.");
                            System.out.println("Se aborta el procesamiento del lote restante.");
                            break;
                        }

                        totalProductosRegistrados++;
                        totalUnidades += cantidad;
                        valorTotalInventario += (precio * cantidad);
                        System.out.println("Producto registrado correctamente.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- ESTADO DEL ALMACÉN ---");
                    System.out.println("Productos registrados: " + totalProductosRegistrados);
                    System.out.println("Unidades totales en stock: " + totalUnidades);
                    System.out.println("Capacidad máxima: " + CAPACIDAD_MAXIMA);
                    System.out.println("Espacio disponible: " + (CAPACIDAD_MAXIMA - totalUnidades));
                    System.out.println("Valor total del inventario: $" + String.format("%.2f", valorTotalInventario));
                    break;

                case 3:
                    System.out.println("Saliendo del sistema de inventario. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
