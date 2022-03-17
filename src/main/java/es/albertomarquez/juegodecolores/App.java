package es.albertomarquez.juegodecolores;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {
    ImageView imgfondo1;
    ImageView imgfondo2;
    Timeline fondoScroll;
    int imagenFondo1X = 0;
    int imagenFondo2X = 500;
    final int TAM_X_PANTALLA = 500;
    final int TAM_Y_PANTALLA = 233;
    Pane paneRoot = new Pane();
   
    @Override
    public void start(Stage stage) {
        var scene = new Scene(paneRoot, TAM_X_PANTALLA, TAM_Y_PANTALLA);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.setTitle("MASTERMIND");
        fondoPantalla();
        
        Tablero tablero = new Tablero();
        tablero.recRojo();
        tablero.recA();
        tablero.recV();
        tablero.recAz();
        
        paneRoot.getChildren().add(tablero);
        Logica logica = new Logica();
        logica.patronGanador(tablero);
    }
    
    public void fondoPantalla(){
        imgfondo1 = new ImageView();
        imgfondo2 = new ImageView();
        paneRoot.getChildren().add(imgfondo1);
        paneRoot.getChildren().add(imgfondo2);
        imgfondo1.setLayoutX(imagenFondo1X);
        imgfondo2.setLayoutX(imagenFondo2X); 
        Image img = new Image(getClass().getResourceAsStream("/images/blanco.jpg"));
        imgfondo1 = new ImageView(img);
        imgfondo2 = new ImageView(img);
        paneRoot.getChildren().add(imgfondo2);
        paneRoot.getChildren().add(imgfondo1);
        fondoScroll = new Timeline(                             
                new KeyFrame(Duration.seconds(0.007), (ActionEvent ae) -> {                                         
                    imagenFondo1X = imagenFondo1X -1;
                    imgfondo1.setLayoutX(imagenFondo1X);
                    imagenFondo2X = imagenFondo2X -1;
                    imgfondo2.setLayoutX(imagenFondo2X);
                    if (imagenFondo1X == -600) {  
                        imagenFondo1X = 500;
                      } else if (imagenFondo2X == -600) {
                          imagenFondo2X = 500;
        }
        })
        );
        fondoScroll.setCycleCount(Timeline.INDEFINITE);
        fondoScroll.play();
    }
    public static void main(String[] args) {
        launch();
    }

}