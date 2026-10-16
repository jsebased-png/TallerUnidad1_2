package JAVA.com.taller.practico.Ciclos.Sección6;

public class Debug3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println("Número impar detectado: " + i);
                continue;
            }
            System.out.println("Número par procesado: " + i);
        }
    }
}
