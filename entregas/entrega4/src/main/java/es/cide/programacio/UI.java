package es.cide.programacio;

//clase totalmente opcional. Solo para hacer el output bonito
public class UI {

    // Colores para el output por consola
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String AZUL = "\u001B[34m";
    private static final String MORADO = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String BLANCO = "\u001B[37m";
    private static final String MARROM = "\u001B[33m";

    // Estilos extra
    public static final String NEGRITA = "\u001B[1m";
    public static final String FONDO_ROJO = "\u001B[41m";
    public static final String FONDO_VERDE = "\u001B[42m";

    // **************************************************************************************************************************/
    // Info unicamente visual, no contiene lógica de la práctica

    public static void escribirLento(String texto, int delay) {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void escribirRapido(String texto, int nanos, long milis) {
        // 1. Imprimimos todo el texto de golpe
        System.out.println(texto);

        // 2. Aplicamos la pausa después de que todo el texto ha sido mostrado
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // En un juego, generalmente ignoramos esta excepción para no detener el flujo.
            // También podrías agregar e.printStackTrace(); para depuración.
        }
    }

    private static String crearBarraDeVida(int actual, int maximo, int longitud) {
        // ... (copiar y pegar de la Opción 1) ...
        actual = Math.max(0, actual);
        double porcentaje = (double) actual / maximo;
        int caracteresLlenos = (int) (porcentaje * longitud);
        int caracteresVacios = longitud - caracteresLlenos;
        String barra = "[" + "█".repeat(caracteresLlenos) + "░".repeat(caracteresVacios) + "]";
        return barra;
    }

    private static String[] generarPanelStringArray(int vidaJugador, int maxVidaJugador, String nombrePirata,
            int vidaPirata, int maxVidaPirata, String nombreJugador, int numPiratas) {

        int anchoBarra = 20;
        String barraJugador = crearBarraDeVida(vidaJugador, maxVidaJugador, anchoBarra);
        String barraPirata = crearBarraDeVida(vidaPirata, maxVidaPirata, anchoBarra);
        String vidaJugadorStr = vidaJugador + "/" + maxVidaJugador;
        String vidaPirataStr = vidaPirata + "/" + maxVidaPirata;

        // El ancho interno del panel será 44 (total 48)
        String[] panel = new String[11];

        // Creamos las líneas de texto que irán dentro
        String titulo = "        BATALLA DE INSULTOS        ";
        String jugadorInfo = " JUGADOR: " + nombreJugador;
        String jugadorVida = String.format("   Vida: %s %s", barraJugador, vidaJugadorStr);
        String pirataInfo = " PIRATA: " + nombrePirata + "/" + numPiratas;
        String pirataVida = String.format("   Vida: %s %s", barraPirata, vidaPirataStr);
        String lineaVacia = "                                            "; // 44 espacios

        // Construimos el panel final usando String.format() para asegurar la longitud
        panel[0] = "╔══════════════════════════════════════════════╗"; // 48 chars
        panel[1] = String.format("║ %-44s ║", titulo);
        panel[2] = "╠══════════════════════════════════════════════╣"; // 48 chars
        panel[3] = String.format("║ %-44s ║", jugadorInfo);
        panel[4] = String.format("║ %-44s ║", jugadorVida);
        panel[5] = String.format("║ %-44s ║", lineaVacia);
        panel[6] = String.format("║ %-44s ║", pirataInfo);
        panel[7] = String.format("║ %-44s ║", pirataVida);
        panel[8] = String.format("║ %-44s ║", lineaVacia);
        panel[9] = String.format("║ %-44s ║", lineaVacia);
        panel[10] = "╚══════════════════════════════════════════════╝"; // 48 chars

        return panel;
    }

    private static void mostrarPanel(int vidaJugador, int maxVidaJugador, String nombrePirata,
            int vidaPirata, int maxVidaPirata, String nombreJugador, int numPiratas) {

        // (Asumo que ROJO y RESET son variables de color definidas en tu clase)
        String[] panel = generarPanelStringArray(vidaJugador, maxVidaJugador, nombrePirata, vidaPirata, maxVidaPirata,
                nombreJugador, numPiratas);

        System.out.println(ROJO); // Color encendido
        for (String linea : panel) {
            escribirLento(linea, 15);
        }
        System.out.println(RESET); // Color apagado
        System.out.println(); // El 'println' vacío que tenías
    }

