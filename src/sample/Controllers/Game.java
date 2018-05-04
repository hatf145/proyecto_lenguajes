package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
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
import sample.Classes.AFD;
import sample.Classes.BaseClass;
import sample.Classes.FuncionTransicion;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

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
    AFD afd;

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
        simonSequence.clear();
        for(int x = 0; x < (level * 5); x++){
            int y = (int)((Math.random() * 4) + 1);
            funcionTransicion.setFuncion("" + x, "" + (x + 1), "" + y);
            //System.out.println("Estado: " + x);
            //System.out.println("Siguiente estado: " + (x + 1));
            System.out.println("Caracter: " + y);
            simonSequence.add("" + y);
        }
        afd = new AFD(funcionTransicion, "" + 0);
        iteracion = 0;
        control = 1;
        sequeence = "";
        showSequence();
    }

    public void showSequence(){
        timeline = null;
        sequentialTransition = new SequentialTransition();
        for(int x = 0; x < control; x++){
            aux = null;
            aux = simonSequence.get(x);
            switch (aux) {
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

    @FXML
    public void onClickRed(){
        iteracion = iteracion + 1;
        if(iteracion < level * 5) {
            sequeence = sequeence + "1";
            if(afd.valida(sequeence)){
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
    public void onClickYellow(){
        iteracion = iteracion + 1;
        if(iteracion < level * 5) {
            sequeence = sequeence + "2";
            if(afd.valida(sequeence)){
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
            if(afd.valida(sequeence)){
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
            if(afd.valida(sequeence)){
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
