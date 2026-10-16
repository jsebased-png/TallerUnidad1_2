package JAVA.com.taller.practico.operadores;

public class Seccion3Switch {
    public static void main(String[] args) {
        System.out.println("--- Gestor de Días de la Semana ---\n");

        int[] diasPrueba = {1, 3, 6, 7, 9};

        for (int dia : diasPrueba) {
            System.out.println("Día número: " + dia);
            System.out.print("  Tradicional → ");
            jornadaTradicional(dia);
            System.out.print("  Moderno     → ");
            jornadaModerna(dia);
            System.out.println();
        }
    }

    private static void jornadaTradicional(int diaSemana) {
        String jornada;
        switch (diaSemana) {
            case 1:
                jornada = "Lunes - Jornada Laboral";
                break;
            case 2:
                jornada = "Martes - Jornada Laboral";
                break;
            case 3:
                jornada = "Miércoles - Jornada Laboral";
                break;
            case 4:
                jornada = "Jueves - Jornada Laboral";
                break;
            case 5:
                jornada = "Viernes - Jornada Laboral";
                break;
            case 6:
                jornada = "Sábado - Jornada de Descanso";
                break;
            case 7:
                jornada = "Domingo - Jornada de Descanso";
                break;
            default:
                jornada = "Día no identificado / entrada inválida";
        }
        System.out.println(jornada);
    }

    private static void jornadaModerna(int diaSemana) {
        String jornada = switch (diaSemana) {
            case 1 -> "Lunes - Jornada Laboral";
            case 2 -> "Martes - Jornada Laboral";
            case 3 -> "Miércoles - Jornada Laboral";
            case 4 -> "Jueves - Jornada Laboral";
            case 5 -> "Viernes - Jornada Laboral";
            case 6 -> "Sábado - Jornada de Descanso";
            case 7 -> "Domingo - Jornada de Descanso";
            default -> "Día no identificado / entrada inválida";
        };
        System.out.println(jornada);
    }
}
