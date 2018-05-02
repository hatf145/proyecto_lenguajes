package sample.Classes;

import java.util.HashMap;
import java.util.Map;

public class FuncionTransicion {
    /**
     * Para abstraer mi función de transición, lo más práctico terminó siendo un mapa de mapas, donde cada estado es
     * una llave y su valor es un mapa secundario; en ese mapa secundario, la llave es un simbolo del alfabeto y el
     * valor es un estado de resultado.
     * Básicamente el mapa principal liga a un estado (key) con un relación entre simbolos y estados (value); esta
     * relación esta implementada como un segundo mapa, donde el simbolo (key) nos indica a que estado ir si es
     * consumido (value).
     */
    private final Map<String, Map<String, String>> funcion = new HashMap();

    //Metodo para agregar una transición a nuestra función.
    public void setFuncion(String estadoActual, String estadoSiguiente, //Recibe el estado actual, el estado al que
                           String caracter){                            //vamos, y el caracter que da pie a la transición.
        funcion.putIfAbsent(estadoActual, new HashMap<>());             //Verificamos si el estado ya está como key en nuestro
                                                                        //mapa, si no está, lo agregamos.
        funcion.get(estadoActual).put(caracter, estadoSiguiente);       //Obtenemos el value de nuestro estado (key), lo que nos regresa
                                                                        //otro mapa; en ese mapa agregamos el caracter (key) y el estado
                                                                        //siguiente (value).
    }


    //Metodo para movernos entre los estados.
    public String transicion(String estadoActual, String caracter){     //Recibe el estado actual y el caracter que se va a consumir.
       return funcion.get(estadoActual).get(caracter); //Regresamos el estado (en forma de String) al cual estado actual llega si consume el caracter.
                                                       //Si el estado no tiene una definida una trancisión para el caracter que recibimos, automaticamente
                                                       //regresa NULL.
    }

}