    public static void titulo(Illa i) {
        System.out.print(CYAN);
        escribirLento(("\r\n" + //
                "████████╗██╗░░██╗███████╗░░██████╗███████╗░█████╗░██████╗░███████╗████████╗░░█████╗░███████╗\r\n" + //
                "╚══██╔══╝██║░░██║██╔════╝░██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝╚══██╔══╝░██╔══██╗██╔════╝\r\n" + //
                "░░░██║░░░███████║█████╗░░░╚█████╗░█████╗░░██║░░╚═╝██████╔╝█████╗░░░░░██║░░░░██║░░██║█████╗░░\r\n" + //
                "░░░██║░░░██╔══██║██╔══╝░░░░╚═══██╗██╔══╝░░██║░░██╗██╔══██╗██╔══╝░░░░░██║░░░░██║░░██║██╔══╝░░\r\n" + //
                "░░░██║░░░██║░░██║███████╗░██████╔╝███████╗╚█████╔╝██║░░██║███████╗░░░██║░░░░╚█████╔╝██║░░░░░\r\n" + //
                "░░░╚═╝░░░╚═╝░░╚═╝╚══════╚░═════╝░╚══════╝░╚════╝░╚═╝░░╚═╝╚══════╝░░░╚═╝░░░░░╚════╝░╚═╝░░░░░\r\n" + //
                "\r\n" + //
                "███╗░░░███╗░█████╗░███╗░░██╗██╗░░██╗███████╗██╗░░░██╗░██╗░██████╗██╗░░░░░░█████╗░███╗░░██╗██████╗░\r\n"
                + //
                "████╗░████║██╔══██╗████╗░██║██║░██╔╝██╔════╝╚██╗░██╔╝░██║██╔════╝██║░░░░░██╔══██╗████╗░██║██╔══██╗\r\n"
                + //
                "██╔████╔██║██║░░██║██╔██╗██║█████═╝░█████╗░░░╚████╔╝░░██║╚█████╗░██║░░░░░███████║██╔██╗██║██║░░██║\r\n"
                + //
                "██║╚██╔╝██║██║░░██║██║╚████║██╔═██╗░██╔══╝░░░░╚██╔╝░░░██║░╚═══██╗██║░░░░░██╔══██║██║╚████║██║░░██║\r\n"
                + //
                "██║░╚═╝░██║╚█████╔╝██║░╚███║██║░╚██╗███████╗░░░██║░░░░██║██████╔╝███████╗██║░░██║██║░╚███║██████╔╝\r\n"
                + //
                "╚═╝░░░░░╚═╝░╚════╝░╚═╝░░╚══╝╚═╝░░╚═╝╚══════╝░░░╚═╝░░░░╚═╝╚═════╝░╚══════╝╚═╝░░╚═╝╚═╝░░╚══╝╚═════╝░"),
                1);
        System.out.println();
        escribirLento("Bienvenido a " + i.getNom() + ", introduce tu nombre: ", 15);
        System.out.print(RESET);
    }

    public static void finDelJuego(boolean victoria) {
        limpiarConsola();
        if (victoria)
            System.out.println(FONDO_VERDE + NEGRITA + BLANCO);
        else
            System.out.println(FONDO_ROJO + NEGRITA + BLANCO);

        System.out.println("                                        ");
        if (victoria)
            escribirLento("                VICTORIA                ", 10);
        else
            escribirLento("              FIN DEL JUEGO             ", 10);

        System.out.println("                                        ");
        System.out.println(RESET);
    }

    public static void limpiarConsola() {
        for (int k = 0; k < 60; k++)
            System.out.println();
    }

