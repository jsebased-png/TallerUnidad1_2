package JAVA.com.taller.practico.operadores;

public class Reto3TarifasEntrada {
    public static void main(String[] args) {
        System.out.println("--- Reto 3: Tarifas de Entrada ---\n");

        double precioBase = 100.0;
        String[] tipos = {"VIP", "ESTUDIANTE", "GENERAL", "ADULTO_MAYOR"};

        for (String tipoEntrada : tipos) {
            double montoFinal;

            if (tipoEntrada.equals("VIP")) {
                montoFinal = precioBase * 1.10;
            } else if (tipoEntrada.equals("ESTUDIANTE")) {
                montoFinal = precioBase * 0.50;
            } else if (tipoEntrada.equals("ADULTO_MAYOR")) {
                montoFinal = precioBase * 0.60;
            } else {
                montoFinal = precioBase;
            }

            System.out.printf("Tipo: %-14s → Precio final: $%.2f%n", tipoEntrada, montoFinal);
        }
    }
}
