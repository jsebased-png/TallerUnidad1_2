package JAVA.com.taller.practico.operadores;

public class RetoIntegrador {
    public static void main(String[] args) {
        System.out.println("========== RETO INTEGRADOR: CAJA E INVENTARIO ==========\n");

        System.out.println("--- Caso de Prueba A ---");
        calcularFactura(3, "VIP", "PROMO1 año");

        System.out.println("\n--- Caso de Prueba B ---");
        calcularFactura(1, "NUEVO", "PROMO1 año");
    }

    private static void calcularFactura(int cantidad, String tipoCliente, String cupon) {
        final double PRECIO_UNITARIO = 250.00;
        final double IVA = 0.16;

        double subtotalBase = cantidad * PRECIO_UNITARIO;
        System.out.printf("Subtotal base (%d × $%.2f): $%.2f%n", cantidad, PRECIO_UNITARIO, subtotalBase);

        double porcentajeDescuento = switch (tipoCliente) {
            case "VIP"     -> 0.20;
            case "REGULAR" -> 0.10;
            case "NUEVO"   -> 0.05;
            default        -> 0.00;
        };

        double descuentoCliente = subtotalBase * porcentajeDescuento;
        double subtotalConDescuento = subtotalBase - descuentoCliente;
        System.out.printf("Descuento cliente %s (%.0f%%): -$%.2f → Subtotal: $%.2f%n",
                tipoCliente, porcentajeDescuento * 100, descuentoCliente, subtotalConDescuento);

        double descuentoCupon = 0.0;
        if (cupon.equals("PROMO1 año") && subtotalConDescuento >= 500.00) {
            descuentoCupon = 50.00;
            System.out.println("Cupón \"PROMO1 año\" válido y subtotal ≥ $500 → Descuento adicional: -$50.00");
        } else {
            System.out.println("Cupón no aplica (código incorrecto o subtotal < $500) → Descuento cupón: $0.00");
        }

        double baseImponible = subtotalConDescuento - descuentoCupon;
        double montoIVA = baseImponible * IVA;
        double totalFinal = baseImponible + montoIVA;

        System.out.printf("Base imponible: $%.2f%n", baseImponible);
        System.out.printf("IVA (16%%): +$%.2f%n", montoIVA);
        System.out.printf(">>> TOTAL A PAGAR: $%.2f%n", totalFinal);
    }
}
