package com.progra_avanzada_3_genercios;

import java.util.List;
//la clase no se la declara genérica pero si puede tener
//métodos genéricos
public class Mgenerico {


    public static <T> void imprimirContenido(T contenido){
        System.out.println("Contenido: "+contenido);

    }

    public static void main(String[] args) {
        imprimirContenido("42");
        imprimirContenido(42);
        imprimirContenido(2.0);
        imprimirContenido('a');

    }
}
