package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sample.Classes.BaseClass;

import java.io.IOException;

public class Main extends BaseClass {

    @FXML
    AnchorPane mainRoot;
    @FXML
    VBox mainVBox;
    @FXML
    JFXButton mainTitle;
    @FXML
    JFXButton mainStart;
    @FXML
    JFXButton mainMore;
    @FXML
    JFXButton mainOut;


    @FXML
    public void goToGame() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample/FXML/Game.fxml"));
        getApplicationInstance().setNewRoot(loader.load());
        ((BaseClass)loader.getController()).setApplicationInstance(getApplicationInstance());
    }

    @FXML
    public void goToMore(){

    }

    @FXML
    public void goOut(){
    }


}
