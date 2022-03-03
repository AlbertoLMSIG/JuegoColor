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
   
    final int TAM_X_PANTALLA = 240;
    final int TAM_Y_PANTALLA = 240;
   
    @Override
    public void start(Stage stage) {
        Pane paneRoot = new Pane();
        var scene = new Scene(paneRoot, TAM_X_PANTALLA, TAM_Y_PANTALLA);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
       
        Tablero tablero = new Tablero();
        Logica logica = new Logica();
        logica.patronGanador(tablero);
       // tablero.mostrarTableroConsola();
        paneRoot.getChildren().add(tablero);
    }

    public static void main(String[] args) {
        launch();
    }

}