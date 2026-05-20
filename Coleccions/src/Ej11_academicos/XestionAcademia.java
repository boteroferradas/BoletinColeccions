package Ej11_academicos;

import java.util.*;

public class XestionAcademia {
    /**
     * Método estático que insire un académico no mapa se a letra é válida.
     *
     * @param academia O mapa da academia (Letra -> Académico)
     * @param novo     O obxecto Académico que quere entrar
     * @param letra    A letra do sillón que quere ocupar
     * @return true se se puido inserir, false en caso contrario
     */
    public static boolean nuevoAcademico(Map<Character, Academico> academia, Academico novo, Character letra) {
        if (!Character.isLetter(letra)) {
            System.out.println("Erro: O carácter '" + letra + "' no e unha letra valida do abecedario.");
            return false;
        }
        if (academia.containsKey(letra)) {
            System.out.println("O sillón '" + letra + "' xa esta ocupa por: " + academia.get(letra).getNome());
            return false;
        }

        academia.put(letra,novo);
        return true;
    }

    public static void listarSenLetraPorNome(Map<Character,Academico> academia){
        System.out.println("\n---LISTADO: SEN LETRA (POR ORDE ALFABETICA)---");

        List<Academico> lista = new ArrayList<>(academia.values());
        Collections.sort(lista);

        for (Academico a : lista) {
            System.out.println(a);
        }
    }

    public static void listarSenLetraPorAno(Map<Character, Academico> academia) {
        System.out.println("\n---LISTADO: SEN LETRA (POR ANO DE INGRESO CRONOLOXICO)---");

        List<Academico> lista = new ArrayList<>(academia.values());

//        Collections.sort(lista, new Comparator<Academico>() {
//            @Override
//            public int compare(Academico a1, Academico a2) {
//                return Integer.compare(a1.getAnoIngreso(), a2.getAnoIngreso());
//            }
//        });
        lista.sort(Comparator.comparingInt(Academico::getAnoIngreso));


        for (Academico a : lista) {
            System.out.println(a.getAnoIngreso() + " -> " + a.getNome());
        }
    }

    public static void main(String[] args) {
        Map<Character, Academico> academia = new TreeMap<>();

        Academico a1 = new Academico("Manuel Rivas", 2009);
        Academico a2 = new Academico("Chus Pato", 2017);
        Academico a3 = new Academico("Fina Casalderrei", 2013);
        Academico a4 = new Academico("Arturo Casas", 2024);
        Academico a5 = new Academico("Ana Montero", 2021);

        System.out.println("Intentando inserir os academicos...");

        nuevoAcademico(academia, a1, 'A');
        nuevoAcademico(academia, a2, 'b');
        nuevoAcademico(academia, a3, 'F');
        nuevoAcademico(academia, a4, 'm');
        nuevoAcademico(academia, a5, 'X');

        System.out.println("---PROBAS DE VALIDACION---");

        Academico intruso1 = new Academico("Intruso 1", 2026);
        nuevoAcademico(academia, intruso1, '8');

        Academico intruso2 = new Academico("Intruso 2", 2025);
        nuevoAcademico(academia, intruso2, 'A');

        System.out.println("\n---ESTADO FINAL DA ACADEMIA---");
        for (Map.Entry<Character, Academico> sillon : academia.entrySet()) {
            System.out.println("Sillon [" + sillon.getKey() + "] ocupado por: " + sillon.getValue());
        }

        listarSenLetraPorAno(academia);
        listarSenLetraPorNome(academia);

    }
}

