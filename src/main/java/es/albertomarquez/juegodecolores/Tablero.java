package es.albertomarquez.juegodecolores;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tablero extends GridPane {
    //VARIABLE UTILIZADAS
    Rectangle[][] mapa;
    Logica logica = new Logica();
    int posYRect = 2;
    int posXRect = -1;
    int posYmapa = 2;
    int posXmapa = -1;
    int tamXTablero = 4;
    int tamYTablero = 3;
    Text enun = new Text("Patrones acertados: ");
    Text cont1 = new Text("0");
    int contador;
    Text in = new Text("Numeros de intentos: ");
    Text cont = new Text("0");
    int score;
   
    //METODO CONSTRUCTOR PARA INICIALIZAR EL TABLERO GRAFICO Y LOS TEXTOS
    public Tablero( ) {
        //TEXTOS
        enun.setStyle("-fx-font: 20 arial;");
        this.add(enun, 10,0);
        cont1.setStyle("-fx-font: 20 arial;");
        this.add(cont1, 11,0);
        in.setStyle("-fx-font: 20 arial;");
        this.add(in, 10,2);
        cont.setStyle("-fx-font: 20 arial;");
        this.add(cont, 11,2);
        //ARRAY PARA FORMAR EL TABLERO GRAFICO
        mapa = new Rectangle[tamXTablero][tamYTablero]; //CREO UN ARRAY RECTANGLE CON EL TAMAÑO ESPECIFICADO EN LAS VARIABLES
        for(int x=0; x<tamXTablero; x=x+1) {
            for(int y=0; y<tamYTablero; y=y+1) {
                Rectangle casilla = new Rectangle(50,50,Color.WHITESMOKE); //CREO UN RECTANGLE CON EL COLOR QUE QUIERO Y EL TAMAÑO ELEGIDO
                mapa[x][y] = casilla; //AÑADO ESE RECTANGLE AL ARRAY RECTANGLE PARA QUE CON EL BUCLE FOR CREE AUTOMATICAMENTE EL TABLERO GRAFICO
                this.add(casilla,x,y); //ANADO EL TABLERO A LAS POSICIONES X E Y 
                this.setVgap(5); //CREO SEPARACION ENTRE LAS CELDAS VERTICAL
                this.setHgap(5); //CREO SEPARACION ENTRE LAS CELDAS HORIZONTAL
            }
        }
       
    }
         
    //METODO PARA REINICIAR EL TABLERO GRAFICO Y DEJARLO DESDE 0 Y SIN PINTAR
    public void restaurarMapa(){
        mapa = new Rectangle[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x=x+1) {
            for(int y=0; y<tamYTablero; y=y+1) {
                Rectangle casilla = new Rectangle(50,50,Color.WHITESMOKE);
                mapa[x][y] = casilla;
                this.add(casilla,x,y);
                this.setVgap(5);
                this.setHgap(5);
            }
        }
    }
/*-----------------------METODO DE SELECION DE COLORES-----------------------------------------*/
    //METODO CUANDO SELECIONE EL RECTANGULO ROJO
    public void recRojo(){
       Rectangle recRojo = new Rectangle(50,50,Color.RED); //PRIMERO CREO EL RECTANGULO CON EL COLOR ELEJIDO
       //CREO UN METODO PARA SELECIONARLO
       recRojo.setOnMouseClicked((event) -> {
            System.out.println("Has pulsado el rojo"); //MUESTRA EN PANTALLA EL COLOR QUE HAS SELECIONADO
            posXRect++; //INCREMENTO LA VARIABLE
            logica.rectangulos[posXRect][posYRect]= logica.rojo; //ACTUALIZO EL ARRAY PARA CADA VEZ QUE INCREMENTE LA VARIABLE SE PONGA LA R DE ROJO EN LA POSICION ADECUADA          
            //CUANDO LA VARIABLE SE INCREMENTA HASTA LLEGAR A 3 PONGO LA VARAIABLE A SU ESTADO INICIAL QUE ES -1 Y LE RESTO A LA VARIABLE Y 1 PARA QUE ASI NUNCA SE SALGA DEL TABLERO DE CONSOLA
            if(posXRect == 3){                
                posXRect=-1;
                posYRect--;
            }
            if (posYRect == -1){
                posYRect=0;
            }
            //HAGO LO MISMO QUE LO ANTERIOR
            posXmapa++;
            mapa[posXmapa][posYmapa].setFill(Color.RED); //AQUI CADA VEZ QUE PULSE EL COLOR ROJO SE ACTUALIZA EL TABLERO GRAFICO CON EL COLOR ROJO EN LA POSICION INDICADA
            if(posXmapa == 3){                
                posXmapa=-1;
                posYmapa--;
            }
            if (posYmapa == -1){
                posYmapa=0;
            }
            logica.mostrarTableroConsola();
            //COMPARO EN LA 1º FILA SI TODO LAS CELDAS SON IGUALES AL PATRON GANADOR SI ES ASI SALE EN CONSOLA QUE HAS GANADO Y AUMENTA EN 1 LA PUNTUACION. 
            //TAMBIEN REINICIO LAS VARIABLES Y RESTAURO DE 0 EL TABLERO GRAFICO Y EL TABLERO DE CONSOLA
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
            //COMPARO EN LA 2º FILA SI TODO LAS CELDAS SON IGUALES AL PATRON GANADOR SI ES ASI SALE EN CONSOLA QUE HAS GANADO Y AUMENTA EN 1 LA PUNTUACION. 
            //TAMBIEN REINICIO LAS VARIABLES Y RESTAURO DE 0 EL TABLERO GRAFICO Y EL TABLERO DE CONSOLA
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
            //COMPARO EN LA 3º FILA SI TODO LAS CELDAS SON IGUALES AL PATRON GANADOR SI ES ASI SALE EN CONSOLA QUE HAS GANADO Y AUMENTA EN 1 LA PUNTUACION. 
            //TAMBIEN REINICIO LAS VARIABLES Y RESTAURO DE 0 EL TABLERO GRAFICO Y EL TABLERO DE CONSOLA
            if (logica.rectangulos[0][0] == logica.ganador1 && logica.rectangulos[1][0] == logica.ganador2 && logica.rectangulos[2][0] == logica.ganador3 && logica.rectangulos[3][0] == logica.ganador4){ 
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
            //COMPARA SI EN LA ULTIMA CELDA DEL TABLERO NO HAS SELECIONADO EL COLOR PARA GANAR Y AUMENTO EN 1 EL NUMERO DE INTENTO Y REINICIO EL TABLERO GRAFICO Y EL DE CONSOLA
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
    /*------------HACEMOS LO MISMO CON TODO LOS RECTANGULOS PARA SELECIONAR------------*/
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
            if (logica.rectangulos[0][0] == logica.ganador1 && logica.rectangulos[1][0] == logica.ganador2 && logica.rectangulos[2][0] == logica.ganador3 && logica.rectangulos[3][0] == logica.ganador4){ 
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
           if(posYmapa == -1){   
               posYmapa=0; 
           } 
           logica.mostrarTableroConsola();           
           if(logica.rectangulos[0][2] == logica.ganador1 && logica.rectangulos[1][2] == logica.ganador2 && logica.rectangulos[2][2] == logica.ganador3 && logica.rectangulos[3][2] == logica.ganador4){
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
           if(logica.rectangulos[0][1] == logica.ganador1 && logica.rectangulos[1][1] == logica.ganador2 && logica.rectangulos[2][1] == logica.ganador3 && logica.rectangulos[3][1] == logica.ganador4){ 
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
           if(logica.rectangulos[0][0] == logica.ganador1 && logica.rectangulos[1][0] == logica.ganador2 && logica.rectangulos[2][0] == logica.ganador3 && logica.rectangulos[3][0] == logica.ganador4){ 
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
           if (logica.rectangulos[0][0] == logica.ganador1 && logica.rectangulos[1][0] == logica.ganador2 && logica.rectangulos[2][0] == logica.ganador3 && logica.rectangulos[3][0] == logica.ganador4){ 
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
       