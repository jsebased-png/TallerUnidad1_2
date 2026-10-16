package JAVA.com.taller.practico.operadores;

public class Seccion1Operadores {
    public static void main(String[] args) {
        System.out.println("========== SECCIÓN 1: CALENTAMIENTO DE OPERADORES ==========\n");

        int seg = 86400 % 3600;
        System.out.println("1) int seg = 86400 % 3600;");
        System.out.println("   Predicción: 0");
        System.out.println("   Resultado real: " + seg + "\n");

        int x = 7;
        int y = ++x + x++;
        System.out.println("2) int y = ++x + x++;  (x inicial = 7)");
        System.out.println("   Predicción: y = 16, x final = 9");
        System.out.println("   Resultado real: y = " + y + ", x final = " + x + "\n");

        double div1 = 15 / 2;
        double div2 = 15.0 / 2;
        System.out.println("3) double div1 = 15 / 2; double div2 = 15.0 / 2;");
        System.out.println("   Predicción: div1 = 7.0 , div2 = 7.5");
        System.out.println("   Resultado real: div1 = " + div1 + " , div2 = " + div2 + "\n");

        x = 7;
        boolean flag = false;
        boolean res = flag && (++x > 0);
        System.out.println("4) boolean res = flag && (++x > 0);  (flag=false, x=7)");
        System.out.println("   Predicción: res = false, x permanece 7 (short-circuit)");
        System.out.println("   Resultado real: res = " + res + ", x = " + x);
    }
}
