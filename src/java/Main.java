package src.java;

import src.java.encriptacion.EncryptedMessage;
import src.java.matriz.*;

public class Main {
    public static void main(String[] args) {

        Key key = new Key(3);
        //Generar LLave
        key.getRandomKey();
        System.out.println("Llave");
        key.showMatriz();

        //determinante de la llave
        System.out.println("Determinante: "+key.determinanKey());

        //paso 1 se crea un mensaje
        String mensaje = "HOLA MUNDO";
        System.out.println("Mensaje: "+mensaje);

        //Encriptar el mensaje
        EncryptedMessage mensajeresultante = new EncryptedMessage(mensaje,key);

        //Guardar la matriz encriptada
        mensajeresultante.setMatrizOrinal(3);
        System.out.println("Valores numéricos del mensaje: ");
        mensajeresultante.getMatrixoriginal().showMatriz();

        // Definir la matriz resultado con dimensiones apropiadas
        mensajeresultante.setMatrizresultante(mensajeresultante.getMatrixoriginal().getColumns());
        System.out.println("Matriz Resultante:");
        mensajeresultante.getMatrizResultante().showMatriz();


        // Convertir los valores numéricos cifrados de vuelta a caracteres
        System.out.println(mensajeresultante.getResultMessaje());

    }
}
