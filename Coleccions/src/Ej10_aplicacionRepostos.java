import java.util.*;

public class Ej10_aplicacionRepostos {

    public static boolean validarFormato(String codigo) {
        String patron = "^[A-Z]{3}-[0-9]{4}$";
        return codigo.matches(patron);
    }

    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Map<String, Integer> almacen = new HashMap<>();

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("---APLICACION TENDA DE REPOSTOS---");
            System.out.println("1. Dar de alta produto");
            System.out.println("2. Dar de baixa producto");
            System.out.println("3. Actualizar a cantidade de produtos");
            System.out.println("4. Visualizar produtos e cantidades");
            System.out.println("5. Sair");
            System.out.println("Elixe unha opcion (1-5): ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- ALTA DE PRODUTO ---");
                    System.out.print("Introduce o código alfanumérico do produto: ");
                    String novoCodigo = teclado.nextLine().toUpperCase().trim();

                    if (!validarFormato(novoCodigo)) {
                        System.out.println("Erro de formato: O codigo debe ter 3 letras, un guion e 3 números (ex: REP-4022).");
                    } else if (almacen.containsKey(novoCodigo)) {
                        System.out.println("O produto xa existe. Se queres cambiar o stock, usa a opcion 3.");
                    } else {
                        System.out.println("Introduce a cantidade inicial en stock: ");
                        try {
                            int cantidade = Integer.parseInt(teclado.nextLine());
                            if (cantidade >= 0) {
                                almacen.put(novoCodigo, cantidade); //.put() engade ao Map "almacen"
                                System.out.println("Produto '" + novoCodigo + "' dado de alta con exito.");
                            } else {
                                System.out.println("Erro: A cantidade non pode ser negativa.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: A cantidade debe ser un numero enteiro");
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n--- BAIXA DE PRODUTO ---");
                    System.out.print("Introduce o código do produto que queres eliminar: ");
                    String codigoBaixa = teclado.nextLine().toUpperCase().trim();

                    if (!validarFormato(codigoBaixa)) {
                        System.out.println("Erro de formato: Ese codigo non pode ser valido");
                    } else if (almacen.remove(codigoBaixa) != null) { //.remove() devolve o valor eliminado, ou null se a clave non existia
                        System.out.println("O produto '" + codigoBaixa + "' foi eliminado do sistema.");
                    } else {
                        System.out.println("O código introducido non corresponde a ningún produto.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- ACTUALIZAR CANTIDADE ---");
                    System.out.print("Introduce o código do produto: ");
                    String codigoActualizar = teclado.nextLine().toUpperCase().trim();

                    if (!validarFormato(codigoActualizar)) {
                        System.out.println("Erro de formato: O codigo debe ter 3 letras, un guion e 3 números (ex: REP-4022).");
                    } else if (almacen.containsKey(codigoActualizar)) {
                        System.out.println("Stock actual de " + codigoActualizar + ": " + almacen.get(codigoActualizar));
                        System.out.print("Introduce a NOVA cantidade total de stock: ");
                        try {
                            int novoStock = Integer.parseInt(teclado.nextLine());
                            if (novoStock >= 0) {
                                almacen.put(codigoActualizar, novoStock);
                                System.out.println("Stock actualizado correctamente.");
                            } else {
                                System.out.println("Erro: O stock non pode ser negativo.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Produto non atopado. Debes dalo de alta primeiro");
                        }
                    } else {
                        System.out.println("Produto non atopado. Debes dalo de alta primeiro.");
                    }
                    break;
                case 4:
                    System.out.println("\n--- INVENTARIO DO ALMACEN ---");
                    if (almacen.isEmpty()) {
                        System.out.println("O almacen esta completamente baleiro.");
                    } else {
                        // Percorremos o Map usando un bucle especial for-each sobre entrySet()
                        // que nos dá acceso á clave e ao valor ao mesmo tempo.
                        for (Map.Entry<String, Integer> rexistro : almacen.entrySet()) {
                            System.out.println("Codigo: " + rexistro.getKey() + " | Stock: " + rexistro.getValue() + " uds.");
                        }
                        System.out.println("Total de referencias distintas: " + almacen.size());
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                default:
                    System.out.println("Opcion incorrecta. Introduce un numero do 1 ao 5.");
                    break;
            }
        }
        teclado.close();
    }
}
