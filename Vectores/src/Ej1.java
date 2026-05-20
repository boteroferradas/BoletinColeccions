import java.util.Scanner;

public class Ej1 {

    // DEFINICIÓN DE CONSTANTES (Para que o código sexa máis limpo e lexíbel)
    private static final String[] DIAS = {"Luns", "Martes", "Mércores", "Xoves", "Venres"};
    private static final String[] HORAS = {"09:00", "10:00", "11:00", "12:00"};
    private static final String VALEIRA = "[Valeira]";

    public static void mostrarHorario(String[][] táboa) {
        System.out.println("\n====================== O TEU HORARIO ACTUAL ======================");

        // Imprimir a cabeceira das horas
        System.out.printf("%-10s", ""); // Espazo en branco na esquina superior esquerda
        for (String hora : HORAS) {
            System.out.printf("%-15s", hora);
        }
        System.out.println("\n------------------------------------------------------------------");

        // Imprimir cada día coas súas respectivas actividades
        for (int i = 0; i < táboa.length; i++) {
            System.out.printf("%-10s", DIAS[i]); // Nome do día
            for (int j = 0; j < táboa[i].length; j++) {
                System.out.printf("%-15s", táboa[i][j]); // Actividade nese día e hora
            }
            System.out.println();
        }
        System.out.println("==================================================================");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // a) Crear a táboa bidimensional (Filas = Días, Columnas = Horas)
        String[][] axenda = new String[DIAS.length][HORAS.length];

        // Inicializamos toda a táboa co texto "[Valeira]"
        for (int i = 0; i < axenda.length; i++) {
            for (int j = 0; j < axenda[i].length; j++) {
                axenda[i][j] = VALEIRA;
            }
        }

        // b) Encher a táboa con algunhas actividades iniciais de exemplo
        axenda[0][0] = "Matemáticas"; // Luns ás 09:00
        axenda[0][2] = "Historia";    // Luns ás 11:00
        axenda[1][1] = "Deporte";     // Martes ás 10:00
        axenda[3][3] = "Compra";      // Xoves ás 12:00
        axenda[4][2] = "Piscina";     // Venres ás 11:00

        int opcion = 0;

        while (opcion != 3) {
            // c) Mostra o horario actual ao usuario ao comezo de cada volta
            mostrarHorario(axenda);

            System.out.println("\n--- MENÚ DA AXENDA ---");
            System.out.println("1. Cambiar unha actividade por outra");
            System.out.println("2. Engadir unha actividade nunha posición valeira");
            System.out.println("3. Sair");
            System.out.print("Elixe unha opción (1-3): ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            // Se o usuario decide saír, saltamos o resto do bucle directamente
            if (opcion == 3) {
                System.out.println("\nTancando a túa axenda. ¡Organización completada!");
                break;
            }

            if (opcion == 1 || opcion == 2) {
                // Pedir o Día (Fila)
                System.out.println("\nSelecciona o Día:");
                for (int i = 0; i < DIAS.length; i++) {
                    System.out.println(i + ". " + DIAS[i]);
                }
                System.out.print("Introduce o número do día: ");
                int diaSeleccionado;
                try {
                    diaSeleccionado = Integer.parseInt(teclado.nextLine());
                } catch (NumberFormatException e) { diaSeleccionado = -1; }

                // Pedir a Hora (Columna)
                System.out.println("\nSelecciona a Hora:");
                for (int j = 0; j < HORAS.length; j++) {
                    System.out.println(j + ". " + HORAS[j]);
                }
                System.out.print("Introduce o número da hora: ");
                int horaSeleccionada;
                try {
                    horaSeleccionada = Integer.parseInt(teclado.nextLine());
                } catch (NumberFormatException e) { horaSeleccionada = -1; }

                // CONTROL DE ERROS: Validar que os índices introducidos estean dentro da táboa
                if (diaSeleccionado < 0 || diaSeleccionado >= DIAS.length || horaSeleccionada < 0 || horaSeleccionada >= HORAS.length) {
                    System.out.println("❌ Erro: Selección de día ou hora non válida.");
                    continue; // Volve ao principio do menú
                }

                // Xestión segundo a opción escollida
                if (opcion == 1) {
                    // d.1) Cambiar unha actividade por outra (non importa se tiña algo ou estaba valeira)
                    System.out.print("Introduce a NOVA actividade para esa posición: ");
                    String novaActividade = teclado.nextLine().trim();
                    if (novaActividade.isEmpty()) novaActividade = VALEIRA;

                    axenda[diaSeleccionado][horaSeleccionada] = novaActividade;
                    System.out.println("✓ Actividade modificada con éxito.");

                } else {
                    // d.2) Engadir unha actividade extra nunha posición valeira
                    if (!axenda[diaSeleccionado][horaSeleccionada].equals(VALEIRA)) {
                        System.out.println("⚠️ Erro: Esa posición xa ten unha actividade ('" + axenda[diaSeleccionado][horaSeleccionada] + "'). Se queres cambiala, usa a opción 1.");
                    } else {
                        System.out.print("Introduce a actividade extra: ");
                        String actividadeExtra = teclado.nextLine().trim();
                        if (!actividadeExtra.isEmpty()) {
                            axenda[diaSeleccionado][horaSeleccionada] = actividadeExtra;
                            System.out.println("✓ Actividade extra engadida.");
                        } else {
                            System.out.println("❌ Non se introduciu ningunha actividade.");
                        }
                    }
                }
            } else {
                System.out.println("❌ Opción incorrecta.");
            }
        }
        teclado.close();
    }
}