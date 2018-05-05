package sample.Classes;

import java.util.ArrayList;

/**
 * Esta clase representa la abstracción de un AFN.
 */
public class AFN {
    /**
     * Atributos de la clase, correspondientes a los atributos de un AFN; se omiten los elementos del alfabeto y
     * el conjunto de estados que lo componen puesto que están implicitos en la función de trancisión.
     */
    private FuncionTransicion funcionTransicion;
    private String estadoInicial;

    //Constructor para determinar el valor de los atributos de la instancia.
    public AFN(FuncionTransicion funcionTransicion, String estadoInicial){
        this.funcionTransicion = funcionTransicion;
        this.estadoInicial = estadoInicial;
    }

    //Método para evaluar una cadena dada con el AFN.
    public boolean valida(String cadena){
        String estadoActual = estadoInicial;    //Iniciamos el proceso a partir del estado incial del AFN.

        for(int x = 0; x < cadena.length(); x++){ //Vamos a recorrer los caracteres de la cadena dada.
            String c = "" + cadena.charAt(x);       //Obtemenos el caracter a evaluar.

            /*
            Llamamos al metodo "transición" de nuestra función de transición para saber a donde nos movemos. Dicho mpetodo nos
            regresa un String que representa el nuevo estado. La proxima vez que entremos al ciclo, ese será el "estado actual".
             */
            estadoActual = funcionTransicion.transicion(estadoActual, c);

            if(estadoActual == null){   //Si la cadena que estamos evaluando tiene un caracte que no es parte del alfabeto,
                                        //el método "transicion" nos regresará null.
                return false;
            }
        }
        /*
        Ya que recorrimos todos los caracteres de la cadena, sólo necesitamos saber si el estado en el que teminamos
        es final o no.
        Recordemos que este método regresa sólo true o false, dependiendo si el ultimo estado visitado (estado actual)
        es final o no.
         */
        return true;
    }

}
