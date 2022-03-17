package es.albertomarquez.juegodecolores;


import java.util.Random;
import javafx.scene.shape.Rectangle;

public class Logica {
   //VARIABLES UTILIZADAS
    char[][] rectangulos;
    Rectangle[][] mapa;
    final short tamXTablero;
    final short tamYTablero;
    final char rojo='r';
    final char amarillo='a';
    final char verde='v';
    final char azul='b';
    Character[] COLORES = {rojo, amarillo, verde, azul};
    char VACIO = '.';
    char ganador1;
    char ganador2;
    char ganador3;
    char ganador4;
  
   //METODO CONTRUCTOR PARA CONSTRUIR EL TABLERO
    public Logica() {
        tamXTablero = 4;
        tamYTablero = 3;
        rectangulos = new char[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x++) {
            for(int y=0; y<tamYTablero; y++) {
                rectangulos[x][y] = VACIO;
            }
        }
    }
    //METODO UTILIZADO PARA REINICIAR EL TABLERO Y BORRAR LO QUE TENIA ANTERIORMENTE
    public void restaurarArr(){
        rectangulos = new char[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x++) {
            for(int y=0; y<tamYTablero; y++) {
                rectangulos[x][y] = VACIO;
            }
        }
    }  
    //METODO PARA MOSTRAR EL TABLERO EN CONSOLA
    public void mostrarTableroConsola() {
        for(int y=0; y<tamYTablero; y++) {
            for(int x=0; x<tamXTablero; x++) {
                System.out.print(rectangulos[x][y]);
            }
            System.out.println();
        }    
        System.out.println();
    }
   
    //METODO UTILIZADO PARA GENEREAR ALEATORIAMENTE COLORES
    public void patronGanador(Tablero tablero){
        char[] x = {rojo,verde,amarillo,azul}; //CREO UN ARRAY CHAR GURADANDO LAS VARIBALES DE LOS COLORES
        Random rand = new Random();//GENERA RANDOM
        int n1 = rand.nextInt(4); //GUARDO EN N1 UN NUMERO ALEATROIO DEL 1 AL 4 
        int n2 = rand.nextInt(4); //GUARDO EN N2 UN NUMERO ALEATROIO DEL 1 AL 4
        int n3 = rand.nextInt(4); //GUARDO EN N3 UN NUMERO ALEATROIO DEL 1 AL 4
        int n4 = rand.nextInt(4); //GUARDO EN N4 UN NUMERO ALEATROIO DEL 1 AL 4
        final char color1 = x [n1]; //GUARDO EN LA VARIABLE COLOR1 UN COLOR ELEJIDO ALEATORIAMENTE DEL 1 AL 4 
        final char color2 = x [n2]; //GUARDO EN LA VARIABLE COLOR2 UN COLOR ELEJIDO ALEATORIAMENTE DEL 1 AL 4
        final char color3 = x [n3]; //GUARDO EN LA VARIABLE COLOR3 UN COLOR ELEJIDO ALEATORIAMENTE DEL 1 AL 4
        final char color4 = x [n4]; //GUARDO EN LA VARIABLE COLOR4 UN COLOR ELEJIDO ALEATORIAMENTE DEL 1 AL 4
        System.out.println("Patrón ganador:"  + VACIO + " " + color2 + " " + color3 + " " + color4);
       // System.out.println("Patrón ganador:"  + color1 + " " + color2 + " " + color3 + " " + color4);
        ganador1 = color1; //GUARDO EL COLOR EN OTRA VARIABLE
        ganador2 = color2; //GUARDO EL COLOR EN OTRA VARIABLE
        ganador3 = color3; //GUARDO EL COLOR EN OTRA VARIABLE
        ganador4 = color4; //GUARDO EL COLOR EN OTRA VARIABLE
    } 
}