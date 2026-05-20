import java.util.HashSet;
import java.util.Set;

public class Ej8_metodoEstatico_interseccion {
    public static <E> Set <E> interseccion(Set<E> conxunto1, Set<E> conxunto2) {
        Set<E> conxuntoInterseccion = new HashSet<>(conxunto1);
        conxuntoInterseccion.retainAll(conxunto2);
        return conxuntoInterseccion;
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


        Set<String> resultado = interseccion(conxuntoA, conxuntoB);

        System.out.println("Conxunto A: " + conxuntoA);
        System.out.println("Conxunto B: " + conxuntoB);
        System.out.println("Intersección:      " + resultado);
    }
}
