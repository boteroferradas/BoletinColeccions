import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ej9_aplicacionMeteorloxica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Double> rexistros = new ArrayList<>();
        List<LocalTime> horas = new ArrayList<>();

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        String opcion = "";
        while(!opcion.equalsIgnoreCase("d")){
            System.out.println("---APLICACION METEOROLOXICA---");
            System.out.println("a.Novo rexixtro");
            System.out.println("b.Listar rexistros");
            System.out.println("c.Mostrar a estatistica");
            System.out.println("d.Sair");
            System.out.println("Elixe unha opcion: ");

            opcion = teclado.nextLine();

            switch (opcion.toLowerCase()) {
                case "a":
                    System.out.println("\nIntroduce a temperatura registrada (ºC)");
                    try{
                        double temp = Double.parseDouble(teclado.nextLine());//Double.parseDouble() transforma o texto que entre por teclado nun numero real para que se poida operar sobre el
                        rexistros.add(temp);

                        LocalTime horaActual = LocalTime.now();
                        horas.add(horaActual);

                        System.out.println("Temperatura gardada correctamente");
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Introduce un numero valido (usa o punto para os decimais)");
                    }
                    break;

                case "b":
                    System.out.println("\n--- LISTAXE DE REXISTROS ---");
                    if (rexistros.isEmpty()) {
                        System.out.println("Non hai temperaturas rexistradas ata o momento");
                    } else {
                        for (int i = 0; i < rexistros.size(); i++) {
                            String horaBonita = horas.get(i).format(formatoHora);
                            System.out.println("Lectura " + (i + 1) + " ["+ horaBonita + "]: " + rexistros.get(i) + " ºC");
                        }
                    }
                    break;
                case "c":
                    System.out.println("\n--- ESTATISTICAS DO DIA ---");
                    if (rexistros.isEmpty()) {
                        System.out.println(" Non se poden calculas estatisticas sen datos. Introduce primeiro un rexistro");
                    } else {
                        double max = rexistros.get(0);//Duas variables: Max colle o primeiro numero da coleccion "rexistros" e fixao como maximo inical para as comparacion
                        double min = rexistros.get(0);//                Min colle o primero numero da mesma coleccion e fixamo como minimo inical para as comparacions
                        double suma = 0;              //Esta variable suma servira para logo facer a media das temperaturas

                        for (double t : rexistros) {
                            if (t>max) {
                                max = t;
                            }
                            if (t<min) {
                                min = t;
                            }
                            suma += t;
                        }

                        double media = suma / rexistros.size();

                        System.out.printf("Temperatura Maxima: %.2f ºC\n", max);
                        System.out.printf("Temperatura Minima: %.2f ºC\n", min);
                        System.out.printf("Temperatura Media: %.2f ºC\n", media);
                        System.out.printf("Total de lecturas: " + rexistros.size());
                    }
                    break;
                case "d":
                    System.out.println("\nSaindo do programa...");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Introduce a, b, c ou d.");
                    break;
            }
        }
        teclado.close();
    }
}
