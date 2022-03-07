package es.albertomarquez.juegodecolores;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tablero extends GridPane {
    final int CELDASX = 4;
    final int CELDASY = 3;
//    final int tamXTablero = 4;
//    final int tamYTablero = 3;
    final int rcy=3;
    Rectangle[][] mapa;
    Logica logica = new Logica();
    boolean colorInf = false;
    int posYRect = 2;
    int posXRect = 0;
    int posYmapa = 2;
    int posXmapa = 0;
    boolean reinicio = false;
    
    public Tablero( ) {
        int tamXTablero = 4;
        int tamYTablero = 3;
        mapa = new Rectangle[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x=x+1) {
            for(int y=0; y<tamYTablero; y=y+1) {
                Rectangle casilla = new Rectangle(50,50,Color.BLACK);
                mapa[x][y] = casilla;
                this.add(casilla,x,y);
            }
        }

       Rectangle recRojo = new Rectangle(50,50,Color.RED);
       recRojo.setOnMouseClicked((event) -> {
            System.out.println("Has pulsado el rojo");
            logica.rectangulos[posXRect++][posYRect]= logica.rojo;
//            mapa[posXmapa++][posYmapa].setFill(Color.RED); 
//            if (posXmapa == 4){
//                posXmapa = 0;
//                posYmapa--;
//            }else if(posXmapa > 3){
//                System.out.println("Ha llegado al final");
//            }
            if (posXRect > 3){
                //System.out.println("Final de fila");
                posXRect = 0;
                posYRect--;
                
                
            }
            else if (posYRect == 0){
                System.out.println("Final de columna");
            }
//            else if (posXRect == 4 && posYRect == 0 ){
//                 posXRect = 0;
//                 posYRect = 0;
//            System.out.println("Ha llegado al final");}
            logica.mostrarTableroConsola();            
       }
       );
       this.add(recRojo,0,6);
       
//       
//       Rectangle recAmarillo = new Rectangle(50,50,Color.YELLOW);
//       recAmarillo.setOnMouseClicked((event) -> {         
//           System.out.println("Has pulsado el Amarillo");      
//           logica.rectangulos[posXRect++][posYRect]= logica.amarillo;        
//           mapa[posXmapa++][posYmapa].setFill(Color.YELLOW);     
//           if (posXmapa == 4){        
//               posXmapa = 0;              
//               posYmapa--;    
//           }else if(posXmapa == 4 && posYmapa == 0){     
//               System.out.println("Ha llegado al final");     
//           }            
//           if ( posXRect == 4 ){               
//               posXRect = 0;                
//               posYRect--;                            
//           }else if (posXRect == 4 && posYRect == 0  ){                       
//               System.out.println("Ha llegado al final");}            
//               logica.mostrarTableroConsola();
//        });
//       this.add(recAmarillo,1,6);
//       
//       Rectangle recVerde = new Rectangle(50,50,Color.GREEN);
//       recVerde.setOnMouseClicked((event) -> {            
//           System.out.println("Has pulsado el verde");
//           logica.rectangulos[posXRect++][posYRect]= logica.verde;
//           mapa[posXmapa++][posYmapa].setFill(Color.GREEN);             
//           if (posXmapa == 4){               
//               posXmapa = 0;
//               posYmapa--;           
//           }else if(posXmapa == 4 && posYmapa == 0){               
//               System.out.println("Ha llegado al final");
//            }           
//           if (posXRect == 4 ){               
//               posXRect = 0;
//               posYRect--;            
//           }else if (posXRect == 4 && posYRect == 0 ){                 
//                          
//               System.out.println("Ha llegado al final");
//           }           
//           logica.mostrarTableroConsola();
//        });
//       this.add(recVerde,2,6);
//       
//       Rectangle recAzul = new Rectangle(50,50,Color.BLUE);
//       recAzul.setOnMouseClicked((event) -> {           
//           System.out.println("Has pulsado el azul");
//           logica.rectangulos[posXRect++][posYRect]= logica.azul;
//           mapa[posXmapa++][posYmapa].setFill(Color.BLUE);            
//           if (posXmapa == 4){                
//               posXmapa = 0;
//               posYmapa--;            
//           }else if(posXmapa == 4 && posYmapa == 0){                
//               System.out.println("Ha llegado al final");           
//           }           
//           if (posXRect == 4){
//               posXRect = 0;              
//               posYRect --;           
//           }else if (posXRect == 4 && posYRect == 0 ){                        
//               System.out.println("Ha llegado al final");
//           }    
//           logica.mostrarTableroConsola();
//        });
//       this.add(recAzul,3,6);    
   }    
}
   
