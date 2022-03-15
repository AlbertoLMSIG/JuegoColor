package es.albertomarquez.juegodecolores;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
   
    final int TAM_X_PANTALLA = 500;
    final int TAM_Y_PANTALLA = 233;
   
    @Override
    public void start(Stage stage) {
        Pane paneRoot = new Pane();
        var scene = new Scene(paneRoot, TAM_X_PANTALLA, TAM_Y_PANTALLA);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
       
        Tablero tablero = new Tablero();
        tablero.recRojo();
        tablero.recA();
        tablero.recV();
        tablero.recAz();
        
        paneRoot.getChildren().add(tablero);
        Logica logica = new Logica();
        logica.patronGanador(tablero);
       
       
       
    }

    public static void main(String[] args) {
        launch();
    }

}