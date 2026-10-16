package JAVA.com.taller.practico.operadores;

public class TernarioRefactor {
    public static void main(String[] args) {
        System.out.println("--- Refactorización a Operador Ternario ---\n");

        boolean cookieSesionActiva = true;
        String estadoConexion = cookieSesionActiva ? "ACTIVA" : "INACTIVA";
        System.out.println("Estado de conexión: " + estadoConexion);

        cookieSesionActiva = false;
        estadoConexion = cookieSesionActiva ? "ACTIVA" : "INACTIVA";
        System.out.println("Estado de conexión (cookie=false): " + estadoConexion);
    }
}
