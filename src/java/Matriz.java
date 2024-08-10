package src.java;
import java.util.Random;

public class Matriz {
	int size;
    int determinante;
    int[][] matriz;

    public Matriz(int size){
        this.size = size;
        this.matriz = new int[size][size];
    }

    public int getDeterminante() {
        return determinante;
    }

    public void setDeterminante(int determinante) {
        this.determinante = determinante;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void MatrizRandom(Random rc){
        for(int i=0; i<matriz.length;i++){
            for (int j=0; j<matriz[0].length; j++){
                matriz[i][j] = rc.nextInt(6)+1;
            }
        }
    }


    public int isMatrizInversa(){
        if(this.size == 3) {
            this.determinante = ((matriz[0][0]) * (matriz[1][1]) * (matriz[2][2])
                    + (matriz[1][0]) * (matriz[2][1]) * (matriz[0][2])
                    + (matriz[2][0]) * (matriz[0][1]) * (matriz[1][2]))
                    - ((matriz[2][0]) * (matriz[1][1]) * (matriz[0][2])
                    + (matriz[1][0]) * (matriz[0][1]) * (matriz[2][2])
                    + (matriz[0][0]) * (matriz[2][1]) * (matriz[1][2]));
        }
        return this.determinante;
    }

    public void showMatriz(){
        for(int i=0; i<matriz.length; i++){
            System.out.print("[ ");
            for (int j = 0; j<matriz[0].length; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.print("]\n");
        }

    }
}
