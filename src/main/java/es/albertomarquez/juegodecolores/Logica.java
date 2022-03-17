package es.albertomarquez.juegodecolores;


import java.util.Random;
import javafx.scene.shape.Rectangle;

public class Logica {
   
     char[][] rectangulos;
    Rectangle[][] mapa;
    final short tamXTablero;
    final short tamYTablero;
    final char rojo='r';
    final char amarillo='a';
    final char verde='v';
    final char azul='b';
    Character[] COLORES = {rojo, amarillo, verde, azul};
    char[] ganador = new char[4];
    char VACIO = '.';
    char ganador1;
    char ganador2;
    char ganador3;
    char ganador4;
    
   
   
   
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
    public void restaurarArr(){
        rectangulos = new char[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x++) {
            for(int y=0; y<tamYTablero; y++) {
                rectangulos[x][y] = VACIO;
            }
        }
    }
    public void mostrarTableroConsola() {
        for(int y=0; y<tamYTablero; y++) {
            for(int x=0; x<tamXTablero; x++) {
                System.out.print(rectangulos[x][y]);
            }
            System.out.println();
        }    
        System.out.println();
    }
   
   
    public void patronGanador(Tablero tablero){
        char[] x = {rojo,verde,amarillo,azul};
        Random rand = new Random();

        int n1 = rand.nextInt(4);
        int n2 = rand.nextInt(4);
        int n3 = rand.nextInt(4);
        int n4 = rand.nextInt(4);
        final char color1 = x [n1];
        final char color2 = x [n2];
        final char color3 = x [n3];
        final char color4 = x [n4];
       
        System.out.println("Patrón ganador:"  + VACIO + " " + color2 + " " + color3 + " " + color4);
       // System.out.println("Patrón ganador:"  + color1 + " " + color2 + " " + color3 + " " + color4);
        
        ganador1 = color1;
        ganador2 = color2;
        ganador3 = color3;
        ganador4 = color4;
}
       
   
   
}