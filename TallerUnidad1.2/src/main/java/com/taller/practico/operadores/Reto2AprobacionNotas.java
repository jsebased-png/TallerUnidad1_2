package JAVA.com.taller.practico.operadores;

public class Reto2AprobacionNotas {
    public static void main(String[] args) {
        System.out.println("--- Reto 2: Aprobación de Notas y Asistencia ---\n");

        evaluarEstudiante(85.0, 90, true);
        evaluarEstudiante(65.0, 70, true);
        evaluarEstudiante(55.0, 75, false);
        evaluarEstudiante(80.0, 60, false);
    }

    private static void evaluarEstudiante(double calificacionFinal, int porcentajeAsistencia, boolean entregoProyectoFinal) {
        String dictamen;

        if (calificacionFinal >= 70.0 && porcentajeAsistencia >= 80) {
            dictamen = "Aprobado";
        } else if (entregoProyectoFinal && calificacionFinal >= 60.0) {
            dictamen = "Pendiente de Examen Extraordinario";
        } else {
            dictamen = "Reprobado";
        }

        System.out.printf("Calificación: %.1f | Asistencia: %d%% | Proyecto: %b → %s%n",
                calificacionFinal, porcentajeAsistencia, entregoProyectoFinal, dictamen);
    }
}
