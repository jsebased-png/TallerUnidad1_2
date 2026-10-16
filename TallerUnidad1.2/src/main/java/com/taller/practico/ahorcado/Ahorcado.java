package main.java.com.taller.practico.ahorcado;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    // ---------- Unidad 1.1: constantes y estado global ----------
    static final int MAX_INTENTOS = 6;
    static final String[] PALABRAS = {
            "JAVA", "CONSOLA", "VARIABLE", "BUCLE", "CADENA", "COMPILADOR",
            "PROGRAMA", "METODO", "OBJETO", "INTELLIJ", "ARREGLO", "ENTERO"
    };

    // Estadísticas acumuladas de la sesión
    static int partidasJugadas = 0;
    static int partidasGanadas = 0;
    static int partidasPerdidas = 0;
    static double mejorPuntaje = 0.0;
    static double puntajeTotal = 0.0;

    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("      ADIVINA LA PALABRA SECRETA - AHORCADO");
        System.out.println("====================================================");

        // ---------- Fase 2: registro y normalización del nombre ----------
        String nombreJugador = pedirNombre();
        System.out.println("¡Bienvenido, " + nombreJugador + "!");

        // ---------- Fase 1: menú principal con do-while + switch ----------
        int opcion;
        do {
            opcion = leerOpcionMenu();
            switch (opcion) {
                case 1:
                    jugarPartida(nombreJugador);
                    break;
                case 2:
                    mostrarEstadisticas(nombreJugador);
                    break;
                case 3:
                    System.out.println("\nGracias por jugar, " + nombreJugador + ". ¡Hasta pronto!");
                    break;
                default:
                    // No debería ocurrir: la validación ya filtra el rango
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    // =====================================================================
    // Fase 2: nombre del jugador (trim + toUpperCase + length)
    // =====================================================================
    static String pedirNombre() {
        String nombre = "";
        while (nombre.length() == 0) {
            System.out.print("Ingresa tu nombre: ");
            nombre = scanner.nextLine().trim().toUpperCase();
            if (nombre.length() == 0) {
                System.out.println("⚠ El nombre no puede estar vacío. Intenta de nuevo.");
            }
        }
        return nombre;
    }

    // =====================================================================
    // Fase 1: lectura validada del menú (nextLine + Integer.parseInt + while)
    // =====================================================================
    static int leerOpcionMenu() {
        int opcion = 0;
        boolean valida = false;

        while (!valida) {
            System.out.println("\n--------------- MENÚ PRINCIPAL ---------------");
            System.out.println("1. Jugar");
            System.out.println("2. Ver Estadísticas");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            String entrada = scanner.nextLine().trim();

            try {
                opcion = Integer.parseInt(entrada);
                if (opcion >= 1 && opcion <= 3) {
                    valida = true;
                } else {
                    System.out.println("⚠ Opción fuera de rango. Debe ser 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Entrada no válida: \"" + entrada + "\". Ingresa solo un número (1, 2 o 3).");
            }
        }
        return opcion;
    }

    // =====================================================================
    // Fase 3: bucle del juego con StringBuilder
    // =====================================================================
    static void jugarPartida(String nombreJugador) {
        String palabraSecreta = PALABRAS[random.nextInt(PALABRAS.length)];

        // Variables de estado de la partida (Unidad 1.1)
        int intentosRestantes = MAX_INTENTOS;
        double puntaje = 100.0;
        boolean juegoGanado = false;
        boolean rendido = false;
        char ultimaLetra = ' ';
        int aciertos = 0;
        int fallos = 0;

        // Máscara oculta: "_ _ _ _" (un guion bajo por letra, separados por espacio)
        StringBuilder mascara = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            mascara.append("_");
            if (i < palabraSecreta.length() - 1) {
                mascara.append(" ");
            }
        }
        // Historial dinámico de letras arriesgadas
        StringBuilder historial = new StringBuilder();

        System.out.println("\n¡Comienza la partida! La palabra tiene " + palabraSecreta.length() + " letras.");
        System.out.println("(Escribe RENDIRSE en cualquier momento para abandonar.)");

        while (intentosRestantes > 0 && !juegoGanado) {
            System.out.println("\n----------------------------------------------------");
            System.out.println("Palabra:  " + mascara);
            System.out.println("Letras usadas: " + (historial.length() == 0 ? "(ninguna)" : historial.toString().trim()));
            System.out.println("Intentos restantes: " + intentosRestantes + " / " + MAX_INTENTOS);
            System.out.print("Ingresa una letra: ");
            String entrada = scanner.nextLine().trim();

            // Validación: entrada no vacía
            if (entrada.length() == 0) {
                System.out.println("⚠ No ingresaste nada. Escribe una letra.");
                continue;
            }

            // Rendición -> break inmediato
            if (entrada.equalsIgnoreCase("RENDIRSE")) {
                rendido = true;
                System.out.println("Te has rendido. La partida termina.");
                break;
            }

            // Solo una letra permitida
            if (entrada.length() > 1) {
                System.out.println("⚠ Ingresa UNA sola letra a la vez.");
                continue;
            }

            // Extracción segura (length() > 0 ya verificado)
            char letra = Character.toUpperCase(entrada.charAt(0));
            if (!Character.isLetter(letra)) {
                System.out.println("⚠ Carácter inválido. Usa solo letras del alfabeto.");
                continue;
            }

            // Letra repetida -> continue
            if (historial.indexOf(String.valueOf(letra)) >= 0) {
                System.out.println("⚠ Ya intentaste la letra '" + letra + "'. Prueba con otra.");
                continue;
            }

            ultimaLetra = letra;
            historial.append(ultimaLetra).append(" ");

            // Comparación con equalsIgnoreCase y actualización de la máscara
            boolean acierto = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                String letraSecreta = String.valueOf(palabraSecreta.charAt(i));
                if (letraSecreta.equalsIgnoreCase(String.valueOf(ultimaLetra))) {
                    mascara.setCharAt(i * 2, letraSecreta.charAt(0)); // posición exacta (hay espacios intercalados)
                    acierto = true;
                }
            }

            if (acierto) {
                aciertos++;
            } else {
                fallos++;
                intentosRestantes--; // solo decrementa cuando la letra NO pertenece
            }

            // Operador ternario para retroalimentación
            System.out.println(acierto
                    ? "✔ ¡Bien! La letra '" + ultimaLetra + "' está en la palabra."
                    : "✘ La letra '" + ultimaLetra + "' no está en la palabra.");

            // Victoria temprana -> break
            if (mascara.indexOf("_") == -1) {
                juegoGanado = true;
                break;
            }
        }

        // Cálculo del puntaje
        if (juegoGanado) {
            puntaje = 100.0 + intentosRestantes * 12.5;
        } else {
            puntaje = aciertos * 5.0;
        }

        // Actualizar estadísticas de sesión
        partidasJugadas++;
        puntajeTotal += puntaje;
        if (juegoGanado) {
            partidasGanadas++;
        } else {
            partidasPerdidas++;
        }
        if (puntaje > mejorPuntaje) {
            mejorPuntaje = puntaje;
        }

        mostrarResumen(nombreJugador, juegoGanado, rendido, palabraSecreta,
                intentosRestantes, aciertos, fallos, puntaje);
    }

    // =====================================================================
    // Fase 4: resumen con System.out.printf
    // =====================================================================
    static void mostrarResumen(String nombre, boolean ganado, boolean rendido, String palabra,
                               int intentosRestantes, int aciertos, int fallos, double puntaje) {
        int totalIntentos = aciertos + fallos;
        // Casting a double para evitar la división entera
        double porcentaje = totalIntentos == 0 ? 0.0 : (double) aciertos / totalIntentos * 100;
        String estado = ganado ? "¡VICTORIA!" : (rendido ? "RENDICIÓN" : "DERROTA");
        String linea = "====================================================";

        System.out.println();
        System.out.printf("%s%n", linea);
        System.out.printf("%s%n", "RESUMEN DE LA PARTIDA");
        System.out.printf("%s%n", linea);
        System.out.printf("%-20s %s%n", "Jugador:", nombre);
        System.out.printf("%-20s %s%n", "Estado Final:", estado);
        System.out.printf("%-20s %s%n", "Palabra Secreta:", palabra);
        System.out.printf("%-20s %d / %d%n", "Intentos Restantes:", intentosRestantes, MAX_INTENTOS);
        System.out.printf("%-20s %.2f%%%n", "Porcentaje Aciertos:", porcentaje);
        System.out.printf("%-20s %.2f pts%n", "Puntaje Final:", puntaje);
        System.out.printf("%s%n", linea);
    }

    static void mostrarEstadisticas(String nombre) {
        String linea = "====================================================";
        double promedio = partidasJugadas == 0 ? 0.0 : puntajeTotal / partidasJugadas;

        System.out.println();
        System.out.printf("%s%n", linea);
        System.out.printf("%s%n", "ESTADÍSTICAS DE LA SESIÓN");
        System.out.printf("%s%n", linea);
        System.out.printf("%-22s %s%n", "Jugador:", nombre);
        System.out.printf("%-22s %d%n", "Partidas jugadas:", partidasJugadas);
        System.out.printf("%-22s %d%n", "Partidas ganadas:", partidasGanadas);
        System.out.printf("%-22s %d%n", "Partidas perdidas:", partidasPerdidas);
        System.out.printf("%-22s %.2f pts%n", "Mejor puntaje:", mejorPuntaje);
        System.out.printf("%-22s %.2f pts%n", "Puntaje promedio:", promedio);
        System.out.printf("%s%n", linea);
    }
}
