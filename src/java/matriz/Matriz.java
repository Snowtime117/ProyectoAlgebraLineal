package src.java.matriz;

public abstract class Matriz {
    protected int rows;
    protected int columns;
    protected int[][] matriz;

    public Matriz(int rows,int columns){
        this.rows = rows;
        this.columns = columns;
        this.matriz = new int[rows][columns];
    }

    public void showMatriz(){
        for (int[] rows : matriz) {
            System.out.print("[ ");
            for (int value : rows) {
                System.out.print(value+" ");
            }
            System.out.print("]\n");
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setValue(int row, int column, int result){
        matriz[row][column] = result;
    }
    public int getValue(int row, int column){
        return matriz[row][column];
    }
}
