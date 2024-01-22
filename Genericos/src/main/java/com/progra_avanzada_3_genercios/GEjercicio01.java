package com.progra_avanzada_3_genercios;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GEjercicio01 {

    public static <T> List<T> filtrar(List<T> lista, Predicate<T> predicado) {
        return lista.stream().
                filter(predicado).
                collect(Collectors.toList());

    }

    public static void main(String[] args) {
        //creamos una lista inmutable con el metodo estatico List.of()
        //implementación imutable de la interfaz List
        List<Integer>lista=List.of(1,2,3,4,5,6,7,8,9,10);

        //filtramos la lista de numeros
        List<Integer> numerosFiltrados=filtrar(lista,num->num>5);
        //imprimimos la lista de numerosFiltrados
        System.out.println("Números mayores que 5:"+numerosFiltrados);

    }
}

