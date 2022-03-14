package es.albertomarquez.juegodecolores;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Logica {
    
    final char[][] rectangulos;
    Rectangle[][] mapa;
    short tamXTablero;
    short tamYTablero;
    char[] COLORES = {'r', 'a', 'v', 'b'};
    char[] ganador = new char[4];
    char VACIO = '.';
    final char rojo='r';
    final char amarillo='a';
    final char verde='v';
    final char azul='b';
   
   
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
//    List<String> lista = Arrays.asList(COLORES);
//        Collections.shuffle(lista);
//        for (int i = 0; i <= 3; i++) {
//            ganador[i] = lista.get(i);
//        }
        System.out.println("Patrón ganador: " + rojo + " " + verde + " " + amarillo + " " + azul);
       
//        if (ganador[0] == COLORES[0] && ganador[1] == COLORES[1] && ganador[2] == COLORES[2] && ganador[3] == COLORES[3]){
//            System.out.println("HAS GANADO");
//        }
}
       
   
   
}