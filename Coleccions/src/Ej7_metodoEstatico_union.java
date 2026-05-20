import java.util.HashSet;
import java.util.Set;

public class Ej7_metodoEstatico_union {
    public static <E> Set<E> union(Set<E> conxunto1, Set<E> conxunto2) {
        Set<E> conxuntoUnion = new HashSet<>();
        conxuntoUnion.addAll(conxunto1);
        conxuntoUnion.addAll(conxunto2);
        return conxuntoUnion;
    }

    public static void main(String[] args) {

        Set<String> conxuntoA = new HashSet<>();
        conxuntoA.add("Luns");
        conxuntoA.add("Martes");
        conxuntoA.add("Mércores");

        Set<String> conxuntoB = new HashSet<>();
        conxuntoB.add("Mércores");
        conxuntoB.add("Xoves");
        conxuntoB.add("Venres");


        Set<String> resultado = union(conxuntoA, conxuntoB);

        System.out.println("Conxunto A: " + conxuntoA);
        System.out.println("Conxunto B: " + conxuntoB);
        System.out.println("Unión:      " + resultado);
    }
}
