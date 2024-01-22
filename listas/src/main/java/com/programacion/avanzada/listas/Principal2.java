package com.programacion.avanzada.listas;

public class Principal2 {
    public static void main(String[] args) {
        //******************Lista 1-Enteros
        //crear una lista
        var ls= Lista.of(1,2,3,4,4);
        //imprimir la lista
        System.out.println("lista:"+ls);
        //contar los elementos de la lista
        System.out.println("Count:"+ls.count());
        //Prepend Agregar elemento al inicio
        System.out.println("Prepend: "+ls.prepend(99));
        //Append-Agregar un elemento al final
        System.out.println("Append: "+ls.append(6));
        //Insert-Insertar un elemento en una posición definida
        System.out.println("Insert"+ls.insert(2,99));
        //get-Obtener un elemnto dado el indice
        System.out.println("get: "+ls.get(0));

        //******************Lista 2- Strings
        //crear una lista
        var ls2=Lista.of("aa","bb","cc");
        //imprimir la lista
        System.out.println("Lista2:"+ls2);
        //contar los elementos de la lista
        System.out.println("Count ls2:"+ls2.count());
        //Prepend-Agregar elemento al inicio
        System.out.println("Prepend:"+ls2.prepend("zz"));
        //Append-Agregar un elemento al final
        System.out.println("Append:"+ls2.append("dd"));
        //Insert-Insertar un elemento en una posición definida
        System.out.println("Insert"+ls2.insert(2,"abc"));
        //get-Obtener un elemnto dado el indice
        System.out.println("get: "+ls2.get(0));
    }
}
