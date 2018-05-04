package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sample.Classes.AFD;
import sample.Classes.BaseClass;
import sample.Classes.FuncionTransicion;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Game extends BaseClass {
    int level = 1;
    int iteracion = 0;
    int control = 1;
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
    JFXButton gameButtonRed;
    @FXML
    JFXButton gameButtonYellow;
    @FXML
    JFXButton gameButtonBlue;
    @FXML
    JFXButton gameButtonGreen;

    @FXML
    public void setUp() throws Exception{
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

    public void showSequence() throws Exception{
        for(int x = 0; x < control; x++){
            aux = null;
            aux = simonSequence.get(x);
            System.out.println(simonSequence);
            switch (aux){
                case "1":
                    gameButtonRed.setStyle("");
                    break;
                case "2":
                    gameButtonYellow.requestFocus();
                    break;
                case "3":
                    gameButtonBlue.requestFocus();
                    break;
                case "4":
                    gameButtonGreen.requestFocus();
                    break;
            }
            gameButtonRed.getParent().requestFocus();
        }
    }

    @FXML
    public void onClickRed() throws Exception{
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
    public void onClickYellow() throws Exception{
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
    public void onClickBlue() throws Exception{
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
    public void onClickGreen() throws Exception{
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
