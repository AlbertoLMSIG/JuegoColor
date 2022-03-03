package es.albertomarquez.juegodecolores;




import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Tablero extends GridPane {
    final int CELDASX = 4;
    final int CELDASY = 3;
    Logica logica = new Logica();
    Rectangle rec1 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec2 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec3 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec4 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec5 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec6 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec7 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec8 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec9 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec10 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec11 = new Rectangle(50,50,Color.BLACK);
    Rectangle rec12 = new Rectangle(50,50,Color.BLACK);
    boolean colorInf = false;
    int posYRect = 2;
    int posXRect = 0;
    
    public Tablero( ) {
        
        this.setHgap(4);
        this.setVgap(3);
        this.add(rec4,5,5);        
        this.add(rec3,4,5);       
        this.add(rec2,3,5);
        this.add(rec1,2,5);
        this.add(rec8,5,4);    
        this.add(rec7,4,4);       
        this.add(rec6,3,4);         
        this.add(rec5,2,4);      
        this.add(rec12,5,3);      
        this.add(rec11,4,3);
        this.add(rec10,3,3);
        this.add(rec9,2,3);
        
      
        
//        for(int x = 0; x<CELDASX; x++ ) {
//            for(int y = 0; y<CELDASY; y++ ) {
//                Rectangle rectangle = new Rectangle(50,50,Color.BLACK);
//                rectangle.setX(x);
//                rectangle.setY(y);
//                this.add(rectangle, x, y);
//            }
//            }

       Rectangle recRojo = new Rectangle(50,50,Color.RED);
       recRojo.setOnMouseClicked((event) -> {
            System.out.println("Has pulsado el rojo");
            logica.rectangulos[posXRect++][posYRect]= logica.rojo;
            if ( posXRect > 3 ){
                posXRect = 0;
                posYRect--;
            } else if (posXRect > 3 && posYRect < 1 ){
                 posXRect = 0;
                 posYRect = 0;
            System.out.println("Ha llegado al final");}
            logica.mostrarTableroConsola();
            
       });
       this.add(recRojo,2,6);
       Rectangle recAmarillo = new Rectangle(50,50,Color.YELLOW);
       recAmarillo.setOnMouseClicked((event) -> {
            System.out.println("Has pulsado el Amarillo");
            logica.rectangulos[posXRect++][posYRect]= logica.amarillo;
            if ( posXRect > 3 ){
                posXRect = 0;
                posYRect--;                
            }else if (posXRect > 3 && posYRect < 1  ){
            posXRect = 0;
                 posYRect = 0;
            System.out.println("Ha llegado al final");}
            logica.mostrarTableroConsola();
        });
       this.add(recAmarillo,3,6);
       Rectangle recVerde = new Rectangle(50,50,Color.GREEN);
       recVerde.setOnMouseClicked((event) -> {
            System.out.println("Has pulsado el verde");
            logica.rectangulos[posXRect++][posYRect]= logica.verde;
            if ( posXRect > 3 ){
                posXRect = 0;
                posYRect--;
            }else if (posXRect > 3 && posYRect < 1 ){
                 posXRect = 0;
                 posYRect = 0;
            System.out.println("Ha llegado al final");}
            logica.mostrarTableroConsola();
        });
       this.add(recVerde,4,6);
       Rectangle recAzul = new Rectangle(50,50,Color.BLUE);
       recAzul.setOnMouseClicked((event) -> {
            System.out.println("Has pulsado el azul");
            logica.rectangulos[posXRect++][posYRect]= logica.azul;
            if ( posXRect > 3 ){
                posXRect = 0;
                posYRect --;
            }else if (posXRect > 3 && posYRect < 1 ){
                 posXRect = 0;
                 posYRect = 0;
            System.out.println("Ha llegado al final");}
            logica.mostrarTableroConsola();
        });
       this.add(recAzul,5,6);
       
    }
   
    public void mostrarTableroConsola() {
//        logica.mostrarTableroConsola();
//     
//        for(int i=0; i<=4;i++){
//            Random random = new Random();
//            int posX = random.nextInt(4);
//            int posY = random.nextInt(3);
//            System.out.println("posX: " + posX +" "+"posY: " + posY);
//            logica.mostrarTableroConsola();
//        }
    }


    
}
