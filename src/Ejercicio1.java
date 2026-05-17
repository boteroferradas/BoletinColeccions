import java.util.Arrays;
import java.util.Random;

public class Ejercicio1 {
    public static void main (String [] args){
        int [] numeros = new int[6];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(50) + 1;
        }

        System.out.println("Orden normal: " + Arrays.toString(numeros));

        System.out.print("[");
        for (int i = numeros.length -1; i >= 0; i--) {
            System.out.print(numeros[i]);

            if (i > 0){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
