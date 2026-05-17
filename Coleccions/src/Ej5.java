import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        List<Integer> nPositivos = new ArrayList<Integer>();

        System.out.println("Introduce un numero: ");
        int n = teclado.nextInt();

        while (n != -1) {
            if (n > 0) {
                nPositivos.add(n);
            }
            System.out.println("Introduce outro número: ");
            n = teclado.nextInt();
        }

        System.out.println("\nLista de positivos gardados: " + nPositivos);
        System.out.println("--- Elementos en índices pares multiplicados por 100 ---");

        for (int i = 0; i< nPositivos.size(); i+= 2) {
            int valor = nPositivos.get(i);
            int resultado = valor * 100;

            System.out.println("Indice " + i + " (Valor: " + valor + ") -> Resultado: " + resultado);
        }

    }
}