    public static void sprites(int vidaJugador, int maxVidaJugador, String nombrePirata,
            int vidaPirata, int maxVidaPirata, String nombreJugador, int numPiratas) {

        // Tu array original intacto
        String[] left = new String[] {
                VERDE +
                        "                          ██▓▓▓▓▓▓██                     ",
                "                        ██████▓▓▓▓████████                 ",
                "                      ████▓▓▓▓▓▓███████▓▓███               ",
                "                      ███████████░░░░░░███████             ",
                "                      ▓▓█████████▓▓███▓▓██▓▓               ",
                "                    ██████▓▓  ░░░░░░  ▓▓██▓▓   ██         ",
                "                    ██  ██░░░░░░░░░░░░▓▓██▓▓ ███           ",
                "                  ██      ░░░░▓▓██▓▓░░▓▓                   ",
                "                          ██▓▓██████▓▓▓▓▓▓               ",
                "                          ██▓▓░░░░░░████▓▓▓▓             ",
                "                        ████░░▓▓▓▓▓▓░░██████             ",
                "                  ▓▓▓▓▓▓████░░░░░░░░▓▓████▓▓▓▓▓▓▓▓       ",
                "                ▓▓▓▓▓▓▓▓████▓▓░░░░░░▓▓████▓▓▓▓▓▓▓▓▓▓▓▓   ",
                "              ▓▓▓▓▓▓▓▓▓▓████▓▓▓▓░░▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓   ",
                "            ▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓░░▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ",
                "            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ",
                "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓██▓▓▓▓▓▓██▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓",
                "          ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓▓▓██▓▓▓▓▓▓  ▓▓▓▓▓▓▓",
                "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓▓▓  ▓▓▓▓▓▓▓",
                "          ▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
                "          ████▒▒▒▒▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒",
                "            ██████▓▓▓▓▓▓▓▓██▓▓████████▓▓██▓▓▓▓▓▓▓▓▒▒▒▒███",
                "            ░░░░░░▓▓▓▓▓▓▓▓██  ██    ██  ██▓▓▓▓▓▓▓▓██████ ",
                "            ░░░░░░░░▓▓▓▓▓▓██  ████  ██  ██▓▓▓▓▓▓▓▓░░░░░░ ",
                "              ░░░░▓▓▓▓  ▓▓██  ██    ██  ██▓▓▓▓▓▓░░░░░░░░ ",
                "                ░░▓▓▓▓▓▓▓▓██░░████████░░██▓▓▓▓▓▓▓▓░░░░░░ ",
                "                  ▓▓▓▓▓▓▓▓██░░░░░░░░░░░░██▓▓▓▓▓▓▓▓░░░░   ",
                "                  ▓▓▓▓▓▓▓▓██░░░░░░░░░░░░████▓▓▓▓▓▓▓▓     ",
                "                  ▓▓▓▓░░▓▓██░░░░░░░░░░░░██▓▓▓▓▓▓▓▓       ",
                "                  ▓▓▓▓░░▓▓██░░░░░░░░░░░░██▓▓▓▓▓▓▓▓       ",
                "                  ▓▓▓▓░░▓▓██░░░░░░░░░░░░██▓▓▓▓░░▓▓       ",
                "                  ▓▓▓▓░░▓▓██░░░░░░  ░░░░░░██▓▓░░██       ",
                "                  ████░░██░░░░░░░░  ░░░░░░░░██░░██       ",
                "                  ████░░██░░░░░░░░  ░░░░░░░░░░░░░░       ",
                "                      ░░░░░░░░░░░░    ░░░░░░░░░░░░       ",
                "                      ▓▓▓▓▓▓▓▓▓▓        ▓▓▓▓▓▓▓▓▓▓▓▓     ",
                "                      ▓▓▓▓▓▓▓▓▓▓▓▓      ▓▓▓▓▓▓▓▓▓▓▓▓     ",
                "                    ██████████▓▓▓▓    ████████████████   ",
                "                    ██████████▓▓▓▓    ████████████████   ",
                "                    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓    ████████████████   ",
                "                        ▓▓▓▓▓▓          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓   ",
                "                        ▓▓████▓▓            ▓▓████▓▓     ",
                "                    ▓▓▓▓████████            ██████████▓▓▓",
                "                  ▓▓████████████            █████████████" + RESET,

        };
        System.out.println();

        // --- LOGICA DE IMPRESION MEJORADA ---

        String[] panel = generarPanelStringArray(vidaJugador, maxVidaJugador, nombrePirata, vidaPirata, maxVidaPirata,
                nombreJugador, numPiratas);

        // 1. Calculamos el ancho real del dibujo (ignorando los códigos de color
        // invisibles)
        // Esto es necesario porque la primera línea tiene "VERDE" y las otras no.
        int anchoMaximoSprite = 0;
        for (String s : left) {
            // Esta expresión regular elimina los códigos ANSI para medir solo el texto
            // visible
            String textoSinColor = s.replaceAll("\u001B\\[[;\\d]*m", "");
            if (textoSinColor.length() > anchoMaximoSprite) {
                anchoMaximoSprite = textoSinColor.length();
            }
        }

        int margenExtra = 4; // Espacio entre dibujo y panel

        // 2. Ajustamos la altura al elemento más grande (el dibujo)
        int altoDibujo = left.length;
        int altoPanel = panel.length;
        int altoTotal = Math.max(altoDibujo, altoPanel);

        int paddingTop = (altoTotal - altoPanel) / 2;

        // 3. Bucle de impresión seguro
        for (int i = 0; i < altoTotal; i++) {

            // -- PARTE IZQUIERDA --
            String lineaSprite = "";
            int longitudVisible = 0;

            if (i < left.length) {
                lineaSprite = left[i];
                // Medimos longitud sin colores para calcular espacios de relleno
                longitudVisible = lineaSprite.replaceAll("\u001B\\[[;\\d]*m", "").length();
            }

            // Imprimimos el sprite forzando VERDE al inicio para asegurar continuidad
            // y RESET al final para no manchar el panel
            System.out.print(VERDE);
            escribirLento(lineaSprite, 1);
            // escribirRapido(lineaSprite, 1, 100);
            System.out.print(RESET);

            // Rellenamos con espacios hasta llegar a la columna del panel
            int espaciosFaltantes = anchoMaximoSprite - longitudVisible + margenExtra;
            // Protección por si sale negativo
            if (espaciosFaltantes > 0) {
                System.out.print(" ".repeat(espaciosFaltantes));
            }

            // -- PARTE DERECHA --
            if (i >= paddingTop && i < paddingTop + altoPanel) {
                // Imprimimos el panel con su color (AMARILLO)
                System.out.print(AMARILLO);
                escribirLento(panel[i - paddingTop], 1);
                // escribirRapido(lineaSprite, 5000, 15);
                System.out.print(RESET);
            }

            // Salto de línea final
            System.out.println();
        }
    }
}
