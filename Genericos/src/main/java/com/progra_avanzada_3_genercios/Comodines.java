package com.progra_avanzada_3_genercios;

import java.util.List;

public class Comodines {
    public void imprimirLista(List<? extends Number>lista){
        for (Number numero:lista){
            System.out.println(numero);
        }

    }

    public static void main(String[] args) {
        Comodines comodin1=new Comodines();
        List<Integer>lista=List.of(1,2,3,4,5);
        List<Double>lista1=List.of(2.0,2.2,2.3,2.4);
        List<Float>lista2=List.of(2.0f,3.0f,4.0f,5.0f);
        comodin1.imprimirLista(lista2);

    }
}
