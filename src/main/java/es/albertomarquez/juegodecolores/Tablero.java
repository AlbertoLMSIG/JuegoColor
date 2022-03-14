package es.albertomarquez.juegodecolores;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tablero extends GridPane {
    final int CELDASX = 4;
    final int CELDASY = 3;
//    final int tamXTablero = 4;
//    final int tamYTablero = 3;
    final int rcy=3;
    Rectangle[][] mapa;
    Logica logica = new Logica();
    App app = new App();
    boolean colorInf = false;
    int posYRect = 2;
    int posXRect = -1;
    int posYmapa = 2;
    int posXmapa = -1;
    boolean reinicio = false;
    Text textFinal;
    HBox panefinal = new HBox();
    
    public Tablero( ) {
        int tamXTablero = 4;
        int tamYTablero = 3;
        mapa = new Rectangle[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x=x+1) {
            for(int y=0; y<tamYTablero; y=y+1) {
                Rectangle casilla = new Rectangle(50,50,Color.WHITE);
                mapa[x][y] = casilla;
                this.add(casilla,x,y);
            }
        }

       Rectangle recRojo = new Rectangle(50,50,Color.RED);
       recRojo.setOnMouseClicked((event) -> {
            System.out.println("Has pulsado el rojo");
            posXRect++;
            logica.rectangulos[posXRect][posYRect]= logica.rojo;          
            if(posXRect == 3){                
                posXRect=-1;
                posYRect--;
            }
            if (posYRect == -1){
                posYRect=0; 
            }
            posXmapa++;
            mapa[posXmapa][posYmapa].setFill(Color.RED);
            if(posXmapa == 3){                
                posXmapa=-1;
                posYmapa--;
            }
            if (posYmapa == -1){
                posYmapa=0; 
            }
            
            if (logica.rectangulos[3][0] == logica.rojo || logica.rectangulos[3][0] == logica.azul || logica.rectangulos[3][0] == logica.amarillo || logica.rectangulos[3][0] == logica.verde ){
                panefinal.setTranslateY(50) ;
                panefinal.setTranslateX(300) ;
                textFinal = new Text("Has perdido");
                textFinal. setFont (Font. font (24));
                textFinal. setFill(Color.BLACK) ;
                this.getChildren().add(panefinal) ;
                panefinal.getChildren().add(textFinal) ;
                System.out.println("Has Perdido");  
            }
            if ( logica.rectangulos[0][2] == logica.rojo && logica.rectangulos[1][2] == logica.verde && logica.rectangulos[2][2] == logica.amarillo && logica.rectangulos[3][2] == logica.azul ){
           System.out.println("Has ganado");
           
           
       }
            logica.mostrarTableroConsola();            
       }
       );
       this.add(recRojo,0,6);
       
       
       Rectangle recAmarillo = new Rectangle(50,50,Color.YELLOW);
       recAmarillo.setOnMouseClicked((event) -> {                    
           System.out.println("Has pulsado el Amarillo");
            posXRect++;           
            logica.rectangulos[posXRect][posYRect]= logica.amarillo;           
           if(posXRect == 3){                
                posXRect=-1;
                posYRect--;
            }
            if (posYRect == -1){
                posYRect=0; 
            } 
            posXmapa++;
            mapa[posXmapa][posYmapa].setFill(Color.YELLOW);
            if(posXmapa == 3){                
                posXmapa=-1;
                posYmapa--;
            }
            if (posYmapa == -1){
                posYmapa=0; 
            }
            if (logica.rectangulos[3][0] == logica.rojo || logica.rectangulos[3][0] == logica.azul || logica.rectangulos[3][0] == logica.amarillo || logica.rectangulos[3][0] == logica.verde ){                 
                panefinal.setTranslateY(50) ;
                panefinal.setTranslateX(300) ;
                textFinal = new Text("Has perdido");
                textFinal. setFont (Font. font (24));
                textFinal. setFill(Color.BLACK) ;
                this.getChildren().add(panefinal) ;
                panefinal.getChildren().add(textFinal) ;
                System.out.println("Has Perdido");   
            }
            if ( logica.rectangulos[0][2] == logica.rojo && logica.rectangulos[1][2] == logica.verde && logica.rectangulos[2][2] == logica.amarillo && logica.rectangulos[3][2] == logica.azul ){
           System.out.println("Has ganado");
           
           
       }
            
               logica.mostrarTableroConsola();
        });
       this.add(recAmarillo,1,6);
       
       Rectangle recVerde = new Rectangle(50,50,Color.GREEN);
       recVerde.setOnMouseClicked((event) -> {            
            System.out.println("Has pulsado el verde");
            posXRect++;
            logica.rectangulos[posXRect][posYRect]= logica.verde;
           //mapa[posXmapa++][posYmapa].setFill(Color.GREEN);             
           if(posXRect == 3){                
                posXRect=-1;
                posYRect--;
            }
            if (posYRect == -1){
                posYRect=0; 
            }
            posXmapa++;
            mapa[posXmapa][posYmapa].setFill(Color.GREEN);
            if(posXmapa == 3){                
                posXmapa=-1;
                posYmapa--;
            }
            if (posYmapa == -1){
                posYmapa=0; 
            }
            if (logica.rectangulos[3][0] == logica.rojo || logica.rectangulos[3][0] == logica.azul || logica.rectangulos[3][0] == logica.amarillo || logica.rectangulos[3][0] == logica.verde ){                 
                 panefinal.setTranslateY(50) ;
                panefinal.setTranslateX(300) ;
                textFinal = new Text("Has perdido");
                textFinal. setFont (Font. font (24));
                textFinal. setFill(Color.BLACK) ;
                this.getChildren().add(panefinal) ;
                panefinal.getChildren().add(textFinal) ;
                System.out.println("Has Perdido");  
            }
            if ( logica.rectangulos[0][2] == logica.rojo && logica.rectangulos[1][2] == logica.verde && logica.rectangulos[2][2] == logica.amarillo && logica.rectangulos[3][2] == logica.azul ){
           System.out.println("Has ganado");
           
           
       }
            
           logica.mostrarTableroConsola();
        });
       this.add(recVerde,2,6);
       
       Rectangle recAzul = new Rectangle(50,50,Color.BLUE);
       recAzul.setOnMouseClicked((event) -> {           
            System.out.println("Has pulsado el azul");
            posXRect++;
            logica.rectangulos[posXRect][posYRect]= logica.azul;           
           if(posXRect == 3){                
                posXRect=-1;
                posYRect--;
            }
            if (posYRect == -1){
                posYRect=0; 
            }
            posXmapa++;
            mapa[posXmapa][posYmapa].setFill(Color.BLUE);
            if(posXmapa == 3){                
                posXmapa=-1;
                posYmapa--;
            }
            if (posYmapa == -1){
                posYmapa=0; 
            }
            if (logica.rectangulos[3][0] == logica.rojo || logica.rectangulos[3][0] == logica.azul || logica.rectangulos[3][0] == logica.amarillo || logica.rectangulos[3][0] == logica.verde ){                 
                panefinal.setTranslateY(50) ;
                panefinal.setTranslateX(300) ;
                textFinal = new Text("Has perdido");
                textFinal. setFont (Font. font (24));
                textFinal. setFill(Color.BLACK) ;
                this.getChildren().add(panefinal) ;
                panefinal.getChildren().add(textFinal) ;
                System.out.println("Has Perdido");    
            }
            if ( logica.rectangulos[0][2] == logica.rojo && logica.rectangulos[1][2] == logica.verde && logica.rectangulos[2][2] == logica.amarillo && logica.rectangulos[3][2] == logica.azul ){
           System.out.println("Has ganado");   
       }
           logica.mostrarTableroConsola();
        });
       
       this.add(recAzul,3,6);    
       
      
   }    
}
   
