import java.util.Random;

public class Main {
    public static void main(String[] args) {
	Random rc = new Random();
        Matriz matriz1 = new Matriz(3);

        //matriz aleatoria
        matriz1.MatrizRandom(rc);

        //matriz seleccionada
        matriz1.showMatriz();

        //determinante de la matriz
        System.out.println(matriz1.isMatrizInversa());



    }
}
