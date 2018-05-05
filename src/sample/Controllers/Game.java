package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import sample.Classes.AFN;
import sample.Classes.BaseClass;
import sample.Classes.FuncionTransicion;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

//TODO LO QUE NO ESTÉ COMENTADO ES PARTE DE LA INTERFAZ GRÁFICA O ANIMACIONES

public class Game extends BaseClass {
    int level = 1;
    int iteracion = 0;
    int control = 1;
    Timeline timeline;
    SequentialTransition sequentialTransition;
    String aux = null;
    String sequeence = "";
    ArrayList<String> simonSequence = new ArrayList<>();
    FuncionTransicion funcionTransicion = new FuncionTransicion();
    AFN AFN;

    @FXML
    AnchorPane gameRoot;
    @FXML
    VBox gameVBox;
    @FXML
    GridPane gameGrid;
    @FXML
    JFXButton gameStart;
    @FXML
    Button gameButtonRed;
    @FXML
    Button gameButtonYellow;
    @FXML
    Button gameButtonBlue;
    @FXML
    Button gameButtonGreen;

    @FXML
    public void setUp(){
        simonSequence.clear(); //Limpiamos la secuencia de colores.
        for(int x = 0; x < (level * 5); x++){ //En este ciclo creamos un objeto FuncionTransición que tendrá 5X funciones de transición, 6 estados.
            int y = (int)((Math.random() * 4) + 1); //Elegimos un simbolo al azar.
            funcionTransicion.setFuncion("" + x,    //El ultimo estado no tendrá transición alguna.
                    "" + (x + 1), "" + y); //Los resultados se deben guardar como String.
            simonSequence.add("" + y); //Para no tener que iterar el automata en ciertos casos, tenemos un ArrayList con la secuencia.
            //Este ArrayList NO se usa para validad la entrada del usuario, esa se realiza a través del automata.
        }
        AFN = new AFN(funcionTransicion, "" + 0); //Creamos el automata a partir de la función de transición que definimos.
        iteracion = 0; //La iteración actual del juego se reinicia.
        control = 1; //El control de reinicia.
        sequeence = ""; //La variable que contiene la entrada del usuario se reincia.
        showSequence(); //Mostramos el primer color.
    }

