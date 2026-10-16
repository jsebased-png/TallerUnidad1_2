package JAVA.com.taller.practico.Ciclos.Sección4;

public class Ejercicio4_1 {
    public static void main(String[] args) {
        System.out.println("=== Ejercicio 4.1: Búsqueda con break ===");
        System.out.println("Buscando el primer número entre 1 y 100 divisible por 7 y 11...");

        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0 && i % 11 == 0) {
                System.out.println("Primer número encontrado: " + i);
                break;
            }
        }
    }
}
