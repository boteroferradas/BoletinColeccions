import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ej4 {

    public static int sumarLista(List<Integer> lista){
        int suma = 0;
        for (int n : lista){
            suma = suma + n;
        }
        return suma;
    }

    public static void eliminarMaioresde10(List<Integer> lista) {
        lista.removeIf(n -> n > 10);
        System.out.println("Positivos sen maiores de 10:  " + lista);
    }

    public static void eliminarMenoresde10(List<Integer> lista) {
        lista.removeIf(n -> n < -10);
        System.out.println("Negativos sen menores de -10: " + lista);
    }

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        List<Integer> nPositivos = new ArrayList<Integer>();
        List<Integer> nNegativos = new ArrayList<Integer>();

        System.out.println("Introduce un numero: ");
        int n = teclado.nextInt();

        while (n != 0) {
            if (n > 0) {
                nPositivos.add(n);
            } else {
                nNegativos.add(n);
            }
            System.out.println("Introduce outro número: ");
            n = teclado.nextInt();
        }

        System.out.println("\n--- ESTADÍSTICAS INICIALES ---");
        System.out.println("Numeros positivos: " + nPositivos);
        System.out.println("Suma de numeros positivos " + sumarLista(nPositivos));
        System.out.println("Numeros negativos: " + nNegativos);
        System.out.println("Suma de numeros positivos " + sumarLista(nNegativos));

        System.out.println("\n--- FILTRADO ---");
        eliminarMaioresde10(nPositivos);
        eliminarMenoresde10(nNegativos);

        teclado.close();
    }
}
