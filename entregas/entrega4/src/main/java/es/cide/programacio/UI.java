package es.cide.programacio;

//clase totalmente opcional. Solo para hacer el output bonito
public class UI {

    // Colores para el output por consola
    private static final String RESET = "\u001B[0m";
    // private static final String ROJO = "\u001B[31m";
    // private static final String VERDE = "\u001B[32m";
    // private static final String AMARILLO = "\u001B[33m";
    // private static final String AZUL = "\u001B[34m";
    // private static final String MORADO = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String BLANCO = "\u001B[37m";

    // Estilos extra
    public static final String NEGRITA = "\u001B[1m";
    public static final String FONDO_ROJO = "\u001B[41m";
    public static final String FONDO_VERDE = "\u001B[42m";
    private static final String[] SPRITE_BOCETO = new String[] {

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

    private static final String[] SPRITE_NORMAL = new String[] {
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

    public static void mostrarUI(int vidaJugador, int maxVidaJugador, String nombrePirata,
            int vidaPirata, int maxVidaPirata, String nombreJugador, int numPiratas) {

        // Definimos colores locales para no depender de constantes externas si no
        // quieres
        String RESET = "\u001B[0m";
        String AMARILLO = "\u001B[33m";

        // --- 1. CÁLCULO BARRA JUGADOR (Lógica integrada) ---
        int vidaJ = Math.max(0, vidaJugador); // Evitar negativos
        int ancho = 20; // Longitud de la barra
        int rellenosJ = (int) (((double) vidaJ / maxVidaJugador) * ancho);
        rellenosJ = Math.min(rellenosJ, ancho); // Evitar que se salga
        String barraJ = "[" + "█".repeat(rellenosJ) + "░".repeat(ancho - rellenosJ) + "]";

        // --- 2. CÁLCULO BARRA PIRATA (Lógica integrada) ---
        int vidaP = Math.max(0, vidaPirata);
        int rellenosP = (int) (((double) vidaP / maxVidaPirata) * ancho);
        rellenosP = Math.min(rellenosP, ancho);
        String barraP = "[" + "█".repeat(rellenosP) + "░".repeat(ancho - rellenosP) + "]";

        // --- 3. IMPRESIÓN DIRECTA ---
        System.out.println(AMARILLO);
        System.out.println("╔══════════════════════════════════════════════╗");
        // Usamos String.format para rellenar con espacios hasta llegar a 44 caracteres
        System.out.println(String.format("║ %-44s ║", "        BATALLA DE INSULTOS"));
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println(String.format("║ %-44s ║", " JUGADOR: " + nombreJugador));
        System.out.println(String.format("║ %-44s ║", "   Vida: " + barraJ + " " + vidaJ + "/" + maxVidaJugador));
        System.out.println(String.format("║ %-44s ║", "                                            "));
        System.out.println(String.format("║ %-44s ║", " PIRATA: " + nombrePirata + "/" + numPiratas));
        System.out.println(String.format("║ %-44s ║", "   Vida: " + barraP + " " + vidaP + "/" + maxVidaPirata));
        System.out.println(String.format("║ %-44s ║", "                                            "));
        System.out.println(String.format("║ %-44s ║", "                                            "));
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println(RESET);
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
            escribirLento("                 DERROTA                ", 10);

        System.out.println("                                        ");
        System.out.println(RESET);
    }

    public static void limpiarConsola() {
        for (int k = 0; k < 60; k++)
            System.out.println();
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
        imprimirSprite(1);
        pausa(delayAnimacion);

        // 2. Estado BOCETO (Efecto Glitch/Impacto)
        limpiarConsola();
        imprimirSprite(2);
        pausa(delayAnimacion);

        // 3. Vuelta a NORMAL (Left)
        limpiarConsola();
        imprimirSprite(1);
        pausa(delayAnimacion);

    }

    private static void imprimirSprite(int x) {
        // 1. Seleccionamos qué configuración usar ANTES del bucle
        String[] spriteSeleccionado;

        if (x == 1) {
            spriteSeleccionado = SPRITE_BOCETO;

        } else {
            spriteSeleccionado = SPRITE_NORMAL; // O la variable 'left' si la tienes definida fuera

        }

        for (String trozo : spriteSeleccionado) {
            System.out.println(trozo);
        }
    }
}
