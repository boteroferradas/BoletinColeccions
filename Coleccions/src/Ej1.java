import java.util.ArrayList;
import java.util.List;

public class Ej1 {
    public static <T> List<String> combinarTaboas(T[] taboa1, T[] taboa2) {
        List<String> listaResultado = new ArrayList<>();

        for (T elemento1 : taboa1) {
            for (T elemento2 : taboa2) {
                String combinacion = elemento1.toString() + elemento2.toString();
                listaResultado.add(combinacion);
            }
        }

        return listaResultado;
    }

    public static void main (String[] args) {
        String[] colores = {"verde", "azul", "naranja", "amarillo", "marron"};
        String[] frutas = {"platano", "manzana", "pera", "mango", "kiwi"};

        List<String> frutasycolores = combinarTaboas(frutas, colores);
        System.out.println(frutasycolores);


    }

}
