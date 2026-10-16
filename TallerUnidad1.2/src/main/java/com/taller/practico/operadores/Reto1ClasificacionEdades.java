package JAVA.com.taller.practico.operadores;

public class Reto1ClasificacionEdades {
    public static void main(String[] args) {
        System.out.println("--- Reto 1: Clasificación de Edades ---\n");

        int[] edadesPrueba = {10, 15, 28, 68};

        for (int edadUsuario : edadesPrueba) {
            String categoria;
            String perfilAcceso;

            if (edadUsuario < 12) {
                categoria = "Infante";
                perfilAcceso = "requiere tutor de cuenta";
            } else if (edadUsuario >= 12 && edadUsuario <= 17) {
                categoria = "Adolescente";
                perfilAcceso = "acceso restringido a foros comunitarios";
            } else if (edadUsuario >= 18 && edadUsuario <= 64) {
                categoria = "Adulto";
                perfilAcceso = "acceso a funcionalidades estándar";
            } else {
                categoria = "Adulto Mayor";
                perfilAcceso = "acceso con interfaz adaptada";
            }

            System.out.println("Edad: " + edadUsuario + " → Categoría: " + categoria +
                    " (" + perfilAcceso + ")");
        }
    }
}
