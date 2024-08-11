package src.java.matriz;

import java.util.Random;

public class Key extends Matriz{
    protected int determinante;
    public Key(int size) {
        super(size, size);
    }

    public void getRandomKey(){
        Random rc =  new Random();
        for(int i=0; i<matriz.length;i++){
            for (int j=0; j<matriz[0].length; j++){
                matriz[i][j] = rc.nextInt(6)+1;
            }
        }
    }
    public int determinanKey(){
        if(this.columns == 3) {
            this.determinante = ((matriz[0][0]) * (matriz[1][1]) * (matriz[2][2])
                    + (matriz[1][0]) * (matriz[2][1]) * (matriz[0][2])
                    + (matriz[2][0]) * (matriz[0][1]) * (matriz[1][2]))
                    - ((matriz[2][0]) * (matriz[1][1]) * (matriz[0][2])
                    + (matriz[1][0]) * (matriz[0][1]) * (matriz[2][2])
                    + (matriz[0][0]) * (matriz[2][1]) * (matriz[1][2]));
        }
        return this.determinante;
    }
    public int size(){
        return this.rows;
    }
}
