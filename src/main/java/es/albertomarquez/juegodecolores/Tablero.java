package es.albertomarquez.juegodecolores;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tablero extends GridPane {
    Rectangle[][] mapa;
    Logica logica = new Logica();
    App app = new App();
    int posYRect = 2;
    int posXRect = -1;
    int posYmapa = 2;
    int posXmapa = -1;
    int tamXTablero = 4;
    int tamYTablero = 3;
    Text textFinal;
    HBox panefinal = new HBox();
    Text textganador;
    HBox paneganador = new HBox();
    Text textScore;
    Text enun = new Text("Patrones acertados: ");
    Text cont1 = new Text("0");
    int contador;
    Text in = new Text("Numeros de intentos: ");
    Text cont = new Text("0");
    int score;
   
    public Tablero( ) {
        enun.setStyle("-fx-font: 20 arial;");
        this.add(enun, 10,0);
        cont1.setStyle("-fx-font: 20 arial;");
        this.add(cont1, 11,0);
        in.setStyle("-fx-font: 20 arial;");
        this.add(in, 10,2);
        cont.setStyle("-fx-font: 20 arial;");
        this.add(cont, 11,2);
        
        mapa = new Rectangle[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x=x+1) {
            for(int y=0; y<tamYTablero; y=y+1) {
                Rectangle casilla = new Rectangle(50,50,Color.BLACK);
                mapa[x][y] = casilla;
                this.add(casilla,x,y);
                this.setVgap(5);
                this.setHgap(5);
            }
        }
       
    }
    
    public void restaurarMapa(){
        mapa = new Rectangle[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x=x+1) {
            for(int y=0; y<tamYTablero; y=y+1) {
                Rectangle casilla = new Rectangle(50,50,Color.BLACK);
                mapa[x][y] = casilla;
                this.add(casilla,x,y);
                this.setVgap(5);
                this.setHgap(5);
            }
        }
    }
    
    public void recRojo(){
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
            logica.mostrarTableroConsola();
            if (logica.rectangulos[0][2] == logica.ganador1 && logica.rectangulos[1][2] == logica.ganador2 && logica.rectangulos[2][2] == logica.ganador3 && logica.rectangulos[3][2] == logica.ganador4){ 
               System.out.println("Has ganado");
               posYRect = 2;
               posXRect = -1;
               posYmapa = 2;
               posXmapa = -1;
               contador++;
               cont1.setText(String.valueOf(contador));
               logica.restaurarArr();
               restaurarMapa();
               logica.patronGanador(this);
           }  
            if (logica.rectangulos[0][1] == logica.ganador1 && logica.rectangulos[1][1] == logica.ganador2 && logica.rectangulos[2][1] == logica.ganador3 && logica.rectangulos[3][1] == logica.ganador4){ 
               System.out.println("Has ganado");
               posYRect = 2;
               posXRect = -1;
               posYmapa = 2;
               posXmapa = -1;
               contador++;
               cont1.setText(String.valueOf(contador));
               logica.restaurarArr();
               restaurarMapa();
               logica.patronGanador(this);
           }   
           if(logica.rectangulos[3][0] == logica.rojo || logica.rectangulos[3][0] == logica.azul || logica.rectangulos[3][0] == logica.amarillo || logica.rectangulos[3][0] == logica.verde ){  
               posYRect = 2;
               posXRect = -1;               
               posYmapa = 2;
               posXmapa = -1;
               score++;
               cont.setText(String.valueOf(score));
               System.out.println("Has Perdido");              
               logica.restaurarArr(); 
               restaurarMapa(); 
               logica.patronGanador(this); 
           }          
       }        
       );  
       this.add(recRojo,0,6);
    }
   
    public void recA(){
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
            logica.mostrarTableroConsola();
            if (logica.rectangulos[0][2] == logica.ganador1 && logica.rectangulos[1][2] == logica.ganador2 && logica.rectangulos[2][2] == logica.ganador3 && logica.rectangulos[3][2] == logica.ganador4){ 
               System.out.println("Has ganado");
               posYRect = 2;
               posXRect = -1;
               posYmapa = 2;
               posXmapa = -1;
               contador++;
               cont1.setText(String.valueOf(contador));
               logica.restaurarArr();
               restaurarMapa();
               logica.patronGanador(this);
           }  
            if (logica.rectangulos[0][1] == logica.ganador1 && logica.rectangulos[1][1] == logica.ganador2 && logica.rectangulos[2][1] == logica.ganador3 && logica.rectangulos[3][1] == logica.ganador4){ 
               System.out.println("Has ganado");
               posYRect = 2;
               posXRect = -1;
               posYmapa = 2;
               posXmapa = -1;
               contador++;
               cont1.setText(String.valueOf(contador));
               logica.restaurarArr();
               restaurarMapa();
               logica.patronGanador(this);
           }   
           if(logica.rectangulos[3][0] == logica.rojo || logica.rectangulos[3][0] == logica.azul || logica.rectangulos[3][0] == logica.amarillo || logica.rectangulos[3][0] == logica.verde ){  
               posYRect = 2;
               posXRect = -1;               
               posYmapa = 2;
               posXmapa = -1;
               score++;
               cont.setText(String.valueOf(score));
               System.out.println("Has Perdido");              
               logica.restaurarArr(); 
               restaurarMapa(); 
               logica.patronGanador(this); 
           }          
       }        
       );  
       this.add(recAmarillo,1,6);
       }

    public void recV(){
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
            logica.mostrarTableroConsola();
             if (logica.rectangulos[0][2] == logica.ganador1 && logica.rectangulos[1][2] == logica.ganador2 && logica.rectangulos[2][2] == logica.ganador3 && logica.rectangulos[3][2] == logica.ganador4){ 
               System.out.println("Has ganado");
               posYRect = 2;
               posXRect = -1;
               posYmapa = 2;
               posXmapa = -1;
               contador++;
               cont1.setText(String.valueOf(contador));
               logica.restaurarArr();
               restaurarMapa();
               logica.patronGanador(this);
           }  
             if (logica.rectangulos[0][1] == logica.ganador1 && logica.rectangulos[1][1] == logica.ganador2 && logica.rectangulos[2][1] == logica.ganador3 && logica.rectangulos[3][1] == logica.ganador4){ 
               System.out.println("Has ganado");
               posYRect = 2;
               posXRect = -1;
               posYmapa = 2;
               posXmapa = -1;
               contador++;
               cont1.setText(String.valueOf(contador));
               logica.restaurarArr();
               restaurarMapa();
               logica.patronGanador(this);
           }   
           if(logica.rectangulos[3][0] == logica.rojo || logica.rectangulos[3][0] == logica.azul || logica.rectangulos[3][0] == logica.amarillo || logica.rectangulos[3][0] == logica.verde ){  
               posYRect = 2;
               posXRect = -1;               
               posYmapa = 2;
               posXmapa = -1;
               score++;
               cont.setText(String.valueOf(score));
               System.out.println("Has Perdido");              
               logica.restaurarArr(); 
               restaurarMapa(); 
               logica.patronGanador(this); 
           }          
       }        
       );  
       this.add(recVerde,2,6);
       }
       
    public void recAz(){
       Rectangle recAzul = new Rectangle(50,50,Color.BLUE);
       recAzul.setOnMouseClicked((event) -> {          
            
           System.out.println("Has pulsado el azul"); 
           posXRect++;  
           logica.rectangulos[posXRect][posYRect]= logica.azul;          
           if(posXRect == 3){                   
               posXRect=-1;
               posYRect--; 
           } 
           if(posYRect == -1){     
               posYRect=0;         
           }  
           posXmapa++;
           mapa[posXmapa][posYmapa].setFill(Color.BLUE);        
           if(posXmapa == 3){                
               posXmapa=-1;
               posYmapa--; 
            }
           if(posYmapa == -1){
               posYmapa=0;  
           }   
           logica.mostrarTableroConsola();  
           if (logica.rectangulos[0][2] == logica.ganador1 && logica.rectangulos[1][2] == logica.ganador2 && logica.rectangulos[2][2] == logica.ganador3 && logica.rectangulos[3][2] == logica.ganador4){ 
               System.out.println("Has ganado");
               posYRect = 2;
               posXRect = -1;
               posYmapa = 2;
               posXmapa = -1;
               contador++;
               cont1.setText(String.valueOf(contador));
               logica.restaurarArr();
               restaurarMapa();
               logica.patronGanador(this);
           } 
           if (logica.rectangulos[0][1] == logica.ganador1 && logica.rectangulos[1][1] == logica.ganador2 && logica.rectangulos[2][1] == logica.ganador3 && logica.rectangulos[3][1] == logica.ganador4){ 
               System.out.println("Has ganado");
               posYRect = 2;
               posXRect = -1;
               posYmapa = 2;
               posXmapa = -1;
               contador++;
               cont1.setText(String.valueOf(contador));
               logica.restaurarArr();
               restaurarMapa();
               logica.patronGanador(this);
           }   
           if(logica.rectangulos[3][0] == logica.rojo || logica.rectangulos[3][0] == logica.azul || logica.rectangulos[3][0] == logica.amarillo || logica.rectangulos[3][0] == logica.verde ){  
               posYRect = 2;
               posXRect = -1;               
               posYmapa = 2;
               posXmapa = -1;
               score++;
               cont.setText(String.valueOf(score));
               System.out.println("Has Perdido");              
               logica.restaurarArr(); 
               restaurarMapa(); 
               logica.patronGanador(this); 
           }          
       }        
       );  
       this.add(recAzul,3,6);     
    }
}
       