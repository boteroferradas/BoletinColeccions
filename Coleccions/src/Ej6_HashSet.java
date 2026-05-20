import java.util.*;

public class Ej6_HashSet {

//    public static void senRepetir(List<Integer> lista) {
//        Set<Integer> conxuntoSenRepetidos = new HashSet<>(lista);
//        lista.clear();
//        lista.addAll(conxuntoSenRepetidos);
//        System.out.println("Lista sen repetidos: " + lista);
//    }

    public static void repetidos(List<Integer> lista) {
        Set<Integer> conxuntoAuxiliar = new HashSet<>();
        List<Integer> nRepetidos = new ArrayList<>();

        for (int n : lista) {
            if (!conxuntoAuxiliar.add(n)) {
                if (!nRepetidos.contains(n)) {
                    nRepetidos.add(n);
                }
            }
        }
        lista.clear();
        lista.addAll(conxuntoAuxiliar);

        System.out.println("Lista sen repetidos " + lista);
        System.out.println("Elementos repetidos: " + nRepetidos);
    }


    public static void main(String[] args){
        List<Integer> listaNumeros = new ArrayList<>();

        Random r = new Random();

        for (int i = 1; i<= 10; i++) {
            int numeroAleatorio = r.nextInt(10) + 1;
            listaNumeros.add(numeroAleatorio);
        }
        System.out.println(listaNumeros);
//        senRepetir(listaNumeros);
        repetidos(listaNumeros);
    }
}
