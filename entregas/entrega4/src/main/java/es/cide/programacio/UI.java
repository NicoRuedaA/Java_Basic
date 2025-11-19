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

    // Estilos extra
    public static final String NEGRITA = "\u001B[1m";
    public static final String FONDO_ROJO = "\u001B[41m";
    public static final String FONDO_VERDE = "\u001B[42m";
    static String[] boceto = new String[] {

            CYAN,
            "                          ████████████           ",
            "                        ████████████████         ",
            "                      ████████████████████       ",
            "                    ████████████░░░░████████     ",
            "                    ██████████░░░░██████         ",
            "                    ██████████░░░░  ░░░░         ",
            "                    ██████░░░░░░░░░░░░░░░░       ",
            "                    ██████░░░░░░░░░░████         ",
            "                  ██████████░░░░░░██████         ",
            "                ████████████████░░██░░░░         ",
            "                ████▒▒▒▒▒▒▒▒░░░░████████         ",
            "                ████▓▓▓▓████▒▒░░░░▒▒             ",
            "                ▓▓▓▓▓▓▓▓██████░░░░████           ",
            "              ▓▓▓▓▓▓▓▓▓▓▓▓████▒▒░░░░████         ",
            "            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓██████▒▒░░▓▓██         ",
            "          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▒▒░░▓▓██         ",
            "        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▒▒░░▓▓██         ",
            "        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▒▒▓▓▓▓██▓▓       ",
            "        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓██▓▓       ",
            "      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▒▒▓▓██▓▓       ",
            "      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▒▒▒▒▓▓██▓▓       ",
            "      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██████████▓▓       ",
            "      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████    ██▓▓       ",
            "      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓████  ████▓▓       ",
            "        ▓▓▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓████    ██▓▓░░     ",
            "        ▒▒██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓██████████▓▓░░     ",
            "        ██░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓██░░░░░░██▓▓▓▓░░   ",
            "        ░░░░░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓██░░░░░░██▓▓▓▓░░   ",
            "        ░░░░░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓██░░░░░░██▓▓▓▓     ",
            "        ░░  ░░▓▓░░▓▓▓▓▓▓▓▓▓▓▓▓██░░░░░░██▓▓▓▓     ",
            "            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██░░░░░░██▓▓▓▓     ",
            "            ▓▓▓▓▓▓▓▓▓▓▓▓░░▓▓▓▓██░░░░░░██▓▓▓▓     ",
            "            ▒▒▒▒▓▓░░▓▓▓▓░░▓▓▓▓██░░░░░░██▓▓▒▒     ",
            "            ████▒▒░░▒▒▒▒░░▓▓▓▓██░░░░░░░░▒▒██     ",
            "              ░░██░░████░░▒▒▒▒▒▒░░░░░░░░██       ",
            "              ░░░░░░░░░░░░██████░░░░░░░░         ",
            "              ▓▓▓▓▓▓▓▓▓▓      ▓▓▓▓▓▓▓▓           ",
            "            ██████████████    ████████████       ",
            "            ██████████████    ██████████▓▓       ",
            "            ██████████████    ████████████       ",
            "              ▓▓▓▓▓▓▓▓▓▓▓▓    ▓▓▓▓▓▓▓▓▓▓         ",
            "                ▓▓▓▓▓▓▓▓          ▓▓▓▓▓▓         ",
            "                ██████▓▓          ██▓▓██████     ",
            "              ██████████▓▓        ▓▓▓▓████████▓▓ ",
            "            ██████████▓▓          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ",
            "            ▓▓▓▓▓▓▓▓▓▓▓▓                         ", RESET
    };

    static String[] left = new String[] {
            "                  ██▓▓▓▓▓▓██                     ",
            "                ██████▓▓▓▓████████               ",
            "              ████▓▓▓▓▓▓███████▓▓███             ",
            "              ███████████░░░░░░███████           ",
            "              ▓▓█████████▓▓███▓▓██▓▓             ",
            "            ██████▓▓  ░░░░░░  ▓▓██▓▓   ██        ",
            "            ██  ██░░░░░░░░░░░░▓▓██▓▓ ███         ",
            "          ██      ░░░░▓▓██▓▓░░▓▓                 ",
            "                  ██▓▓██████▓▓▓▓▓▓               ",
            "                  ██▓▓░░░░░░████▓▓▓▓             ",
            "                ████░░▓▓▓▓▓▓░░██████             ",
            "          ▓▓▓▓▓▓████░░░░░░░░▓▓████▓▓▓▓▓▓▓▓       ",
            "        ▓▓▓▓▓▓▓▓████▓▓░░░░░░▓▓████▓▓▓▓▓▓▓▓▓▓▓▓   ",
            "      ▓▓▓▓▓▓▓▓▓▓████▓▓▓▓░░▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓   ",
            "    ▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓░░▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ",
            "    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ",
            "  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓██▓▓▓▓▓▓██▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓",
            "  ▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓▓▓██▓▓▓▓▓▓  ▓▓▓▓▓▓▓",
            "  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓██▓▓▓▓██▓▓▓▓▓▓  ▓▓▓▓▓▓▓",
            "  ▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
            "  ████▒▒▒▒▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓██████▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒",
            "    ██████▓▓▓▓▓▓▓▓██▓▓████████▓▓██▓▓▓▓▓▓▓▓▒▒▒▒███",
            "    ░░░░░░▓▓▓▓▓▓▓▓██  ██    ██  ██▓▓▓▓▓▓▓▓██████ ",
            "    ░░░░░░░░▓▓▓▓▓▓██  ████  ██  ██▓▓▓▓▓▓▓▓░░░░░░ ",
            "      ░░░░▓▓▓▓  ▓▓██  ██    ██  ██▓▓▓▓▓▓░░░░░░░░ ",
            "        ░░▓▓▓▓▓▓▓▓██░░████████░░██▓▓▓▓▓▓▓▓░░░░░░ ",
            "          ▓▓▓▓▓▓▓▓██░░░░░░░░░░░░██▓▓▓▓▓▓▓▓░░░░   ",
            "          ▓▓▓▓▓▓▓▓██░░░░░░░░░░░░████▓▓▓▓▓▓▓▓     ",
            "          ▓▓▓▓░░▓▓██░░░░░░░░░░░░██▓▓▓▓▓▓▓▓       ",
            "          ▓▓▓▓░░▓▓██░░░░░░░░░░░░██▓▓▓▓▓▓▓▓       ",
            "          ▓▓▓▓░░▓▓██░░░░░░░░░░░░██▓▓▓▓░░▓▓       ",
            "          ▓▓▓▓░░▓▓██░░░░░░  ░░░░░░██▓▓░░██       ",
            "          ████░░██░░░░░░░░  ░░░░░░░░██░░██       ",
            "          ████░░██░░░░░░░░  ░░░░░░░░░░░░░░       ",
            "              ░░░░░░░░░░░░    ░░░░░░░░░░░░       ",
            "              ▓▓▓▓▓▓▓▓▓▓        ▓▓▓▓▓▓▓▓▓▓▓▓     ",
            "              ▓▓▓▓▓▓▓▓▓▓▓▓      ▓▓▓▓▓▓▓▓▓▓▓▓     ",
            "            ██████████▓▓▓▓    ████████████████   ",
            "            ██████████▓▓▓▓    ████████████████   ",
            "            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓    ████████████████   ",
            "                ▓▓▓▓▓▓          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓   ",
            "                ▓▓████▓▓            ▓▓████▓▓     ",
            "            ▓▓▓▓████████            ██████████▓▓▓",
            "          ▓▓████████████            █████████████"
    };

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

    // ... (El resto de la clase UI se mantiene igual: imports, constantes,
    // escribirLento, etc.) ...

    public static void sprites(int vidaJugador, int maxVidaJugador, String nombrePirata,
            int vidaPirata, int maxVidaPirata, String nombreJugador, int numPiratas, boolean mostrarOriginal) {

        // 1. Definición de los Sprites

        System.out.println();

        // --- LÓGICA DE SELECCIÓN ---
        // Aquí decidimos qué array y qué color usar
        String[] spriteSeleccionado;
        String colorSprite;

        if (mostrarOriginal) {
            spriteSeleccionado = left;
            colorSprite = VERDE;
        } else {
            spriteSeleccionado = boceto;
            colorSprite = BLANCO; // Usamos blanco para el "fantasma" o boceto
        }

        // --- LÓGICA DE IMPRESIÓN MEJORADA ---
        String[] panel = generarPanelStringArray(vidaJugador, maxVidaJugador, nombrePirata, vidaPirata, maxVidaPirata,
                nombreJugador, numPiratas);

        // 1. Calculamos el ancho real del dibujo (basado en el sprite seleccionado)
        int anchoMaximoSprite = 0;
        for (String s : spriteSeleccionado) {
            String textoSinColor = s.replaceAll("\u001B\\[[;\\d]*m", "");
            if (textoSinColor.length() > anchoMaximoSprite) {
                anchoMaximoSprite = textoSinColor.length();
            }
        }

        int margenExtra = 4;

        // 2. Ajustamos la altura al elemento más grande
        int altoDibujo = spriteSeleccionado.length;
        int altoPanel = panel.length;
        int altoTotal = Math.max(altoDibujo, altoPanel);

        int paddingTop = (altoTotal - altoPanel) / 2;

        // 3. Bucle de impresión
        for (int i = 0; i < altoTotal; i++) {

            // -- PARTE IZQUIERDA (SPRITE) --
            String lineaSprite = "";
            int longitudVisible = 0;

            if (i < spriteSeleccionado.length) {
                lineaSprite = spriteSeleccionado[i];
                longitudVisible = lineaSprite.replaceAll("\u001B\\[[;\\d]*m", "").length();
            }

            // Imprimimos el sprite con el color dinámico elegido
            System.out.print(colorSprite);
            escribirLento(lineaSprite, 0);
            System.out.print(RESET);

            // Rellenamos espacios
            int espaciosFaltantes = anchoMaximoSprite - longitudVisible + margenExtra;
            if (espaciosFaltantes > 0) {
                System.out.print(" ".repeat(espaciosFaltantes));
            }

            // -- PARTE DERECHA (PANEL) --
            if (i >= paddingTop && i < paddingTop + altoPanel) {
                System.out.print(AMARILLO);
                escribirLento(panel[i - paddingTop], 0);
                System.out.print(RESET);
            }

            // Salto de línea final
            System.out.println();
        }
    }

    public static void pausa(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Realiza una secuencia de animación: Normal -> Boceto -> Normal
     * Simula un efecto de impacto o tensión.
     */
    public static void animarGolpe() {

        int delayAnimacion = 350; // Milisegundos entre cada cambio (ajusta a tu gusto)

        // 1. Estado NORMAL (Left)
        limpiarConsola();
        sprites(0, 0, " ", 0, 0, " ", 0, true);
        pausa(delayAnimacion);

        // 2. Estado BOCETO (Efecto Glitch/Impacto)
        limpiarConsola();
        sprites(0, 0, " ", 0, 0, " ", 0, false);
        pausa(delayAnimacion);

        // 3. Vuelta a NORMAL (Left)
        limpiarConsola();
        sprites(0, 0, " ", 0, 0, " ", 0, true);

    }
}
