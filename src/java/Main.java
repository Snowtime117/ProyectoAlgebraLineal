import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random ramdom = new Random();
        Matriz llave = new Matriz(3);

        //Generar LLave
        llave.MatrizRandom(new Random());
        System.out.println("Llave");
        llave.showMatriz();

        //determinante de la llave
        System.out.println(llave.isMatrizInversa());


        //paso 1 se crea un mensaje
        Mensaje mensajeHandler = new Mensaje();
        String mensaje = "HOLA MUNDO";
        System.out.printf("Mensaje: %s\n",mensaje);

        StringBuilder textoCifrado = new StringBuilder();

        int[] valoresNumericos = mensajeHandler.convertirMensaje(mensaje);
        System.out.println("Valores numéricos del mensaje: ");
        int[][] bloques = mensajeHandler.dividirEnBloques(valoresNumericos, 3);
        for (int[] bloque : bloques) {
            System.out.print("[ ");
            for (int valor : bloque) {
                System.out.print(valor+" ");
            }
            System.out.print("]\n");
        }

        // Definir la matriz resultado con dimensiones apropiadas
        int[][] resultado = new int[llave.size][bloques[0].length];

        // Multiplicar las matrices
        for (int i = 0; i < llave.size; i++) {
            for (int j = 0; j < bloques[0].length; j++) {
                for (int k = 0; k < llave.size; k++) {
                    resultado[i][j] += llave.matriz[i][k] * bloques[k][j];
                }
            }
        }

        // Mostrar Matriz
        System.out.println("Matriz Encriptada: ");
        for (int[] bloque : resultado) {
            System.out.print("[ ");
            for (int valor : bloque) {
                System.out.print(valor+" ");
            }
            System.out.print("]\n");
        }
        // Convertir los valores numéricos cifrados de vuelta a caracteres
        for (int[] bloque : resultado) {
            for (int valor : bloque) {
                textoCifrado.append((char) (valor%26 + 'A'));
            }
        }
        System.out.println(textoCifrado);

    }
}
