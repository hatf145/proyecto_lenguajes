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
import java.util.Random;

public class Game extends BaseClass {
    int level = 1;
    int iteracion = 0;
    String sequeence = "";
    private ArrayList<String> estadosVisitados = new ArrayList<String>();
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
    public void setUp(){
        for(int x = 0; x < (level * 5); x++){
            int y = (int)((Math.random() * 4) + 1);
            funcionTransicion.setFuncion("" + x, "" + (x + 1), "" + y);
            System.out.println("Estado: " + x);
            System.out.println("Siguiente estado: " + (x + 1));
            System.out.println("Caracter: " + y + "\n");
        }
        afd = new AFD(funcionTransicion, "" + 0);
    }

    @FXML
    public void onClickRed(){
        iteracion += 1;
        if(iteracion < level * 5) {
            sequeence = sequeence + "1";
            System.out.println(sequeence);
            if(afd.valida(sequeence, estadosVisitados)){
                System.out.println("Yas!");
            } else {
                JOptionPane.showMessageDialog(null, "You loose this level!", "Fail!", JOptionPane.ERROR_MESSAGE);
                level = 1;
                iteracion = 0;
                sequeence = "";
                setUp();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You win this level!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            level += 1;
            iteracion = 0;
            sequeence = "";
            setUp();
        }
    }

    @FXML
    public void onClickYellow(){
        iteracion += 1;
        if(iteracion < level * 5) {
            sequeence = sequeence + "2";
            System.out.println(sequeence);
            if(afd.valida(sequeence, estadosVisitados)){
                System.out.println("Yas!");
            } else {
                JOptionPane.showMessageDialog(null, "You loose this level!", "Fail!", JOptionPane.ERROR_MESSAGE);
                level = 1;
                iteracion = 0;
                sequeence = "";
                setUp();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You win this level!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            level += 1;
            iteracion = 0;
            sequeence = "";
            setUp();
        }
    }

    @FXML
    public void onClickBlue(){
        iteracion += 1;
        if(iteracion < level * 5) {
            sequeence = sequeence + "3";
            System.out.println(sequeence);
            if(afd.valida(sequeence, estadosVisitados)){
                System.out.println("Yas!");
            } else {
                JOptionPane.showMessageDialog(null, "You loose this level!", "Fail!", JOptionPane.ERROR_MESSAGE);
                level = 1;
                iteracion = 0;
                sequeence = "";
                setUp();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You win this level!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            level += 1;
            iteracion = 0;
            sequeence = "";
            setUp();
        }
    }

    @FXML
    public void onClickGreen(){
        iteracion += 1;
        if(iteracion < level * 5) {
            sequeence = sequeence + "4";
            System.out.println(sequeence);
            if(afd.valida(sequeence, estadosVisitados)){
                System.out.println("Yas!");
            } else {
                JOptionPane.showMessageDialog(null, "You loose this level!", "Fail!", JOptionPane.ERROR_MESSAGE);
                level = 1;
                iteracion = 0;
                sequeence = "";
                setUp();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You win this level!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            level += 1;
            iteracion = 0;
            sequeence = "";
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
