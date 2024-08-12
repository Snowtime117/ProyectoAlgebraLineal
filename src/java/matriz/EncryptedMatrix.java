package src.java.matriz;

public class EncryptedMatrix extends Matriz{
    public EncryptedMatrix(int rows, int columns) {
        super(rows, columns);
    }
    public void setMatrizResult(int [] values){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int index = i * columns + j;
                matriz[i][j] = (index < values.length)? values[index]:28; // Padding si el último bloque es incompleto
            }
        }
    }
}