    private void showSequence(){
        timeline = null;
        sequentialTransition = new SequentialTransition();
        for(int x = 0; x < control; x++){ //Vamos a mostrar la secuencia de colores sólo hasta el punto que el jugador ha llegado.
            aux = null;
            aux = simonSequence.get(x); //Obtenemos un caracter de la secuencia. Aquí utilizamos el ArrayList.
            switch (aux) { //Depende del color obtenido, "iluminamos" el botón correspondiente.
                case "1":
                    timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> gameButtonRed.setStyle("-fx-background-color: RED")),
                            new KeyFrame(Duration.millis(300), evt -> gameButtonRed.setStyle("-fx-background-color: #ff6666")));
                    timeline.setCycleCount(1);
                    sequentialTransition.getChildren().add(timeline);
                    break;
                case "2":
                    timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> gameButtonYellow.setStyle("-fx-background-color: YELLOW")),
                            new KeyFrame(Duration.millis(300), evt -> gameButtonYellow.setStyle("-fx-background-color: #ffff99")));
                    timeline.setCycleCount(1);
                    sequentialTransition.getChildren().add(timeline);
                    break;
                case "3":
                    timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> gameButtonBlue.setStyle("-fx-background-color: BLUE")),
                            new KeyFrame(Duration.millis(300), evt -> gameButtonBlue.setStyle("-fx-background-color: #6666ff")));
                    timeline.setCycleCount(1);
                    sequentialTransition.getChildren().add(timeline);
                    break;
                case "4":
                    timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> gameButtonGreen.setStyle("-fx-background-color: GREEN")),
                            new KeyFrame(Duration.millis(300), evt -> gameButtonGreen.setStyle("-fx-background-color: #66b266")));
                    timeline.setCycleCount(1);
                    sequentialTransition.getChildren().add(timeline);
                    break;
            }
        }
        sequentialTransition.play();
    }

    /**
     * Todos los botones se comportan igual. Sólo está comentado este.
     */
    @FXML
    public void onClickRed(){ //Se presionó el botón ROJO.
        iteracion = iteracion + 1; //Aumentamos la iteración del juego.
        if(iteracion < level * 5) { //Si no se han presionado 5X botones, no se ha completado el nivel.
            sequeence = sequeence + "1"; //Agregamos el simbolo correspondiente a la sequencia de entrada.
            if(AFN.valida(sequeence)){
                /**
                 * La validación de la cadena la lleva a cabo el AFN, que devuelve TRUE si y solo sí, ocurrio una transición
                 * al consumir cada uno de los simbolos de la secuencia.
                 * En cuanto una transición no suceda, es decir, no esté definida para el estado y simbolo en cuestión, el
                 * AFN regresa FALSE.
                 */
                if(iteracion == control) { //Control represneta el numero de entradas del usuario que estamos esperando.
                    sequeence = ""; //Limpiamos la entrada del usuario.
                    control = control + 1; //Aumentamos el control, puesto que ahora esperaremos un color más.
                    iteracion = 0; //Reiniciamos las iteraciones.
                    showSequence(); //Mostramos la secuencia, ahora mostrará un simbolo.
                }
            } else { //Si el AFN regresó FALSE, el usuario falló y el juego entero se reinicia (no sólo el nivel).
                JOptionPane.showMessageDialog(null, "You loose this level!", "Fail!", JOptionPane.ERROR_MESSAGE);
                level = 1;
                setUp();
            }
        }
        else { //Si ya se presionaron 5X botones, el nivel fue superado.
            JOptionPane.showMessageDialog(null, "You win this level!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            level += 1;
            setUp();
        }
    }

    @FXML
    public void onClickYellow(){
        iteracion = iteracion + 1;
        if(iteracion < level * 5) {
            sequeence = sequeence + "2";
            if(AFN.valida(sequeence)){
                if(iteracion == control) {
                    System.out.println("YAS! - " + sequeence);
                    sequeence = "";
                    control = control + 1;
                    iteracion = 0;
                    showSequence();
                }
            } else {
                JOptionPane.showMessageDialog(null, "You loose this level!", "Fail!", JOptionPane.ERROR_MESSAGE);
                level = 1;
                setUp();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You win this level!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            level += 1;
            setUp();
        }
    }

    @FXML
    public void onClickBlue(){
        iteracion = iteracion + 1;
        if(iteracion < level * 5) {
            sequeence = sequeence + "3";
            if(AFN.valida(sequeence)){
                if(iteracion == control) {
                    System.out.println("YAS! - " + sequeence);
                    sequeence = "";
                    control = control + 1;
                    iteracion = 0;
                    showSequence();
                }
            } else {
                JOptionPane.showMessageDialog(null, "You loose this level!", "Fail!", JOptionPane.ERROR_MESSAGE);
                level = 1;
                setUp();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You win this level!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            level += 1;
            setUp();
        }
    }

    @FXML
    public void onClickGreen(){
        iteracion = iteracion + 1;
        if(iteracion < level * 5) {
            sequeence = sequeence + "4";
            if(AFN.valida(sequeence)){
                if(iteracion == control) {
                    System.out.println("YAS! - " + sequeence);
                    sequeence = "";
                    control = control + 1;
                    iteracion = 0;
                    showSequence();
                }
            } else {
                JOptionPane.showMessageDialog(null, "You loose this level!", "Fail!", JOptionPane.ERROR_MESSAGE);
                level = 1;
                setUp();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You win this level!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            level += 1;
            setUp();
        }
    }

    @FXML
    public void onClickOut() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample/FXML/Main.fxml"));
        getApplicationInstance().setNewRoot(loader.load());
        ((BaseClass)loader.getController()).setApplicationInstance(getApplicationInstance());
    }
}
