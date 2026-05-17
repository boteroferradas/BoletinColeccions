import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Ej3 {
    public static void eliminar5e7(List<Integer> lista){
        Iterator<Integer> iterador = lista.iterator();
        while (iterador.hasNext()) {
            Integer n = iterador.next();
            if (n == 5 || n == 7) {
                iterador.remove();
            }
        }
        System.out.println(lista);
    }

    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<>();

        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            int numeroAleatorio = r.nextInt(10) + 1;

            listaNumeros.add(numeroAleatorio);
        }

        System.out.println(listaNumeros);
        eliminar5e7(listaNumeros);
    }
}