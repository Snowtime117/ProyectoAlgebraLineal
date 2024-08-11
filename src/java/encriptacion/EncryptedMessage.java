package src.java.encriptacion;

import src.java.matriz.EncryptedMatrix;
import src.java.matriz.Key;

public class EncryptedMessage {

    private String message;
    int[] values;
    EncryptedMatrix matrixoriginal;
    EncryptedMatrix matrizresultante;
    Key key;
    StringBuilder textoCifrado = new StringBuilder();

    public EncryptedMessage(String message, Key key) {
        this.message = message;
        values = setValues();
        this.key = key;
    }

    //esto es para convertir el mensaje en el módulo 27
    private int[] setValues() {
        message = message.toUpperCase().replaceAll(" ", "");
        int[] valores = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            valores[i] = (message.charAt(i) - 'A') % 27;
        }
        return valores;
    }

    public void setMatrizOrinal(int size) {
        int numBloques = (int) Math.ceil((double) values.length / size);
        matrixoriginal= new EncryptedMatrix(numBloques,size);
        matrixoriginal.setMatrizResult(values);
    }

    public EncryptedMatrix getMatrixoriginal() {
        return matrixoriginal;
    }

    public void setMatrizresultante(int column) {
        matrizresultante = new EncryptedMatrix(key.size(),column);
        matrizMultiplication();
    }

    public StringBuilder getResultMessaje(){
        for (int[] bloque : matrizresultante.getMatriz()) {
            for (int valor : bloque) {
                textoCifrado.append((char) (valor%26 + 'A'));
            }
        }
        return textoCifrado;
    }
    public void matrizMultiplication(){
        // Multiplicar las matrices
        for (int i = 0; i < matrizresultante.getRows(); i++) {
            for (int j = 0; j < matrixoriginal.getColumns(); j++) {
                for (int k = 0; k < matrizresultante.getRows(); k++)
                    matrizresultante.getMatriz()[i][j] += key.getMatriz()[i][k] * matrixoriginal.getMatriz()[k][j];
            }
        }
    }

    public EncryptedMatrix getMatrizResultante() {
        return matrizresultante;
    }
}
