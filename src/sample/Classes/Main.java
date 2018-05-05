package sample.Classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    Scene scene;

    @Override
    public void init(){
        scene = new Scene(new Pane());
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/FXML/Main.fxml"));
        primaryStage.setTitle("Proyecto Final");
        scene.setRoot(loader.load());
        ((BaseClass)loader.getController()).setApplicationInstance(this);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setNewRoot(Pane nuevoRoot){
        scene.setRoot(nuevoRoot);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
