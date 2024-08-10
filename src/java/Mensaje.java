public class Mensaje {

    //esto es para convertir el mensaje en el módulo 27
    public int[] convertirMensaje(String mensaje) {
        mensaje = mensaje.toUpperCase().replaceAll(" ", "");
        int[] valores = new int[mensaje.length()];
        for (int i = 0; i < mensaje.length(); i++) {
            valores[i] = (mensaje.charAt(i) - 'A') % 27;
        }
        return valores;
    }

    // con esto podemos dividir los valores numéricos en los bloques
    public int[][] dividirEnBloques(int[] valores, int tamañoBloque) {
        int numBloques = (int) Math.ceil((double) valores.length / tamañoBloque);
        int[][] bloques = new int[numBloques][tamañoBloque];

        for (int i = 0; i < numBloques; i++) {
            for (int j = 0; j < tamañoBloque; j++) {
                int index = i * tamañoBloque + j;
                if (index < valores.length) {
                    bloques[i][j] = valores[index];
                } else {
                    bloques[i][j] = 28; // Padding si el último bloque es incompleto
                }
            }
        }
        return bloques;
    }
}
